package com.telespazio.vega.Parser.core;

import java.io.File;
import java.util.List;

import model.DataObject;
import utils.CheckSum;

public class Analyzer {
	
	public static String checkDataObjects(File[] filesList, List<DataObject> objectList){
		
		boolean isName = false;
		boolean isChecksum = false;
		boolean isSize = false;
		for(File f : filesList){
			for(DataObject data : objectList){
				if(f.getName().equals(data.getName())){isName = true;}
				if(CheckSum.calculateMD5(f).equals(data.getCheckSum())){isChecksum = true;}
				if(new Long(f.length()).equals( Long.parseLong(data.getSize()))){isSize = true;
				}
			}
		}
		String result = String.format("\r\tFile Name: %s \r\tChecksum match: %s \r\tSize match: %s",isName, isChecksum, isSize);
		return result;
		
	}

}