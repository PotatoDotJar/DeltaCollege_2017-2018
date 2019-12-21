
// This application displays academic data pulled from an external file.
// It allows various sorting patterns for better analysis.

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class StudentSort extends JFrame {
	private JPanel labelPanel;
	private JPanel buttonPanel;
	private JPanel bottomPanel;
	private JLabel sortLabel;
	private JTextArea dataArea;

	// Buttons for sorting choices
	private JButton sortNameAsc;
	private JButton sortGPADesc;
	private JButton sortGradeAsc;
	private JButton sortIDAsc;
	private JButton sortAbcence;

	// Parallel data arrays
	private String name[];
	private int ID[];
	private char grade[];
	private double gpa[];
	private int absences[];

	GradeDB studentDatabase;

	// set up GUI
	public StudentSort() {
		// get content pane
		Container container = getContentPane();

		// Add panel for label
		labelPanel = new JPanel();
		labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		sortLabel = new JLabel("Sort by ...");
		labelPanel.add(sortLabel);

		// Instantiate buttons
		sortIDAsc = new JButton("ID");
		sortNameAsc = new JButton("Name");
		sortGPADesc = new JButton("GPA");
		sortGradeAsc = new JButton("Grade");
		sortAbcence = new JButton("Abcence");

		// set up panel and set its layout
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 5));

		// Add buttons to panel
		buttonPanel.add(sortIDAsc);
		buttonPanel.add(sortNameAsc);
		buttonPanel.add(sortGPADesc);
		buttonPanel.add(sortGradeAsc);
		buttonPanel.add(sortAbcence);

		// Associate buttons to listener
		ButtonHandler eventmanager = new ButtonHandler();
		sortIDAsc.addActionListener(eventmanager);
		sortNameAsc.addActionListener(eventmanager);
		sortGPADesc.addActionListener(eventmanager);
		sortGradeAsc.addActionListener(eventmanager);
		sortAbcence.addActionListener(eventmanager);

		// Add text area and panels to GUI
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2, 1));
		bottomPanel.add(labelPanel);
		bottomPanel.add(buttonPanel);
		dataArea = new JTextArea();
		container.add(dataArea, BorderLayout.CENTER);
		container.add(bottomPanel, BorderLayout.SOUTH);

		// Instantiate student data object
		studentDatabase = new GradeDB();
	}

	// -------------------------------------------------------------
	// Private inner class for event handling
	private class ButtonHandler implements ActionListener {
		// Process button click
		public void actionPerformed(ActionEvent event) {
			// If user clicks button, grab text currently stored
			// in text field and display it in a dialog
			if (event.getSource() == sortIDAsc)
				studentDatabase.sortIDAsc();
			if (event.getSource() == sortNameAsc)
				studentDatabase.sortNameAsc();
			if (event.getSource() == sortGradeAsc)
				studentDatabase.sortGradeAsc();
			if (event.getSource() == sortGPADesc)
				studentDatabase.sortGPADesc();
			if (event.getSource() == sortAbcence)
				studentDatabase.sortAbsenceAsc();

			// Write updated data to the text area
			dataArea.setText(studentDatabase.toString());

		} // end method actionPerformed
	} // end ButtonHandler class

	// -------------------------------------------------------------
	public static void main(String args[]) {
		StudentSort application = new StudentSort();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 300);
		application.setVisible(true);
		application.setTitle("Student Summary");
	}

}
