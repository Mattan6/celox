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
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class MainMenuWindow {

	private JFrame MainMenuFrame;
	private JTable LastSortTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuWindow window = new MainMenuWindow();
					window.MainMenuFrame.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainMenuFrame = new JFrame();
		MainMenuFrame.getContentPane().setPreferredSize(new Dimension(10, 0));
		
		JPanel pnlMainMenuHeader = new JPanel();
		pnlMainMenuHeader.setBackground(Color.WHITE);
		pnlMainMenuHeader.setPreferredSize(new Dimension(10, 150));
		MainMenuFrame.getContentPane().add(pnlMainMenuHeader, BorderLayout.NORTH);
		pnlMainMenuHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 45));
		
		JLabel lblMainMenuHeader = new JLabel("Cellox Statistics Software");
		lblMainMenuHeader.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		pnlMainMenuHeader.add(lblMainMenuHeader);
		
		JPanel pnlMainMenuFooter = new JPanel();
		pnlMainMenuFooter.setPreferredSize(new Dimension(10, 450));
		MainMenuFrame.getContentPane().add(pnlMainMenuFooter, BorderLayout.SOUTH);
		pnlMainMenuFooter.setLayout(new BorderLayout(10, 5));
		
		//////column names //////
		
		String[] columns = {"Plot's ID","Sort Start Date","Sort End Date","Size Of Plot", "Species","Percentage In Plot","Comments","Departments Breakdown"};
		
		////// data do be abstracted from the DB of last Sorts - from the Sort TABLE in the DB //////////////////////
		Object[][] data = {{"ID","Start Date","End Date","Plot-Size", "Species"," % In Plot","Comments","A,B,C,D,E,F,W"}};
		
			
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
		MainMenuFrame.getContentPane().add(pnlMainMenuCenter, BorderLayout.CENTER);
		pnlMainMenuCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 110));
		
		JButton btnMainMenuStats = new JButton("Statistics");
		btnMainMenuStats.setBackground(Color.LIGHT_GRAY);
		btnMainMenuStats.setPreferredSize(new Dimension(250, 50));
		btnMainMenuStats.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnMainMenuStats);
		
		JButton btnMainMenuUpdate = new JButton("Update Data");
		btnMainMenuUpdate.setBackground(Color.LIGHT_GRAY);
		btnMainMenuUpdate.setPreferredSize(new Dimension(250, 50));
		btnMainMenuUpdate.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnMainMenuUpdate);
		
		JButton btnMainMenuSearch = new JButton("Search");
		btnMainMenuSearch.setBackground(Color.LIGHT_GRAY);
		btnMainMenuSearch.setPreferredSize(new Dimension(250, 50));
		btnMainMenuSearch.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnMainMenuSearch);
		
		JButton btnNewSort = new JButton("New Sort");
		btnNewSort.setBackground(Color.LIGHT_GRAY);
		btnNewSort.setPreferredSize(new Dimension(250, 50));
		btnNewSort.setFont(new Font("Arial", Font.PLAIN, 18));
		pnlMainMenuCenter.add(btnNewSort);
		MainMenuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		MainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
