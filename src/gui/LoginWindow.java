package gui;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class LoginWindow {
	/**Form variables**/
	private JFrame frmLogin;
	private JTextField txtUserName;
	private JLabel lblPassword;
	private JPasswordField txtpasswordField;
	private JLabel lblImgLogo;
	private JButton btnClear;
	
	/**SQL variables**/
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		buildLoginFrame();	
		ConnectionDB();
	}
	//Connection To DB Method - example!
	private void ConnectionDB() {
		 // This will load the MySQL driver, each DB has its own driver
       try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
       // Setup the connection with the DB
       try {
		connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?user=celox&password=celoxpw");
	} catch (SQLException e) {
		e.printStackTrace();
	}
       
		
	}
	
	private void buildLoginFrame()
	{
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBounds(100, 100, 354, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmLogin.setLocation(dim.width/2-frmLogin.getSize().width/2, dim.height/2-frmLogin.getSize().height/2);
		
		JPanel pnlHeader = new JPanel();
		pnlHeader.setBackground(Color.WHITE);
		pnlHeader.setBounds(10, 11, 318, 140);
		frmLogin.getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);
		
		lblImgLogo = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/GoCarrotsLogo.png")).getImage();
		lblImgLogo.setIcon(new ImageIcon(image));
		lblImgLogo.setBounds(50,0, 254, 140);
		pnlHeader.add(lblImgLogo);
				
		JPanel pnlContent = new JPanel();
		pnlContent.setBackground(Color.WHITE);
		pnlContent.setBounds(10, 162, 318, 88);
		frmLogin.getContentPane().add(pnlContent);
		pnlContent.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUserName.setBounds(75, 23, 105, 20);
		pnlContent.add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUserName.setBounds(0, 25, 65, 17);
		pnlContent.add(lblUserName);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(0, 53, 65, 17);
		pnlContent.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setBounds(211, 51, 95, 20);
		pnlContent.add(btnLogin);
		
		txtpasswordField = new JPasswordField();
		txtpasswordField.setFont(new Font("Arial", Font.PLAIN, 12));
		txtpasswordField.setBounds(75, 51, 105, 20);
		pnlContent.add(txtpasswordField);
		
		btnClear = new JButton("Clear");
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 12));
		btnClear.setBounds(211, 23, 95, 20);
		pnlContent.add(btnClear);
	}
}

