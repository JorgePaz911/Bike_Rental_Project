package com.goldenbike.model.domain;

import java.io.Serializable;

/**
 * Domain Customer class that manages customer information like name, e-mail and phone number
 * @author Jorge Paz
 */
@SuppressWarnings("serial")
public class Customer implements Serializable {

	/** Name of the customer */
	private CustomerName name;
	
	
	/** Customer e-mail */
	private String email;
	
	/** Customer phone number */
	private String phone;
	
	/**
	 * Default constructor
	 */
	public Customer() {
		
	}

	/**
	 * @param name
	 * @param email
	 * @param phone
	 */
	public Customer(CustomerName name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	/**
	 * @return Returns the name.
	 */
	public CustomerName getName() {
		return name;
	}

	/**
	 * @param name. Sets the name
	 */
	public void setName(CustomerName name) {
		this.name = name;
	}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email. Sets the e-mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone. Sets the phone number
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 *  @return Returns the state of the object in a String format
	 */
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	/**
	 * hashCode() auto-generated using right-click--> Source--> Generate hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	/**
	 * @param cust
	 * @return returns boolean
	 */
	public boolean equals(Customer cust) {
		if(!name.equals(cust.name))
			return false;
		if(!email.equals(cust.email))
			return false;
		if(!phone.equals(cust.phone))
			return false;
		return true;
	}

	/**
	 * Validates if instance variables are initialized
	 * @return returns boolean
	 */
	public boolean validate() 
	{
		if(name == null)
			return false;
		if(email == null)
			return false;
		if(phone == null)
			return false;
		return true;
	}
	
	
	
}
