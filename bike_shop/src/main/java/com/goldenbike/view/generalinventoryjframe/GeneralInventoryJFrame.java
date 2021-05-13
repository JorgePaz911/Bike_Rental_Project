package com.goldenbike.view.generalinventoryjframe;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import com.goldenbike.view.mainjframe.MainJFrameController;
import javax.swing.JLabel;
import java.beans.PropertyVetoException;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

/**
 * General Inventory Menu
 * @author Jorge
 *
 */
@SuppressWarnings("serial")
public class GeneralInventoryJFrame extends JInternalFrame{

	private JInternalFrame frmGeneralBikeInventory;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnAddBike;
	private JButton btnRemoveBike;
	private JButton btnUpdateBike;
	private MainJFrameController mjfc;
	private JDesktopPane desktop;

	/**
	 * Constructor
	 */
	public GeneralInventoryJFrame(MainJFrameController mainjfc) {
		mjfc = mainjfc;
		desktop = mjfc.getDesktop();
		initialize();
	}
	
	/**
	 * returns the general bike inventory frame
	 * @return JFrame
	 */
	public JInternalFrame getFrame() {
		return frmGeneralBikeInventory;
	}
	
	/**
	 * returns the add bike button
	 * @return JButton
	 */
	public JButton addButton(){
		return btnAddBike;
	}
	
	/**
	 * returns the remove bike button
	 * @return JButton
	 */
	public JButton removeButton(){
		return btnRemoveBike;
	}
	
	/**
	 * returns the update bike button
	 * @return JButton
	 */
	public JButton updateButton(){
		return btnUpdateBike;
	}

	/**
	 * returns the contents of the field
	 * @return JTextField
	 */
	public JTextField getField() {
		return textField;
	}
	
	/**
	 * returns the contents of the field
	 * @return JTextField
	 */
	public JTextField getField1() {
		return textField_1;
	}
	
	/**
	 * returns the contents of the field
	 * @return JTextField
	 */
	public JTextField getField2() {
		return textField_2;
	}
	
	/**
	 * returns the contents of the field
	 * @return JTextField
	 */
	public JTextField getField3() {
		return textField_3;
	}
	
	/**
	 * returns the contents of the field
	 * @return JTextField
	 */
	public JTextField getField4() {
		return textField_4;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneralBikeInventory = new JInternalFrame();
		frmGeneralBikeInventory.setMaximizable(true);
		frmGeneralBikeInventory.setIconifiable(true);
		frmGeneralBikeInventory.setResizable(true);
		frmGeneralBikeInventory.setClosable(true);
		frmGeneralBikeInventory.setTitle("General Bike Inventory");
		frmGeneralBikeInventory.setBounds(100, 100, 600, 511);
		frmGeneralBikeInventory.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(114, 243, 116, 22);
		frmGeneralBikeInventory.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 313, 116, 22);
		frmGeneralBikeInventory.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(347, 243, 116, 22);
		frmGeneralBikeInventory.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(114, 278, 116, 22);
		frmGeneralBikeInventory.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(347, 278, 116, 22);
		frmGeneralBikeInventory.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblBikeId = new JLabel("Bike ID");
		lblBikeId.setBounds(31, 246, 56, 16);
		frmGeneralBikeInventory.getContentPane().add(lblBikeId);
		
		JLabel lblNewLabel = new JLabel("Bike Type");
		lblNewLabel.setBounds(31, 281, 71, 16);
		frmGeneralBikeInventory.getContentPane().add(lblNewLabel);
		
		JLabel lblBikeYear = new JLabel("Bike Model");
		lblBikeYear.setBounds(31, 316, 75, 16);
		frmGeneralBikeInventory.getContentPane().add(lblBikeYear);
		
		JLabel lblBikeType = new JLabel("Bike Year");
		lblBikeType.setBounds(279, 246, 56, 16);
		frmGeneralBikeInventory.getContentPane().add(lblBikeType);
		
		JLabel lblBikeInfo = new JLabel("Bike Info");
		lblBikeInfo.setBounds(279, 281, 56, 16);
		frmGeneralBikeInventory.getContentPane().add(lblBikeInfo);
		
		btnAddBike = new JButton("Add Bike");
		btnAddBike.setBounds(31, 382, 110, 45);
		frmGeneralBikeInventory.getContentPane().add(btnAddBike);
		btnAddBike.addActionListener(new GeneralInventoryJFrameController(this));
		
		btnRemoveBike = new JButton("Remove Bike");
		btnRemoveBike.setBounds(234, 382, 110, 45);
		frmGeneralBikeInventory.getContentPane().add(btnRemoveBike);
		btnRemoveBike.addActionListener(new GeneralInventoryJFrameController(this));
		
		btnUpdateBike = new JButton("Update Bike");
		btnUpdateBike.setBounds(438, 382, 110, 45);
		frmGeneralBikeInventory.getContentPane().add(btnUpdateBike);
		btnUpdateBike.addActionListener(new GeneralInventoryJFrameController(this));
		
		frmGeneralBikeInventory.setVisible(true);
		desktop.add(frmGeneralBikeInventory);
		try {
			frmGeneralBikeInventory.setSelected(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
