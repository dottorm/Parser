package com.telespazio.vega.Parser;

import java.io.File;
import java.io.IOException;

import com.telespazio.vega.Parser.core.DirectoryWalker;

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
		
		for(File dir : inputFolder){
			
			if(!dir.isDirectory()){
				System.out.println("Input is not a directory");
				return;
			}
			
			if (!FileNameUtils.isValidName(dir.getName())){
				System.out.println("Input not correct: "+dir.getName());
				return;
			}
			
			try {
				if(FileNameUtils.renameFile(dir) == null){
					System.out.println("Impossible to rename: "+dir.getName());
					return;
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
			
		}
	}

}
