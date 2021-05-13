package com.goldenbike.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class testing the CustomerName class
 * 
 * Tests validate() for a true case and for a false case
 * Tests equals() for a true case and for a false case
 * 
 * @author Jorge Paz
 *
 */
public class CustomerNameTest {

	   /**
	    * Tests a valid customer name
	    */
	@Test
	public void testValidate() {
		CustomerName name = new CustomerName("James", "Smith");
		assertTrue(name.validate());
	}

	   /**
	    * Tests a invalid customer name
	    */
	@Test
	public void testNotValidate() {
		CustomerName name = new CustomerName();
		assertFalse(name.validate());
	}
	
	   /**
	    * Tests if two customer names are equal
	    */
	@Test
	public void testEquals() {
		CustomerName name1 = new CustomerName("James", "Smith");
		CustomerName name2 = new CustomerName("James", "Smith");
		assertTrue(name1.equals(name2));
	}
	
	   /**
	    * Tests if two customer names are NOT equal
	    */
	@Test
	public void testNotEquals() {
		CustomerName name1 = new CustomerName("James", "Smith");
		CustomerName name2 = new CustomerName("Brian", "West");
		assertFalse(name1.equals(name2));
	}
}
