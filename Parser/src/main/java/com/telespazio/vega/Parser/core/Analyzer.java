package com.telespazio.vega.Parser.core;

import java.util.List;

import model.DataObject;
import utils.Messages;

public class Analyzer {
	
	public static String checkDataObjects(List<DataObject> filesList, List<DataObject> objectList){
		String result = "";
		
		String name = Messages.ERROR.getMessage();
		String checkSum = Messages.ERROR.getMessage();
		String size = Messages.ERROR.getMessage();
		
		for(DataObject f : filesList){
			
			for(DataObject data : objectList){
				
				if(f.getName().equals(data.getName())){
					System.out.println(f.getName()+" - "+data.getName());
					name = Messages.OK.getMessage();
					
					if(f.getCheckSum().equals(data.getCheckSum())){
						checkSum = Messages.OK.getMessage();
						
					}
					
					if(f.getSize().equals(data.getSize())){
						size = Messages.OK.getMessage();
						
					}
					
					result = String.format("File Name: \r\t%s \r", f.getName());
					result = String.format("%s \r\tFile Name: %s \r\tChecksum match: %s \r\tSize match: %s \r",result, name, checkSum,size);
				}
				
			}
			result = result +"\r"+result;
			
		}
		return result;
		
	}

}
