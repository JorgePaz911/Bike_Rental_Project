package com.goldenbike.model.services.reservationservice;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import com.goldenbike.model.domain.Reservation;
import com.goldenbike.model.services.factory.ServiceFactory;

public class ReservationSvcImplTest {

	private ServiceFactory serviceFactory;
	private IReservationSvc resSvc;
	private Hashtable<Integer,Reservation> table;
	
	@Before
	public void setUp() {
		serviceFactory = new ServiceFactory();
		try {
			resSvc = (IReservationSvc) serviceFactory.getService(IReservationSvc.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Tests if reservation 1 exists, which was created through the
	 * presentation layer 
	 */
	@Test
	public void testGetandCreate() {
		Reservation res1 = resSvc.getReservation(1);
		assertTrue(res1 != null);
	}
	
	/**
	 * Tests that reservation #5000 does not exist.
	 */
	@Test
	public void testNotGetandCreate() {
		Reservation res2 = resSvc.getReservation(50000);
		assertFalse(res2 != null);
	}
	
	/**
	 * Grabs the reservation hashtable and asserts it is not empty
	 */
	@Test
	public void testGetAll() {
		table = resSvc.getAllReservations();
		assertTrue(table != null);
	}
	
	/**
	 * Does not assign the reservation hashtable to table
	 * and asserts that it is null
	 */
	@Test
	public void testNotGetAll() {
		assertFalse(table != null);
	}

}
