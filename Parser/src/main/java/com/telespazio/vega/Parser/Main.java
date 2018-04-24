package com.telespazio.vega.Parser;

import com.telespazio.vega.Parser.core.LoadRegex;

public class Main {

	public static void main (String[] a){
		
		LoadRegex regex = new LoadRegex();
		regex.readDirecotry();
		
		//pattern = RegexMap.REGEX.get("TM_0_NAT___");
		
		//System.out.println(pattern);
		
		//System.out.println(CheckName.chekName(fileName, pattern));
		
		Engine engine = new Engine();
		
	}
}
