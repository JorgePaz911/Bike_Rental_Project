package com.goldenbike.view.reservationjframe;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.goldenbike.view.mainjframe.MainJFrameController;

import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;

/**
 * Golden Bike Reservation Menu
 * @author Jorge
 */
public class ReservationJFrame {

	private JInternalFrame frame;
	private JTextField txtJorge;
	private JTextField txtPaz;
	private JTextField textField_2;
	private JTextField txtEmail;
	private JLabel lblBikeId;
	private JTextField textField_4;
	private JLabel lblPickupDate;
	private JLabel lblPickupTime;
	private JLabel lblReturnTime;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnReserve;
	private MainJFrameController mjfc;
	private JDesktopPane desktop;


	/**
	 * Constructor
	 */
	public ReservationJFrame(MainJFrameController mainjfc) {
		mjfc = mainjfc;
		desktop = mjfc.getDesktop();
		initialize();
	}
	
	/**
	 * Reference to the frame
	 * @return JInternalFrame
	 */
	public JInternalFrame getFrame() {
		return frame;
	}
	
	/**
	 * Reference to the Reserve button
	 * @return JButton
	 */
	public JButton getReserveBtn() {
		return btnReserve;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField() {
		return txtJorge;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField1() {
		return txtPaz;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField2() {
		return textField_2;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField3() {
		return txtEmail;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField4() {
		return textField_4;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField5() {
		return textField_5;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField6() {
		return textField_6;
	}
	
	/**
	 * Reference to the field
	 * @return JTextField
	 */
	public JTextField getField7() {
		return textField_7;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JInternalFrame();
		frame.setMaximizable(true);
		frame.setIconifiable(true);
		frame.setResizable(true);
		frame.setClosable(true);
		frame.setTitle("Reservations");
		frame.setBounds(100, 100, 600, 511);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(29, 272, 62, 16);
		frame.getContentPane().add(lblFirstName);
		
		txtJorge = new JTextField();
		txtJorge.setBounds(106, 269, 116, 22);
		frame.getContentPane().add(txtJorge);
		txtJorge.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(29, 301, 62, 16);
		frame.getContentPane().add(lblLastName);
		
		txtPaz = new JTextField();
		txtPaz.setBounds(106, 298, 116, 22);
		frame.getContentPane().add(txtPaz);
		txtPaz.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone #");
		lblPhone.setBounds(39, 330, 56, 16);
		frame.getContentPane().add(lblPhone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(106, 327, 116, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-mail");
		lblNewLabel.setBounds(49, 359, 36, 16);
		frame.getContentPane().add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(106, 356, 116, 22);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblBikeId = new JLabel("Bike ID");
		lblBikeId.setBounds(262, 272, 56, 16);
		frame.getContentPane().add(lblBikeId);
		
		textField_4 = new JTextField();
		textField_4.setBounds(316, 269, 116, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		lblPickupDate = new JLabel("Pick-up date");
		lblPickupDate.setBounds(234, 301, 84, 16);
		frame.getContentPane().add(lblPickupDate);
		
		lblPickupTime = new JLabel("Pick-up time");
		lblPickupTime.setBounds(234, 330, 77, 16);
		frame.getContentPane().add(lblPickupTime);
		
		lblReturnTime = new JLabel("Return time");
		lblReturnTime.setBounds(234, 359, 70, 16);
		frame.getContentPane().add(lblReturnTime);
		
		textField_5 = new JTextField();
		textField_5.setBounds(316, 298, 116, 22);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(316, 327, 116, 22);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(316, 356, 116, 22);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		btnReserve = new JButton("Reserve");
		btnReserve.setBounds(219, 402, 116, 36);
		frame.getContentPane().add(btnReserve);
		btnReserve.addActionListener(new ReservationJFrameController(this));
		
		frame.setVisible(true);
		desktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
