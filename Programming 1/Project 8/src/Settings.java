
/**
 * @author Richard Nader
 * Class for holding game setting data.
 */
public class Settings {
	
	public static enum ContactPrefrence {
		EMAIL,
		TEXT;
	}
	public static enum Difficulty {
		BEGINNER,
		EXPERIANCED,
		ADVANCED,
		EXPERT;
	}
	public static enum GamePieceColor {
		RED,
		GREEN,
		BLUE,
		YELLOW,
		PURPLE;
	}
	
	
	private String username;
	private ContactPrefrence contactPrefrence;
	private Difficulty gameDifficulty;
	private int gameSpeed;
	private GamePieceColor gamePieceColor;
	
	
	// Constructor
	public Settings(String username, ContactPrefrence contactPrefrence, Difficulty gameDifficulty, int gameSpeed, GamePieceColor gamePieceColor) {
		this.username = username;
		this.contactPrefrence = contactPrefrence;
		this.gameDifficulty = gameDifficulty;
		this.gameSpeed = gameSpeed;
		this.gamePieceColor = gamePieceColor;
	}
	
	// Utility
	public static GamePieceColor getColorEnumFromString(String colorStr) {
		if(colorStr.equalsIgnoreCase("RED"))
			return GamePieceColor.RED;
		else if (colorStr.equalsIgnoreCase("GREEN"))
			return GamePieceColor.GREEN;
		else if (colorStr.equalsIgnoreCase("BLUE"))
			return GamePieceColor.BLUE;
		else if (colorStr.equalsIgnoreCase("YELLOW"))
			return GamePieceColor.YELLOW;
		else if (colorStr.equalsIgnoreCase("PURPLE"))
			return GamePieceColor.PURPLE;
		return GamePieceColor.RED;
	}
	
	
	// Getters and setters
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the contactPrefrence
	 */
	public ContactPrefrence getContactPrefrence() {
		return contactPrefrence;
	}
	/**
	 * @param contactPrefrence the contactPrefrence to set
	 */
	public void setContactPrefrence(ContactPrefrence contactPrefrence) {
		this.contactPrefrence = contactPrefrence;
	}
	/**
	 * @return the gameDifficulty
	 */
	public Difficulty getGameDifficulty() {
		return gameDifficulty;
	}
	/**
	 * @param gameDifficulty the gameDifficulty to set
	 */
	public void setGameDifficulty(Difficulty gameDifficulty) {
		this.gameDifficulty = gameDifficulty;
	}
	/**
	 * @return the gameSpeed
	 */
	public int getGameSpeed() {
		return gameSpeed;
	}
	/**
	 * @param gameSpeed the gameSpeed to set
	 */
	public void setGameSpeed(int gameSpeed) {
		this.gameSpeed = gameSpeed;
	}
	/**
	 * @return the gamePieceColor
	 */
	public GamePieceColor getGamePieceColor() {
		return gamePieceColor;
	}
	/**
	 * @param gamePiceColor the gamePiceColor to set
	 */
	public void setGamePieceColor(GamePieceColor gamePieceColor) {
		this.gamePieceColor = gamePieceColor;
	}


	// Override method for printing object contents.
	@Override
	public String toString() {
		return "Username: " + username + "\n" +
		"Contact Via: " + contactPrefrence + "\n" +
		"Difficulty: " + gameDifficulty + "\n" +
		"Game Speed: " + gameSpeed + "\n" +
		"Game Piece Color: " + gamePieceColor + "\n";
		
	}
	
	
	
}
