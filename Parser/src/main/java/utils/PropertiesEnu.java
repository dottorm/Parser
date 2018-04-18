package utils;

public enum PropertiesEnu {
	
	INPUT_DIR("input.dir");
	
	private String prop;
	
	private PropertiesEnu(String prop){
		this.prop = prop;
	}
	
	public String getProp(){
		return this.prop;
	}

}
