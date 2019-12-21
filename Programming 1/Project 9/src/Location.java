import java.text.DecimalFormat;
import java.util.Comparator;


/**
 * @author Richard Nader
 * Class to handle storage of locations based on zip codes.
 */
public class Location implements Comparator<Location>, Comparable<Location> {
	
	// Home Base Location
	public final static Location HOME_BASE = new Location(48640, -83.99430, 43.55660, "MI", "University Center");
	
	// Limit constants
	public final static int MIN_ZIPCODE = 10000;
	public final static int MAX_ZIPCODE = 99999;
	
	// Variables
	private int zipCode;
	private Double longitude;
	private Double latitude;
	private String state;
	private String postOfficeName;
	
	// Main constructor
	public Location(int zipCode, Double longitude, Double latitude, String state, String postOfficeName) {
		this.zipCode = zipCode;
		this.longitude = longitude;
		this.latitude = latitude;
		this.state = state;
		this.postOfficeName = postOfficeName;
	}
	
	// Constructor for making a copy
	public Location(Location original) {
		this.zipCode = original.zipCode;
		this.longitude = original.longitude;
		this.latitude = original.latitude;
		this.state = original.state;
		this.postOfficeName = original.postOfficeName;
	}
	
	public double distanceToBase() {
		double theta = this.longitude - HOME_BASE.longitude;
		double dist = Math.sin(deg2rad(this.latitude)) * Math.sin(deg2rad(HOME_BASE.latitude)) + Math.cos(deg2rad(this.latitude)) * Math.cos(deg2rad(HOME_BASE.latitude)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		return (dist);
	}
	
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
	

	// -------------------------------------------- Getters --------------------------------------------
	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the postOfficeName
	 */
	public String getPostOfficeName() {
		return postOfficeName;
	}

	@Override
	public int compareTo(Location location) {
		int zipcode = ((Location)location).getZipCode();
        return this.getZipCode() - zipcode;
	}

	@Override
	public String toString() {
		return "Longitude: " + longitude + "\n" +
				"Latitude: " + latitude + "\n" +
				"Post office name: " + postOfficeName + "\n" +
				"State: " + state + "\n" +
				"Zip Code: " + zipCode + "\n" +
				"Distace from home base: " + new DecimalFormat("0.00").format(distanceToBase()) + " Miles";
		
	}

	@Override
	public int compare(Location o1, Location o2) {
		return o1.getZipCode() - o2.getZipCode();
	}
	
	
	
}
