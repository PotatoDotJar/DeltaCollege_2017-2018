/**
 * @author Richard Nader
 * Class for handling the message DAO and error checking
 */
public class Message {

	// Main variable declarations
	private String message;
	private String country;
	private int criticalityCode;

	EncryptionEngine encryptionEngine = new EncryptionEngine();



	// Main constructor
	public Message(String rawMessage) {
		String[] incommingMessage = rawMessage.toUpperCase().split(",");
		this.country = incommingMessage[0].substring(0, 2);
		this.criticalityCode = Integer.parseInt(incommingMessage[0].substring(2,3));
		this.message = incommingMessage[1];


	}

	// Translates the encrypted message
	public String getEncryptedMessage() {
		return EncryptionEngine.convertFromMessage(getMessage());
	}

	// Basic check for valid country code
	public static boolean isValidCountry(Message message) {
		if(		message.getCountry().equals("FR") || 
				message.getCountry().equals("CA") || 
				message.getCountry().equals("RU") ||
				message.getCountry().equals("AU") ||
				message.getCountry().equals("GB") ||
				message.getCountry().equals("JA") ||
				message.getCountry().equals("GE") ||
				message.getCountry().equals("MX")) {
			return true;
		}
		return false;
	}

	// Basic check for valid Criticality Code
	public static boolean isValidCriticalityCode(Message message) {
		if(message.getCriticalityCode() >= 1 && message.getCriticalityCode() <= 3) {
			return true;
		}
		return false;
	}

	// Get string version of the Criticality Codes
	public static String getCriticalityCodeString(Message message) {
		if(Message.isValidCriticalityCode(message)) {
			if(message.getCriticalityCode() == 1) {
				return "URGENT";
			}
			else if(message.getCriticalityCode() == 2) {
				return "IMPORTANT";
			}
			else if(message.getCriticalityCode() == 3) {
				return "ROUTINE";
			}
		}
		return "INVALID";
	}

	// Get string version of the Country Codes
	public static String getCountryCodeString(Message message) {
		if(Message.isValidCountry(message)) {
			if(message.getCountry().equals("FR")) {
				return "France";
			}
			else if(message.getCountry().equals("CA")) {
				return "Canada";
			}
			else if(message.getCountry().equals("RU")) {
				return "Russia";
			}
			else if(message.getCountry().equals("AU")) {
				return "Australia";
			}
			else if(message.getCountry().equals("GB")) {
				return "Great Britain";
			}
			else if(message.getCountry().equals("JA")) {
				return "Japan";
			}
			else if(message.getCountry().equals("GE")) {
				return "Germany";
			}
			else if(message.getCountry().equals("MX")) {
				return "Mexico";
			}
		}
		return "INVALID";
	}
	
	@Override
	public String toString() {

		return "To Embassy: " + getCountryCodeString(this) + "|" + getCriticalityCodeString(this) +
		"|" + getEncryptedMessage();
	}
	
	// To change all the data (Just like the constructor)
	public void setRawMessage(String rawMessage) {
		String[] incommingMessage = rawMessage.toUpperCase().split(",");
		this.country = incommingMessage[0].substring(0, 2);
		this.criticalityCode = Integer.parseInt(incommingMessage[0].substring(2,3));
		this.message = incommingMessage[1];
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the criticalityCode
	 */
	public int getCriticalityCode() {
		return criticalityCode;
	}

	/**
	 * @param criticalityCode the criticalityCode to set
	 */
	public void setCriticalityCode(int criticalityCode) {
		this.criticalityCode = criticalityCode;
	}



}
