package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class GlobalSearchWindow {

	private JFrame frmSearch;
	private JTextField txtGrowersId;
	private JTextField textStartSort;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtPlotId;
	private JTextField txtName;
	private JTextField txtEndSort;
	private JTextField txtPlotName;
	private JTable tblResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlobalSearchWindow window = new GlobalSearchWindow();
					window.frmSearch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlobalSearchWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSearchWindowHeader = new JPanel();
		pnlSearchWindowHeader.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSearchWindowHeader.setBackground(Color.WHITE);
		FlowLayout fl_pnlSearchWindowHeader = (FlowLayout) pnlSearchWindowHeader.getLayout();
		fl_pnlSearchWindowHeader.setVgap(35);
		frmSearch.getContentPane().add(pnlSearchWindowHeader, BorderLayout.NORTH);
		
		JLabel lblSearchWindow = new JLabel("Search");
		lblSearchWindow.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 47));
		pnlSearchWindowHeader.add(lblSearchWindow);
		
		JPanel pnlSearchWindowBody = new JPanel();
		frmSearch.getContentPane().add(pnlSearchWindowBody, BorderLayout.CENTER);
		pnlSearchWindowBody.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSearchBy = new JPanel();
		pnlSearchBy.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSearchBy.setBackground(Color.WHITE);
		pnlSearchBy.setPreferredSize(new Dimension(250, 50));
		pnlSearchWindowBody.add(pnlSearchBy, BorderLayout.WEST);
		pnlSearchBy.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		
		JLabel lblSearchBy = new JLabel("Search by: ");
		lblSearchBy.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearchBy.add(lblSearchBy);
		
		
		String[] searchList = {"Grower","Plot","Date","Other"};
		JComboBox cmbSelection = new JComboBox(searchList);
		cmbSelection.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbSelection.setPreferredSize(new Dimension(150, 20));
		pnlSearchBy.add(cmbSelection);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Arial", Font.BOLD, 19));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		pnlSearchBy.add(btnSearch);
		
		JPanel pnlSearchDetails = new JPanel();
		pnlSearchDetails.setBackground(Color.WHITE);
		pnlSearchWindowBody.add(pnlSearchDetails, BorderLayout.CENTER);
		pnlSearchDetails.setLayout(new BorderLayout(15, 500));
		
		JPanel pnlEnterDetails = new JPanel();
		pnlEnterDetails.setBackground(Color.WHITE);
		pnlEnterDetails.setPreferredSize(new Dimension(0, 135));
		pnlSearchDetails.add(pnlEnterDetails, BorderLayout.NORTH);
		pnlEnterDetails.setLayout(new GridLayout(5, 0, 6, 1));
		
		JLabel lblGrowersId = new JLabel("Grower's ID:");
		lblGrowersId.setBackground(Color.WHITE);
		lblGrowersId.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblGrowersId);
		
		txtGrowersId = new JTextField();
		pnlEnterDetails.add(txtGrowersId);
		txtGrowersId.setColumns(10);
		
		JLabel lblPlotId = new JLabel("Plot ID:");
		lblPlotId.setBackground(Color.WHITE);
		lblPlotId.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblPlotId);
		
		txtPlotId = new JTextField();
		txtPlotId.setColumns(10);
		pnlEnterDetails.add(txtPlotId);
		
		JLabel lblGrowersPhoneNumber = new JLabel("Grower's Phone Number:");
		lblGrowersPhoneNumber.setBackground(Color.WHITE);
		lblGrowersPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblGrowersPhoneNumber);
		
		txtPhoneNumber = new JTextField();
		pnlEnterDetails.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		
		JLabel lblPlotName = new JLabel("Plot Name:");
		lblPlotName.setBackground(Color.WHITE);
		lblPlotName.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblPlotName);
		
		txtPlotName = new JTextField();
		pnlEnterDetails.add(txtPlotName);
		txtPlotName.setColumns(10);
		
		JLabel lblGrowersAddress = new JLabel("Grower's Address:");
		lblGrowersAddress.setBackground(Color.WHITE);
		lblGrowersAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblGrowersAddress);
		
		txtAddress = new JTextField();
		pnlEnterDetails.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblDateOfSorting = new JLabel("Start Sorting Date:");
		lblDateOfSorting.setBackground(Color.WHITE);
		lblDateOfSorting.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblDateOfSorting);
		
		textStartSort = new JTextField();
		textStartSort.setText("");
		pnlEnterDetails.add(textStartSort);
		textStartSort.setColumns(10);
		
		JLabel lblGrowersName = new JLabel("Grower's Name:");
		lblGrowersName.setBackground(Color.WHITE);
		lblGrowersName.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblGrowersName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		pnlEnterDetails.add(txtName);
		
		JLabel lblEndSortingDate = new JLabel("End Sorting Date:");
		lblEndSortingDate.setBackground(Color.WHITE);
		lblEndSortingDate.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlEnterDetails.add(lblEndSortingDate);
		
		txtEndSort = new JTextField();
		pnlEnterDetails.add(txtEndSort);
		txtEndSort.setColumns(10);
		
		JPanel pnlSearchResults = new JPanel();
		pnlSearchResults.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSearchResults.setPreferredSize(new Dimension(10, 500));
		pnlSearchDetails.add(pnlSearchResults, BorderLayout.SOUTH);
		pnlSearchResults.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlResultHeader = new JPanel();
		pnlResultHeader.setBackground(Color.WHITE);
		FlowLayout fl_pnlResultHeader = (FlowLayout) pnlResultHeader.getLayout();
		fl_pnlResultHeader.setAlignment(FlowLayout.LEFT);
		pnlSearchResults.add(pnlResultHeader, BorderLayout.NORTH);
		
		JLabel lblResults = new JLabel("Search Results:");
		lblResults.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlResultHeader.add(lblResults);
		
		
		//////column names //////----->>>>> need to change 
		
		String[] columns = {"Plot's ID","Sort Start Date","Sort End Date","Size Of Plot", "Species","Percentage In Plot","Comments","Departments Breakdown"};
		
		////// data do be abstracted from the DB of last Sorts - from the Sort TABLE in the DB //////////////////////
		Object[][] data = {{"ID","Start Date","End Date","Plot-Size", "Species"," % In Plot","Comments","A,B,C,D,E,F,W"}};
		
		JScrollPane scpResult = new JScrollPane();
		pnlSearchResults.add(scpResult, BorderLayout.CENTER);
		
		tblResults = new JTable(data,columns);
		scpResult.setViewportView(tblResults);
		tblResults.setFillsViewportHeight(true);
	}

}
