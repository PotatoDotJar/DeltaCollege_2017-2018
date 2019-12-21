package Practice;

//This program prompts the user for their first name and
//generates a random greeting.

import javax.swing.JOptionPane;
import java.util.Random;      

public class GreetingMachine {
	public static void main(String[] args) {
		String name;

		// Getting name using prompt
		name = getName();

		// Display greeting
		JOptionPane.showMessageDialog(null, generateGreeting(name));

		System.exit(0);
	}

	// Opens prompt for the user's name
	public static String getName() {
		// Get the user's first name.
		return JOptionPane.showInputDialog("What is your first name? ");
	}
	
	// Generates a greeting with a specified name.
	public static String generateGreeting(String name) {
		String greeting = ""; 
		// Determine a random greeting
		Random randomNumbers = new Random();
		int greetingChoice = randomNumbers.nextInt(4);

		// Generate greeting string
		if (greetingChoice == 0)
			greeting = "Hello " + name + ", how are you?";
		else if (greetingChoice == 1)
			greeting = "Yo " + name + ", wazzup?";
		else if (greetingChoice == 2)
			greeting = name + ", how goes it dude?";
		else if (greetingChoice == 3)
			greeting = "Buenos días " + name;
		
		return greeting;
	}

}