package com.telespazio.vega.Parser.core;

import model.Adf;
import model.Element;

public class FileNameReader {
	
	public static Element nameReader(String fileName){
		String[] name = new String[12];
		
		Adf product = new Adf(fileName);
		
		product.setName(fileName.substring(0, 3));
		product.setType(fileName.substring(4, 15));
		product.setStartTime(fileName.substring(16, 31));
		product.setStopTime(fileName.substring(32, 47));
		product.setGenTime(fileName.substring(48, 63));
		
		name[5] = fileName.substring(64, 68);
		
		product.setCycle(fileName.substring(69, 72));
		product.setOrbit(fileName.substring(73, 76));
		product.setSurface(fileName.substring(82, 85));
		product.setPlatform(fileName.substring(86, 87));
		
		product.setTimeliness(fileName.substring(88, 90));
		product.setBaseLine(fileName.substring(91, 94));
		
		return product;
	}

}
