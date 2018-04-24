package com.telespazio.vega.Parser.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.DataObject;
import utils.CheckSum;

public class DirectoryWalker {
	
	private String MANIFEST = "xfdumanifest.xml";
	
	
	public DirectoryWalker(){}
	
	public List<DataObject> readDataObject(final File folder, List<DataObject> dataList){
		
		List<DataObject> toCheck = new ArrayList<>(dataList.size());
		
		DataObject dataObject;
		
		boolean found = false;
		
		for(int i = 0; i<dataList.size(); i++){
			for(File f : listFilesForFolder(folder)){
				if(dataList.get(i).getName().equals(f.getName())){
					dataObject = new DataObject();
					dataObject.setName(dataList.get(i).getName());
					dataObject.setCheckSum(CheckSum.calculateMD5(f));
					dataObject.setSize(f.length());
					toCheck.add(dataObject);
					found = true;
				}
			}
			if(!found){
				System.out.println("File: "+dataList.get(i).getName()+"NOT FOUND!");
			}
		}
		
		return toCheck;
	}
	
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
