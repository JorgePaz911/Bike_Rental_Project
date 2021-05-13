package com.goldenbike.view.mainjframe;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JMenuBar;

/**
 * Main Menu
 * @author Jorge
 *
 */
@SuppressWarnings("serial")
public class MainJFrame extends JFrame {

	private JButton btnNewButton;
	private JButton btnNewButton_2;
	private JDesktopPane desktop;
	private JMenuItem menuItem;
 
	/**
	 * Constructor
	 */
	public MainJFrame() {
		super("Main Menu Golden Bike");
		initialize();
	}
	
	public JDesktopPane getDesktop() {
		return desktop;
	}
	
	/**
	 * returns general inventory button
	 * @return JButton
	 */
	public JButton getButton1() {
		return btnNewButton;
	}
	
	/**
	 * returns reservation button
	 * @return JButton
	 */
	public JButton getButton3() {
		return btnNewButton_2;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        int inset = 175;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width  - inset*2, screenSize.height - inset*2);
        desktop = new JDesktopPane();
        setContentPane(desktop);
        setJMenuBar(createMenuBar());
	}
	
	/**
	 * Creates and returns the menu bar
	 * @return JMenuBar
	 */
	private JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Inventory");
		menuItem.setActionCommand("Inventory");
        menuItem.addActionListener(new MainJFrameController(this));
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Reservations");
        menuItem.setActionCommand("Reservations");
        menuItem.addActionListener(new MainJFrameController(this));
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Exit");
        menuItem.setActionCommand("Exit");
        menuItem.addActionListener(new MainJFrameController(this));
        menu.add(menuItem);
        
        return menuBar;
	}
	
	/**
	 * Main that launches the program
	 * @param args
	 */
	public static void main(String [] args) {
		MainJFrame frame = new MainJFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
}
