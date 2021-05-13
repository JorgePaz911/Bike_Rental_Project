package com.goldenbike.view.reservationjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.goldenbike.model.business.manager.BikeManager;
import com.goldenbike.model.business.manager.ReservationManager;
import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.domain.Customer;
import com.goldenbike.model.domain.CustomerName;
import com.goldenbike.model.domain.Reservation;
import com.goldenbike.model.domain.ReservationTimes;
import com.goldenbike.model.services.exception.BikeIDException;
import com.goldenbike.view.exception.InputException;

/**
 * Reservation Menu Controller
 * @author Jorge
 */
public class ReservationJFrameController implements ActionListener {

	private ReservationJFrame resjf;
	private JButton reserveBtn;
	private ReservationManager resManager;
	private BikeManager bikeManager;
	final static Logger logger = LogManager.getLogger();
	
	/**
	 * Constructor
	 * @param rjf
	 */
	public ReservationJFrameController(ReservationJFrame rjf) {
		resjf = rjf;
		reserveBtn = resjf.getReserveBtn();	
	}
	
	/**
	 * Calls method depending on which button was 
	 * pressed from ReservationJFrame class
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(reserveBtn)) {
			reservationAdd();
		}
	}
	
	/**
	 * Creates a new reservation using the fields entered by the user.
	 * Checks certain conditions before creating the new reservation.
	 */
	@SuppressWarnings("deprecation")
	private void reservationAdd() {
		resManager = new ReservationManager();
		bikeManager = new BikeManager();
		Date date = null;
		ReservationTimes resTimes = null;
		Customer customer = null;
		Bike bike = null;
		DateTimeFormatter parser = null;
		try {
			CustomerName custName = new CustomerName(resjf.getField().getText(), resjf.getField1().getText());
			customer = new Customer(custName, resjf.getField3().getText(), resjf.getField2().getText());
			bike = bikeManager.get(Integer.parseInt(resjf.getField4().getText()));
			if (bike == null) {
				throw new BikeIDException("Bike ID Exception");
			}
			DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
			parser = DateTimeFormatter.ofPattern("h[:mm]a");
			date = format.parse(resjf.getField5().getText());
			resTimes = new ReservationTimes(date, LocalTime.parse(resjf.getField6().getText(), parser),
					LocalTime.parse(resjf.getField7().getText(), parser));
			if(customer.getName().getFirstName().equals("") || customer.getName().getLastName().equals("") ||
			   customer.getEmail().equals("") || customer.getPhone().equals("")) {
				throw new InputException("Input Format Exception");
			}
			Date todayDate = new Date();
			LocalTime nowTime = LocalTime.now();
			if (resTimes.getPickUpDate().getDate() == todayDate.getDate()
				|| resTimes.getPickUpDate().after(todayDate)) {
				if (resTimes.getPickUpTime().isAfter(nowTime) 
					|| resTimes.getPickUpDate().getDate() != todayDate.getDate()) {
					if (resTimes.getReturnTime().isAfter(resTimes.getPickUpTime().plusMinutes(29))) {
						if (resTimes.getPickUpTime().isAfter(LocalTime.parse("9:59AM", parser))
							&& resTimes.getPickUpTime().isBefore(LocalTime.parse("6:01PM", parser))
							&& resTimes.getReturnTime().isBefore(LocalTime.parse("6:01PM", parser))) {
							Reservation reservation = new Reservation(customer, bike, resTimes);
							resManager.create(reservation);
						} else {
							JOptionPane.showMessageDialog(null, "Rentals allowed only between 10AM-6PM");
							logger.info("Rentals allowed only between 10AM-6PM");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Reservation must be at least 30 min");
						logger.info("Reservation must be at least 30 min");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Cannot reserve Time in the past");
					logger.info("Cannot reserve Time in the past");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Cannot reserve Date in the past");
				logger.info("Cannot reserve Date in the past");
			}
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Invalid date. Enter MMMM dd, yyyy");
			logger.info("Invalid date. Enter MMMM dd, yyyy");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid Bike ID");
			logger.info("Invalid Bike ID");
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Invalid Time. Enter time followed by PM or AM eg. 1PM, 11:30AM");
			logger.info("Invalid Time. Enter time followed by PM or AM eg. 1PM, 11:30AM");
		} catch (BikeIDException bie) {
			JOptionPane.showMessageDialog(null, "Bike ID does not exist");
			logger.info("Bike ID does not exist");
		}catch (InputException ife) {
			JOptionPane.showMessageDialog(null, "Invalid Input");
			logger.info("Invalid Input");
		}
	}

}
