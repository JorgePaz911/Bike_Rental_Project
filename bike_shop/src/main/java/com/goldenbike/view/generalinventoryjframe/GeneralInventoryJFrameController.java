package com.goldenbike.view.generalinventoryjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.goldenbike.model.business.manager.BikeManager;
import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.services.exception.BikeIDException;
import com.goldenbike.view.exception.InputException;

/**
 * General Inventory Menu Controller
 * @author Jorge
 *
 */
public class GeneralInventoryJFrameController implements ActionListener {

	private JButton addButton;
	private JButton removeButton;
	private JButton updateButton;
	private GeneralInventoryJFrame generalInv;
	private BikeManager bikeManager;
	final static Logger logger = LogManager.getLogger();
	
	/**
	 * constructor accessing instances of the 
	 * buttons in the GeneralInventoryJFrame class
	 * 
	 * @param Instance of GeneralInventoryJFrame class
	 */
	public GeneralInventoryJFrameController(GeneralInventoryJFrame gijf) {
		generalInv = gijf;
		addButton = generalInv.addButton();
		removeButton = generalInv.removeButton();
		updateButton = generalInv.updateButton();
	}

	/**
	 * Calls method depending on which button was 
	 * pressed from GeneralInventoryJFrame class
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(addButton)) {
			bikeAdd();
		}else if(e.getSource().equals(removeButton)) {
			bikeRemove();
		}else if(e.getSource().equals(updateButton)){
			bikeUpdate();
		}
		
	}
	
	/**
	 * Gets field components, creates a new bike with them, 
	 * and adds the bike to the general inventory
	 */
	private void bikeAdd() {
		bikeManager = new BikeManager();
		Bike bike = null;
		try {
			bike = new Bike(generalInv.getField1().getText(), 
							Integer.parseInt(generalInv.getField2().getText()),
							generalInv.getField3().getText(), 
							generalInv.getField4().getText(),
							Integer.parseInt(generalInv.getField().getText()));
			if(bike.getModel().equals("") ||
			   bike.getType().equals("") ||
			   bike.getOtherInfo().equals("")) {
				throw new InputException("Input Exception");
			}
			if(bikeManager.get(bike.getBikeID()) != null) {
				throw new BikeIDException("Bike ID already exists");
			}
			bikeManager.create(bike);
			JOptionPane.showMessageDialog(null, "Bike successfully created");
			logger.info("Bike successfully created");
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Invalid input");
			logger.info("Invalid input");
		}catch (InputException ie) {
			JOptionPane.showMessageDialog(null, "Invalid input");
			logger.info("Invalid input");
		} catch(BikeIDException bie) {
			JOptionPane.showMessageDialog(null, "Bike ID already exists");
			logger.info("Bike ID already exists");
		}
	}
	
	/**
	 * Gets field components and removes the bike from 
	 * the general inventory
	 */
	private void bikeRemove() {
		bikeManager = new BikeManager();
		try {
			bikeManager.delete(Integer.parseInt(generalInv.getField().getText()));
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Invalid input");
			logger.info("Invalid input");
		}
	}
	
	/**
	 * Gets field components, creates a new bike with them, 
	 * and updates the existing bike
	 */
	private void bikeUpdate() {
		bikeManager = new BikeManager();
		try {
			Bike bike = new Bike(generalInv.getField1().getText(), 
								 Integer.parseInt(generalInv.getField2().getText()),
								 generalInv.getField3().getText(), 
								 generalInv.getField4().getText(),
								 Integer.parseInt(generalInv.getField().getText()));
			if(bike.getModel().equals("") ||
			   bike.getType().equals("") ||
			   bike.getOtherInfo().equals("")) {
				throw new InputException("Input Exception");
			}
			bikeManager.update(bike);
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Invalid input");
			logger.info("Invalid input");
		}catch (InputException ie) {
			JOptionPane.showMessageDialog(null, "Invalid input");
			logger.info("Invalid input");
		}
	}
}
