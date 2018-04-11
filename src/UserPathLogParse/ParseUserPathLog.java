package UserPathLogParse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import sun.security.krb5.internal.crypto.Des;

public class ParseUserPathLog {
	
	private static final int MAX_USER_ACTION_STEP = 200;
	private static int MAX_USER_ACTION_TYPE = 100;
	private static final String DELIMITER = ",";
	private static final String PATHPREFIX = "path=";
	private static final String EXITTAG = "none";
	private static final String ACTIONDESFILE = "G://tfpt//asdf.java";
	private DecimalFormat decimalFormat=new DecimalFormat("0.00");
	private static final double THRESHOLD = 0.01;
	
//	从文件中解析得到的字符串数组队列。	
    ArrayList<String[]> path = new ArrayList<>();    
//  保存统计信息。  
    ArrayList<Map<String, Integer>> columns = new ArrayList<>(MAX_USER_ACTION_STEP);
//  解析action type定义文件:<数字，描述>
    Map<String, String> actionTypeDes = new HashMap<>();
    
    private void init(){
    	//actionTypeDes = Utils.getActionDes(ACTIONDESFILE);
    	//MAX_USER_ACTION_TYPE = //Utils.MaxNum +1; // 注意一定要在这里+1。为什么如果不加1，在parse的时候，第六次访问columns的第六列的时候columns.get(6).size()的大小始终为2或者为1？？？
    	System.out.println("最大的ACTION TYPE值： "+MAX_USER_ACTION_TYPE);
        
        /**
         * columns初始化后的内容：
         * 0 <"1",0> <"2",0> <"3",0> ... <"43",0>
         * 1 <"1",0> <"2",0> <"3",0> ... <"43",0>
         * 2 <"1",0> <"2",0> <"3",0> ... <"43",0>
         * ...
         * 99 <"1",0> <"2",0> <"3",0> ... <"43",0>
         */
        for (int i = 0; i < MAX_USER_ACTION_STEP; i++) {
        	try{
                Map<String, Integer> row = new HashMap<>();
                for (int j = 0; j < MAX_USER_ACTION_TYPE; j++) {
                    row.put(String.valueOf(j), 0);
                }
//                System.out.print(row.size()+" ");
                columns.add(row);        		
        	}catch (Exception e) {
        		System.out.println(e.getMessage().toString());
			}
        }
    	System.out.println("初始化完成。");
    }

    public void main(String fileName) {    	
    	init();

        try {
            readfile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
//    	Utils.printTable(columns);
        
        parse();
    	
//    	Utils.printTable(columns);

        data();

    }

//    public void ReadFileContent(Context context, String fileName) {
//        try {
//            FileInputStream inputStream = context.openFileInput(fileName);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String s = "";
//            while ((s = reader.readLine()) != null) {
//                String[] array = s.split("path=");
//                path.add(array[1].split(","));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    /**
     * 执行完成后，path = 
     * [37, 5, 4]
     * [37]
     * [37, 5, 7, 14, 14, 21, 25, 5, 5, 8, 9, 6]
     */
    public void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int totalline = 0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
                String[] array = tempString.split(PATHPREFIX);
                String[] actionList = new String[0];
                if (array != null && array.length > 1) {
                	actionList = array[1].split(DELIMITER);
				}
                boolean isValidActionList = true;
                for(String action : actionList){
                	if (!Utils.isValidActionType(action)) {
                		isValidActionList = false;
//                		System.out.println("invalid "+action);
					}
                }
                if (isValidActionList) {
					path.add(actionList);
					totalline++;
				}
            }
            System.out.println("设备总数: "+totalline);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /** 统计完成后的内容如下：
    * 0 <"1",10> <"4",22> <"5",33> ... <"37",55> <"EXITTAG",10>
    * 1 <"1",22> <"4",20> <"5",11> ... <"37",40> <"EXITTAG",0>
    * 2 <"1",0> <"4",1> <"3",0> ... <"37",0> <"EXITTAG",0>
    * ...
    * 99 <"1",0> <"2",0> <"3",0> ... <"37",0> <"EXITTAG",0>
    */
    /**
     * 当i=0:
     * 	map = <"1",10> <"4",22> <"5",33> ... <"37",55> <"EXITTAG",10>
     * 	total = 各个元素值的和。
     *  循环打印各个元素值与total的和。
     *  疑问：none里面的值是如何确定的？这么样的统计意义何在？？？因为总数始终都是不变的，其值等于path里面的行数，即用户总数.
     */
    public void data() {
    	System.out.println("开始计算比例：");
    	String deString = "";
    	int exitTotalBefore = 0;
    	int exitTotalBeforeTemp = 0;    	
    	int exitBasedOnLastStep = 0;
    	double exitBasedOnLastPercent = 0.0;
    	double total = 0.0;
    	double percentOfPerActionAction = 0.0;
    	List<Entry<String, Integer>> mapList = new ArrayList<Entry<String, Integer>>();

        for (int i = 0; i < columns.size(); i++) {
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> map = columns.get(i);
            mapList.addAll((map.entrySet()));
            java.util.Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {

				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return -o1.getValue() + o2.getValue();
				}
			});
            int sum = 0;
            Iterator<Map.Entry<String, Integer>> it1 = mapList.iterator();
            while (it1.hasNext()) {
                Map.Entry<String, Integer> me = it1.next();
                Integer value = me.getValue();
                sum += (int) value;
                if (me.getKey().equals(EXITTAG)) {
                	exitTotalBeforeTemp = me.getValue();
				}
            }
            exitBasedOnLastStep = exitTotalBeforeTemp - exitTotalBefore;
            sum = sum - exitTotalBeforeTemp;
            if (sum > 0) {
                exitBasedOnLastPercent = (exitBasedOnLastStep / (double)sum);				
			} else {
				exitBasedOnLastPercent = 0.0;
			}
            total = sum / 1.0;
            /**
             * 计算基于上一步操作退出了多少比例的用户：
             */
            sb.append("步："+i);
            sb.append(" remain："+sum+" "+" 上一步退出："+(decimalFormat.format(exitBasedOnLastPercent * 100))+"%").append("(");

            //percent
            Iterator<Map.Entry<String, Integer>> it2 = mapList.iterator();
            while (it2.hasNext()) {
                Map.Entry<String, Integer> me = it2.next();
                Integer value = me.getValue(); 
                String stringKey = me.getKey();
                if (stringKey.equals(EXITTAG)) {
					continue;
				}
                if (value > 0) {
                	deString = Utils.getDescrib(stringKey);
                	if(total > 0){
                		percentOfPerActionAction = value / total;
                	}else{
                		percentOfPerActionAction = 0.0;
                	}
                	if (percentOfPerActionAction < THRESHOLD) {
						continue;
					}
                    sb.append(" [" + deString + ", " + (decimalFormat.format(percentOfPerActionAction * 100)) + "%]");
                }
            }

            sb.append(")\n");
            System.out.print(sb.toString());
            exitTotalBefore = exitTotalBeforeTemp;
        	mapList.clear();
        }
    }

    // 计算百分比
    public String myPercent(int many, int hundred) {
        String baifenbi = "";// 接受百分比的值
        double baiy = many * 1.0;
        double baiz = hundred * 1.0;
        double fen = baiy / baiz;
        DecimalFormat df1 = new DecimalFormat("##.00%"); // ##.00%
        baifenbi = df1.format(fen);
        return baifenbi;
    }
    
//    path保存的是字符串数组组成的列表，即从文件中得到的所有path内容。
//    此函数之前，columns的内容是空的。columns用来统计各个步骤中各个操作的次数。
//    依次取出path中的内容，
//    columns里面的行和列代表什么？行代表的是path中的一列（即操作中的一步），每一列代表的是每一个操作类型和这个类型对应的统计个数。
//    如果path中的某一行的长度小雨
//    此函数执行之后：
    /**
     * path里面的内容
     * [37, 5, 4]
     * [37]
     * [37, 5, 7, 14, 14, 21, 25, 5, 5, 8, 9, 6]
     * ...
     */
//    解析path里面的内容是一行一行解析的。
    /**
     * 当j = 0: 
     * 	j < 3; 
     * 		if(columns[0].contains[37]) 
     * 			columns[0][37].count++;
     * 当j = 1
     * 	j <３
     * 		if(columns[0].contains[5])
     * 			columns[1][5].count++;
     * 当j = 2
     * 	j <３
     * 		if(columns[0].contains[5])
     * 			columns[2][4].count++;
     * 当j=3: 
     * 	j<3不成立。
     * 		if(columns[0].containsKey("EXITTAG"))
     * 			columns[0]["EXITTAG"].count++;
     */
    
    /**
     * columns内容：
     * 0 <"1",0> <"4",0> <"5",0> ... <"37",3> <"EXITTAG",0>
     * 1 <"1",0> <"4",0> <"5",2> ... <"37",0> <"EXITTAG",0>
     * 2 <"1",0> <"4",1> <"3",0> ... <"37",0> <"EXITTAG",0>
     * ...
     * 99 <"1",0> <"2",0> <"3",0> ... <"37",0> <"EXITTAG",3>
     */
    /**
     * 这个表的意义是什么？
     * 第j行，代表第j次操作。第j行里面的内容，代表所有用户在进行第j次操作中，各个操作内容的次数总和。第j行的所有计数的总数等于path的行数，即用户数。
     * 统计完成后的内容如下：
     * 0 <"1",10> <"4",22> <"5",33> ... <"37",55> <"EXITTAG",10>
     * 1 <"1",22> <"4",20> <"5",11> ... <"37",40> <"EXITTAG",0>
     * 2 <"1",0> <"4",1> <"3",0> ... <"37",0> <"EXITTAG",0>
     * ...
     * 99 <"1",0> <"2",0> <"3",0> ... <"37",0> <"EXITTAG",0>
     */
    public void parse() {
    	System.out.println("开始解析：");
    	int maxLength = 0;
    	String[] maxStrArray = new String[0];
        for (String[] arrPath : path) {
//        	Utils.printStrArray(arrPath);
        	if (arrPath.length > maxLength) {
				maxLength = arrPath.length;
				maxStrArray = arrPath;
			}
            for (int j = 0; j < MAX_USER_ACTION_STEP; j++) {
                Map<String, Integer> map = columns.get(j);
//                System.out.print(map.size()+" ");
                if (j < arrPath.length) {
                    String type = arrPath[j];
                    if (map.containsKey(type)) {
                        Integer num = map.get(type);
                        map.put(type, num + 1);
                    } else {
                        HashMap<String, Integer> newMap = new HashMap<>();
                        newMap.put(type, 1);
                        columns.set(j, newMap);
                    }
                } else {
                    if (map.containsKey(EXITTAG)) {
                        Integer num = map.get(EXITTAG);
                        map.put(EXITTAG, num + 1);
                    } else {
                        map.put(EXITTAG, 1);
                    }
                }
                
            }
//            System.out.println("");
        }
//        Utils.printTable(columns);
        System.out.println("最长操作 = "+maxLength+" 最长操作序列: ");
        Utils.printStrArray(maxStrArray);
    }


    public boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件信息:");
                System.out.println("文件路径=" + file.getPath());
                System.out.println("绝对路径=" + file.getAbsolutePath());
                System.out.println("文件名=" + file.getName());
                readFileByLines(file.getPath());

            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                File[] fz = file.listFiles();
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath="
                                + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                        readFileByLines(readfile.getPath());
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }
}
