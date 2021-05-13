package com.goldenbike.model.services.factory;

import org.junit.Test;

import com.goldenbike.model.services.bikeservice.BikeSvcImpl;
import com.goldenbike.model.services.bikeservice.IBikeSvc;

import junit.framework.TestCase;

public class ServiceFactoryTest extends TestCase {

	private ServiceFactory serviceFactory;
	
    /**
     * Instantiation of objects used in the tests
     */
	protected void setUp() {
		
		serviceFactory = new ServiceFactory();
	}
	
    /**
     * Tests if bikeSvc is an instance of BikeSvcImpl
     * @throws Exception 
     */
	@Test
	public void testGetBikeSvc() throws Exception {
		
		
		IBikeSvc bikeSvc = (IBikeSvc) serviceFactory.getService(IBikeSvc.NAME);
		assertTrue(bikeSvc instanceof BikeSvcImpl);
		System.out.println("bikeSvc is an instance of BikeSvcImpl PASSED");
	}
	


}