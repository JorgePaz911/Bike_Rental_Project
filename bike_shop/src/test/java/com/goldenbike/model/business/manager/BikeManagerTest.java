package com.goldenbike.model.business.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import com.goldenbike.model.domain.Bike;

public class BikeManagerTest  {

	private BikeManager bikeManager;
	private Bike bike1;
	private Bike bike2;
	private Bike updateBike;
	
	@Before
	public void setUp() {
		bikeManager = new BikeManager();
		bike1 = new Bike("YIYI", 2012, "Sport", "Yellow",1006);
		bike2 = new Bike("Stevenson", 2015, "Leisure", "Blue",1007);
		updateBike = new Bike("YAYA", 2012, "Sport", "Yellow",1006);
	}

	@Test
	public void createBike() {
		bikeManager.create(bike1);
		assertTrue(bikeManager.get(1006).equals(bike1));
		bikeManager.delete(1006);
	}
	
	@Test
	public void notCreateBike() {
		bikeManager.create(bike1);
		assertFalse(bikeManager.get(1006).equals(bike2));
		bikeManager.delete(1006);
	}


	@Test
	public void deleteBike() {
		boolean flag = false;
		bikeManager.create(bike1);
		bikeManager.delete(bike1.getBikeID());
		if(bikeManager.get(bike1.getBikeID()) == null)
			flag = true;
		assertTrue(flag);
		
	}

	
	@Test
	public void getBike() {
		bikeManager.create(bike1);
		Bike bike = bikeManager.get(bike1.getBikeID());
		assertTrue(bike.equals(bike1));
		bikeManager.delete(bike1.getBikeID());
	}

	@Test
	public void updateBike() {
		bikeManager.create(bike1);
		Bike bike3 = bikeManager.get(bike1.getBikeID());
		bikeManager.update(updateBike);
		Bike bike4 = bikeManager.get(bike1.getBikeID());
		assertFalse(bike3.equals(bike4));
		bikeManager.delete(bike1.getBikeID());
	}
	
	@Test
	public void notUpdateBike() {
		bikeManager.create(bike1);
		bikeManager.update(updateBike);
		Bike bike = bikeManager.get(bike1.getBikeID());
		assertTrue(bike.equals(updateBike));
		bikeManager.delete(bike1.getBikeID());
	}
	
}
