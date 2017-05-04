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
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GlobalSearchWindow {

	private JFrame frmSearch;
	private JTable tblResults;
	private JTextField txtGrowerId;
	private JTextField txtGrowerName;
	private JTextField txtGrowerPhone;
	private JTextField txtEndDate;
	private JTextField txtStartDate;

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
		setEnabled("Grower");
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
		fl_pnlSearchWindowHeader.setVgap(50);
		frmSearch.getContentPane().add(pnlSearchWindowHeader, BorderLayout.NORTH);

		JLabel lblSearchWindow = new JLabel("Sort Search");
		lblSearchWindow.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 47));
		pnlSearchWindowHeader.add(lblSearchWindow);

		JPanel pnlSearchWindowBody = new JPanel();
		frmSearch.getContentPane().add(pnlSearchWindowBody, BorderLayout.CENTER);
		pnlSearchWindowBody.setLayout(new BorderLayout(0, 0));

		JPanel pnlSearchDetails = new JPanel();
		pnlSearchDetails.setBackground(Color.WHITE);
		pnlSearchWindowBody.add(pnlSearchDetails, BorderLayout.CENTER);
		pnlSearchDetails.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1347px:grow"),},
				new RowSpec[] {
						RowSpec.decode("181px:grow"),
						RowSpec.decode("500px"),}));

		JPanel pnlSearch = new JPanel();
		pnlSearchDetails.add(pnlSearch, "1, 1, fill, fill");
		pnlSearch.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblSearchBy, "6, 4, right, default");

		JComboBox cmbSearchBy = new JComboBox();
		cmbSearchBy.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbSearchBy.setModel(new DefaultComboBoxModel(new String[] {"Grower", "Date"}));
		pnlSearch.add(cmbSearchBy, "8, 4, fill, default");

		cmbSearchBy.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {	
				setEnabled((String)cmbSearchBy.getSelectedItem());

			}

		});

		JLabel lblGrowerId = new JLabel("Grower Id");
		lblGrowerId.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblGrowerId, "12, 4, right, default");

		txtGrowerId = new JTextField();
		txtGrowerId.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtGrowerId, "14, 4, fill, default");
		txtGrowerId.setColumns(10);
		
		JLabel lblGrowerName = new JLabel("Grower Name");
		lblGrowerName.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblGrowerName, "12, 6, right, default");
		
		txtGrowerName = new JTextField();
		txtGrowerName.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtGrowerName, "14, 6, fill, top");
		txtGrowerName.setColumns(10);
		
		JLabel lblGrowerPhoneNumber = new JLabel("Grower Phone Number");
		lblGrowerPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblGrowerPhoneNumber, "12, 8, right, default");

		txtGrowerPhone = new JTextField();
		txtGrowerPhone.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtGrowerPhone, "14, 8, fill, default");
		txtGrowerPhone.setColumns(10);

		JLabel lblStartDate = new JLabel("Date Of Sort - Start");
		lblStartDate.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblStartDate, "18, 4, right, default");

		txtStartDate = new JTextField();
		txtStartDate.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtStartDate, "20, 4, fill, default");
		txtStartDate.setColumns(10);


		JLabel lblEndDate = new JLabel("Date Of Sort - End");
		lblEndDate.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblEndDate, "18, 6, right, default");

		txtEndDate = new JTextField();
		txtEndDate.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtEndDate, "20, 6, fill, default");
		txtEndDate.setColumns(10);



		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(btnBack, "12, 12");

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(btnSearch, "14, 12");

		JPanel pnlSearchResults = new JPanel();
		pnlSearchResults.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSearchResults.setPreferredSize(new Dimension(10, 500));
		pnlSearchDetails.add(pnlSearchResults, "1, 2, fill, top");
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
	
	private void setEnabled(String selectedItem) {
		switch(selectedItem){
		case "Grower":
			txtStartDate.setEnabled(false);
			txtStartDate.setBackground(Color.LIGHT_GRAY);
			txtEndDate.setEnabled(false);
			txtEndDate.setBackground(Color.LIGHT_GRAY);
			txtGrowerId.setEnabled(true);
			txtGrowerId.setBackground(Color.WHITE);
			txtGrowerName.setEnabled(true);
			txtGrowerName.setBackground(Color.WHITE);
			txtGrowerPhone.setEnabled(true);
			txtGrowerPhone.setBackground(Color.WHITE);
			break;
		case "Date":
			txtGrowerId.setEnabled(false);
			txtGrowerId.setBackground(Color.LIGHT_GRAY);
			txtGrowerName.setEnabled(false);
			txtGrowerName.setBackground(Color.LIGHT_GRAY);
			txtGrowerPhone.setEnabled(false);
			txtGrowerPhone.setBackground(Color.LIGHT_GRAY);
			txtStartDate.setEnabled(true);
			txtStartDate.setBackground(Color.WHITE);
			txtEndDate.setEnabled(true);
			txtEndDate.setBackground(Color.WHITE);
			break;
		default : 

		}
		
	}

}
