package com.telespazio.vega.Parser.core;

import model.Adf;
import model.Element;

public class FileNameReader {
	
	
	public static String getName(String fileName){
		return fileName.substring(0, 3);
	}
	
	public static String getType(String fileName){
		return fileName.substring(4, 15);
	}
	
	public static String getStartTime(String fileName){
		return fileName.substring(16, 31);
	}
	
	public static String getStopTime(String fileName){
		return fileName.substring(32, 47);
	}
	
	public static String getGenerationTime(String fileName){
		return fileName.substring(48, 63);
	}
	
	public static String getPacketCount(String fileName){
		return fileName.substring(64, 68);
	}
	
	public static String getCycle(String fileName){
		return fileName.substring(69, 72);
	}
	
	public static String getOrbit(String fileName){
		return fileName.substring(73, 76);
	}
	
	public static String getSurface(String fileName){
		return fileName.substring(82, 85);
	}
	
	public static String getPlatform(String fileName){
		return fileName.substring(86, 87);
	}
	
	public static String getTimeliness(String fileName){
		return fileName.substring(88, 90);
	}
	
	public static String getBaseLine(String fileName){
		return fileName.substring(91, 94);
	}
	
	//public FileNameReader(String fileName){
	//	this.filename = fileName;
	//}
	
	public static Element nameReader(String fileName){
		
		Adf product = new Adf(fileName);
		
		product.setName(fileName.substring(0, 3));
		product.setType(fileName.substring(4, 15));
		product.setStartTime(fileName.substring(16, 31));
		product.setStopTime(fileName.substring(32, 47));
		product.setGenTime(fileName.substring(48, 63));
		
		product.setPacketCount(fileName.substring(64, 68));
		
		product.setCycle(fileName.substring(69, 72));
		product.setOrbit(fileName.substring(73, 76));
		product.setSurface(fileName.substring(82, 85));
		product.setPlatform(fileName.substring(86, 87));
		
		product.setTimeliness(fileName.substring(88, 90));
		product.setBaseLine(fileName.substring(91, 94));
		
		return product;
	}

}
