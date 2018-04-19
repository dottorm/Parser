package com.telespazio.vega.Parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.telespazio.vega.Parser.core.DirectoryWalker;
import com.telespazio.vega.Parser.core.ManifestParser;

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
				dir = FileNameUtils.renameFile(dir);
				if(dir == null){
					System.out.println("Impossible to rename: "+dir.getName());
					return;
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
			
			manifest = reader.manifestExists(reader.readContent(dir));
			try {
				ManifestParser man = new ManifestParser(manifest);
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
