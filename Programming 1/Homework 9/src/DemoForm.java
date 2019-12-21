// Delta College - CST 183 - Klingler  
// The application provides an example of using multiple event listeners for
// Java GUI components.  It also demonstrates three distinct patterns for
// implementing the listeners

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoForm extends JFrame implements ActionListener
{
	// Application Class Attributes

	// GUI Components
	private JLabel nameLabel;        // Label for "Name"
	private JTextField textIn;       // Name text field
	private JLabel  sizeLabel;       // Label for "Size"
	private JComboBox sizeChoice;    // Size choice drop-down list
	private JLabel  colorLable;       // Label for "Color"
	private JComboBox colorChoice;    // Color choice drop-down list
	private JCheckBox rushBox;       // Check box for rush order status
	private JButton goButton;        // Button to transmit order

	// Application data
	private String name;             // Name for current order   
	private String size;             // Size for current order
	private String color;             // Color for current order
	private boolean rush;            // Yes/no status for rush order
	private String rushMsg;          // Message to accompany rush order

	// Size alternatives
	String sizeList[] = {"S","M","L","XL","XXL"};

	// Color alternatives
	String colorList[] = {"White","Red","Blue"};

	// Application frame class constructor
	public DemoForm()
	{
		// Set up application window for GUI
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );

		// Construct nametext field and label
		nameLabel = new JLabel("Name");
		c.add( nameLabel );
		textIn = new JTextField( 20 );
		c.add( textIn );

		// Construct size drop down list and label
		sizeLabel = new JLabel("Size");
		c.add( sizeLabel );
		sizeChoice = new JComboBox( sizeList );
		c.add( sizeChoice );      
		SizeChoiceHandler sizeHandlerObject = new SizeChoiceHandler();
		sizeChoice.addItemListener( sizeHandlerObject );   
		size = new String(sizeList[0]);               // Let default size be first in list

		// Construct size drop down list and label
		colorLable = new JLabel("Color");
		c.add( colorLable );
		colorChoice = new JComboBox( colorList );
		c.add( colorChoice );      
		ColorChoiceHandler colorHandlerObject = new ColorChoiceHandler();
		colorChoice.addItemListener( colorHandlerObject );   
		color = new String(colorList[0]);               // Let default color be first in list



		// Construct rush order check box
		// Anoymous inner class defines event handling for checkbox
		rushBox = new JCheckBox("Rush Order");
		rushBox.addItemListener (
				new ItemListener() 
				{
					public void itemStateChanged( ItemEvent e )
					{
						if (e.getStateChange() == ItemEvent.SELECTED)  // If checked
						{
							rush = true;                            // rush order status TRUE
							rushMsg = "Yes";     
						}
						else
						{
							rush = false;                           // otherwise FALSE
							rushMsg = "No";     
						}
					}
				}
				);                    
		c.add( rushBox );
		rush = false;                   // Let default be NOT a rush order
		rushMsg = "No";     

		// Construct "go" button to transmit order
		goButton = new JButton("Submit Order");
		goButton.addActionListener( this );   
		c.add( goButton );

		// Set window attributes
		setSize( 320, 140 );
		setVisible( true );      
		setTitle( "Shirt Order Form" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}  // end application constructor

	// Required method for handling order submission button click
	public void actionPerformed( ActionEvent e )
	{
		name = textIn.getText();      // Grab name stored in text field at button click

		if(name.equals("") || name.equals(null)) {
			JOptionPane.showMessageDialog(rootPane, "Invalid Name");
		} else {

			// Display details of order that would be transmitted for processing 
			JOptionPane.showMessageDialog
			(  null, "Name: " + name + "\n" + 
					"Size: " + size + "\n" +
					"Color: " + color + "\n" +
					"Rush order: " + rushMsg, 
					"Order to be processed ...",
					JOptionPane.INFORMATION_MESSAGE );
		}
	}

	// Inner class for handling changes to size drop-down list
	private class SizeChoiceHandler implements ItemListener 
	{
		public void itemStateChanged( ItemEvent e )
		{
			size = (String) sizeChoice.getSelectedItem();
		}
	}

	// Inner class for handling changes to color drop-down list
	private class ColorChoiceHandler implements ItemListener 
	{
		public void itemStateChanged( ItemEvent e )
		{
			color = (String) colorChoice.getSelectedItem();
		}
	} 

	// MAIN method to launch application and enable exit at application window closing
	public static void main( String args[] )
	{ 
		DemoForm app = new DemoForm();
	}

}  // End application

