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
	
//	���ļ��н����õ����ַ���������С�	
    ArrayList<String[]> path = new ArrayList<>();    
//  ����ͳ����Ϣ��  
    ArrayList<Map<String, Integer>> columns = new ArrayList<>(MAX_USER_ACTION_STEP);
//  ����action type�����ļ�:<���֣�����>
    Map<String, String> actionTypeDes = new HashMap<>();
    
    private void init(){
    	//actionTypeDes = Utils.getActionDes(ACTIONDESFILE);
    	//MAX_USER_ACTION_TYPE = //Utils.MaxNum +1; // ע��һ��Ҫ������+1��Ϊʲô�������1����parse��ʱ�򣬵����η���columns�ĵ����е�ʱ��columns.get(6).size()�Ĵ�Сʼ��Ϊ2����Ϊ1������
    	System.out.println("����ACTION TYPEֵ�� "+MAX_USER_ACTION_TYPE);
        
        /**
         * columns��ʼ��������ݣ�
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
    	System.out.println("��ʼ����ɡ�");
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
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
     */
    /**
     * ִ����ɺ�path = 
     * [37, 5, 4]
     * [37]
     * [37, 5, 7, 14, 14, 21, 25, 5, 5, 8, 9, 6]
     */
    public void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int totalline = 0;
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                // ��ʾ�к�
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
            System.out.println("�豸����: "+totalline);
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

    /** ͳ����ɺ���������£�
    * 0 <"1",10> <"4",22> <"5",33> ... <"37",55> <"EXITTAG",10>
    * 1 <"1",22> <"4",20> <"5",11> ... <"37",40> <"EXITTAG",0>
    * 2 <"1",0> <"4",1> <"3",0> ... <"37",0> <"EXITTAG",0>
    * ...
    * 99 <"1",0> <"2",0> <"3",0> ... <"37",0> <"EXITTAG",0>
    */
    /**
     * ��i=0:
     * 	map = <"1",10> <"4",22> <"5",33> ... <"37",55> <"EXITTAG",10>
     * 	total = ����Ԫ��ֵ�ĺ͡�
     *  ѭ����ӡ����Ԫ��ֵ��total�ĺ͡�
     *  ���ʣ�none�����ֵ�����ȷ���ģ���ô����ͳ��������ڣ�������Ϊ����ʼ�ն��ǲ���ģ���ֵ����path��������������û�����.
     */
    public void data() {
    	System.out.println("��ʼ���������");
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
             * ���������һ�������˳��˶��ٱ������û���
             */
            sb.append("����"+i);
            sb.append(" remain��"+sum+" "+" ��һ���˳���"+(decimalFormat.format(exitBasedOnLastPercent * 100))+"%").append("(");

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

    // ����ٷֱ�
    public String myPercent(int many, int hundred) {
        String baifenbi = "";// ���ܰٷֱȵ�ֵ
        double baiy = many * 1.0;
        double baiz = hundred * 1.0;
        double fen = baiy / baiz;
        DecimalFormat df1 = new DecimalFormat("##.00%"); // ##.00%
        baifenbi = df1.format(fen);
        return baifenbi;
    }
    
//    path��������ַ���������ɵ��б������ļ��еõ�������path���ݡ�
//    �˺���֮ǰ��columns�������ǿյġ�columns����ͳ�Ƹ��������и��������Ĵ�����
//    ����ȡ��path�е����ݣ�
//    columns������к��д���ʲô���д������path�е�һ�У��������е�һ������ÿһ�д������ÿһ���������ͺ�������Ͷ�Ӧ��ͳ�Ƹ�����
//    ���path�е�ĳһ�еĳ���С��
//    �˺���ִ��֮��
    /**
     * path���������
     * [37, 5, 4]
     * [37]
     * [37, 5, 7, 14, 14, 21, 25, 5, 5, 8, 9, 6]
     * ...
     */
//    ����path�����������һ��һ�н����ġ�
    /**
     * ��j = 0: 
     * 	j < 3; 
     * 		if(columns[0].contains[37]) 
     * 			columns[0][37].count++;
     * ��j = 1
     * 	j <��
     * 		if(columns[0].contains[5])
     * 			columns[1][5].count++;
     * ��j = 2
     * 	j <��
     * 		if(columns[0].contains[5])
     * 			columns[2][4].count++;
     * ��j=3: 
     * 	j<3��������
     * 		if(columns[0].containsKey("EXITTAG"))
     * 			columns[0]["EXITTAG"].count++;
     */
    
    /**
     * columns���ݣ�
     * 0 <"1",0> <"4",0> <"5",0> ... <"37",3> <"EXITTAG",0>
     * 1 <"1",0> <"4",0> <"5",2> ... <"37",0> <"EXITTAG",0>
     * 2 <"1",0> <"4",1> <"3",0> ... <"37",0> <"EXITTAG",0>
     * ...
     * 99 <"1",0> <"2",0> <"3",0> ... <"37",0> <"EXITTAG",3>
     */
    /**
     * ������������ʲô��
     * ��j�У������j�β�������j����������ݣ����������û��ڽ��е�j�β����У������������ݵĴ����ܺ͡���j�е����м�������������path�����������û�����
     * ͳ����ɺ���������£�
     * 0 <"1",10> <"4",22> <"5",33> ... <"37",55> <"EXITTAG",10>
     * 1 <"1",22> <"4",20> <"5",11> ... <"37",40> <"EXITTAG",0>
     * 2 <"1",0> <"4",1> <"3",0> ... <"37",0> <"EXITTAG",0>
     * ...
     * 99 <"1",0> <"2",0> <"3",0> ... <"37",0> <"EXITTAG",0>
     */
    public void parse() {
    	System.out.println("��ʼ������");
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
        System.out.println("����� = "+maxLength+" ���������: ");
        Utils.printStrArray(maxStrArray);
    }


    public boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {

            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("�ļ���Ϣ:");
                System.out.println("�ļ�·��=" + file.getPath());
                System.out.println("����·��=" + file.getAbsolutePath());
                System.out.println("�ļ���=" + file.getName());
                readFileByLines(file.getPath());

            } else if (file.isDirectory()) {
                System.out.println("�ļ���");
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
