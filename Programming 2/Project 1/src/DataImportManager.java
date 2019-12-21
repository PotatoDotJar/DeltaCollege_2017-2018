import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * DataImportManager class for holding and handling the BST
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class DataImportManager {

	public static String FILE_PATH = "travelers.txt";

	// Hold file path for later use
	private String filePath;

	// Data Importing Objects
	private File file;
	private BufferedReader reader;

	// Main BST object
	BinarySearchTree<Traveler> binarySearchTree = new BinarySearchTree<>();

	// Main constructor
	public DataImportManager() {
		this.filePath = FILE_PATH;

		processFile(); // Process file
	}

	// Method to import data line by line into a BST
	private void processFile() {
		String line = "";
		int lineNum = 0;
		try {
			file = new File(filePath); // L1oad file

			reader = new BufferedReader(new FileReader(file)); // Load buffered reader

			// Process through whole data file
			while ((line = reader.readLine()) != null) {
				lineNum++;

				String[] splitLine = line.split(","); // Split line into parts using comma delimiter

				Traveler nTraveler = getTravelerFromStringArray(splitLine); // Get Traveler obj using private method

				binarySearchTree.add(nTraveler); // Add traveler to search tree
			}

			System.out.println("Loaded " + lineNum + " records into memory.");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error loading file!\n" + e.getStackTrace());
			System.exit(0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading line " + lineNum + "!\n" + e.getStackTrace());
			System.exit(0);
		}
	}

	// Private method for processing String arrays into Traveler objects
	private Traveler getTravelerFromStringArray(String[] splitArray) {
		
		String firstName 	= splitArray[0];
		String lastName 	= splitArray[1];
		String address 		= splitArray[2];
		String city = splitArray[3];
		String state = splitArray[4];
		int zipCode = Integer.parseInt(splitArray[5]);
		String phone = splitArray[6];
		String email = splitArray[7];
		int riskLevel = Integer.parseInt(splitArray[8]);
		
		return new Traveler(firstName, lastName, address, city, state, zipCode,
				phone, email, riskLevel);
	}

	// ----- Getters and Setters -----
	public BinarySearchTree<Traveler> getBinarySearchTree() {
		return binarySearchTree;
	}

}
