import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Class to manage importing data into arrays and parsing data into respectable
 * lists.
 * 
 * @author Richard Nader
 */
public class DataManager {

	private CountyList countyList;
	private AlertList alertList;

	// Raw imported String Arrays
	private String[] rawAlerts;
	private String[] rawCounties;
	private String[] rawPopulation;
	private String[] warningList;
	private String[] securityWarningsList;
	// Keep track of array sizes
	private int rawAlertsSize;
	private int rawCountiesSize;
	private int rawPopulationSize;
	private int warningListSize;
	private int securityWarningsListSize;

	// FileReader objects
	private FileReader alertsFile;
	private FileReader countiesFile;
	private FileReader countyPopFile;
	private FileReader warningsFile;

	// Buffered Readers for files
	private BufferedReader alertsReader;
	private BufferedReader countiesReader;
	private BufferedReader countyPopReader;
	private BufferedReader warningReader;

	// Main constructor
	public DataManager() {
		// init arrays
		rawAlerts = new String[20000];
		rawCounties = new String[20000];
		rawPopulation = new String[20000];
		warningList = new String[20000];
		securityWarningsList = new String[1000];

		// Init file readers and buffered readers
		try {
			alertsFile = new FileReader("alerts.txt");
			countiesFile = new FileReader("fipsCounty.txt");
			countyPopFile = new FileReader("popcounty.txt");
			warningsFile = new FileReader("warningList.txt");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error loading file!\n" + e.getMessage());
			System.exit(0);
		}

		// Init Buffered Readers
		alertsReader = new BufferedReader(alertsFile);
		countiesReader = new BufferedReader(countiesFile);
		countyPopReader = new BufferedReader(countyPopFile);
		warningReader = new BufferedReader(warningsFile);

		// Load and format arrays
		loadFilesToArrays();
		cleanArrays();

		// Init obj arrays
		alertList = new AlertList();
		countyList = new CountyList();

		// Make a CountyList from imported data
		parseCounties();
		parseAlerts();

		alertList.sort();
	}

	/**
	 * Method used for loading data files to String arrays
	 */
	private void loadFilesToArrays() {
		try {
			// Load Alerts to array
			String line;
			for (int i = 0; (line = alertsReader.readLine()) != null; i++) {
				rawAlerts[i] = line;
				rawAlertsSize++;
			}
			line = "";

			// Load counties to array
			for (int i = 0; (line = countiesReader.readLine()) != null; i++) {
				rawCounties[i] = line;
				rawCountiesSize++;
			}
			line = "";

			// Load county population to array
			for (int i = 0; (line = countyPopReader.readLine()) != null; i++) {
				rawPopulation[i] = line;
				rawPopulationSize++;
			}
			line = "";

			// Load warnings to array
			for (int i = 0; (line = warningReader.readLine()) != null && !line.isEmpty(); i++) {
				if (line.contains("_")) {
					warningList[i] = line;
					warningListSize++;

				} else {
					i--;
				}
			}

			// Reset warning reader to be used again
			warningReader = new BufferedReader(warningReader);

			// Load security warnings to array
			boolean reachedSecerityPart = false;
			for (int i = 0; (line = warningReader.readLine()) != null; i++) {

				if (line.contains("NATIONAL SECURITY WARNING LEVEL INDICATORS")) {
					reachedSecerityPart = true;
					i = -1;
				} else if (reachedSecerityPart && !line.contains("-") && !line.isEmpty() && line != null) {
					securityWarningsList[i] = line;
					securityWarningsListSize++;
				} else if (line.contains("-") && reachedSecerityPart) {
					i--;
				} else {
					i--;
				}

			}

			cleanFileReaders();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading files!\n" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}

	// Cleaning file readers
	private void cleanFileReaders() throws IOException {
		alertsReader.close();
		countiesReader.close();
		countyPopReader.close();
		warningReader.close();
	}

	// Make arrays correct size
	private void cleanArrays() {
		String[] tmpAlerts = rawAlerts;
		String[] tmpCounties = rawCounties;
		String[] tmpPopulation = rawPopulation;
		String[] tmpWarningList = warningList;
		String[] tmpSecurityWarningsList = securityWarningsList;

		rawAlerts = new String[rawAlertsSize];
		rawCounties = new String[rawCountiesSize];
		rawPopulation = new String[rawPopulationSize];
		warningList = new String[warningListSize];
		securityWarningsList = new String[securityWarningsListSize];

		for (int i = 0; i < tmpAlerts.length; i++) {
			if (tmpAlerts[i] != null && !tmpAlerts[i].isEmpty())
				rawAlerts[i] = tmpAlerts[i];
		}

		for (int i = 0; i < tmpCounties.length; i++) {
			if (tmpCounties[i] != null && !tmpCounties[i].isEmpty())
				rawCounties[i] = tmpCounties[i];
		}

		for (int i = 0; i < tmpPopulation.length; i++) {
			if (tmpPopulation[i] != null && !tmpPopulation[i].isEmpty())
				rawPopulation[i] = tmpPopulation[i];
		}

		for (int i = 0; i < tmpWarningList.length; i++) {
			if (tmpWarningList[i] != null && !tmpWarningList[i].isEmpty())
				warningList[i] = tmpWarningList[i];
		}

		for (int i = 0; i < tmpSecurityWarningsList.length; i++) {
			if (tmpSecurityWarningsList[i] != null && !tmpSecurityWarningsList[i].isEmpty())
				securityWarningsList[i] = tmpSecurityWarningsList[i];
		}
	}

	/**
	 * Method to parse raw data into County objects.
	 */
	private void parseCounties() {
		System.out.println("Parsing " + rawCountiesSize + " Counties");

		for (String str : rawCounties) {
			String[] splitStr = str.split(" ");

			int fipsCode = Integer.parseInt(splitStr[0].trim());

			String countyName = "";
			for (int i = 1; i < splitStr.length; i++) {
				countyName += splitStr[i] + " ";
			}
			countyName.trim();

			countyList.add(new County(fipsCode, countyName, getPopulation(fipsCode)));

		}

		countyList.sort(true);
	}

	/**
	 * Method to parse raw data into County objects.
	 */
	private void parseAlerts() {

		for (String str : rawAlerts) {
			String[] splitStr = str.split(",");

			int fipsCode = Integer.parseInt(splitStr[0].trim());

			County county = getCountyList().getByFipsCode(fipsCode);

			alertList.add(new Alert(county, parseDate(splitStr[1]), parseDate(splitStr[2]),
					getWarningMessageByCode(splitStr[3]), getSevarity(splitStr[3])));

		}

	}

	/**
	 * Method to get the warning string from code.
	 * 
	 * @param Warning
	 *            code
	 * 
	 * @return Warning String
	 */
	public String getWarningMessageByCode(String code) {

		if (code.length() == 3) {
			String severity = "";
			if (code.charAt(0) == 'W')
				severity = "Warning";
			else if (code.charAt(0) == 'A')
				severity = "Watch";
			else if (code.charAt(0) == 'Y')
				severity = "Advisory";

			for (String str : warningList) {

				str = str.substring(1);
				String[] splitArray = str.split(" ");

				if (splitArray[0].equalsIgnoreCase(code.substring(1))) {
					String returnedString = "";
					for (int i = 1; i < splitArray.length; i++) {
						returnedString += splitArray[i] + " ";

					}
					returnedString += severity;
					return returnedString.trim();
				}
			}
		}
		else {
			String returnedString = "";
			for (String str : securityWarningsList) {
				str = str.trim().replaceAll(" +", " ");

				String[] split = str.split(" ");

				if (code.equalsIgnoreCase(split[0].trim())) {
					for (int i = 1; i < split.length; i++) {
						returnedString += split[i] + " ";
					}
					return returnedString.trim();
				}

			}
		}

		return "";
	}

	// Get severity index for sorting
	public int getSevarity(String code) {
		if (code.length() == 3) {
			if (code.charAt(0) == 'W')
				return 1;
			else if (code.charAt(0) == 'A')
				return 2;
			else if (code.charAt(0) == 'Y')
				return 3;
		}
		return 0;
	}

	/**
	 * Parses raw date string to a Date object.
	 * 
	 * @param rawDate
	 * @return Date object
	 * @throws ParseException
	 */
	public Date parseDate(String rawDate) {
		SimpleDateFormat fDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		try {
			return fDateFormat.parse(rawDate);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error parsing date!\n" + e.getMessage());
			System.exit(0);
			return null;
		}
	}

	/**
	 * Gets population for fips code.
	 * 
	 * @param fipsCode
	 *            for the county
	 * @return population int
	 */
	public int getPopulation(int fipsCode) {
		for (String str : rawPopulation) {
			String[] splitStr = str.split(",");

			if (Integer.parseInt(splitStr[0]) == fipsCode) {
				return Integer.parseInt(splitStr[1]);
			}
		}
		return -1; // If not found
	}

	/**
	 * @return the countyList
	 */
	public CountyList getCountyList() {
		return countyList;
	}

	/**
	 * @return the alertList
	 */
	public AlertList getAlertList() {
		return alertList;
	}

}
