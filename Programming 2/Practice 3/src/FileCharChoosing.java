
// Delta College - CST 283 - Klingler
// This application reads a file of namesand allows a user to pick a
// character from a name of their choice.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileCharChoosing {

	static int numNames, nameReq, charReq;

	public static void main(String args[]) {
		try {
			String fileNameString = JOptionPane.showInputDialog(null, "Enter Filename");

			try {
				numNames = Integer.parseInt(JOptionPane.showInputDialog(null, "How many total names?"));
				nameReq = Integer.parseInt(JOptionPane.showInputDialog(null, "Which name do you want?"));
				charReq = Integer.parseInt(JOptionPane.showInputDialog(null, "What letter of this name do you want?"));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error! Input must be a number!");
				System.err.println("Parse exception error!");
				System.exit(0);
			}

			// Dynamically allocate array
			String[] customers = new String[numNames];

			// Read file into array
			File fileIn = new File(fileNameString);
			Scanner inputFile;
			try {
				inputFile = new Scanner(fileIn);

				int i = 0;
				while (inputFile.hasNext()) {
					customers[i] = inputFile.next();
					i++;
				}
				inputFile.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error finding file!");
				System.err.println("Error importing file!");
				System.exit(0);

			}

			// Select requested name and then requested character
			String nameChoice = customers[nameReq];
			char charChoice = nameChoice.charAt(charReq);

			// Output results
			JOptionPane.showMessageDialog(null, "Your character is: " + charChoice);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An error has occured!\n" + e.getMessage());
		}

		System.exit(0);
	}
}
