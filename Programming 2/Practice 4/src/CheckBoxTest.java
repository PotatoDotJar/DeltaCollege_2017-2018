
// Delta College - CST 283 - Klingler  
// This application demonstrates use of check boxes for management
// of "on/off" decisions

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckBoxTest extends JFrame {
	private JTextField field;
	private JCheckBox summer, spring, winter, fall;
	private JButton goButton;

	private boolean summerState, springState, winterState, fallState;

	// set up GUI
	public CheckBoxTest() {
		// Get content pane and set its layout
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		// Set up JTextField
		field = new JTextField("Enter your name here", 20);
		container.add(field);

		// Create checkbox objects
		summer = new JCheckBox("Summer");
		spring = new JCheckBox("Spring");
		winter = new JCheckBox("Winter");
		fall = new JCheckBox("Fall");
		container.add(summer);
		container.add(spring);
		container.add(winter);
		container.add(fall);

		// Set up JButton
		goButton = new JButton("Evaluate");
		container.add(goButton);

		// register listeners for JCheckBoxes
		CheckBoxHandler theHandler = new CheckBoxHandler();
		summer.addItemListener(theHandler);
		spring.addItemListener(theHandler);
		winter.addItemListener(theHandler);
		fall.addItemListener(theHandler);

		// register listeners for JButton
		ButtonHandler theButtonHandler = new ButtonHandler();
		goButton.addActionListener(theButtonHandler);

		// Initialize all check box variables to default "unchecked"
		summerState = false;
		springState = false;
		winterState = false;
		fallState = false;

		// Set window attributes
		setSize(275, 140);
		setVisible(true);
		setTitle("JCheckBox Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	} // end CheckBoxText constructor

	// Private inner class for ItemListener event handling
	private class CheckBoxHandler implements ItemListener {
		// Respond to checkbox events
		public void itemStateChanged(ItemEvent event) {
			if (summer.isSelected()) // Button for "summer"
				summerState = true;
			else
				summerState = false;

			if (spring.isSelected()) // Button for "spring"
				springState = true;
			else
				springState = false;

			if (winter.isSelected()) // Button for "winter"
				winterState = true;
			else
				winterState = false;

			if (fall.isSelected()) // Button for "fall"
				fallState = true;
			else
				fallState = false;

		} // end method itemStateChanged

	} // end private inner class CheckBoxHandler

	// Private inner class for ActionListener event handling
	private class ButtonHandler implements ActionListener {
		// Respond to button event
		public void actionPerformed(ActionEvent event) {
			// Build output message
			String message = field.getText() + ", \n";
			int selected = 0;
			if (summerState)
				selected++;
			if (springState)
				selected++;
			if (winterState)
				selected++;
			if (fallState)
				selected++;

			if (selected >= 2) {
				message += "You will be mailed the annual travel guide.";

			} else if (selected == 1) {
				if (summerState)
					message += "The travel guide for summer will be mailed to you shortly.";
				else if (springState)
					message += "The travel guide for spring will be mailed to you shortly.";
				else if (winterState)
					message += "The travel guide for winter will be mailed to you shortly.";
				else if (fallState)
					message += "The travel guide for fall will be mailed to you shortly.";
			} else if (selected == 0) {
				message += "Please return and check at least one box.";
			}

			JOptionPane.showMessageDialog(null, message);
		}
	}

	// Main application method
	public static void main(String args[]) {
		CheckBoxTest application = new CheckBoxTest();
	}

}
