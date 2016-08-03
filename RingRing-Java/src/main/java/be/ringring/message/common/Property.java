package be.ringring.message.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  
**/
public class Property {

	private static final Logger LOG = LoggerFactory.getLogger(Property.class);
	
	private static final String FILENAME = "config.properties";
	
	private Properties props;
	
	private static Property property = new Property();
	
	private Property() {
		
		props = new Properties();
		
		InputStream stream = getClass().getClassLoader().getResourceAsStream(FILENAME);
		
		try {
			props.load(stream);
		} catch (IOException e) {
			LOG.error("Unable to load config ! File not found ! Please fix it !");
		} finally {
			try {
				stream.close();
			} catch (IOException e) {}
		}
		
	}
	
	public String get(String key) {
		return props.getProperty(key);
	}
	
	public static Property getInstance() {
		return property;
	}
}
