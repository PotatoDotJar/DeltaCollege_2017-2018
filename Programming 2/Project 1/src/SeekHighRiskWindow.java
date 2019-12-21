import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * JFrame for seeking the high risk users in the database
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class SeekHighRiskWindow extends JFrame {

	// Prev JFrame
	private JFrame prevJFrame;

	// Main content pane
	private JPanel contentPane;

	// Binary search tree database
	BinarySearchTree<Traveler> binarySearchTree;

	// Table
	private JTable dataTable;

	// Columns
	private String[] columns = { "First Name", "Last Name", "Phone Number", "Email", "Risk Level" };

	Traveler[] travelersInTable; // Keep track of Travelers in the table
	private JPanel panelTop;
	private JCheckBox ckbxOne;
	private JCheckBox ckbxTwo;
	private JCheckBox ckbxThree;
	private JCheckBox ckbxFour;

	// Main constructor
	public SeekHighRiskWindow(JFrame prevJFrame, BinarySearchTree<Traveler> binarySearchTree) {
		this.binarySearchTree = binarySearchTree; // Init provided search tree
		this.prevJFrame = prevJFrame; // The previous window reference

		travelersInTable = getTravelersSortedByRisk().toArray(new Traveler[getTravelersSortedByRisk().size()]);

		// Window settings
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Hide window on close
		setBounds(100, 100, 760, 980);
		setLocationRelativeTo(prevJFrame);
		setTitle("Seek High Risk Travelers");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Table
		dataTable = new JTable(new DefaultTableModel(getTableArray(getTravelersSortedByRisk()), columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		dataTable.addMouseListener(new IMouseAdapter());
		dataTable.setToolTipText("To make a report double click the row.");

		// Scroll pane for table
		JScrollPane scrollPane = new JScrollPane(dataTable);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		// Check Box listener
		CheckBoxListener checkBoxListener = new CheckBoxListener();

		panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);

		ckbxOne = new JCheckBox("Level 1");
		ckbxOne.setSelected(true);
		ckbxOne.addActionListener(checkBoxListener);
		panelTop.add(ckbxOne);

		ckbxTwo = new JCheckBox("Level 2");
		ckbxTwo.setSelected(true);
		ckbxTwo.addActionListener(checkBoxListener);
		panelTop.add(ckbxTwo);

		ckbxThree = new JCheckBox("Level 3");
		ckbxThree.setSelected(true);
		ckbxThree.addActionListener(checkBoxListener);
		panelTop.add(ckbxThree);

		ckbxFour = new JCheckBox("Level 4");
		ckbxFour.setSelected(true);
		ckbxFour.addActionListener(checkBoxListener);
		panelTop.add(ckbxFour);

		// Show window
		setVisible(true);
	}

	// Class for handling mouse events in the table
	private class IMouseAdapter implements MouseListener {


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

				new ReportWindow(binarySearchTree, selectedTraveler);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

	}

	private Boolean[] checkBoxes = { true, true, true, true }; // Keep track of check boxes
	// Action listener for the check boxes
	private class CheckBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ckbxOne) {
				checkBoxes[0] = ckbxOne.isSelected();
			} else if (e.getSource() == ckbxTwo) {
				checkBoxes[1] = ckbxTwo.isSelected();
			} else if (e.getSource() == ckbxThree) {
				checkBoxes[2] = ckbxThree.isSelected();
			} else if (e.getSource() == ckbxFour) {
				checkBoxes[3] = ckbxFour.isSelected();
			}

			updateTable();
		}

	}

	// Method to update table based on risk check boxes
	private void updateTable() {
		ArrayList<Traveler> travelersSortedWithRisk = getTravelersSortedByRisk(); // Existing list
		ArrayList<Traveler> newList = new ArrayList<>(); // New list

		for (int i = 0; i < travelersSortedWithRisk.size(); i++) {
			if (checkBoxes[0]) {
				if (travelersSortedWithRisk.get(i).getRiskLevel() == 1) {
					newList.add(travelersSortedWithRisk.get(i));
				}
			}
			if (checkBoxes[1]) {
				if (travelersSortedWithRisk.get(i).getRiskLevel() == 2) {
					newList.add(travelersSortedWithRisk.get(i));
				}
			}
			if (checkBoxes[2]) {
				if (travelersSortedWithRisk.get(i).getRiskLevel() == 3) {
					newList.add(travelersSortedWithRisk.get(i));
				}
			}
			if (checkBoxes[3]) {
				if (travelersSortedWithRisk.get(i).getRiskLevel() == 4) {
					newList.add(travelersSortedWithRisk.get(i));
				}
			}
		}

		newList.sort(new RiskSortComparator()); // Sort

		dataTable.setModel(new DefaultTableModel(getTableArray(newList), columns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		
	}

	// Method to get a Array of travelers sorted by risk level decending
	private ArrayList<Traveler> getTravelersSortedByRisk() {
		ArrayList<Traveler> travelers = binarySearchTree.toArrayList(new Traveler[binarySearchTree.getFastSize()]);
		travelers.sort(new RiskSortComparator());
		return travelers;
	}

	// Method to build a 2D string array from returned data
	private String[][] getTableArray(ArrayList<Traveler> travelers) {
		String[][] data = new String[travelers.size()][5];

		travelersInTable = getTravelersSortedByRisk().toArray(new Traveler[travelers.size()]); // Keep track of what's
																								// in the table

		for (int i = 0; i < data.length; i++) {
			data[i] = travelers.get(i).toString().split(",");
		}
		return data;
	}

	// Class for sorting an array list by risk
	public class RiskSortComparator implements Comparator<Traveler> {

		@Override
		public int compare(Traveler o1, Traveler o2) {
			return o2.getRiskLevel() - o1.getRiskLevel();
		}

	}

}
