// Delta College - CST 183 - Klingler  
// This appication demonstrates radio buttons using
// ButtonGroup and JRadioButton.  It writes one word
// at the end of a phrase depending on the radio button
// selected at the time of a user button click

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonTest extends JFrame 
{
   private JTextField field;
   private JRadioButton good, bad, ugly, gorgeous;
   private JButton goButton;
   private ButtonGroup theButtonGroup;
   
   private boolean goodState, badState, uglyState, gorgeousState;

   // set up GUI
   public RadioButtonTest()
   {
      // Get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( new FlowLayout() );

      // Set up JTextField 
      field = new JTextField( "Enter a name here", 20 );
      container.add( field );

      // Create radio button objects
      good = new JRadioButton( "Good" );
      bad = new JRadioButton( "Bad" );
      ugly = new JRadioButton( "Ugly" );
      gorgeous = new JRadioButton("Gorgeous");
      container.add( good );     
      container.add( bad );
      container.add( ugly );
      container.add( gorgeous );
      
      // Set up radio button group and add buttons to it
      theButtonGroup = new ButtonGroup();
      theButtonGroup.add(good);
      theButtonGroup.add(bad);
      theButtonGroup.add(ugly);
      theButtonGroup.add(gorgeous);

      // Set up JButton 
      goButton = new JButton( "Evaluate" );
      container.add( goButton );

      // register listeners for radio buttons
      RadioButtonHandler theHandler = new RadioButtonHandler();
      good.addItemListener( theHandler );
      bad.addItemListener( theHandler );
      ugly.addItemListener( theHandler );
      gorgeous.addItemListener(theHandler);
      
      // register listeners for  JButton
      ButtonHandler theButtonHandler = new ButtonHandler();
      goButton.addActionListener( theButtonHandler );
      
      // Initialize radio buttons to default state
      good.setSelected( true );  // Initialize as "checked" 
      goodState = true;          // Set as default value
      badState = false;
      uglyState = false;
      gorgeousState = false;
      
      // Set window attributes
      setSize( 275, 140 );
      setVisible( true );      
      setTitle( "Radio Button Test" );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end RadioButtonTest constructor

   // Private inner class for ItemListener event handling
   private class RadioButtonHandler implements ItemListener 
   {
      // Respond to radio button events
      public void itemStateChanged( ItemEvent event )
      {
         if (good.isSelected() )    // Button for "good"
            goodState = true;
         else
            goodState = false;
               
         if (bad.isSelected() )     // Button for "bad"
            badState = true;
         else
            badState = false;
               
         if (ugly.isSelected() )     // Button for "ugly"
            uglyState = true;
         else
            uglyState = false;
         
         if (gorgeous.isSelected() )	// Button for "gorgeous"
        	 gorgeousState = true;
         else
        	 gorgeousState = false;
 
       } // end method itemStateChanged

   } // end private inner class RadioButtonHandler

   // Private inner class for ActionListener event handling
   private class ButtonHandler implements ActionListener 
   {
      // Respond to button event
      public void actionPerformed( ActionEvent event )
      { 
          // Build output message
          String message = field.getText() + " is: ";
          if (goodState)
             message += " good ";
          if (badState)
             message += " bad ";
          if (uglyState)
             message += " ugly ";
          if (gorgeousState)
              message += " gorgeous ";
          
          JOptionPane.showMessageDialog(null, message);
      }
   }
   
   // Main application method
   public static void main( String args[] )
   { 
      RadioButtonTest application = new RadioButtonTest();
   }

}

