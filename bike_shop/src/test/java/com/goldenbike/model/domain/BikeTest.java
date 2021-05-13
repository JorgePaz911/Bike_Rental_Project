package com.goldenbike.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class testing the Bike class
 * 
 * Tests validate() for a true case and for a false case
 * Tests equals() for a true case and for a false case
 * 
 * @author Jorge Paz.
 *
 */
public class BikeTest 
{
	
	   /**
	    * Tests a valid bike
	    */
		@Test
		public void testValidate() 
		{
			Bike b1 = new Bike("Pinarello", 2000, "Sport", "Black", 100);
			assertTrue("Bike b1 is valid", b1.validate());
		}
		
		   /**
		    * Tests an invalid bike
		    */
		@Test
		public void testNotValidate() 
		{
			Bike b1 = new Bike();
			assertFalse("Bike b1 is not valid", b1.validate());
		}
		
		   /**
		    * Tests if two bikes are equal
		    */
		@Test
		public void testEqualsBike() 
		{
			Bike b1 = new Bike("Holcast", 2015, "Casual", "Blue",100);
			Bike b2 = new Bike("Holcast", 2015, "Casual", "Blue",100);
			assertTrue("b1 is equal to b2", b1.equals(b2));
		}
		
		   /**
		    * Tests if two bikes are NOT equal
		    */
		@Test
		public void testNotEqualsBike() 
		{
			Bike b1 = new Bike("Holcast", 2015, "Casual", "Blue",100);
			Bike b2 = new Bike("Pinarello", 2000, "Sport", "Black",100);
			assertFalse("b1 is NOT equal to b2", b1.equals(b2));
		}
}


