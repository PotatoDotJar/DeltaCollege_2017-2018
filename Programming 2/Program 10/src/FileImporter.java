import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Class to handle importing arrays from specified files
 * 
 * @author Richard Nader
 */
public class FileImporter {

	// File importing objects
	private FileReader fileReader;
	private BufferedReader reader;

	private int[] data;

	// Main Constructor
	public FileImporter(String filePath) {

		try {
			fileReader = new FileReader(filePath);
			reader = new BufferedReader(fileReader);

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Can't find file \"" + filePath + "\"!", "File not found",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		String line = "";
		int lineNum = 0;
		ArrayList<Integer> tempData = new ArrayList<>();
		try {
			while ((line = reader.readLine()) != null) {
				
				tempData.add(Integer.parseInt(line.trim()));
				lineNum++;
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading line " + lineNum + " from file!", "Line Read Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		data = new int[tempData.size()];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = tempData.get(i);
		}
		
	}
	
	// Getter method to return imported array of integers
	public int[] getDataArray() {
		return data;
	}

}
