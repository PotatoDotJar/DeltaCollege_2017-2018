/**
 * Class DAO for holding data about an airline traveler
 * 
 * Delta College - CST 283
 * 
 * @author Richard Nader
 *
 */
public class Traveler implements Comparable<Traveler> {

	// ----- Private data variables -----

	// First and last name
	private String firstName;
	private String lastName;

	// Location information
	private String address;
	private String city;
	private String state;
	private int zipCode;

	// Contact information
	private String phone;
	private String email;

	// Risk level (val of 1 to 4) 1 being highest and 4 lowest
	private int riskLevel;

	// Main constructor
	public Traveler(String firstName, String lastName, String address, String city, String state, int zipCode,
			String phone, String email, int riskLevel) {

		this.firstName = firstName;
		this.lastName = lastName;

		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;

		this.phone = phone;
		this.email = email;

		this.riskLevel = riskLevel;

	}

	// Constructor for searching
	public Traveler(String email) {
		this.email = email;
	}

	// ----- Comparison method -----
	// Method for comparing Travelers based on email
	@Override
	public int compareTo(Traveler o) {
		return this.email.compareTo(o.email);
	}

	// ----- To String method -----
	// Method for representing Travelers as a String
	@Override
	public String toString() {
		return firstName + "," + lastName + "," + phone + "," + email + "," + riskLevel;
	}

	// ----- Getters and setters -----
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(int riskLevel) {
		this.riskLevel = riskLevel;
	}

}
