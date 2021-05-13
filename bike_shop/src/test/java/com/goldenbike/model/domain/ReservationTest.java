package com.goldenbike.model.domain;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ReservationTest {

	private Reservation res1;
	private Reservation res2;
	private Reservation res3;
	private Reservation res4;

	@Before
	public void setUp() {
		CustomerName name = new CustomerName("James", "Smith");
		Customer c1 = new Customer(name, "smith@hotmail.com", "1111111");
		Bike b1 = new Bike("Pinarello", 2000, "Sport", "Black", 100);
		Bike b2 = new Bike("Carrera", 2000, "Sport", "Black", 100);
		@SuppressWarnings("deprecation")
		Date date1 = new Date(5,5,2000);
		LocalTime time1 = LocalTime.of(5,5,5,5);
		ReservationTimes resTimes = new ReservationTimes(date1,time1, time1);
		res1 = new Reservation(c1, b1, resTimes);
		res2 = new Reservation();
		res3 = new Reservation(c1,b1,resTimes);
		res4 = new Reservation(c1,b2,resTimes);
	}
	
	@Test
	public void testValidate() {
		assertTrue("res1 validate", res1.validate());
	}
	
	@Test
	public void testNotValidate() {
		assertFalse("res2 not validate", res2.validate());	
	}

	@Test
	public void testEquals() {
		assertTrue("res1 equals res3", res1.equals(res3));
	}
	
	@Test
	public void testNotEquals() {
		assertFalse("res1 not equals res4", res1.equals(res4));
	}
}
