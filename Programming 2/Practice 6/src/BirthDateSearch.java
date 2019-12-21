
// Delta College - CST 283 - Klingler
// This application builds one contact list object and then searches it to
// determine if any birthdays fall on this date.

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BirthDateSearch extends JFrame {
	// Class wide component declarations
	private JComboBox monthList, dayList;
	private JLabel monthLabel, dayLabel, areaCodeLabel;
	private JButton goButton, areaSearchBtn;
	private JTextArea areaCode;

	private JFrame outputDisplayWindow;
	private JScrollPane scrollableTextArea;
	private JTextArea outputDisplayArea;

	private final String months[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV",
			"DEC" };

	ContactList allContacts;

	// Primary constructor for GUI construction
	public BirthDateSearch() {
		
		setSize(600, 600);

		allContacts = new ContactList(); // Create contact list object

		Container frameContainer = getContentPane();
		frameContainer.setLayout(new GridLayout(2, 1));
		frameContainer.setSize(600, 600);

		// Initialize month and date drop boxes
		String days[] = new String[31]; // Generate day array
		for (int i = 0; i < 31; i++)
			days[i] = String.format("%02d", (i + 1));

		JPanel birthSearch = new JPanel(new FlowLayout());

		// Initialize GUI objects
		monthLabel = new JLabel("Month");
		dayLabel = new JLabel("Day");
		monthList = new JComboBox(months);
		dayList = new JComboBox(days);

		// Add commponents to container frame (left-to-right, top-to-bottom)
		birthSearch.add(monthLabel);
		birthSearch.add(monthList);
		birthSearch.add(dayLabel);
		birthSearch.add(dayList);


		// Initialize button and its label
		goButton = new JButton("Search birthday");
		birthSearch.add(goButton);

		frameContainer.add(birthSearch);

		// Area code search
		JPanel zipSearch = new JPanel(new FlowLayout());
		areaCodeLabel = new JLabel("Area Code");
		zipSearch.add(areaCodeLabel);

		areaCode = new JTextArea();
		areaCode.setColumns(5);
		zipSearch.add(areaCode);

		areaSearchBtn = new JButton("Search Area Code");
		zipSearch.add(areaSearchBtn);



		frameContainer.add(zipSearch);
		// Register event handler for button
		ButtonHandler handler = new ButtonHandler();
		goButton.addActionListener(handler);
		areaSearchBtn.addActionListener(handler);

		// Set up frame for final output report - Initially make invisible
		outputDisplayWindow = new JFrame();
		outputDisplayWindow.setSize(600, 600);
		outputDisplayWindow.setVisible(false);

		outputDisplayArea = new JTextArea(10, 15);
		outputDisplayArea.setFont(new Font("Monospaced", Font.PLAIN, 16));

		scrollableTextArea = new JScrollPane(outputDisplayArea);

		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		outputDisplayWindow.add(scrollableTextArea);

		// Set application window attributes
		setTitle("Contact List - Birthday Check");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setVisible(true);

	} // end constructor ButtonTest

	// Private inner class for event handling
	private class ButtonHandler implements ActionListener {
		// Process button click
		public void actionPerformed(ActionEvent event) {
			// If user clicks button collect the birthday info and search
			if (event.getSource() == goButton) {

				int month = monthList.getSelectedIndex() + 1;
				int day = dayList.getSelectedIndex() + 1;

				String outputString = allContacts.searchContactsByBirthDate(month, day);
				if (outputString.equals(""))
					JOptionPane.showMessageDialog(null, "No birthdays found.");
				else // Display contact data via new window
				{
					outputDisplayWindow.setTitle("Birthdays on " + month + "/" + day);
					outputDisplayArea.setText(outputString);
					outputDisplayWindow.setVisible(true);
				}
			}

			else if (event.getSource() == areaSearchBtn) {
				try {
					int zipCode = Integer.parseInt(areaCode.getText());

					if (zipCode >= 0) {
						String outputString = allContacts.searchContactsByZipCode(zipCode);

						if (outputString.equals(""))
							JOptionPane.showMessageDialog(null, "No records with that zipcode found.");
						else // Display contact data via new window
						{
							outputDisplayWindow.setTitle("Records matching zipcode " + zipCode);
							outputDisplayArea.setText(outputString);
							outputDisplayWindow.setVisible(true);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Invalid zip code!");
						areaCode.setText("");
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid zip code!");
					areaCode.setText("");
				}
			}

		} // end method actionPerformed
	} // end ButtonHandler class

	// Main method - to launch application
	public static void main(String args[]) {
		BirthDateSearch application = new BirthDateSearch();
	}

}