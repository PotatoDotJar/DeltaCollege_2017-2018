package examples;

/**
* Delta College - CST 283 - Klingler 
* This class drives an interface that displays a drawing panel and a set of
* radio buttons that allow the user to select shapes. The selected shapes are
* drawn on the drawing panel at the position of a mouse click.
*/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GraphicsWindow extends JFrame {
	// Declare an array of radio button components
	private JRadioButton[] shapeChoices;
	private ButtonGroup buttonSet;

	// The following titles array contains the titles of the radio buttons
	private String[] titles = { "Rectangle", "Filled Rectangle", "Circle", "Filled Circle" };

	// The following will reference a panel to contain the radio buttons
	private JPanel buttonPanel;

	// The following will reference an instance of the DrawingPanel class.
	// This will be a panel to draw on.
	private DrawingPanel drawingPanel;

	// Constructor
	public GraphicsWindow() {
		// Build the radio button panel.
		buildButtonPanel();

		// Create the drawing panel.
		drawingPanel = new DrawingPanel(shapeChoices);

		// Add the radio button panel to the west region
		// and the drawing panel to the center region (i.e. the remaining area)
		add(buttonPanel, BorderLayout.WEST);
		add(drawingPanel, BorderLayout.CENTER);
	}

	// This method instantiates the radio buttons, addes them to the panel
	// container, and then associates them with the listener.
	private void buildButtonPanel() {
		// Create the panel.
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(titles.length, 1));

		// Create the radio button array.
		shapeChoices = new JRadioButton[titles.length];

		// Create the radio buttons, associate them as a group, and add
		// them to the panel.
		buttonSet = new ButtonGroup();
		for (int i = 0; i < shapeChoices.length; i++) {
			shapeChoices[i] = new JRadioButton(titles[i]);
			buttonSet.add(shapeChoices[i]);
			buttonPanel.add(shapeChoices[i]);
			shapeChoices[i].addItemListener(new RadioButtonListener());
		}
	}

	// A private inner class to respond to changes in the state of the
	// radio buttons. If a button changes is made, alert the drawing panel
	// allowing it to update the current shape in focus.
	private class RadioButtonListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			for (int i = 0; i < shapeChoices.length; i++)
				if (shapeChoices[i].isSelected())
					drawingPanel.setShapeIndex(i);
		}
	}

	// Driver method
	public static void main(String args[]) {
		// Instantiate drawing panel
		GraphicsWindow application = new GraphicsWindow();

		// Set application attributes
		application.setSize(800, 600);
		application.setVisible(true);
		application.setTitle("Drawing");
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}