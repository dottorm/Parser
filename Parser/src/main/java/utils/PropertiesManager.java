package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {
	
	private String propFileName = "conf/parser.properties";
	
	private Properties prop = new Properties();
	
	private static PropertiesManager manager;
	
	private PropertiesManager(){
		try{
			InputStream inputStream = new FileInputStream(propFileName);
			prop.load(inputStream);
		}catch(IOException e){
			System.err.println("Unable to load Properties file: "+e);
		}
	}
	
	public static PropertiesManager getInstance(){
		if(manager == null){
			manager = new PropertiesManager();
		}
		
		return manager;
	}
	
	public String getProperty(String property){
		return prop.getProperty(property);
	}
}
