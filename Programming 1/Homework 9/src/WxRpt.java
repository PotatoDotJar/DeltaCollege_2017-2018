// Delta College - CST 183 - Klingler  
// Weather reporting input form

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WxRpt extends JFrame 
{
	private JTextField outputField,visField;
	private JLabel visLabel,skyLabel;
	private ButtonGroup radioGroup;
	private JComboBox skyList;
	private JButton goButton;

	String outSky,visString,aircraftIcing = new String("");

	String skyCover[] = {"Clear","Scattered","Broken","Overcast"};
	private JCheckBox chckbxAircraftIcing;

	public WxRpt()
	{
		Container theContainer = getContentPane();
		theContainer.setLayout( new FlowLayout() );

		outSky = new String("Clear");
		visString = new String("");

		// Text field for visibility 
		visLabel = new JLabel( "Visibility" );
		theContainer.add( visLabel ); 
		visField = new JTextField( 8 );
		theContainer.add( visField ); 

		// Make altitude drop-down list
		skyLabel = new JLabel( "Sky cover" );
		theContainer.add( skyLabel ); 
		skyList = new JComboBox( skyCover );
		theContainer.add( skyList );

		// Button to submit info
		goButton = new JButton("Submit");;

		chckbxAircraftIcing = new JCheckBox("Aircraft Icing Has Occurred");
		getContentPane().add(chckbxAircraftIcing);
		theContainer.add( goButton ); 

		// Output text field
		outputField = new JTextField( 15 );
		outputField.setEditable( false );
		theContainer.add( outputField ); 

		// Add event handlers
		ListHandler skyListHandler = new ListHandler();
		skyList.addItemListener( skyListHandler );   

		GoButtonHandler buttonHandler = new GoButtonHandler();
		goButton.addActionListener( buttonHandler );

		AircraftIcingHandler aircraftIcingHandler = new AircraftIcingHandler();
		chckbxAircraftIcing.addActionListener( aircraftIcingHandler );

		// Set application attributes
		setSize( 220, 200 );
		setVisible( true );
		setTitle( "Sky Cover Analysis" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	// Handler for a change in the sky cover list
	private class ListHandler implements ItemListener 
	{
		public void itemStateChanged( ItemEvent e )
		{
			if ( e.getSource() == skyList ) 
				outSky = skyCover[skyList.getSelectedIndex()];
		}
	}

	// Handler for a  button  click
	private class GoButtonHandler implements ActionListener 
	{
		public void actionPerformed( ActionEvent e )
		{
			if ( e.getSource() == goButton ) 
			{
				visString = new String(visField.getText());
				outputField.setText("Visibility: " + visString + "  Sky cover: " + outSky + " " + aircraftIcing);

			}
		}
	}

	// Handler for a  check  click
	private class AircraftIcingHandler implements ActionListener 
	{
		public void actionPerformed( ActionEvent e )
		{
			if ( e.getSource() == chckbxAircraftIcing ) 
			{
				if(chckbxAircraftIcing.isSelected())
					aircraftIcing = new String("\nICING");
				else
					aircraftIcing = new String("");

			}
		}
	}

	// Launch main application object
	public static void main( String args[] )
	{
		WxRpt app = new WxRpt();
	}

}
