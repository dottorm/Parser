package com.telespazio.vega.Parser;

import java.io.File;
import java.io.IOException;

import com.telespazio.vega.Parser.core.DirectoryWalker;
import com.telespazio.vega.Parser.core.FileNameReader;
import com.telespazio.vega.Parser.core.ManifestParser;
import com.telespazio.vega.Parser.core.RegexMap;

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
			
			if (!FileNameUtils.isValidName(dir.getName())){
				System.out.println("Input not correct: "+dir.getName());
				return;
			}
			
			type = FileNameReader.getType(dir.getName());
			pattern = RegexMap.REGEX.get(type);
			
			if(!CheckName.chekName(dir.getName(), pattern)){
				System.out.println("File Name not compliant");
				return;
			}
			
			try {
				dir = FileNameUtils.renameFile(dir);
				if(dir == null){
					System.out.println("Impossible to rename directory");
					return;
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
			manifest = reader.manifestExists(reader.readContent(dir));
			try {
				ManifestParser man = new ManifestParser(manifest);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
