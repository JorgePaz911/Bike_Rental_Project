package com.goldenbike.model.business.manager;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import com.goldenbike.model.domain.Reservation;

public class ReservationManagerTest {

	private ReservationManager resManager;
	private Hashtable<Integer,Reservation> table;
	@Before
	public void setUp() {
		resManager = new ReservationManager();
	}
	
	/**
	 * Tests if reservation 1 exists, which was created through the
	 * presentation layer 
	 */
	@Test
	public void testGetandCreate() {
		Reservation res1 = resManager.get(1);
		assertTrue(res1 != null);
	}
	
	/**
	 * Tests that reservation #5000 does not exist.
	 */
	@Test
	public void testNotGetandCreate() {
		Reservation res2 = resManager.get(50000);
		assertFalse(res2 != null);
	}
	
	/**
	 * Grabs the reservation hashtable and asserts it is not empty
	 */
	@Test
	public void testGetAll() {
		table = resManager.getAll();
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
