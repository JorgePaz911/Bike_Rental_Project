package com.goldenbike.model.domain;

import java.io.Serializable;

/**
 * Domain Bike class that manages information like model, year, type and other info
 * @author Jorge Paz
 */

@SuppressWarnings("serial")
public class Bike implements Serializable
{
	/** Model name of the bike*/
	private String model;
	
	/** Year of the bike */
	private int year;
	
	/** Type of bike */
	private String type;
	
	/** Extra information that can be included about the bike */
	private String otherInfo;
	
	/** Bike identification number**/
	private int bikeID;
	
	
	/**
	 * Default constructor
	 */
	public Bike() 
	{
		
	}
	
	/**
	 * @param model
	 * @param year
	 * @param type
	 * @param otherInfo
	 * @param BikeID
	 */
	public Bike(String model, int year, String type, String otherInfo, int bikeID) 
	{		
		this.model = model;
		this.year = year;
		this.type = type;
		this.otherInfo = otherInfo;	
		this.bikeID = bikeID;
	}

	/**
	 * @return Returns the Bike ID
	 */
	public int getBikeID() {
		return bikeID;
	}

	/**
	 * sets the Bike ID
	 * @param bikeID
	 */
	public void setBikeID(int bikeID) {
		this.bikeID = bikeID;
	}

	/**
	 * @return Returns the model.
	 */
	public String getModel() 
	{
		return model;
	}

	/**
	 * @param model. Sets the bike model
	 */
	public void setModel(String model) 
	{
		this.model = model;
	}
	
	/**
	 * @return Returns the year.
	 */
	public int getYear() 
	{
		return year;
	}

	/**
	 * @param year. Sets the bike year
	 */
	public void setYear(int year) 
	{
		this.year = year;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() 
	{
		return type;
	}

	/**
	 * @param model. Sets the bike type
	 */
	public void setType(String type) 
	{
		this.type = type;
	}

	/**
	 * @return Returns the otherInfo.
	 */
	public String getOtherInfo() 
	{
		return otherInfo;
	}

	/**
	 * @param model. Sets otherInfo
	 */
	public void setOtherInfo(String otherInfo) 
	{
		this.otherInfo = otherInfo;
	}

	/**
	 * returns String with all the bike details.
	 */
	public String toString() {
		return "Bike [model=" + model + ", year=" + year + ", type=" + type + ", otherInfo=" + otherInfo + ", bikeID="
				+ bikeID + "]";
	}
	
	/**
	 * hashCode() auto-generated using right-click--> Source--> Generate hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bikeID;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((otherInfo == null) ? 0 : otherInfo.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + year;
		return result;
	}

	/**
	 * @param bike
	 * @return returns boolean
	 */
	public boolean equals(Bike bike) 
	{
		if (!model.equals(bike.model)) 
			return false;
		if (year != bike.year) 
			return false;
		if (!type.equals(bike.type)) 
			return false;
		if (!otherInfo.equals(bike.otherInfo)) 
			return false;
		if (bikeID != bike.bikeID)
			return false;
		return true;
	}

	/**
	 * Validates if instance variables are initialized
	 * @return returns boolean
	 */
	public boolean validate() 
	{
		if(model == null)
			return false;
		if(type == null)
			return false;
		if(year == 0)
			return false;
		if(otherInfo == null)
			return false;
		return true;
	}
	
	
	
	
}