package be.ringring.message.common;

/**
 * Provide the method for conversion of an object into json format
**/

public interface Convertable {
	
	/**
	 * Convert the object in json format
	 * @return Return the json format in a String
	**/
	
	public String toJSON();
	
}
