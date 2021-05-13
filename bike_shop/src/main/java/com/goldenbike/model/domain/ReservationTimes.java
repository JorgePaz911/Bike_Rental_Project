package com.goldenbike.model.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

/**
 * Domain ReservationTimes class that manages Pickup Date, Pickup Time and Return Time
 * @author Jorge Paz
 */
@SuppressWarnings("serial")
public class ReservationTimes implements Serializable {

	/**Date of bike pickup**/
	private Date pickUpDate;
	
	/**Time of bike pickup**/
	private LocalTime pickUpTime;
	
	/**Time of bike return**/
	private LocalTime returnTime;
	
	/**
	 * Default Constructor
	 */
	public ReservationTimes() {
		
	}

	/**
	 * Constructor
	 * @param pickUpDate
	 * @param pickUpTime
	 * @param returnTime
	 */
	public ReservationTimes(Date pickUpDate, LocalTime pickUpTime, LocalTime returnTime) {
		this.pickUpDate = pickUpDate;
		this.pickUpTime = pickUpTime;
		this.returnTime = returnTime;
	}

	/**
	 * @return Returns pickUpDate
	 */
	public Date getPickUpDate() {
		return pickUpDate;
	}

	/**
	 * Sets pick up date
	 * @param pickUpDate
	 */
	public void setPickUpDate(Date pickUpDate) {
		this.pickUpDate = pickUpDate;
	}

	/**
	 * @return Returns pickUpTime
	 */
	public LocalTime getPickUpTime() {
		return pickUpTime;
	}

	/**
	 * Sets pick up time
	 * @param pickUpTime
	 */
	public void setPickUpTime(LocalTime pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	/**
	 * @return Returns returnTime
	 */
	public LocalTime getReturnTime() {
		return returnTime;
	}

	/**
	 * Sets return time
	 * @param returnTime
	 */
	public void setReturnTime(LocalTime returnTime) {
		this.returnTime = returnTime;
	}

	/**
	 * Returns the state of the object in String format
	 */
	public String toString() {
		return "ReservationTimes [pickUpDate=" + pickUpDate + ", pickUpTime=" + pickUpTime + ", returnTime="
				+ returnTime + "]";
	}

	/**
	 * hashCode() auto-generated using right-click--> Source--> Generate hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pickUpDate == null) ? 0 : pickUpDate.hashCode());
		result = prime * result + ((pickUpTime == null) ? 0 : pickUpTime.hashCode());
		result = prime * result + ((returnTime == null) ? 0 : returnTime.hashCode());
		return result;
	}

	/**
	 * @param rt
	 * @return Returns Boolean
	 */
	public boolean equals(ReservationTimes rt) {
		if(!pickUpDate.equals(rt.pickUpDate))
			return false;
		if(!returnTime.equals(rt.returnTime))
			return false;
		if(!pickUpTime.equals(rt.getPickUpTime()))
			return false;
		return true;
	}
	
	/**
	 * @return Returns Boolean
	 */
	public boolean validate() {
		if(pickUpDate == null)
			return false;
		if(pickUpTime == null)
			return false;
		if(returnTime == null)
			return false;
		return true;
	}
	
}
