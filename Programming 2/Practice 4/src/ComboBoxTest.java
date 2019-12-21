
// This example demonstrates a common method for selecting
// information from a drop-down menu.  It converts a user
// choice for a state code to the state name.

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ComboBoxTest extends JFrame {
	private JComboBox stateIDList;
	private JButton doIt;

	private String outputStr = "";
	private int selectedIndex; // Maintain index of current state selected

	private String stateApprevs[] = { "", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID",
			"IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
			"NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
			"WI", "WY" };
	private String stateNames[] = { "NONE", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
			"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
			"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Massachusetts", "Maryland", "Michigan",
			"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
			"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
			"Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
			"Washington", "West Virginia", "Wisconsin", "Wyoming" };

	// set up GUI
	public ComboBoxTest() {
		// get content pane and set its layout
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		// set up JComboBox and register its event handler
		stateIDList = new JComboBox(stateApprevs);
		container.add(stateIDList);

		// Use anonymous inner class to handle list selection event
		stateIDList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Determin index of state code selected
				selectedIndex = stateIDList.getSelectedIndex();
			}
		} // end anonymous inner class
		); // end call to addItemListener

		// Set up button allowing user to make selection.
		// Button click will retrieve index of current selected item and
		// match with string in state name array
		doIt = new JButton("Select a State");
		container.add(doIt);
		doIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Access state name associated with selected index
				// Perform basic error check to be sure that a selection was made
				// (index zero will generate an error message)
				if (selectedIndex == 0) {
					JOptionPane.showMessageDialog(null, "You must make a selection");
				} else {
					if (stateApprevs[selectedIndex].equalsIgnoreCase("MI")) {
						outputStr = stateNames[selectedIndex] + "\nThe greatest, most beautiful state in the USA!";
						JOptionPane.showMessageDialog(null, "You selected: " + outputStr);
					} else if (stateApprevs[selectedIndex].equalsIgnoreCase("CA")) {
						outputStr = stateNames[selectedIndex] + "\nThe grossest, most smog-filled state in the USA!";
						JOptionPane.showMessageDialog(null, "You selected: " + outputStr);
					} else {
						outputStr = stateNames[selectedIndex];
						JOptionPane.showMessageDialog(null, "You selected: " + outputStr);
					}

				}
			}
		} // end anonymous inner class
		); // end call to addActionListener

		// Set up application attributes
		setSize(350, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Testing JComboBox");

	} // end ComboBoxTest constructor

	public static void main(String args[]) {
		ComboBoxTest application = new ComboBoxTest();
	}

}