package utils;

public enum Messages {
	
	OK("OK"),
	ERROR("ERROR");
	
	private String message;
	
	private Messages(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}

}
