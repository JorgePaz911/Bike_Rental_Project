package com.goldenbike.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class testing the Customer class
 * 
 * Tests validate() for a true case and for a false case
 * Tests equals() for a true case and for a false case
 * 
 * @author Jorge Paz
 *
 */
public class CustomerTest {

	   /**
	    * Tests a valid customer
	    */
		@Test
		public void testValidate() 
		{
			CustomerName name = new CustomerName("James", "Smith");
			Customer c1 = new Customer(name, "smith@hotmail.com", "1111111");
			assertTrue("Customer c1 is valid", c1.validate());
		}
		
		   /**
		    * Tests an invalid customer
		    */
		@Test
		public void testNotValidate() 
		{
			Customer c1 = new Customer();
			assertFalse("Customer c1 is not valid", c1.validate());
		}
		
		   /**
		    * Tests if two customers are equal
		    */
		@Test
		public void testEqualsBike() 
		{
			CustomerName name = new CustomerName("James", "Smith");
			Customer c1 = new Customer(name, "smith@hotmail.com", "1111111");
			Customer c2 = new Customer(name, "smith@hotmail.com", "1111111");
			assertTrue("c1 is equal to c2", c1.equals(c2));
		}
		
		   /**
		    * Tests if two customers are NOT equal
		    */
		@Test
		public void testNotEqualsBike() 
		{
			CustomerName name = new CustomerName("James", "Smith");
			CustomerName name2 = new CustomerName("Michael", "Jones");
			Customer c1 = new Customer(name, "smith@hotmail.com", "1111111");
			Customer c2 = new Customer(name2, "jordan@hotmail.com", "2222222");
			assertFalse("c1 is NOT equal to c2", c1.equals(c2));
		}
}
