import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * JFrame for logging into the system
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class LoginWindow extends JFrame {

	// Panels
	private JPanel contentPane;

	// Fields
	private JTextField fldUsername;
	private JPasswordField fldPassword;

	// Labels
	private JLabel lblError;

	// Login info [Don't look at this if you're not supposed to ;) ]
	private static String username = "admin";
	private static String password = "admin";

	// Database to pass later
	DataImportManager dataImportManager;

	// Create the window
	public LoginWindow() {
		// Window settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setTitle("Login");

		// Field labels
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(10, 11, 72, 19);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 41, 72, 19);
		contentPane.add(lblPassword);

		// Action listener for enter press on fields
		Action action = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Check login
				if (!checkLogin()) {
					lblError.setForeground(Color.RED);
					lblError.setText("Invalid login!");
					fldPassword.setText("");

				} else {

					lblError.setForeground(Color.GREEN);
					lblError.setText("Logged in! Loading Database...");
					dataImportManager = new DataImportManager();

					lblError.setText("Database Loaded!");

					setVisible(false);

					// Open Main Window
					MainWindow mainWindow = new MainWindow(dataImportManager.getBinarySearchTree());

				}
			}
		};

		// Username field
		fldUsername = new JTextField();
		fldUsername.setToolTipText("Press enter to login");
		fldUsername.setBounds(92, 12, 182, 20);
		fldUsername.addActionListener(action);
		contentPane.add(fldUsername);
		fldUsername.setColumns(10);

		// Password field
		fldPassword = new JPasswordField();
		fldPassword.setToolTipText("Press enter to login");
		fldPassword.setBounds(92, 42, 182, 20);
		fldPassword.addActionListener(action);
		contentPane.add(fldPassword);

		// Info output
		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblError.setBounds(10, 76, 264, 18);
		contentPane.add(lblError);
		setVisible(true);
	}

	// Method to test login info
	private boolean checkLogin() {
		boolean loggedIn = true;
		if (!fldUsername.getText().equals(username)) {
			loggedIn = false;
		}
		if (!String.valueOf(fldPassword.getPassword()).equals(password)) {
			loggedIn = false;
		}

		return loggedIn;
	}

	// Getter and setter for database
	public BinarySearchTree<Traveler> getBinaryTreeDatabase() {
		return dataImportManager.getBinarySearchTree();
	}

}
