package com.goldenbike.model.business.manager;

import com.goldenbike.model.business.exception.PropertiesNotFoundException;
import com.goldenbike.model.services.manager.PropertyManager;

public abstract class ManagerSuperType {

	/**
	 * Static initializer block
	 */
	static {
		try {
			ManagerSuperType.loadProperties();
		} catch (PropertiesNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads properties file once and makes it available to the other models
	 * @throws PropertiesNotFoundException: Property file not loaded
	 */
	public static void loadProperties() throws PropertiesNotFoundException {
		//String fileLocation = System.getProperty("prop_location");
		String fileLocation = "config/goldenbike.properties";
		if (fileLocation != null) {
			PropertyManager.loadProperties(fileLocation);
		}/*else {
			throw new PropertiesNotFoundException("Property file not loaded");
		}*/
	}
}
