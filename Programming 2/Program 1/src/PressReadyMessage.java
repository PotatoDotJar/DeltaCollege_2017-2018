/**
 * @author Richard Nader 
 * Object for holding press ready messages and can be called using the toString method.
 */
public class PressReadyMessage {

	// Private variables.
	private String dateTime;
	private String country;
	private String event;
	private String gender;
	private String description;
	private String significantEvent;

	// Constructor
	public PressReadyMessage(String dataTime, String country, String event, String gender, String description,
			String significantEvent) {

		this.dateTime = dataTime;
		this.country = country;
		this.event = event;
		this.gender = gender;
		this.description = description;
		this.significantEvent = significantEvent;

	}

	// PressReadyMessage

	@Override
	public String toString() {
		return dateTime + "\n" + country + "\n" + description + "\n" + gender + event + "\n" + significantEvent;

	}

	// Getters and Setters

	public String getDateTime() {
		return dateTime;
	}

	public String getCountry() {
		return country;
	}

	public String getEvent() {
		return event;
	}

	public String getGender() {
		return gender;
	}

	public String getDescription() {
		return description;
	}

	public String getSignificantEvent() {
		return significantEvent;
	}

}
