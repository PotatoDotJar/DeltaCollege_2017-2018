// Delta College - CST 183 - Klingler  
// This application demonstrates a basic Java event-driven application with
// a user interface that allows two number to be entered.  When the button
// is pressed, the numbers are added and the sum displayed via an output dialog
// box

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdditionButton extends JFrame 
{
	// Class wide component declarations
	private JTextField operand1; 
	private JTextField operand2;
	private JTextField operand3; 
	private JLabel operandLabel1;
	private JLabel operandLabel2;
	private JLabel operandLabel3;
	private JButton addButton;

	// set up GUI
	public AdditionButton()
	{
		// Get access to JFrame container - required to add components
		// Set layout to flow layout; allow components to be displayed
		// left-to-right and top-to-bottom
		Container frameContainer = getContentPane();
		frameContainer.setLayout( new FlowLayout() );

		// Initialize label objects
		operandLabel1 = new JLabel("First Number");
		operandLabel2 = new JLabel("Second Number");
		operandLabel3 = new JLabel("Third Number");

		// Initialize text field objects
		operand1 = new JTextField( 15 );
		operand2 = new JTextField( 15 );
		operand3 = new JTextField( 15 );

		// Add commponents to container frame (left-to-right, top-to-bottom)
		frameContainer.add( operandLabel1 );
		frameContainer.add( operand1 );
		frameContainer.add( operandLabel2 );
		frameContainer.add( operand2 );
		frameContainer.add( operandLabel3 );
		frameContainer.add( operand3 );

		// Initialize button and its label
		addButton = new JButton("Add");
		frameContainer.add( addButton );      

		// Register event handler for button
		ButtonHandler handler = new ButtonHandler();
		addButton.addActionListener( handler );

		// Set application window attributes
		setTitle( "Adding Machine" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 350, 200 );
		setVisible( true );

	} // end constructor ButtonTest

	// Private inner class for event handling
	private class ButtonHandler implements ActionListener 
	{
		// Process button click
		public void actionPerformed( ActionEvent event )
		{
			// If user clicks button, grab text currently stored
			// in text field and display it in a dialog
			if ( event.getSource() == addButton )
			{
				String operand1Str = operand1.getText();
				String operand2Str = operand2.getText();
				String operand3Str = operand3.getText();
				int field1 = 0, field2= 0, field3 = 0, sum;

				// Convert and add operands from text fields
				try {
					if(operand3Str != null && !operand3Str.equals("")) {
						field1 = Integer.parseInt(operand1Str);
						field2 = Integer.parseInt(operand2Str);
						field3 = Integer.parseInt(operand3Str);
					} else {
						field1 = Integer.parseInt(operand1Str);
						field2 = Integer.parseInt(operand2Str);
					}

					if(!(field1 > 0) || !(field2 > 0) || !(field3 > 0)) {
						JOptionPane.showMessageDialog(null, "Numbers must be non-negative!");
					} else {
						sum = field1 + field2 + field3;
						// Display via dialog vbox
						JOptionPane.showMessageDialog( null, "Sum is: " + sum );
					}

				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog( null, "Invalid number input!\n" + e.getMessage());
				}

			}

		} // end method actionPerformed
	} // end ButtonHandler class

	// Main method - to launch application
	public static void main( String args[] )
	{ 
		AdditionButton application = new AdditionButton();
	}

} 