package utils;

import java.util.regex.Pattern;

public class CheckName {
	
	public static boolean chekName(String fileName, String pattern){
		return Pattern.compile(pattern).matcher(fileName).find();
	}
	
	public static String checkPlatform(String platform){
		
		if(platform.equals("OPE"))
			return "O";
		if(platform.equals("DEV"))
			return "D";
		
		return "F";
	}

}
