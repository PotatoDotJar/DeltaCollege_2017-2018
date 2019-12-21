import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Richard Nader
 * Class to manage data importing and package data into an
 * array, sorting, and searching.
 */
public class DataManager {

	private static final int MAX_COUNTIES = 2000;

	File file;

	DocumentBuilderFactory dbf;
	DocumentBuilder db;
	Document miCounties;

	private County[] countyArray;

	public DataManager() {

		// Import the file and build XML parsing.
		try {
			file = new File("miCounties.txt");
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			miCounties = db.parse(file);
		} catch (ParserConfigurationException e) {
			JOptionPane.showMessageDialog(null, "Error parsing XML!\n" + e.getMessage());
			System.exit(0);
		} catch (SAXException e) {
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error opening data file!\n" + e.getMessage());
			System.exit(0);
		}

		makeArray();

	}

	// Build the array from imported data.
	private void makeArray() {
		County[] tempCountyArray = new County[MAX_COUNTIES];
		String name = "null", seat = "null", created = "null", nameorigin = "null", area = "null", population = "null",
				fipscode = "null", mapfile = "null";

		Element docElement = miCounties.getDocumentElement();

		NodeList list = docElement.getElementsByTagName("dict");

		if (list != null) {
			int length = list.getLength();

			// Loop through dict elements
			for (int i = 0; i < list.getLength(); i++) {
				// Get selected dict element
				Element node = (Element) list.item(i);
				// Create list of child data in dict list.
				NodeList data = node.getChildNodes();

				// Loop through child data and assign values to appropriate strings.
				for (int j = 1; j < data.getLength(); j += 4) {
					String text = data.item(j).getTextContent();

					if (text.equalsIgnoreCase("name")) {
						name = data.item(j + 2).getTextContent();
					} else if (text.equalsIgnoreCase("seat")) {
						seat = data.item(j + 2).getTextContent();
					} else if (text.equalsIgnoreCase("created")) {
						created = data.item(j + 2).getTextContent();
					} else if (text.equalsIgnoreCase("nameorigin")) {
						nameorigin = data.item(j + 2).getTextContent();
					} else if (text.equalsIgnoreCase("area")) {
						area = data.item(j + 2).getTextContent();
					} else if (text.equalsIgnoreCase("population")) {
						population = data.item(j + 2).getTextContent();
					} else if (text.equalsIgnoreCase("fipscode")) {
						fipscode = data.item(j + 2).getTextContent();
					} else if (text.equalsIgnoreCase("mapfile")) {
						mapfile = data.item(j + 2).getTextContent();
					}
				}

				// Add county to temp large array
				tempCountyArray[i] = new County(name, seat, created, nameorigin, area, population, fipscode, mapfile);
			}

			// Create smaller sized array with proper length
			countyArray = new County[length];

			// Move temp counties to proper sized list
			for (int x = 0; x < length; x++) {
				countyArray[x] = tempCountyArray[x];
			}

		} else {
			// If list is null
			JOptionPane.showMessageDialog(null, "Error loading Counties list!");
			System.exit(0);
		}
	}

	/**
	 * @return the imported countyArray
	 */
	public County[] getBaseCountyArray() {
		return countyArray;
	}

	// Sort array by name ascending
	public County[] getCountySortedByNameAsc() {
		Arrays.sort(countyArray, new Comparator<County>() {
			@Override
			public int compare(County o1, County o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return countyArray;
	}

	// Sort array by name descending
	public County[] getCountySortedByNameDec() {
		Arrays.sort(countyArray, new Comparator<County>() {
			@Override
			public int compare(County o1, County o2) {
				return o2.getName().compareTo(o1.getName());
			}
		});
		return countyArray;
	}

	// Sort array by population ascending
	public County[] getCountySortedByPopulationAsc() {
		Arrays.sort(countyArray, new Comparator<County>() {
			@Override
			public int compare(County o1, County o2) {
				return o1.getPopulation() - o2.getPopulation();
			}
		});
		return countyArray;
	}

	// Sort array by population descending
	public County[] getCountySortedByPopulationDec() {
		Arrays.sort(countyArray, new Comparator<County>() {
			@Override
			public int compare(County o1, County o2) {
				return o2.getPopulation() - o1.getPopulation();
			}
		});
		return countyArray;
	}

}
