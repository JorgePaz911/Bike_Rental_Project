package com.goldenbike.model.services.reservationservice;

import java.util.Hashtable;

import com.goldenbike.model.domain.Reservation;
import com.goldenbike.model.services.IService;

/**
 * Interface for Reservation Service
 * @author Jorge Paz
 */
public interface IReservationSvc extends IService {

	public final String NAME = "IReservationSvc";
	
	/**
	 * Stores a reservation in a file
	 * @param res
	 */
	public void storeReservation(Reservation res);
	
	/**
	 * Returns a reservation with specified ID
	 * @param id
	 * @return Reservation
	 */
	public Reservation getReservation(int id);
	
	/**
	 * Returns a hashtable with all the reservations stored in it
	 * @return Hashtable
	 */
	public Hashtable<Integer, Reservation> getAllReservations();
	
}
