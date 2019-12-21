import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
/**
 * @author Richard Nader
 * Class to handle importing of data from a data file containing location info
 * and sorts it into a array list. Class also includes a search and distance from
 * the main base function.
 */
public class DataHandler {

	// File system objects
	File inFileRef;
	Scanner inputFile;
	private final String DATA_FILENAME = "zipMIcity.txt";
	
	// Main data array
	private List<Location> locationDataArray;

	
	// Main constructor
	public DataHandler() {
		loadDataToArray();
	}

	// Load data to array
	private void loadDataToArray() {
		
		// Init ArrayList
		locationDataArray = new ArrayList<>();
		
		// Load Products file
		try {
			inFileRef = new File(DATA_FILENAME);
			inputFile = new Scanner(inFileRef);
		} catch (FileNotFoundException e) {
			System.out.println("Data File not found!\n" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Error: Missing Data File!\n" + e.getMessage());
			System.exit(0);
		}
		
		// Loop through scanner buffer
		@SuppressWarnings("unused")
		int row = 1;
		while(inputFile.hasNext()) {
			String[] cutData = inputFile.nextLine().split(" ");
			locationDataArray.add(new Location(Integer.parseInt(cutData[0]), Double.parseDouble(cutData[2]), Double.parseDouble(cutData[1]), cutData[3], cutData[4]));
			row++;
		}
		
		// Sort array ascending for binary sort
		sortArray(locationDataArray);
		System.out.println("Data Loaded...");
	}
	
	private void sortArray(List<Location> oldArrayList) {
		Collections.sort(oldArrayList);
	}

	// Search for Location object using zipcode
	public Location getLocationFromZipcode(int zipcode) {
		int index = Collections.binarySearch(locationDataArray, new Location(zipcode, null, null, null, null));
		if(!(index < 0))
			return locationDataArray.get(index);
		return null;
	}
	
	// ------------------------------- Error Checking -------------------------------
	public static Boolean isZipcodeValid(int zipCode) {
		if((zipCode >= Location.MIN_ZIPCODE && zipCode <= Location.MAX_ZIPCODE) && zipCode != Location.HOME_BASE.getZipCode()) {
			return true;
		}
		return false; 
	}


}
