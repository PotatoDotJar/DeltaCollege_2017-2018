import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * JFrame for editing users in the database
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class UserEditWindow extends JFrame {

	// Main content pane
	private JPanel contentPane;

	// Binary search tree database
	private BinarySearchTree<Traveler> binarySearchTree;

	// User Table
	private UserTableWindow userTableWindow;

	// Traveler Object
	private Traveler traveler;
	private Traveler oldTraveler;

	// Panels
	private JPanel panelFirstName;
	private JPanel panelLastName;
	private JPanel panelAddress;
	private JPanel panelCity;
	private JPanel panelState;
	private JPanel panelZipcode;
	private JPanel panelPhone;
	private JPanel panelRiskLevel;

	// TextField
	private JTextField fldFirstName;
	private JTextField fldLastName;
	private JTextField fldAddress;
	private JTextField fldCity;
	private JTextField fldZipCode;
	private JTextField fldPhone;

	// Lists
	private JComboBox<Integer> listRiskLevel;
	private JComboBox<String> listState;

	// State Abbreviations
	String[] states = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL",
			"IN", "KS", "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ",
			"NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT",
			"WA", "WI", "WV", "WY" };
	private JPanel panelButtons;
	private JButton btnExit;
	private JButton btnSave;
	private JPanel panelTitle;
	private JLabel lblTitle;
	private JButton btnDelete;
	private JPanel panelEmail;
	private JTextField fldEmail;

	// Main constructor
	public UserEditWindow(UserTableWindow userTableWindow, BinarySearchTree<Traveler> binarySearchTree,
			Traveler traveler) {
		this.userTableWindow = userTableWindow;
		this.binarySearchTree = binarySearchTree; // Init provided search tree
		this.oldTraveler = traveler;
		this.traveler = traveler;

		// Window settings
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Hide window on close
		setBounds(100, 100, 350, 630);
		setLocationRelativeTo(null);
		setTitle("Edit User");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		panelTitle = new JPanel();
		contentPane.add(panelTitle);

		lblTitle = new JLabel("Edit User - " + traveler.getFirstName() + " " + traveler.getLastName());
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTitle.add(lblTitle);

		// First Name panel
		panelFirstName = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelFirstName.getLayout();
		panelFirstName
				.setBorder(new TitledBorder(null, "First Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelFirstName);

		// First Name field
		fldFirstName = new JTextField();
		fldFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		panelFirstName.add(fldFirstName);
		fldFirstName.setColumns(20);

		// Last Name panel
		panelLastName = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelLastName.getLayout();
		panelLastName.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Last Name",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelLastName);

		// Last Name field
		fldLastName = new JTextField();
		fldLastName.setHorizontalAlignment(SwingConstants.LEFT);
		fldLastName.setColumns(20);
		panelLastName.add(fldLastName);

		panelEmail = new JPanel();
		panelEmail.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Email", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelEmail);

		fldEmail = new JTextField();
		fldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		fldEmail.setColumns(20);
		panelEmail.add(fldEmail);

		// Address panel
		panelAddress = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelAddress.getLayout();
		panelAddress.setBorder(new TitledBorder(null, "Address", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panelAddress);

		// Address field
		fldAddress = new JTextField();
		fldAddress.setHorizontalAlignment(SwingConstants.LEFT);
		fldAddress.setColumns(20);
		panelAddress.add(fldAddress);

		// City panel
		panelCity = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCity.getLayout();
		panelCity.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "City", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelCity);

		// City field
		fldCity = new JTextField();
		fldCity.setHorizontalAlignment(SwingConstants.LEFT);
		fldCity.setColumns(20);
		panelCity.add(fldCity);

		// State panel
		panelState = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panelState.getLayout();
		panelState.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "State", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelState);

		// State selection
		DefaultComboBoxModel<String> statesModel = new DefaultComboBoxModel<>(states);
		listState = new JComboBox(statesModel);
		panelState.add(listState);

		// Zipcode panel
		panelZipcode = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panelZipcode.getLayout();
		panelZipcode.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ZipCode",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelZipcode);

		// Zipcode field
		fldZipCode = new JTextField();
		fldZipCode.setHorizontalAlignment(SwingConstants.LEFT);
		fldZipCode.setColumns(20);
		panelZipcode.add(fldZipCode);

		// Phone panel
		panelPhone = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panelPhone.getLayout();
		panelPhone.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Phone Number",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelPhone);

		// Phone panel
		fldPhone = new JTextField();
		fldPhone.setHorizontalAlignment(SwingConstants.LEFT);
		fldPhone.setColumns(20);
		panelPhone.add(fldPhone);

		// Risk panel
		panelRiskLevel = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panelRiskLevel.getLayout();
		panelRiskLevel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Risk Level",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panelRiskLevel);

		// Risk selection
		Integer[] risks = { 1, 2, 3, 4 };
		DefaultComboBoxModel<Integer> riskModel = new DefaultComboBoxModel<>(risks);
		listRiskLevel = new JComboBox(riskModel);
		panelRiskLevel.add(listRiskLevel);

		// Buttons panel
		panelButtons = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panelButtons.getLayout();
		contentPane.add(panelButtons);

		// Buttons

		ButtonListener listener = new ButtonListener(this);

		btnExit = new JButton("Exit");
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.addActionListener(listener);

		btnSave = new JButton("Save");
		btnSave.addActionListener(listener);
		panelButtons.add(btnSave);
		panelButtons.add(btnExit);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(listener);
		panelButtons.add(btnDelete);

		// Set window visible
		setVisible(true);

		// Init fields
		loadTravelerIntoFields();
	}

	// Method to load Traveler data into fields
	private void loadTravelerIntoFields() {
		fldFirstName.setText(this.traveler.getFirstName());
		fldLastName.setText(this.traveler.getLastName());
		fldEmail.setText(this.traveler.getEmail());
		fldAddress.setText(this.traveler.getAddress());
		fldCity.setText(this.traveler.getCity());
		listState.setSelectedIndex(stringStateToArrIndex(this.traveler.getState()));
		fldZipCode.setText(String.valueOf(this.traveler.getZipCode()));
		fldPhone.setText(this.traveler.getPhone());
		listRiskLevel.setSelectedIndex(this.traveler.getRiskLevel() - 1);
	}

	// Method to get Traveler object from field data.
	private Traveler getTravelerFromFieldData() {
		String firstName = fldFirstName.getText();
		String lastName = fldLastName.getText();
		String email = fldEmail.getText();
		String address = fldAddress.getText();
		String city = fldCity.getText();
		String state = states[listState.getSelectedIndex()];
		int zipCode = Integer.parseInt(fldZipCode.getText());
		String phone = fldPhone.getText();
		int riskLevel = listRiskLevel.getSelectedIndex() + 1;

		Traveler traveler = new Traveler(firstName, lastName, address, city, state, zipCode, phone, email, riskLevel);

		return traveler;
	}

	// Method to save edited traveler to database
	private void saveTravelerToDataBase() {

		int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "Save",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (answer == JOptionPane.YES_OPTION) {
			binarySearchTree.remove(oldTraveler);
			binarySearchTree.add(getTravelerFromFieldData());
			binarySearchTree.saveToFile();
			userTableWindow.reloadTable();
			this.dispose();
		}
	}

	// Method to delete a Traveler from the database
	private void removeTravelerFromDataBase() {

		int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "Delete",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (answer == JOptionPane.YES_OPTION) {
			binarySearchTree.remove(oldTraveler);
			binarySearchTree.saveToFile();
			userTableWindow.reloadTable();
			this.dispose();
		}
	}

	// Method to get state array index from string
	private int stringStateToArrIndex(String stateAbb) {
		return Arrays.asList(states).indexOf(stateAbb.trim().toUpperCase());
	}

	// Class for button listeners at bottom
	private class ButtonListener implements ActionListener {

		private JFrame frame;

		// Constructor
		public ButtonListener(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// Exit button
			if (e.getSource() == btnExit) {
				frame.dispose();
			}
			// Save button
			else if (e.getSource() == btnSave) {
				saveTravelerToDataBase();
			} else if (e.getSource() == btnDelete) {
				removeTravelerFromDataBase();
			}
		}
	}

}
