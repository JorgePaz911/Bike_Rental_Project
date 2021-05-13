package com.goldenbike.model.services.reservationservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import com.goldenbike.model.domain.Reservation;

/**
 * Interface method implementation
 * @author Jorge
 */
public class ReservationSvcImpl implements IReservationSvc{

	/**Hashtable used to manipulate reservations stored**/
	private Hashtable<Integer,Reservation> resTable = new Hashtable<Integer,Reservation>();
	
	/**
	 * Stores a reservation in a file
	 * @param res
	 */
	@SuppressWarnings("unchecked")
	public void storeReservation(Reservation res) {
		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		File file = new File("Reservations.txt");
		boolean exists = file.exists();
		try {
			if (exists) {
				input = new ObjectInputStream(new FileInputStream("Reservations.txt"));
				resTable = (Hashtable<Integer, Reservation>) input.readObject();
			}
			resTable.put(resTable.size() + 1, res);
			output = new ObjectOutputStream(new FileOutputStream("Reservations.txt"));
			output.writeObject(resTable);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
	 * Returns a reservation with specified ID
	 * @param id
	 * @return Reservation
	 */
	@SuppressWarnings("unchecked")
	public Reservation getReservation(int id) {
		ObjectInputStream input = null;
		File file = new File("Reservations.txt");
		boolean exists = file.exists();
		try {
			if (exists) {
				input = new ObjectInputStream(new FileInputStream("Reservations.txt"));
				resTable = (Hashtable<Integer, Reservation>) input.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resTable.get(id);
	}

	/**
	 * Returns a hashtable with all the reservations stored in it
	 * @return Hashtable
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<Integer, Reservation> getAllReservations() {
		ObjectInputStream input = null;
		File file = new File("Reservations.txt");
		boolean exists = file.exists();
		try {
			if(exists) {
			input = new ObjectInputStream(new FileInputStream("Reservations.txt"));
			resTable = (Hashtable<Integer, Reservation>) input.readObject();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(input != null)
						input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return resTable;
	}

}
