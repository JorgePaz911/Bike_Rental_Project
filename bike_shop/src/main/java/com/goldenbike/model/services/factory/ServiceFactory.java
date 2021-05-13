package com.goldenbike.model.services.factory;

import com.goldenbike.model.services.manager.PropertyManager;
import com.goldenbike.model.services.IService;

/**
 * Service Factory
 *   
 * @author Jorge Paz
 *
 */
public class ServiceFactory {

	/**
	 * @param serviceName
	 * @return IService
	 * @throws Exception
	 */
	public IService getService(String serviceName) throws Exception {
		
		Class<?> c = Class.forName(getImplName(serviceName));
		return (IService) c.newInstance();
	}
	
	/**
	 * @param serviceName
	 * @return String
	 * @throws IOException
	 */
	private String getImplName(String serviceName) {
		
		return PropertyManager.getPropertyValue(serviceName);
	}
}
