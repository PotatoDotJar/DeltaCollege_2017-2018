
// Delta College - CST 183 - Klingler  
// This application draws a stoplight

import java.awt.*;
import javax.swing.*;

public class StopLight extends JPanel 
{
	public void paintComponent( Graphics g )
	{
		// Set up drawing context
		super.paintComponent( g );
		
		// Background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getSize().width, getSize().height);

		// Red Light
		g.setColor(Color.red);
		g.fillOval((getSize().width/2) - 40, (getSize().height/3) - 40, 80, 80);
		
		// Yellow Light
		g.setColor(Color.yellow);
		g.fillOval((getSize().width/2) - 40, ((getSize().height/3) - 40) * 2, 80, 80);
		
		// Green Light
		g.setColor(Color.green);
		g.fillOval((getSize().width/2) - 40, ((getSize().height/3) - 40) * 3, 80, 80);
		

	}

	public static void main( String args[] )
	{ 
		// Instantiate drawing panel
		StopLight drawPanel = new StopLight();  

		// Instantiate application object
		JFrame application = new JFrame();   

		// Add drawing panel to application
		application.add(drawPanel);                  

		// Set application attributes
		application.setSize( 300,500 );
		application.setVisible( true );
		application.setTitle( "My Stoplight" );
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
}
