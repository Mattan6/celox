package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import Classes.Sorts;
import Handlers.SendServer;

public class MainMenuWindow {

	private JFrame frmMainMenu;
	private JTable lastSortTable;
	private List<Sorts> sorts = new ArrayList<>();

	/**
	 * Create the application.
	 */
	public MainMenuWindow() {
		getDataFromDB();
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

		String[] columns = {"Grower Name","Plot Name","Sort Start Date","Sort End Date","Size Of Plot", "Species","Comments"};
		
		

		////// data do be abstracted from the DB of last Sorts - from the Sort TABLE in the DB //////////////////////
		Object[][] data = new Object[sorts.size()][7];
		int j=0;
		for (int i=0;i<sorts.size();++i){
			
			if (sorts.get(i)!=null){
				data[i][j++] = new String(sorts.get(i).getGrower().getgName());
				data[i][j++] = new String(sorts.get(i).getPlot().getpName());
				data[i][j++] = new String(sorts.get(i).getStartData().toString());
				data[i][j++] = new String(sorts.get(i).getEndDate().toString());
				data[i][j++] = new Integer(sorts.get(i).getPlot().getpSize());
				data[i][j++] = new String(sorts.get(i).getPlot().getpSpec());
				data[i][j++] = new String(sorts.get(i).getComments());
				j=0;
			}
		}


		lastSortTable = new JTable(data,columns){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {                
				return false;               
			};
		};


		JScrollPane scpSortTable = new JScrollPane();
		scpSortTable.setViewportView(lastSortTable);
		lastSortTable.setFillsViewportHeight(true);
		
		lastSortTable.addMouseListener(new MouseAdapter() {
			
			@Override
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
							frmMainMenu.dispose();
						}
					}
				}
			}
		});


		
		
		
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

	private void getDataFromDB(){

		SendServer get = new SendServer();
		sorts = get.getSorts();
		for (int i=0;i<sorts.size();++i){
			System.out.println(sorts.get(i).toString());
		}

	}

}
