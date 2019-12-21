import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 * JFrame for managing the users in the database
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class UserTableWindow extends JFrame {

	// Prev JFrame
	private JFrame prevJFrame;

	// Main content pane
	private JPanel contentPane;

	// Binary search tree database
	BinarySearchTree<Traveler> binarySearchTree;
	private JTable dataTable;
	private JScrollPane scrollPane;
	private JPanel panelTop;
	private JTextField fldSearch;
	private JLabel lblSearch;

	// Top column labels
	String[] columns = { "First Name", "Last Name", "Phone Number", "Email", "Risk Level" };
	Traveler[] travelersInTable;
	private JLabel lblInfo;

	// Main constructor
	public UserTableWindow(JFrame prevJFrame, BinarySearchTree<Traveler> binarySearchTree) {
		this.binarySearchTree = binarySearchTree; // Init provided search tree
		this.prevJFrame = prevJFrame;

		// Window settings
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Hide window on close
		setBounds(100, 100, 900, 1000);
		setLocationRelativeTo(prevJFrame);
		setTitle("User Table");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Top panel
		panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);

		// Search field
		fldSearch = new JTextField();
		fldSearch.setToolTipText("Search By Email (Not Case Sensitive)");
		fldSearch.getDocument().addDocumentListener(new SearchActionHandler());

		// Label for the top Search Field
		lblSearch = new JLabel("Search:");
		panelTop.add(lblSearch);
		panelTop.add(fldSearch);
		fldSearch.setColumns(18);

		lblInfo = new JLabel("To edit a user double click on table row.");
		panelTop.add(lblInfo);

		// Main table
		dataTable = new JTable(new DefaultTableModel(buildTableData(binarySearchTree), columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});


		// Table click listener
		dataTable.addMouseListener(new IMouseAdapter(this));

		// Scroll panel for table
		scrollPane = new JScrollPane(dataTable);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// Set window viable
		setVisible(true);
	}

	// Class for handling mouse events in the table
	private class IMouseAdapter implements MouseListener {

		private UserTableWindow userTableWindow;

		public IMouseAdapter(UserTableWindow tableWindow) {
			this.userTableWindow = tableWindow;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {

			Point point = e.getPoint();
			int rowNum = dataTable.rowAtPoint(point);

			if (rowNum != -1 && e.getClickCount() == 2) {

				// Get selected traveler in the Array that is used to keep track of what
				// Traveler objects are in the table.
				Traveler selectedTraveler = travelersInTable[rowNum];
				new UserEditWindow(this.userTableWindow, binarySearchTree, selectedTraveler);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}

	// Method to build the table data
	private String[][] buildTableData(BinarySearchTree<Traveler> dataBase) {
		ArrayList<Traveler> dataList = dataBase.toArrayList(new Traveler[dataBase.size()]);
		travelersInTable = new Traveler[dataList.size()];
		travelersInTable = dataList.toArray(travelersInTable);

		String[][] data = new String[dataList.size()][5];

		for (int rows = 0; rows < dataList.size(); rows++) {
			data[rows] = dataList.get(rows).toString().split(",");
		}

		return data;
	}

	// Method to update table with a 2D array of data and update Array used to keep
	// track of what Traveler objects are in the table
	private void updateTable(String[][] data, ArrayList<Traveler> indexList) {
		travelersInTable = new Traveler[indexList.size()];
		travelersInTable = indexList.toArray(travelersInTable);

		dataTable.setModel(new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	// Method to update table with a 2D array of data
	private void updateTable(String[][] data) {

		dataTable.setModel(new DefaultTableModel(data, columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}

	// Public method to reload table
	public void reloadTable() {
		fldSearch.setText("");
		updateTable(buildTableData(binarySearchTree));
	}

	// Class to call update when search field changes
	private class SearchActionHandler implements DocumentListener {

		// Events called when JTextField is changed
		@Override
		public void changedUpdate(DocumentEvent e) {
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			searchUpdate();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			searchUpdate();
		}

		// Method to retrieve data from binary search tree
		private void searchUpdate() {
			String[][] dataNoneFound = { { "None", "None", "None", "None", "None" } };
			ArrayList<Traveler> searchData;

			// If field is not blank
			if (!fldSearch.getText().equals("")) {
				searchData = binarySearchTree.search(fldSearch.getText());
				String[][] data = new String[searchData.size()][5];

				for (int rows = 0; rows < searchData.size(); rows++) {
					data[rows] = searchData.get(rows).toString().split(",");
				}

				if (data != null && data.length >= 1) {
					updateTable(data, searchData);
				} else {
					updateTable(dataNoneFound, searchData);
				}
			} else {
				// If field is blank show all records
				updateTable(buildTableData(binarySearchTree));
			}
		}
	}

}
