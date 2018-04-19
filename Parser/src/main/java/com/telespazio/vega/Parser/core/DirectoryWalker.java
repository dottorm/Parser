package com.telespazio.vega.Parser.core;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import utils.FileNameUtils;
import utils.PropertiesEnu;
import utils.PropertiesManager;

public class DirectoryWalker {
	
	private String MANIFEST = "xfdumanifest.xml";
	
	
	public DirectoryWalker(){}
	
	public File[] listFilesForFolder(final File folder) {
		
		//File manifest = null;
		
		if(folder == null){
			return null;
		}
		
		return folder.listFiles();
		
		//for (final File fileEntry : folder.listFiles()) {
			
			//if (fileEntry.isDirectory() && FileNameUtils.isValidName(fileEntry.getName())) {
				//System.out.println("Reading files under the folder "+fileEntry.getName());
				
				//System.out.println(FileNameReader.nameReader(fileEntry.getName()).toString());
				
				//manifest = manifestExists(readContent(fileEntry));
				//System.out.println(manifest.getName());
				
				//if(manifest != null){
				//	ManifestParser man = new ManifestParser(manifest);
				//}
				
				//listFilesForFolder(fileEntry);
				
			//} //else {
				
				//if (fileEntry.isFile()) {
					
					//System.out.println("File= " + fileEntry.getName());
					
				//}
				
			//}
			
		//}
		
	}
	
	public File[] readContent(File directory){
		if(directory == null)
			return null;
		
		return directory.listFiles();
	}
	
	public File manifestExists(File[] directory){
		
		if(directory == null || directory.length == 0)
			return null;
		
		String manifest = null;
		for(File file : directory){
			manifest = file.getName();
			if(manifest.equals(MANIFEST)){
				return file;
			}
		}
		
		return null;
	}
	

}
