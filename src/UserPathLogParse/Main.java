package UserPathLogParse;

public class Main {
	
	public static void main(String args[]) {
		if (args != null && args.length > 0) {
			
			StringBuilder param = new StringBuilder();
	    
			param.append(args[0]);
//"G://tfpt//user_path.log (4).2016-05-20");//"G://tfpt//user_path//user_path.log.2017-02-10");//"G://tfpt//user_path.log (4).2016-05-20");//"G://tfpt//user_path.log (4).2016-05-20");//.append("user_path.log (4).2016-05-20");
		
			if (param.toString().equals("-h") || param.toString().equals("help")) {
				System.out.println("param:\n\tG://tfpt//user_path//user_path.log.2017-02-12");
				System.exit(0);
			}else {				
			    ParseUserPathLog aClass = new ParseUserPathLog();
				aClass.main(param.toString());				
			}
		}    
	    
	}

}
