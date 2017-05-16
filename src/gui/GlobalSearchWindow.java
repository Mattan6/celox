package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import Classes.Growers;
import Classes.Plots;
import Classes.Sorts;
import Handlers.SendServer;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class GlobalSearchWindow {

	private JFrame frmSearch;
	private JTable tblResults;
	private JTextField txtGrowerId;
	private JTextField txtEndDate;
	private JTextField txtStartDate;
	private JLabel lblDateFormat;
	private JComboBox<String> cmbGrowerName;
	private List<Sorts> sorts = new ArrayList<>();
	private List<Growers> growers = new ArrayList<>();
	private JComboBox<String> cmbPlotName;
	private JPanel pnlSearchResults;
	private String[] columns = {"Grower Name","Plot Name","Sort Start Date","Sort End Date","Size Of Plot", "Species","Comments"};
	private Object[][] data;
	private JScrollPane scpResult;
	private JTable table;

	/**
	 * Create the application.
	 */
	public GlobalSearchWindow() {
		getDataFromDB();

		initialize();
		buildMenu();
		txtGrowerId.setEnabled(false);
		setEnabled("Plot");
		frmSearch.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */

	private void buildMenu(){

		JMenuBar menuBar = new JMenuBar();
		frmSearch.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		menuBar.add(mnFile);

		JMenuItem mntmMenu = new JMenuItem("Main Menu");
		mntmMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuWindow();
				frmSearch.dispose();

			}
		});
		mnFile.add(mntmMenu);

		JMenuItem mntmSearch = new JMenuItem("Search");
		mnFile.add(mntmSearch);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frmSearch, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);

		JMenuItem mntmNewSort = new JMenuItem("Sort");
		mntmNewSort.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewSort();
				frmSearch.dispose();
				
			}
		});
		mnNew.add(mntmNewSort);

		JMenuItem mntmUpdatenewCustomer = new JMenuItem("Grower/Plot");
		mntmUpdatenewCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewCustomer();
				frmSearch.dispose();
				
			}
		});
		mnNew.add(mntmUpdatenewCustomer);

		JMenu mnEdit = new JMenu("Action");
		menuBar.add(mnEdit);

		JMenuItem mntmStatistics = new JMenuItem("Statistics");
		mntmStatistics.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Statistics();
				frmSearch.dispose();
				
			}
		});
		mnEdit.add(mntmStatistics);

	}
	
	
	private void initialize() {
		frmSearch = new JFrame();
		frmSearch.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSearch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSearch.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pnlSearchWindowHeader = new JPanel();
		pnlSearchWindowHeader.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSearchWindowHeader.setBackground(new Color(192, 192, 192));
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
		pnlSearch.setBackground(new Color(128, 128, 128));
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
		cmbSearchBy.setBackground(new Color(169, 169, 169));
		cmbSearchBy.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbSearchBy.setModel(new DefaultComboBoxModel(new String[] {"Plot", "Date"}));
		pnlSearch.add(cmbSearchBy, "8, 4, fill, default");

		cmbSearchBy.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {	
				setEnabled((String)cmbSearchBy.getSelectedItem());

			}

		});

		JLabel lblGrowerName = new JLabel("Grower Name");
		lblGrowerName.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblGrowerName, "12, 4, right, default");

		//cmbGrowerName = new JComboBox();
		pnlSearch.add(cmbGrowerName, "14, 4, fill, default");
		cmbGrowerName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < growers.size(); i++)
				{
					if (cmbGrowerName.getSelectedItem().toString() == growers.get(i).getgName())
					{
						txtGrowerId.setText(growers.get(i).getgID());
						cmbPlotName.removeAllItems();
						for (Plots p : growers.get(i).getPlots())
						{
							cmbPlotName.addItem(p.getpName());
						}
					}
				}

			}
		});

		JLabel lblGrowerId = new JLabel("Grower Id");
		lblGrowerId.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblGrowerId, "12, 6, right, default");

		txtGrowerId = new JTextField();
		txtGrowerId.setBackground(new Color(169, 169, 169));
		txtGrowerId.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtGrowerId, "14, 6, fill, default");
		txtGrowerId.setColumns(10);

		JLabel lblGrowerPhoneNumber = new JLabel("Plot");
		lblGrowerPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblGrowerPhoneNumber, "12, 8, right, default");

		JLabel lblStartDate = new JLabel("Date Of Sort - Start");
		lblStartDate.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblStartDate, "18, 4, right, default");

		txtStartDate = new JTextField();
		txtStartDate.setBackground(new Color(169, 169, 169));
		txtStartDate.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtStartDate, "20, 4, fill, default");
		txtStartDate.setColumns(10);



		JLabel lblEndDate = new JLabel("Date Of Sort - End");
		lblEndDate.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlSearch.add(lblEndDate, "18, 6, right, default");

		txtEndDate = new JTextField();
		txtEndDate.setBackground(new Color(169, 169, 169));
		txtEndDate.setFont(new Font("Arial", Font.PLAIN, 13));
		pnlSearch.add(txtEndDate, "20, 6, fill, default");
		txtEndDate.setColumns(10);

		cmbPlotName = new JComboBox<String>();
		cmbPlotName.setBackground(new Color(169, 169, 169));
		pnlSearch.add(cmbPlotName, "14, 8, fill, default");

		lblDateFormat = new JLabel("Format ---- dd/MM/yyyy  ");
		lblDateFormat.setFont(new Font("Arial", Font.BOLD, 13));
		lblDateFormat.setEnabled(false);
		lblDateFormat.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSearch.add(lblDateFormat, "20, 8");



		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(230, 230, 250));
		btnBack.setForeground(new Color(255, 0, 0));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.setContentAreaFilled(false);
		btnBack.setOpaque(true);
		pnlSearch.add(btnBack, "12, 12");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new MainMenuWindow();
				frmSearch.dispose();

			}
		});

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(230, 230, 250));
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setOpaque(true);
		pnlSearch.add(btnSearch, "14, 12");



		btnSearch.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				SendServer get = new SendServer();

				if (cmbSearchBy.getSelectedItem().toString() == "Plot"){

					sorts = get.getSearchSorts(txtGrowerId.getText(), cmbPlotName.getSelectedItem().toString(), "Grower");
					//System.out.println("start from plot search");
					data = new Object[sorts.size()][7];
					int j=0;
					int m = 0;
					for (int i=0;i<sorts.size();++i){
						data[m][j++] = new String(sorts.get(i).getGrower().getgName());
						data[m][j++] = new String(sorts.get(i).getPlot().getpName());
						data[m][j++] = new String(sorts.get(i).getStartData().toString());
						data[m][j++] = new String(sorts.get(i).getEndDate().toString());
						data[m][j++] = new Integer(sorts.get(i).getPlot().getpSize());
						data[m][j++] = new String(sorts.get(i).getPlot().getpSpec());
						data[m][j++] = new String(sorts.get(i).getComments());
						m++;
						j=0;
					}								


				}
				else
				{
					if (!checkDate(txtStartDate.getText())){
						System.out.println("Start Date wasn't enterd right!");
					}
					else if (!checkDate(txtEndDate.getText())){
						System.out.println("End Date wasn't enterd right!");
					}
					else{
						String start = handleDate(txtStartDate.getText());
						String end  = handleDate(txtEndDate.getText());
						sorts = get.getSearchSorts(start,end, "Date");
						data = new Object[sorts.size()][7];
						for (Sorts srt : sorts)
						{
							System.out.println(srt.toString());
						}

						//System.out.println("start from plot search");
						int j=0;
						int m = 0;
						for (int i=0;i<sorts.size();++i){
							data[m][j++] = new String(sorts.get(i).getGrower().getgName());
							data[m][j++] = new String(sorts.get(i).getPlot().getpName());
							data[m][j++] = new String(sorts.get(i).getStartData().toString());
							data[m][j++] = new String(sorts.get(i).getEndDate().toString());
							data[m][j++] = new Integer(sorts.get(i).getPlot().getpSize());
							data[m][j++] = new String(sorts.get(i).getPlot().getpSpec());
							data[m][j++] = new String(sorts.get(i).getComments());
							m++;
							j=0;
						}								
					}
				}
				if (data!=null){
					table = new JTable(data,columns){
						// make table uneditable ! 
						private static final long serialVersionUID = 1L;

						public boolean isCellEditable(int row, int column) {                
							return false;               
						};
					};
					scpResult.setViewportView(table);
					table.setFillsViewportHeight(true);
					table.setBackground(new Color(192, 192, 192));

					table.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if (e.getClickCount() == 2) //Double Click
							{
								JTable target = (JTable)e.getSource();
								int row = target.getSelectedRow();

								for (Sorts srt : sorts)
								{
									if (srt.getStartData().toString().equals(target.getValueAt(row, 2))
											&& srt.getEndDate().toString().equals(target.getValueAt(row, 3)))
									{
										new Statistics(srt); 
										frmSearch.dispose();
									}
								}
							}
						}
					});
				}
			}

		});

		pnlSearchResults = new JPanel();
		pnlSearchResults.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlSearchResults.setPreferredSize(new Dimension(10, 500));
		pnlSearchDetails.add(pnlSearchResults, "1, 2, fill, top");
		pnlSearchResults.setLayout(new BorderLayout(0, 0));

		JPanel pnlResultHeader = new JPanel();
		pnlResultHeader.setBackground(new Color(192, 192, 192));
		FlowLayout fl_pnlResultHeader = (FlowLayout) pnlResultHeader.getLayout();
		fl_pnlResultHeader.setAlignment(FlowLayout.LEFT);
		pnlSearchResults.add(pnlResultHeader, BorderLayout.NORTH);

		JLabel lblResults = new JLabel("Search Results:");
		lblResults.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		pnlResultHeader.add(lblResults);

		scpResult = new JScrollPane();
		scpResult.setBackground(new Color(255, 255, 153));
		pnlSearchResults.add(scpResult, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionBackground(new Color(128, 128, 128));
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(192, 192, 192));
		scpResult.setViewportView(table);


	}



	private void setEnabled(String selectedItem) {
		switch(selectedItem){
		case "Plot":
			txtStartDate.setEnabled(false);
			txtStartDate.setBackground(Color.LIGHT_GRAY);
			txtEndDate.setEnabled(false);
			txtEndDate.setBackground(Color.LIGHT_GRAY);
			txtGrowerId.setEnabled(false);
			txtGrowerId.setBackground(Color.WHITE);
			cmbGrowerName.setEnabled(true);
			cmbGrowerName.setBackground(Color.WHITE);
			cmbPlotName.setEnabled(true);
			cmbPlotName.setBackground(Color.WHITE);	
			lblDateFormat.setVisible(false);
			break;
		case "Date":
			txtGrowerId.setEnabled(false);
			txtGrowerId.setBackground(Color.LIGHT_GRAY);
			cmbGrowerName.setEnabled(false);
			cmbGrowerName.setBackground(Color.LIGHT_GRAY);
			cmbPlotName.setEnabled(false);
			cmbPlotName.setBackground(Color.LIGHT_GRAY);
			txtStartDate.setEnabled(true);
			txtStartDate.setBackground(Color.WHITE);
			txtEndDate.setEnabled(true);
			txtEndDate.setBackground(Color.WHITE);
			lblDateFormat.setVisible(true);
			break;
		default : 

		}

	}

	private void getDataFromDB()
	{
		SendServer get = new SendServer();
		growers = get.getGrowers();

		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(new String[]{});
		cmbGrowerName = new JComboBox<String>(model);
		cmbGrowerName.setBackground(new Color(169, 169, 169));
		cmbGrowerName.removeAllItems();
		for (int i=0; i < growers.size(); i++)
		{	
			if(model.getIndexOf(growers.get(i).getgName()) == -1) {
				model.addElement(growers.get(i).getgName());
			}
		}
	}

	private boolean checkDate(String date) {
		if (date.matches("[0-9][0-9]/[0-1][0-9]/2[0-9][0-9][0-9]")){
			return true;
		}
		return false;
	}


	private String handleDate(String text) {
		String day = text.substring(0, 2);
		String mon = text.substring(3, 5);
		String year = text.substring(6,text.trim().length());
		String toReturn="";
		switch(mon){
		case "01": toReturn+= "Jan ";
		break;
		case "02": toReturn+= "Feb ";
		break;
		case "03": toReturn+= "Mar ";
		break;
		case "04": toReturn+= "Apr ";
		break;
		case "05": toReturn+= "May ";
		break;
		case "06": toReturn+= "Jun ";
		break;
		case "07": toReturn+= "Jul ";
		break;
		case "08": toReturn+= "Aug ";
		break;
		case "09": toReturn+= "Sep ";
		break;
		case "10": toReturn+= "Oct ";
		break;
		case "11": toReturn+= "Nov ";
		break;
		case "12": toReturn+= "Dec ";
		break;	
		}
		switch(day){
		case "01": day = "1";
		break;
		case "02": day = "2";
		break;
		case "03": day = "3";
		break;
		case "04": day = "4";
		break;
		case "05": day = "5";
		break;
		case "06": day = "6";
		break;
		case "07": day = "7";
		break;
		case "08": day = "8";
		break;
		case "09": day = "9";
		break;		
		}
		toReturn+=day + ", ";
		toReturn+=year + " ";


		System.out.println(toReturn);
		return toReturn;
	}

}

