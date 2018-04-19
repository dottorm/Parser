package com.telespazio.vega.Parser.core;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import utils.PropertiesEnu;
import utils.PropertiesManager;
import utils.XPathCommands;

public class LoadRegex {
	
	
	private File folder = new File(PropertiesManager.getInstance().getProperty(PropertiesEnu.REGEX_DIR.getProp()));
	private DirectoryWalker walker;

	public LoadRegex() {
		walker = new DirectoryWalker();
	}
	
	public boolean readDirecotry(){
		System.out.println("Reading REGEX");
		
		boolean result = false;
		File[] regexList = walker.listFilesForFolder(folder);
		
		if(regexList == null || regexList.length == 0){
			System.err.println("Impossible to read REGEX");
			return false;
		}
		
		String reg;
		String type;
		for(File file : regexList){
			if(!file.getName().contains("SEN3")){
				continue;
			}
			
			try {
				
				type = readxPath(file,XPathCommands.GET_TYPE);
				reg = readxPath(file,XPathCommands.GET_REGEX);
								
				RegexMap.REGEX.put(type, reg);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		System.out.println("Regex succesfully read");
		return result;
	}
	
	private String readxPath(File file, String param) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		XmlManager manager = new XmlManager(file);
		
		manager.setExpr(manager.compileXpath(param));
		String result = (String) manager.getExpr().evaluate(manager.getDoc(), XPathConstants.STRING);
		
		return result;
	}

}
