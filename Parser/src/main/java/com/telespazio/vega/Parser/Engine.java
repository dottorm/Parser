package com.telespazio.vega.Parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import com.telespazio.vega.Parser.core.Analyzer;
import com.telespazio.vega.Parser.core.DirectoryWalker;
import com.telespazio.vega.Parser.core.FileNameReader;
import com.telespazio.vega.Parser.core.ManifestParser;
import com.telespazio.vega.Parser.core.ModelCreator;
import com.telespazio.vega.Parser.core.RegexMap;

import model.DataObject;
import utils.CheckName;
import utils.FileNameUtils;
import utils.PropertiesEnu;
import utils.PropertiesManager;

public class Engine {
	
	private File folder = new File(PropertiesManager.getInstance().getProperty(PropertiesEnu.INPUT_DIR.getProp()));
	
	private DirectoryWalker reader;
	
	public Engine() {
		reader = new DirectoryWalker();
		checkInputFolder(folder);
	}
	
	public void checkInputFolder(File directory){
		File[] inputFolder = reader.listFilesForFolder(directory);
		File manifest = null;
		String type;
		String pattern;
		
		for(File dir : inputFolder){
			
			if(!dir.isDirectory()){
				System.out.println("Input is not a directory");
				return;
			}
			
			if (!FileNameUtils.isValid(dir.getName())){
				System.out.println("Input not correct: "+dir.getName());
				return;
			}
			
			type = FileNameReader.getType(dir.getName());
			pattern = RegexMap.REGEX.get(type);
			
			if(!CheckName.chekName(dir.getName(), pattern)){
				System.out.println("File Name not compliant");
				return;
			}
			
			System.out.println(FileNameReader.nameReader(dir.getName()));
			
			System.out.println("Checking: "+dir.getName());
			try {
				dir = FileNameUtils.renameFile(dir);
				if(dir == null){
					System.out.println("Impossible to rename directory");
					return;
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
			//Reading Manifest
			manifest = reader.manifestExists(reader.readContent(dir));
			
			if(manifest == null){
				System.out.println("Product Not valid no Manifest to Parse");
				return;
			}
			ManifestParser man = null;
			try {
				man = new ManifestParser(manifest);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			List<DataObject> objectList = null;;
			try {
				objectList = man.getObjects();
			} catch (XPathExpressionException e) {
				e.printStackTrace();
			}
			
			if(objectList == null || objectList.size() == 0){
				System.out.println("Object List null");
				return;
			}
			
			File[] filesList = reader.readDataObject(dir, objectList);
			
			if(filesList == null || filesList.length == 0){
				System.out.println("Empty dir impossible to elaborate");
				return;
			}
			
			System.out.println(Analyzer.checkDataObjects(filesList,objectList));
			
			
			System.out.println(ModelCreator.createManifest(manifest).toString());
			
		}
	}

}
