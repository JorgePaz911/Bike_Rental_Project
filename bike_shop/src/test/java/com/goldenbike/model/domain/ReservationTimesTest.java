package com.goldenbike.model.domain;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ReservationTimesTest {

	private ReservationTimes resTimes1;
	private ReservationTimes resTimes2;
	private ReservationTimes resTimes3;
	
	@Before
	public void setUp() {
		@SuppressWarnings("deprecation")
		Date date1 = new Date(5,5,2000);
		LocalTime time1 = LocalTime.of(5,5,5,5);
		resTimes1 = new ReservationTimes(date1,time1, time1);
		resTimes2 = new ReservationTimes();
		resTimes3 = new ReservationTimes(date1,time1, time1);
	}
	@Test
	public void testValidate() {
		assertTrue("resTimes1 validated",resTimes1.validate());
	}
	
	@Test
	public void testNotValidate() {
		assertFalse("resTimes2 Not validated", resTimes2.validate());
	}
	
	@Test
	public void testEquals() {
		assertTrue("resTimes1 equals resTimes3",resTimes1.equals(resTimes3));
	}
	
	@Test
	public void testNotEquals() {
		assertFalse("resTimes1 not equal to resTimes2",resTimes1.equals(resTimes2));
	}

}
