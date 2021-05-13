package com.goldenbike.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import com.goldenbike.model.business.manager.BikeManager;
import com.goldenbike.model.business.manager.ReservationManager;
import com.goldenbike.model.domain.Bike;
import com.goldenbike.model.domain.Reservation;
import com.goldenbike.view.generalinventoryjframe.GeneralInventoryJFrame;
import com.goldenbike.view.reservationjframe.ReservationJFrame;

/**
 * Main Menu Controller
 * @author Jorge
 *
 */
public class MainJFrameController implements ActionListener {


	private MainJFrame main;
	private JTable table;
	private BikeManager bikeManager;
	private ReservationManager resManager;
	private Hashtable<Integer, Bike> bikeTable;
	private Hashtable<Integer, Reservation> resTable;
	private JDesktopPane desktop;

	/**
	 * constructor accessing instances of the 
	 * buttons in MainJFrame class
	 * 
	 * @param Instance of MainJFrame class
	 */
	public MainJFrameController(MainJFrame mjf) {
		main = mjf;
		desktop = main.getDesktop();
	}
	
	public JDesktopPane getDesktop() {
		return desktop;
	}
	
	/**
	 * Calls method depending on which button was 
	 * pressed from MainJFrame class
	 */
	public void actionPerformed(ActionEvent e) {
	
		if("Inventory".equals(e.getActionCommand())) {
			createBikeTable();
		}else if("Reservations".equals(e.getActionCommand())) {
			createInventoryTable();
		}else if("Exit".equals(e.getActionCommand())) {
			exitApplication();
		}
	}
	
	/**
	 * Calls the next frame and creates a table using all of the bikes in 
	 * the general inventory
	 */
	private void createBikeTable() {
		GeneralInventoryJFrame gijf = new GeneralInventoryJFrame(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 13, 447, 200);
		gijf.getFrame().getContentPane().add(scrollPane);
		
		bikeManager = new BikeManager();
		bikeTable = bikeManager.getAll();
		Object[][] data = new Object[bikeTable.size()][5];
		int row = 0;
		for (Object key : bikeTable.keySet()) {
		    data[row][0] = key;
		    Bike bike = (Bike)bikeTable.get(key);
		    data[row][1] = bike.getModel();
		    data[row][2] = bike.getYear();
		    data[row][3] = bike.getType();
		    data[row][4] = bike.getOtherInfo();
		    row++;
		}
		String[] headers = {"Bike ID", "Bike Model", "Year", "Type", "Other Info"};
		table = new JTable(data, headers);
		scrollPane.setViewportView(table);
		
	}

	/**
	 * Calls the next frame and creates a table using all of the reservations in 
	 * the reservations file
	 */
	@SuppressWarnings("static-access")
	private void createInventoryTable() {
		ReservationJFrame rjf = new ReservationJFrame(this);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 13, 447, 200);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		rjf.getFrame().getContentPane().add(scrollPane);
		
		resManager = new ReservationManager();
		resTable = resManager.getAll();
		Object[][] data = new Object[resTable.size()][8];
		int row = 0;
		for (Object key : resTable.keySet()) {
		    data[row][0] = key;
		    Reservation res = (Reservation)resTable.get(key);
		    data[row][1] = res.getReservationTimes().getPickUpDate();
		    data[row][2] = res.getReservationTimes().getPickUpTime();
		    data[row][3] = res.getReservationTimes().getReturnTime();
		    data[row][4] = res.getBike().getBikeID();
		    data[row][5] = res.getCustomer().getName().getFirstName();
		    data[row][6] = res.getCustomer().getName().getLastName();
		    data[row][7] = res.getCustomer().getPhone();
		    row++;
		}
		String[] headers = {"Res ID","Pickup Date", "Pickup Time", "Return Time", "Bike ID", "First Name","Last Name", "Phone #"};
		table = new JTable(data, headers);
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
	}
	
	/**
	 * Exits the application
	 */
	private void exitApplication() {
		System.exit(0);
	}
}
