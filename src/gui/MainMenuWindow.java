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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Classes.Sorts;
import Handlers.SendServer;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

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
		buildMenu();
		frmMainMenu.setVisible(true);
	}

	
	private void buildMenu(){

		JMenuBar menuBar = new JMenuBar();
		frmMainMenu.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		menuBar.add(mnFile);

		JMenuItem mntmMenu = new JMenuItem("Main Menu");
		mnFile.add(mntmMenu);

		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GlobalSearchWindow();
				frmMainMenu.dispose();
				
			}
		});
		mnFile.add(mntmSearch);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(frmMainMenu, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION,
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
				frmMainMenu.dispose();
				
			}
		});
		mnNew.add(mntmNewSort);

		JMenuItem mntmUpdatenewCustomer = new JMenuItem("Grower/Plot");
		mntmUpdatenewCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewCustomer();
				frmMainMenu.dispose();
				
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
				frmMainMenu.dispose();
				
			}
		});
		mnEdit.add(mntmStatistics);

	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmMainMenu = new JFrame();
		frmMainMenu.getContentPane().setPreferredSize(new Dimension(10, 0));
		
		try {
			frmMainMenu.setIconImage(ImageIO.read(new File("img/logo.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}


		JPanel pnlMainMenuHeader = new JPanel();
		pnlMainMenuHeader.setBackground(new Color(192, 192, 192));
		pnlMainMenuHeader.setPreferredSize(new Dimension(10, 150));
		frmMainMenu.getContentPane().add(pnlMainMenuHeader, BorderLayout.NORTH);
		pnlMainMenuHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

		JLabel lblMainMenuHeader = new JLabel("Cellox Statistics Software");
		lblMainMenuHeader.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		pnlMainMenuHeader.add(lblMainMenuHeader);

		JPanel pnlMainMenuFooter = new JPanel();
		pnlMainMenuFooter.setPreferredSize(new Dimension(10, 600));
		frmMainMenu.getContentPane().add(pnlMainMenuFooter, BorderLayout.SOUTH);
		pnlMainMenuFooter.setLayout(new BorderLayout(16, 0));

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
		lastSortTable.setSelectionBackground(new Color(128, 128, 128));
		lastSortTable.setBackground(new Color(192, 192, 192));


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
		pnlMainMenuLastSorts.setBackground(new Color(192, 192, 192));
		FlowLayout fl_pnlMainMenuLastSorts = (FlowLayout) pnlMainMenuLastSorts.getLayout();
		fl_pnlMainMenuLastSorts.setHgap(2);
		fl_pnlMainMenuLastSorts.setAlignment(FlowLayout.LEFT);
		pnlMainMenuFooter.add(pnlMainMenuLastSorts, BorderLayout.NORTH);

		JLabel lblLastSorts = new JLabel("10 Last Sorts: ");
		lblLastSorts.setBackground(new Color(0, 0, 0));
		pnlMainMenuLastSorts.add(lblLastSorts);
		lblLastSorts.setForeground(new Color(0, 0, 0));
		lblLastSorts.setPreferredSize(new Dimension(200, 30));
		lblLastSorts.setFont(new Font("Arial", Font.PLAIN, 25));
		JPanel pnlMainMenuCenter = new JPanel();
		pnlMainMenuCenter.setBackground(new Color(128, 128, 128));
		frmMainMenu.getContentPane().add(pnlMainMenuCenter, BorderLayout.CENTER);
		pnlMainMenuCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 20));

		JButton btnStats = new JButton("Statistics");
		btnStats.setBackground(new Color(230, 230, 250));
		btnStats.setPreferredSize(new Dimension(250, 50));
		btnStats.setFont(new Font("Arial", Font.PLAIN, 18));
		btnStats.setContentAreaFilled(false);
		btnStats.setOpaque(true);
		pnlMainMenuCenter.add(btnStats);
		btnStats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Statistics();
				frmMainMenu.dispose();

			}
		});


		JButton btnCustomers = new JButton("Customer Update");
		btnCustomers.setBackground(new Color(230, 230, 250));
		btnCustomers.setPreferredSize(new Dimension(250, 50));
		btnCustomers.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCustomers.setContentAreaFilled(false);
		btnCustomers.setOpaque(true);
		pnlMainMenuCenter.add(btnCustomers);
		btnCustomers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new NewCustomer();
				frmMainMenu.dispose();

			}
		});


		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(230, 230, 250));
		btnSearch.setPreferredSize(new Dimension(250, 50));
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSearch.setContentAreaFilled(false);
		btnSearch.setOpaque(true);
		pnlMainMenuCenter.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GlobalSearchWindow();
				frmMainMenu.dispose();

			}
		});


		JButton btnNewSort = new JButton("New Sort");
		btnNewSort.setBackground(new Color(230, 230, 250));
		btnNewSort.setPreferredSize(new Dimension(250, 50));
		btnNewSort.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewSort.setContentAreaFilled(false);
		btnNewSort.setOpaque(true);
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
		//for (int i=0;i<sorts.size();++i){
		//	System.out.println(sorts.get(i).toString());
	//	}

	}

}
