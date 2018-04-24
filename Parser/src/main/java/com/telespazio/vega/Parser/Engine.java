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

import model.Adf;
import model.DataObject;
import model.XfduManifest;
import utils.CheckName;
import utils.FileNameUtils;
import utils.ObjectsUtils;
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
		
		String dirName;
		
		for(File dir : inputFolder){
			
			if(!dir.isDirectory()){
				System.out.println("Input is not a directory");
				continue;
			}
			dirName = dir.getName();
			if (!FileNameUtils.isValid(dirName)){
				System.out.println("Input not correct: "+dirName);
				continue;
			}
			
			type = FileNameReader.getType(dirName);
			pattern = RegexMap.REGEX.get(type);
			
			if(!CheckName.chekName(dirName, pattern)){
				System.out.println("File Name not compliant");
				continue;
			}
			
			System.out.println(FileNameReader.nameReader(dirName));
			
			System.out.println("Checking: "+dirName);
			try {
				dir = FileNameUtils.renameFile(dir);
				if(dir == null){
					System.out.println("Impossible to rename directory");
					continue;
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
			//Reading Manifest
			manifest = reader.manifestExists(reader.readContent(dir));
			
			if(manifest == null){
				System.out.println("Product Not valid no Manifest to Parse");
				continue;
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
				continue;
			}
			
			List<DataObject> filesList = reader.readDataObject(dir, objectList);
			
			if(filesList == null || filesList.size() == 0){
				System.out.println("Empty dir impossible to elaborate");
				continue;
			}
			
			System.out.println(Analyzer.checkDataObjects(filesList,objectList));
			
			XfduManifest xfduMan = ModelCreator.createManifest(manifest);
			Adf adf = ModelCreator.createAdf(dirName,filesList);
			
			System.out.println(xfduMan.toString());
			System.out.println(adf.toString() +" - "+ adf.getDataObjects().size());
			System.out.println(ObjectsUtils.compareObjects(adf, xfduMan));
			
		}
	}

}
