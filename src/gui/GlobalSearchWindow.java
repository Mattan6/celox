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

public class GlobalSearchWindow {

	private JFrame frame;
	private JTextField txtGrowersId;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlobalSearchWindow window = new GlobalSearchWindow();
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
	public GlobalSearchWindow() {
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
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(35);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Search");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 47));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(250, 50));
		panel_2.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		
		JLabel label = new JLabel("Search by: ");
		label.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_3.add(label);
		
		
		String[] searchList = {"Grower","Plot","Date","Other"};
		JComboBox comboBox = new JComboBox(searchList);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setPreferredSize(new Dimension(150, 20));
		panel_3.add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 19));
		btnNewButton.setPreferredSize(new Dimension(150, 50));
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(15, 500));
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(0, 135));
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(5, 0, 6, 1));
		
		JLabel lblGrowersId = new JLabel("Grower's ID:");
		lblGrowersId.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblGrowersId);
		
		txtGrowersId = new JTextField();
		panel_5.add(txtGrowersId);
		txtGrowersId.setColumns(10);
		
		JLabel lblPlotId = new JLabel("Plot ID:");
		lblPlotId.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblPlotId);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_5.add(textField_4);
		
		JLabel lblGrowersPhoneNumber = new JLabel("Grower's Phone Number:");
		lblGrowersPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblGrowersPhoneNumber);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPlotName = new JLabel("Plot Name:");
		lblPlotName.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblPlotName);
		
		textField_7 = new JTextField();
		panel_5.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblGrowersAddress = new JLabel("Grower's Address:");
		lblGrowersAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblGrowersAddress);
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDateOfSorting = new JLabel("Start Sorting Date:");
		lblDateOfSorting.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblDateOfSorting);
		
		textField = new JTextField();
		textField.setText("");
		panel_5.add(textField);
		textField.setColumns(10);
		
		JLabel lblGrowersName = new JLabel("Grower's Name:");
		lblGrowersName.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblGrowersName);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_5.add(textField_5);
		
		JLabel lblEndSortingDate = new JLabel("End Sorting Date:");
		lblEndSortingDate.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_5.add(lblEndSortingDate);
		
		textField_6 = new JTextField();
		panel_5.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 500));
		panel_4.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_6, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("Search Results:");
		label_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		panel_6.add(label_1);
		
		
		//////column names //////----->>>>> need to change 
		
		String[] columns = {"Plot's ID","Sort Start Date","Sort End Date","Size Of Plot", "Species","Percentage In Plot","Comments","Departments Breakdown"};
		
		////// data do be abstracted from the DB of last Sorts - from the Sort TABLE in the DB //////////////////////
		Object[][] data = {{"ID","Start Date","End Date","Plot-Size", "Species"," % In Plot","Comments","A,B,C,D,E,F,W"}};
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(data,columns);
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
	}

}
