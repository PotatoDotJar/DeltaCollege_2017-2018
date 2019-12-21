import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Richard Nader
 * Class to parse files and trigger the decoder on parsed array lists.
 */
public class FileParser {

	// Define file locations
	private static String rawFeed = "rawfeed.txt";
	private static String countries = "countries.txt";
	private static String events = "events.txt";

	// Files
	private File inRawFile;
	private File inCountries;
	private File inEvents;

	// Streams
	private Scanner rawFeedScnr;
	private Scanner countriesScnr;
	private Scanner eventsScnr;

	// Data arrays
	private ArrayList<String> rawDataArray;
	private ArrayList<String> countriesArray;
	private ArrayList<String> eventsArray;

	// Decoder object
	private Decoder decoder;

	public FileParser() {

		// Initialize data arrays.
		rawDataArray = new ArrayList<>();
		countriesArray = new ArrayList<>();
		eventsArray = new ArrayList<>();

		// Initialize files.
		inRawFile = new File(rawFeed);
		inCountries = new File(countries);
		inEvents = new File(events);

		// Check if files exist.
		if (!inRawFile.exists() || !inCountries.exists() || !inEvents.exists()) {
			System.err.println("ERROR! Missing files!");
			System.exit(0);
		}

		// Create scanner objects.
		try {
			rawFeedScnr = new Scanner(inRawFile);
			countriesScnr = new Scanner(inCountries);
			eventsScnr = new Scanner(inEvents);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR! Problem importing files!");
			e.printStackTrace();
			cleanUpScanners();
		}

		// Populate raw data array
		while (rawFeedScnr.hasNextLine()) {
			rawDataArray.add(rawFeedScnr.nextLine());
		}
		// Populate countries array
		while (countriesScnr.hasNextLine()) {
			countriesArray.add(countriesScnr.nextLine());
		}
		// Populate events array
		while (eventsScnr.hasNextLine()) {
			eventsArray.add(eventsScnr.nextLine());
		}
		cleanUpScanners();

		decoder = new Decoder(rawDataArray, countriesArray, eventsArray);
	}

	// Getters for data

	public ArrayList<String> getRawDataArray() {
		return rawDataArray;
	}

	public ArrayList<String> getCountriesArray() {
		return countriesArray;
	}

	public ArrayList<String> getEventsArray() {
		return eventsArray;
	}

	public ArrayList<PressReadyMessage> getPressReadyMessages() {
		return decoder.getPressReadyMessages();
	}

	// Method for closing scanner streams.
	private void cleanUpScanners() {
		rawFeedScnr.close();
		countriesScnr.close();
		eventsScnr.close();
	}

}
