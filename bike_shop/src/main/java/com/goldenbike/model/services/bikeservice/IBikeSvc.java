package com.goldenbike.model.services.bikeservice;

import java.util.Hashtable;

import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.services.IService;
import com.goldenbike.model.services.exception.BikeIDException;
import com.goldenbike.model.services.exception.NullBikeException;

/**
 * Interface for Bike Service
 * @author Jorge Paz 
 */
public interface IBikeSvc extends IService{

	public final String NAME = "IBikeSvc";
	
	/**
	 * storeBike method declaration
	 * @param bike - The bike to be stored in the file
	 * @throws BikeIDException - If the bike ID already exists in the file
	 */
	public void storeBike(Bike bike) throws NullBikeException;
	
	/**
	 * getBike method declaration
	 * @param id - ID used to search for a bike
	 * @throws BikeIDException - If the bike ID is not found in the file.
	 * @return Returns the bike that was found in the file with the bike id
	 */
	public Bike getBike(int id);
	
	/**
	 * Removes a bike from the general bike inventory
	 * @param id
	 * @throws BikeIDException
	 */	
	public void removeBike(int id) throws BikeIDException;
	
	/**
	 * Returns all of the bikes in the inventory inside a hashtable
	 * @return Hashtable
	 */
	public Hashtable<Integer, Bike> getAllBikes();
}
