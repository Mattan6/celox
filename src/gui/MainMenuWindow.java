package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class MainMenuWindow {

	private JFrame frmMainMenu;
	private JTable LastSortTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuWindow window = new MainMenuWindow();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuWindow() {
		initialize();
		frmMainMenu.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.getContentPane().setPreferredSize(new Dimension(10, 0));
		
		JPanel pnlMainMenuHeader = new JPanel();
		pnlMainMenuHeader.setBackground(Color.WHITE);
		pnlMainMenuHeader.setPreferredSize(new Dimension(10, 150));
		frmMainMenu.getContentPane().add(pnlMainMenuHeader, BorderLayout.NORTH);
		pnlMainMenuHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
		
		JLabel lblMainMenuHeader = new JLabel("Cellox Statistics Software");
		lblMainMenuHeader.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		pnlMainMenuHeader.add(lblMainMenuHeader);
		
		JPanel pnlMainMenuFooter = new JPanel();
		pnlMainMenuFooter.setPreferredSize(new Dimension(10, 450));
		frmMainMenu.getContentPane().add(pnlMainMenuFooter, BorderLayout.SOUTH);
		pnlMainMenuFooter.setLayout(new BorderLayout(16, 5));
		
		//////column names //////
		
		String[] columns = {"Plot's Name","Sort Start Date","Sort End Date","Size Of Plot", "Species","Percentage In Plot","Comments","Departments Breakdown"};
		
		////// data do be abstracted from the DB of last Sorts - from the Sort TABLE in the DB //////////////////////
		Object[][] data = {{"Plot Name","Start Date","End Date","Plot-Size", "Species"," % In Plot","Comments","A,B,C,D,E,F,W"}};
		
			
		LastSortTable = new JTable(data,columns);

		
		JScrollPane scpSortTable = new JScrollPane(LastSortTable);
		LastSortTable.setFillsViewportHeight(true);
		
		pnlMainMenuFooter.add(scpSortTable, BorderLayout.CENTER);
		
		JPanel pnlMainMenuLastSorts = new JPanel();
		pnlMainMenuLastSorts.setBackground(Color.WHITE);
		FlowLayout fl_pnlMainMenuLastSorts = (FlowLayout) pnlMainMenuLastSorts.getLayout();
		fl_pnlMainMenuLastSorts.setHgap(2);
		fl_pnlMainMenuLastSorts.setAlignment(FlowLayout.LEFT);
		pnlMainMenuFooter.add(pnlMainMenuLastSorts, BorderLayout.NORTH);
		
		JLabel lblLastSorts = new JLabel("10 Last Sorts... ");
		pnlMainMenuLastSorts.add(lblLastSorts);
		lblLastSorts.setForeground(Color.RED);
		lblLastSorts.setPreferredSize(new Dimension(200, 30));
		lblLastSorts.setFont(new Font("Arial", Font.PLAIN, 25));
		JPanel pnlMainMenuCenter = new JPanel();
		pnlMainMenuCenter.setBackground(Color.WHITE);
		frmMainMenu.getContentPane().add(pnlMainMenuCenter, BorderLayout.CENTER);
		pnlMainMenuCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 110));
		
		JButton btnStats = new JButton("Statistics");
		btnStats.setBackground(Color.LIGHT_GRAY);
		btnStats.setPreferredSize(new Dimension(250, 50));
		btnStats.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnStats);
		btnStats.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Statistics();
				frmMainMenu.dispose();
				
			}
		});
		
		
		JButton btnCustomers = new JButton("Customer Update");
		btnCustomers.setBackground(Color.LIGHT_GRAY);
		btnCustomers.setPreferredSize(new Dimension(250, 50));
		btnCustomers.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnCustomers);
		btnCustomers.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewCustomer();
				frmMainMenu.dispose();
				
			}
		});
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.LIGHT_GRAY);
		btnSearch.setPreferredSize(new Dimension(250, 50));
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GlobalSearchWindow();
				frmMainMenu.dispose();
				
			}
		});
		
		
		JButton btnNewSort = new JButton("New Sort");
		btnNewSort.setBackground(Color.LIGHT_GRAY);
		btnNewSort.setPreferredSize(new Dimension(250, 50));
		btnNewSort.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnNewSort);
		btnNewSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewSort();
				frmMainMenu.dispose();
			}
		});
		
		
		frmMainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
