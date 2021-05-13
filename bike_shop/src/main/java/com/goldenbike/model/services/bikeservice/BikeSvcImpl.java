package com.goldenbike.model.services.bikeservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.services.exception.BikeIDException;
import com.goldenbike.model.services.exception.NullBikeException;

/**
 * Implementation for the Bike Service
 * @author Jorge Paz
 */
public class BikeSvcImpl implements IBikeSvc {

	private Hashtable<Integer,Bike> bikeTable = new Hashtable<Integer,Bike>();
	final static Logger logger = LogManager.getLogger();
	/**
	 * storeBike method declaration
	 * @param bike - The bike to be stored in the file
	 * @throws BikeIDException - If the bike ID already exists in the file
	 */
	@SuppressWarnings("unchecked")
	public void storeBike(Bike bike) throws NullBikeException {
				
		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		File file = new File("RegisteredBikes.txt");
		boolean exists = file.exists();
		try {
			if (exists == true) {
				input = new ObjectInputStream(new FileInputStream("RegisteredBikes.txt"));
				bikeTable = (Hashtable<Integer, Bike>) input.readObject();
			}
			if (bike.validate() == false) {
				throw new NullBikeException("Cannot Store a null bike");
			}
			bikeTable.put(bike.getBikeID(), bike);
			output = new ObjectOutputStream(new FileOutputStream("RegisteredBikes.txt"));
			output.writeObject(bikeTable);

		} catch (FileNotFoundException e) {
			logger.error("File with registered bikes not found");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException while searching for file with registered bikes");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Class not found while reading files with registered bikes");
			e.printStackTrace();
		} finally {
			try {
				if (input != null)
					input.close();
				if (output != null) {
					output.flush();
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * getBike method declaration
	 * @param id - ID used to search for a bike
	 * @throws BikeIDException - If the bike ID is not found in the file.
	 * @return Returns the bike that was found in the file with the bike id
	 */
	@SuppressWarnings("unchecked")
	public Bike getBike(int id) {
		ObjectInputStream input = null;
		File file = new File("RegisteredBikes.txt");
		boolean exists = file.exists();
		try {
			if (exists) {
				input = new ObjectInputStream(new FileInputStream("RegisteredBikes.txt"));
				bikeTable = (Hashtable<Integer, Bike>) input.readObject();
			}
		} catch (FileNotFoundException e) {
			logger.error("File with registered bikes not found");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException while searching for file with registered bikes");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Class not found while reading files with registered bikes");
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bikeTable.get(id);
	}
	
	/**
	 * Returns all of the bikes in the inventory inside a hashtable
	 * @return Hashtable
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<Integer, Bike> getAllBikes(){
		ObjectInputStream input = null;
		File file = new File("RegisteredBikes.txt");
		boolean exists = file.exists();
		try {
			if (exists) {
				input = new ObjectInputStream(new FileInputStream("RegisteredBikes.txt"));
				bikeTable = (Hashtable<Integer, Bike>) input.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return bikeTable;
	}
	
	/**
	 * Removes a bike from the general bike inventory
	 * @param id
	 * @throws BikeIDException
	 */
	@SuppressWarnings("unchecked")
	public void removeBike(int id) throws BikeIDException{
		ObjectInputStream input = null;
		ObjectOutputStream output = null;
		File file = new File("RegisteredBikes.txt");
		boolean exists = file.exists();
		try {
			if (exists) {
				input = new ObjectInputStream(new FileInputStream("RegisteredBikes.txt"));
				bikeTable = (Hashtable<Integer, Bike>) input.readObject();
			}
			if (bikeTable.get(id) == null) {
				throw new BikeIDException("Bike ID not found :: removeBike");
			} else {
				bikeTable.remove(id);

				output = new ObjectOutputStream(new FileOutputStream("RegisteredBikes.txt"));
				output.writeObject(bikeTable);
			}

		} catch (FileNotFoundException e) {
			logger.error("File with registered bikes not found");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException while searching for file with registered bikes");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.error("Class not found while reading files with registered bikes");
			e.printStackTrace();
		}finally {
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.flush();
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
