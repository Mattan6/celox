package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.SystemColor;

public class NewCustomer {

	private JFrame frame;
	private JTextField txtGower;
	private JTextField txtPlot;
	private JTextField txtGrowerName;
	private JTextField txtGrowerID;
	private JTextField txtGrowerAddr;
	private JTextField txtGrowerPhone;
	JPanel pnlNewCustomer = new JPanel();
	JPanel pnlfooter = new JPanel();
	JPanel pnlEast = new JPanel();
	JPanel pnlWest = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer window = new NewCustomer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlHeader = new JPanel();
		frame.getContentPane().add(pnlHeader, BorderLayout.NORTH);
		
		JLabel lblNewCustomer = new JLabel("New Customer");
		lblNewCustomer.setForeground(new Color(255, 69, 0));
		lblNewCustomer.setFont(new Font("Arial", Font.BOLD, 20));
		pnlHeader.add(lblNewCustomer);
		
		frame.getContentPane().add(pnlEast, BorderLayout.EAST);
		pnlEast.setLayout(new GridLayout(1,1));	
		JLabel lblSpaces = new JLabel("----------------------------------------------------------------------");
		pnlEast.add(lblSpaces);
		
		frame.getContentPane().add(pnlWest, BorderLayout.WEST);
		pnlWest.setLayout(new GridLayout(1,1));	
		JLabel lblSpacesW = new JLabel("----------------------------------------------------------------------");
		pnlWest.add(lblSpacesW);
		
		frame.getContentPane().add(pnlfooter, BorderLayout.SOUTH);
		pnlfooter.setLayout(new GridLayout(6,2));		
		FieldsFormPlots();
		
		//frame.getContentPane().add(pnlfooter, BorderLayout.SOUTH);
		//pnlfooter.setLayout(new GridLayout(0, 1, 0, 0));		
		
		frame.getContentPane().add(pnlNewCustomer, BorderLayout.CENTER);
		pnlNewCustomer.setLayout(new GridLayout(6,2));		
		FieldsFormNewCustomer();
	}
	private void FieldsFormNewCustomer()
	{
		JLabel lblGrowerID = new JLabel("Grower ID");
		txtGrowerID = new JTextField();
		JLabel lblGrowerName = new JLabel("Full Name");
		txtGrowerName = new JTextField();
		JLabel lblGrowerAddr = new JLabel("Address");
		txtGrowerAddr = new JTextField();
		JLabel lblGrowerPhone = new JLabel("Phone");
		txtGrowerPhone = new JTextField();
		JLabel lblNumsPlots = new JLabel("Numbers of Plots");
		JButton btnClearForm = new JButton("Clear");
		JButton btnAddNewCustomer = new JButton("Add");
		
		pnlNewCustomer.add(lblGrowerID);
		pnlNewCustomer.add(txtGrowerID);
		pnlNewCustomer.add(lblGrowerName);
		pnlNewCustomer.add(txtGrowerName);
		pnlNewCustomer.add(lblGrowerAddr);
		pnlNewCustomer.add(txtGrowerAddr);
		pnlNewCustomer.add(lblGrowerPhone);
		pnlNewCustomer.add(txtGrowerPhone);
		pnlNewCustomer.add(lblNumsPlots);		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		pnlNewCustomer.add(spinner);
		pnlNewCustomer.add(btnClearForm);
		pnlNewCustomer.add(btnAddNewCustomer);
	}
	
	private void FieldsFormPlots()
	{
		JLabel lblGrowerID = new JLabel("Grower ID");
		txtGrowerID = new JTextField();
		JLabel lblGrowerName = new JLabel("Full Name");
		txtGrowerName = new JTextField();
		JLabel lblGrowerAddr = new JLabel("Address");
		txtGrowerAddr = new JTextField();
		JLabel lblGrowerPhone = new JLabel("Phone");
		txtGrowerPhone = new JTextField();
		JLabel lblNumsPlots = new JLabel("Numbers of Plots");
		JButton btnClearForm = new JButton("Clear");
		JButton btnAddNewCustomer = new JButton("Add");
		
		pnlfooter.add(lblGrowerID);
		pnlfooter.add(txtGrowerID);
		pnlfooter.add(lblGrowerName);
		pnlfooter.add(txtGrowerName);
		pnlfooter.add(lblGrowerAddr);
		pnlfooter.add(txtGrowerAddr);
		pnlfooter.add(lblGrowerPhone);
		pnlfooter.add(txtGrowerPhone);
		pnlfooter.add(lblNumsPlots);		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		pnlfooter.add(spinner);
		pnlfooter.add(btnClearForm);
		pnlfooter.add(btnAddNewCustomer);
	}

}