package com.goldenbike.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jorge Paz
 *
 */
public class PropertyManager {

	private static Properties properties;
	
	/**
	 * Loads the properties file
	 * @param propertyLocation
	 */
	public static void loadProperties(String propertyLocation) {
	    properties = new Properties();
	    FileInputStream input = null;
	    try {
			input = new FileInputStream(propertyLocation);
			properties.load(input);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Properties file not found");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Returns the value for the specific key
	 * @param key
	 * @return String
	 */
    static public String getPropertyValue (String key)
    {
    	return properties.getProperty(key);
    }
}
