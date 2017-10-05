package util;

/**
 * This Enum helps defining set of Valid input Commands
 * @author ${Shreyas MN}
 * 
 */

public enum InputCommands {
	
	    SHOW("show"),
	    PUT("put"),
	    TAKE("take"), 
	    CHANGE("change"), 
	    QUIT("quit");
	
	
	final String value;
	
	InputCommands(String strIn){
		value = strIn;
	}
	
	public String getValue(){
		return value;
	}
}
