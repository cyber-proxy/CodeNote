package UserPathLogParse;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	
	private final static String PREFIX = "int";
	private final static String ASIGN = "=";
	private final static String delimiter = ";";
	public static int MaxNum = 73;
	
	/**
	 * 解析NewUserActionType.java文件
	 * @param classFilePath
	 * @return
	 */
	public static Map<String, String> getActionDes(String classFilePath){
		Map<String, String> actionDes = new HashMap<>();
    	BufferedReader reader = null;
		try {
	        File file = new File(classFilePath);
	        if (!file.isDirectory()) {
	        	reader = new BufferedReader(new FileReader(classFilePath));
	        	String readLine = null;
	        	while( (readLine = reader.readLine()) != null){
//		        	System.out.print(readLine);
	        		readLine = readLine.replaceAll(" ", "");
	        		if (readLine.contains(PREFIX)) {
						String intStatement = readLine.split(PREFIX)[1];
						String name = intStatement.split(ASIGN)[0];
						name = name.toLowerCase();
						String valueInt = intStatement.split(ASIGN)[1];	
						valueInt = valueInt.split(delimiter)[0];
						if (isNumeric2(valueInt)) {
							actionDes.put(valueInt, name);
							if (Integer.valueOf(valueInt) > MaxNum) {
								MaxNum = Integer.valueOf(valueInt);
							}
						}
					}
	        	}
	        }else {
				System.out.println("not a file");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}finally {
			try {
				if (reader != null) {
					reader.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			for (Map.Entry<String, String> entry : actionDes.entrySet()) {  
				  
//			    System.out.println("Key=" + entry.getKey() + "Value =" + entry.getValue());  
			  
			} 
		}		
		
		return actionDes;		
	}
	
	public static boolean isValidActionType(String actionType){
		if (!isNumeric(actionType)) {
			return false;
		}
		if (NewUserAction.actionDes.containsKey(Integer.valueOf(actionType))) {
			return true;
		}
		return false;
	}
	
	public static String getDescrib(String actionType){
		if (!isNumeric(actionType)) {
			return "exit";
		}
		return NewUserAction.actionDes.get(Integer.valueOf(actionType));
	}
	
	public static boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("[0-9]*"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
	}
	
	public static boolean isNumeric2(String str){
	  for (int i = 0; i < str.length(); i++){
		   if (!Character.isDigit(str.charAt(i))){
			   return false;
		   }
	  	}
		  return true;
	 }
	
	/**
	 * 判断是否合法","分割的数字串。
	 * @param str
	 * @return
	 */
	public static boolean isValidActionList(String str){
		Pattern pattern = Pattern.compile("(/d{1,}/,){0,}");
		if (pattern.matcher(str).matches()) {
			return true;
		}
		return false;		
	}
	
	public static void printTable(ArrayList<Map<String, Integer>> columns){
		System.out.println("------------- start -------------------");
		for(Map<String, Integer> map : columns){
			Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Map.Entry<String, Integer> entry = iterator.next();
				System.out.print("("+entry.getKey()+","+entry.getValue()+") ");
			}
			System.out.println("");
		}
		System.out.println("------------- end -------------------");
	}
	
	public static void printStrArray(String[] array){
		for(String string : array){
			System.out.print(string+" ");
		}
		System.out.println("");
	}

}
