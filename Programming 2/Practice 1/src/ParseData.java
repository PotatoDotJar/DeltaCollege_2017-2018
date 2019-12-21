
// Delta College - CST 283 - Klingler
// This program reads a multiple lines of coded text, parses out the coded
// data and writes the resul.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ParseData {
	public static final String filename = "rawdata.txt";

	public static void main(String[] args) {

		String aLine = new String();

		try {
			File infile;
			infile = new File(filename);

			if (!infile.exists()) {
				System.out.println("ERROR: Input File Not Found");
				System.exit(0);
			}

			// File exists and OK; instantiate Scanner object to read
			Scanner inputFileScanner = new Scanner(infile);

			// Read contents of file line-by-line and send to method to
			// be processed
			while (inputFileScanner.hasNext()) {
				aLine = inputFileScanner.nextLine();
				parseData(aLine);
			}

		} catch (IOException e) {
			System.out.println("ERROR: Input File Error");
			System.exit(0);
		}

	} // end main

	// **************************************************************************
	// This function receives a line of formatted data and extracts
	// different fields before writing the details to the console
	public static void parseData(String oneLine) {
		// System.out.println(oneLine);

		String firstName = "";
		String lastName = "";
		String phone = "";
		double fraction = 0;

		// PERFORM STRING WORK HERE

		// Create an array for split spaces
		String[] separatedData = oneLine.split(" ");

		// Parse first and last name
		String[] name = separatedData[0].split(",");
		firstName = name[0];
		lastName = name[1];

		// Parse phone number
		String rawPhoneNumber = new String(separatedData[1]);
		for (int i = 0; i < rawPhoneNumber.length(); i++) {
			char currentChar = rawPhoneNumber.charAt(i);
			if (Character.isDigit(currentChar))
				phone += String.valueOf(currentChar);
		}

		// Parse Fraction
		String[] fractionSplit = separatedData[2].split("/");
		fraction = (Double.parseDouble(fractionSplit[0]) / Double.parseDouble(fractionSplit[1]));

		System.out.println(firstName + "|" + lastName + "|" + phone + "|" + fraction + "\n\n");

	} // end printMorse

}
