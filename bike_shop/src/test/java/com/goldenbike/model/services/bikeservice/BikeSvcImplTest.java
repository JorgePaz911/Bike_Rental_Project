package com.goldenbike.model.services.bikeservice;

import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.services.exception.BikeIDException;
import com.goldenbike.model.services.exception.NullBikeException;
import com.goldenbike.model.services.factory.ServiceFactory;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BikeSvcImplTest{

	private Bike bike1;
	private Bike bike2;
	private Bike bike3;
	private Bike testBike;
	private ServiceFactory serviceFactory;
	private IBikeSvc bikeSvc;
	
    /**
     * Instantiation of objects used in the tests
     * @throws Exception 
     */
	@Before
	public void setUp() {
		serviceFactory = new ServiceFactory();
		bike1 = new Bike("Buster",2000,"Sport","Brown",750);
		bike3 = new Bike("Buster",2000,"Sport","Brown",751);
		bike2 = new Bike("Carrera",1990,"Slow","Pink", 752);
		try {
			bikeSvc = (IBikeSvc) serviceFactory.getService(IBikeSvc.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
    /**
     * Stores a bike in the file, then gets the bike and compares it to the original bike created
     */
	@Test
	public void testStoreBike() {
		try {
		bikeSvc.storeBike(bike1);
		testBike = bikeSvc.getBike(bike1.getBikeID());
		bikeSvc.removeBike(bike1.getBikeID());
		}catch(NullBikeException bie) {
			bie.printStackTrace();
		} catch (BikeIDException e) {
			e.printStackTrace();
		}
		assertTrue(bike1.equals(testBike));				
	}
	
    /**
     * Stores a bike in the file, then gets the bike and compares it to another different bike
     */
	@Test
	public void testNotStoreBike() {
		try {
			bikeSvc.storeBike(bike3);
			testBike = bikeSvc.getBike(bike3.getBikeID());	
			bikeSvc.removeBike(bike3.getBikeID());
		}catch(NullBikeException bie) {
			bie.printStackTrace();
		} catch (BikeIDException e) {
			e.printStackTrace();
		}
		assertFalse(bike2.equals(testBike));
		System.out.println("testNotStoreBike PASSED");
	}
	
    /**
     * Gets a bike from the file, then compares it to the original bike
     */
	@Test
	public void testGetBike() {
		try {
			bikeSvc.storeBike(bike1);
		} catch (NullBikeException e) {
			e.printStackTrace();
		}
		testBike = bikeSvc.getBike(bike1.getBikeID());
		assertTrue(bike1.equals(testBike));
		System.out.println("testGetBike PASSED");
	}
	
    /**
     * Gets a bike from the file, then compares it to a different bike
     */
	@Test
	public void testNotGetBike() {
		try {
			bikeSvc.storeBike(bike1);
		} catch (NullBikeException e) {
			e.printStackTrace();
		}
		testBike = bikeSvc.getBike(bike1.getBikeID());
		assertFalse(testBike.equals(bike2));
		System.out.println("testNotGetBike PASSED");
	}
	
}
