import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Richard Nader 
 * Class for decoding and parsing parsed array lists into Press Ready messages.
 */
public class Decoder {

	// Store data arrays
	private ArrayList<String> rawDataArray;
	private ArrayList<String> countriesArray;
	private ArrayList<String> eventsArray;

	// Output array
	private ArrayList<PressReadyMessage> pressReadyMessages;

	// Constructor
	public Decoder(ArrayList<String> rawDataArray, ArrayList<String> countriesArray, ArrayList<String> eventsArray) {
		this.rawDataArray = rawDataArray;
		this.countriesArray = countriesArray;
		this.eventsArray = eventsArray;

		pressReadyMessages = new ArrayList<>();

		decode();
	}

	// Method for decoding
	private void decode() {
		// 0 1 2 3 4 5
		// [dateTime] [countryCode] [gender] [eventCode] [description]
		// [significantEvent]
		for (String raw : rawDataArray) {

			// Split apart array and decode parts using various methods
			String[] splitStringData = raw.split(",");

			pressReadyMessages
					.add(new PressReadyMessage(getDateTime(splitStringData[0]), getCountryFromCode(splitStringData[1]),
							getEventFromCode(splitStringData[3]), getGenderFromCode(splitStringData[2]),
							splitStringData[4], getSigEventFromCode(splitStringData[5])));
		}

	}

	// Method gets event name from code
	private String getEventFromCode(String code) {
		for (String eventRow : eventsArray) {
			String[] splitString = eventRow.split(" - ");

			if (splitString[0].equalsIgnoreCase(code))
				return splitString[1];
		}
		return "N/F";
	}

	// Method gets country name from code
	private String getCountryFromCode(String code) {
		for (String countryRow : countriesArray) {
			String[] splitString = countryRow.split(" ");

			if (splitString[0].equalsIgnoreCase(code) && splitString.length <= 2) {
				return splitString[1];
			} else {
				if (splitString[0].equalsIgnoreCase(code)) {
					String out = new String();

					for (int i = 1; i < splitString.length; i++) {
						out += splitString[i] + " ";
					}
					return out;
				}
			}
		}
		return "N/F";
	}

	// Method gets gender from code
	private String getGenderFromCode(String code) {
		if (code.equalsIgnoreCase("M"))
			return "Men's ";
		else if (code.equalsIgnoreCase("F"))
			return "Women's ";
		else if (code.equalsIgnoreCase("X"))
			return "(Mixed Gender) ";
		else
			return "";
	}

	// Method for parsing significant event codes
	private String getSigEventFromCode(String code) {
		int eventsInStrings = (code.length() + 1) / 2;

		switch (eventsInStrings) {
		case 1:
			return getSigString(code);
		case 2:
			return getSigString(code.substring(0, 1) + " & " + getSigString(code.substring(2, 3)));
		case 3:
			return getSigString(code.substring(0, 1) + " & "
					+ getSigString(code.substring(2, 3) + " & " + getSigString(code.substring(4, 5))));
		case 4:
			return getSigString(code.substring(0, 1) + " & " + getSigString(code.substring(2, 3) + " & "
					+ getSigString(code.substring(4, 5)) + " & " + getSigString(code.substring(6, 7))));
		default:
			return "";
		}

	}

	// Method to decode sig events
	private String getSigString(String code) {
		if (code.equalsIgnoreCase("OR"))
			return "Olympic Record";
		else if (code.equalsIgnoreCase("MG"))
			return "Gold Medal";
		else if (code.equalsIgnoreCase("WR"))
			return "World Record";
		else if (code.equalsIgnoreCase("MS"))
			return "Silver Medal";
		else if (code.equalsIgnoreCase("MB"))
			return "Bronze Medal";
		else
			return "";
	}

	// Method for parsing datetime
	private String getDateTime(String dateTimeRaw) {
		// Cut raw data
		String date = dateTimeRaw.substring(0, 10);
		String time = dateTimeRaw.substring(11, 16);

		// Make date obj with raw data.
		Date dateObj;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm");
		try {
			dateObj = format.parse(date + time);
		} catch (ParseException e) {
			e.printStackTrace();
			return "null";
		}

		// Convert to final date format
		SimpleDateFormat finalFormat = new SimpleDateFormat("dd MMM yyyy hh:mm aa");

		return finalFormat.format(dateObj);

	}

	// Getter for output array
	public ArrayList<PressReadyMessage> getPressReadyMessages() {
		return pressReadyMessages;
	}

}
