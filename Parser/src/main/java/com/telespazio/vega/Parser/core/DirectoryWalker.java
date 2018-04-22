package com.telespazio.vega.Parser.core;

import java.io.File;
import java.util.List;

import model.DataObject;

public class DirectoryWalker {
	
	private String MANIFEST = "xfdumanifest.xml";
	
	
	public DirectoryWalker(){}
	
	public File[] readDataObject(final File folder, List<DataObject> dataList){
		
		File[] toCheck = new File[dataList.size()];
		
		boolean found = false;
		
		for(int i = 0; i<dataList.size(); i++){
			for(File f : listFilesForFolder(folder)){
				if(dataList.get(i).getName().equals(f.getName())){
					toCheck[i] = f;
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
