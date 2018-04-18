package utils;

import java.io.File;
import java.io.IOException;

public class FileNameUtils {
	
	private static final String INPROGRESS = ".inProgess";
	private static final String EXT = ".SEN3";
	
	public static boolean isValidName(String name){
		
		String extension = getExtension(name);
		
		if(extension.equals(EXT)  && !name.contains(INPROGRESS)){
			return true;
		}
		
		return false;
	}
	
	public static File renameFile(File input) throws IOException{
		
		System.out.println("Renaming: "+input.getName());
		
		File renamed = new File(input.getAbsolutePath()+INPROGRESS);
		
		if(renamed.exists()){
			throw new java.io.IOException("file "+renamed.getName()+" exists");
		}
			
		if(!input.renameTo(renamed)){
			return null;
		}
		
		System.out.println("Succesfully renamed: "+input.getName());
		
		return input;
		
	}
	
	public static String getExtension(String name){
		return name.substring(name.lastIndexOf("."),name.length());
	}

}
