package utils;

public enum PropertiesEnu {
	
	INPUT_DIR("input.dir"),
	REGEX_DIR("regex.dir");
	
	private String prop;
	
	private PropertiesEnu(String prop){
		this.prop = prop;
	}
	
	public String getProp(){
		return this.prop;
	}

}
