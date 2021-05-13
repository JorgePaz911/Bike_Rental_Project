package com.goldenbike.model.domain;

import java.io.Serializable;

/**
 * Domain CustomerName class that manages the Customer Name
 * @author Jorge Paz
 */
@SuppressWarnings("serial")
public class CustomerName implements Serializable {

	/** First Name of the customer */
	private String firstName;
	
	/** Last Name of the customer */
	private String lastName;
	
	/**
	 * Default constructor
	 */
	public CustomerName() {

	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public CustomerName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName. Sets the firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName. Sets the lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 *  @return Returns the state of the object in a String format
	 */
	public String toString() {
		return "CustomerName [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	/**
	 * hashCode() auto-generated using right-click--> Source--> Generate hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/**
	 * @param cust
	 * @return returns boolean
	 */
	public boolean equals(CustomerName cust) {
		if(!firstName.equals(cust.firstName))
			return false;
		if(!lastName.equals(cust.lastName))
			return false;
		return true;
	}
	
	/**
	 * Validates if instance variables are initialized
	 * @return returns boolean
	 */
	public boolean validate() {
		if(firstName == null)
			return false;
		if(lastName == null)
			return false;
		return true;
	}
	
}
