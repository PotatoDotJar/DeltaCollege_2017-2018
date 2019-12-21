
// Delta College - CST 283 - Klingler  
// This application demonstrates a basic Java event-driven application with
// a user interface that allows two number to be entered.  When the button
// is pressed, the numbers are added and the sum displayed via an output dialog
// box

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DoMath extends JFrame {
	// Class wide component declarations
	private JTextField operand1;
	private JTextField operand2;
	private JTextField operand3;

	private JLabel operandLabel1;
	private JLabel operandLabel2;
	private JLabel operandLabel3;

	private JButton addButton;
	private JButton multButton;

	// set up GUI
	public DoMath() {
		// Get access to JFrame container - required to add components
		// Set layout to flow layout; allow components to be displayed
		// left-to-right and top-to-bottom
		Container frameContainer = getContentPane();
		frameContainer.setLayout(new FlowLayout());

		// Initialize label objects
		operandLabel1 = new JLabel("First Number");
		operandLabel2 = new JLabel("Second Number");
		operandLabel3 = new JLabel("Third Number");

		// Initialize text field objects
		operand1 = new JTextField(15);
		operand2 = new JTextField(15);
		operand3 = new JTextField(15);

		// Add commponents to container frame (left-to-right, top-to-bottom)
		frameContainer.add(operandLabel1);
		frameContainer.add(operand1);
		frameContainer.add(operandLabel2);
		frameContainer.add(operand2);
		frameContainer.add(operandLabel3);
		frameContainer.add(operand3);

		// Initialize button and its label
		addButton = new JButton("Add");
		frameContainer.add(addButton);
		multButton = new JButton("Multiply");
		frameContainer.add(multButton);

		// Register event handler for button
		ButtonHandler handler = new ButtonHandler();
		addButton.addActionListener(handler);
		multButton.addActionListener(handler);

		// Set application window attributes
		setTitle("Adding Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);

	} // end constructor ButtonTest

	// Private inner class for event handling
	private class ButtonHandler implements ActionListener {
		// Process button click
		public void actionPerformed(ActionEvent event) {
			// If user clicks button, collect values and add
			if (event.getSource() == addButton) {
				String operand1Str = operand1.getText();
				String operand2Str = operand2.getText();
				String operand3Str = operand3.getText();

				// Convert and add operands from text fields
				int sum = Integer.parseInt(operand1Str) + Integer.parseInt(operand2Str) + Integer.parseInt(operand3Str);

				// Display via dialog vbox
				JOptionPane.showMessageDialog(null, "Sum is: " + sum);
			} else if (event.getSource() == multButton) {
				String operand1Str = operand1.getText();
				String operand2Str = operand2.getText();
				String operand3Str = operand3.getText();

				// Convert from string and multiply.
				int prouduct = Integer.parseInt(operand1Str) * Integer.parseInt(operand2Str)
						* Integer.parseInt(operand3Str);

				// Display via dialog vbox
				JOptionPane.showMessageDialog(null, "Prouduct is: " + prouduct);
			}

		} // end method actionPerformed
	} // end ButtonHandler class

	// Main method - to launch application
	public static void main(String args[]) {
		DoMath application = new DoMath();
	}

}