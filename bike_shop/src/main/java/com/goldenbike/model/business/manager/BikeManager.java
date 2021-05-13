package com.goldenbike.model.business.manager;

import java.util.Hashtable;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.services.bikeservice.IBikeSvc;
import com.goldenbike.model.services.exception.BikeIDException;
import com.goldenbike.model.services.exception.NullBikeException;
import com.goldenbike.model.services.factory.ServiceFactory;

/**
 * BikeManager implementation
 * @author Jorge Paz
 */
public class BikeManager extends ManagerSuperType{

	final static Logger logger = LogManager.getLogger();
	/**
	 * Stores the bike received with the received id
	 * @param bike
	 */
	public void create (Bike bike) {
		ServiceFactory serviceFactory = new ServiceFactory();
		IBikeSvc bikeSvc;
		try {
			bikeSvc = (IBikeSvc) serviceFactory.getService(IBikeSvc.NAME);
			bikeSvc.storeBike(bike);
		} catch (NullBikeException e) {
			logger.error("Bike is null :: BikeManager create");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Removes a bike from the inventory with the received id.
	 * @param id
	 */
	public void delete (int id) {
		ServiceFactory serviceFactory = new ServiceFactory();
		IBikeSvc bikeSvc;
		try {
			bikeSvc = (IBikeSvc) serviceFactory.getService(IBikeSvc.NAME);
			bikeSvc.removeBike(id);
			JOptionPane.showMessageDialog(null, "Bike successfully removed");
			logger.info("Bike successfully removed");
		} catch (BikeIDException e) {
			JOptionPane.showMessageDialog(null, "The bike ID does not exist");
			logger.info("The bike ID does not exist");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a bike from the inventory with the specified id
	 * @param id
	 * @return Returns a bike with the specified id
	 */
	public Bike get(int id) {
		ServiceFactory serviceFactory = new ServiceFactory();
		IBikeSvc bikeSvc = null;
		try {
			bikeSvc = (IBikeSvc) serviceFactory.getService(IBikeSvc.NAME);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bikeSvc.getBike(id);
	}
	
	/**
	 * Returns all the bikes in the inventory inside a hashtable
	 * @return Hashtable
	 */
	public Hashtable<Integer, Bike> getAll(){
		ServiceFactory serviceFactory = new ServiceFactory();
		IBikeSvc bikeSvc = null;
		try {
			bikeSvc = (IBikeSvc) serviceFactory.getService(IBikeSvc.NAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bikeSvc.getAllBikes();
	}
	
	/**
	 * Modifies a bike with the received id.
	 * @param id
	 * @param bike
	 */
	public void update(Bike bike) {
		ServiceFactory serviceFactory = new ServiceFactory();
		IBikeSvc bikeSvc = null;
		try {
			bikeSvc = (IBikeSvc) serviceFactory.getService(IBikeSvc.NAME);
			if(bikeSvc.getBike(bike.getBikeID()) == null) {
				throw new BikeIDException("Bike ID does not exist :: BikeManager update");
			} else {
				if (bike.validate() == true) {
					bikeSvc.removeBike(bike.getBikeID());
					bikeSvc.storeBike(bike);
					JOptionPane.showMessageDialog(null, "Bike successfully updated");
					logger.info("Bike successfully updated");
				}else {
					throw new NullBikeException("Null Bike :: BikeManager update");
				}
			}
			
		} catch (NullBikeException e) {
			logger.error("Null Bike :: BikeManager update");
			e.printStackTrace();
		} catch (BikeIDException e) {
			JOptionPane.showMessageDialog(null, "Bike ID does not exist");
			logger.info("Bike ID does not exist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
