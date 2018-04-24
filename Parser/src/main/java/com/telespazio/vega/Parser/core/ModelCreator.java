package com.telespazio.vega.Parser.core;

import java.util.List;
import java.io.File;

import model.Adf;
import model.DataObject;
import model.XfduManifest;

public class ModelCreator {
	
	private static ManifestParser parser;

	public ModelCreator() {}
	
	public static XfduManifest createManifest(File manifest){
		
		XfduManifest xfduManifest = new XfduManifest();
		
		try {
			parser = new ManifestParser(manifest);
		
			xfduManifest.setStartTime(parser.getTime("startTime"));
			xfduManifest.setStopTime(parser.getTime("stopTime"));
			xfduManifest.setType(parser.getProductInformation("productType"));
			xfduManifest.setFullName(parser.getProductInformation("productName"));
			xfduManifest.setName(xfduManifest.getFullName().substring(0,3));
			xfduManifest.setTimeliness(parser.getProductInformation("timeliness"));
			xfduManifest.setBaseLine(parser.getProductInformation("baselineCollection"));
			xfduManifest.setGenTime(parser.getProductInformation("creationTime"));
			xfduManifest.setPlatform(parser.getPlatform());
			xfduManifest.setOrbit(parser.getOrbit());
			xfduManifest.setDataObjects(parser.getObjects());
			xfduManifest.setSurface(parser.getSurface());
			xfduManifest.setPacketCount(parser.getProductInformation("packetCount"));
			xfduManifest.setCycle(parser.getCycleNumber());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return xfduManifest;
		
	}
	
	public static Adf createAdf(String fileName, List<DataObject> filesList){
		
		Adf adf = new Adf();
		adf = (Adf) FileNameReader.nameReader(fileName);
		
		adf.setDataObjects(filesList);
		
		return adf;
		
	}

}
