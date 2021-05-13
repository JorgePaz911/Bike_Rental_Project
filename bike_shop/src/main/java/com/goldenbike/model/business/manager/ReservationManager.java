package com.goldenbike.model.business.manager;

import java.time.LocalTime;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.domain.Reservation;
import com.goldenbike.model.services.factory.ServiceFactory;
import com.goldenbike.model.services.reservationservice.IReservationSvc;
import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Reservation Manager Implementation
 * @author Jorge
 */
public class ReservationManager extends ManagerSuperType {

	final static Logger logger = LogManager.getLogger();
	/**
	 * Stores a reservation if all conditions are met
	 * @param res
	 */
	public void create(Reservation res) {
		ServiceFactory serviceFactory = new ServiceFactory();
		IReservationSvc resSvc = null;
		try {
			resSvc = (IReservationSvc) serviceFactory.getService(IReservationSvc.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Hashtable<Integer, Reservation> resTable = resSvc.getAllReservations();
		LocalTime newPickupTime = res.getReservationTimes().getPickUpTime();
		LocalTime newReturnTime = res.getReservationTimes().getReturnTime();
		Date newPickupDate = res.getReservationTimes().getPickUpDate();
		boolean allowRes = true;
		if (resTable.size() == 0) {
			resSvc.storeReservation(res);
			JOptionPane.showMessageDialog(null, "Reservation successful");
			logger.info("Reservation successful");
		} else {
			for (Object key : resTable.keySet()) {
				Bike bike = (Bike) resTable.get(key).getBike();
				LocalTime oldPickupTime = resTable.get(key).getReservationTimes().getPickUpTime();
				LocalTime oldReturnTime = resTable.get(key).getReservationTimes().getReturnTime();
				Date oldPickupDate = resTable.get(key).getReservationTimes().getPickUpDate();
				if (bike.getBikeID() == res.getBike().getBikeID()) {
					if (oldPickupDate.equals(newPickupDate)) {
						if (newPickupTime.compareTo(oldPickupTime) >= 0) {
							if(MINUTES.between(oldReturnTime, newPickupTime)>59) {
								
							}else {
								allowRes = false;
							}
						} else if(newPickupTime.isBefore(oldPickupTime)){
							if(MINUTES.between(newReturnTime,oldPickupTime)>59 &&
								MINUTES.between(newPickupTime, oldPickupTime) >89) {
								
							}else {
								allowRes = false;
							}
						}
					}
				}
			}
			if (allowRes == true) {
				resSvc.storeReservation(res);
				JOptionPane.showMessageDialog(null, "Reservation successful");
				logger.info("Reservation successful");
			}else {
				JOptionPane.showMessageDialog(null, "Bike not available during those times");
				logger.info("Bike not available during those times");
			}
		}
	}
	
	/**
	 * returns a specific reservation using its ID
	 * @param id
	 * @return Reservation
	 */
	public Reservation get(int id) {
		ServiceFactory serviceFactory = new ServiceFactory();
		IReservationSvc resSvc = null;
		try {
			resSvc = (IReservationSvc) serviceFactory.getService(IReservationSvc.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resSvc.getReservation(id); 
	}
	
	/**
	 * Returns a Hashtable containing all the reservations
	 * @return Hashtable
	 */
	public Hashtable<Integer,Reservation> getAll() {
		ServiceFactory serviceFactory = new ServiceFactory();
		IReservationSvc resSvc = null;
		try {
			resSvc = (IReservationSvc) serviceFactory.getService(IReservationSvc.NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resSvc.getAllReservations();
	}
}
