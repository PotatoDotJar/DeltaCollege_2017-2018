import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Manager for importing data
 * 
 * @author Richard Nader
 */
public class DataManager {

	private final static String fileName = "players.txt";

	// For reading data from file
	private FileReader file;
	private BufferedReader fileIn;

	// For holding player data
	private ArrayList<Player> playerList;

	// Main constructor
	public DataManager() {
		playerList = new ArrayList<>();

		// Init buffered readers and file reader
		try {
			file = new FileReader(fileName);
			fileIn = new BufferedReader(file);

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error loading file!\n" + e.getStackTrace());
			System.exit(0);
		}

		// Load player objects
		loadPlayers();

	}

	// Method to parse player data into player objects
	private void loadPlayers() {
		Player player = null;
		String line = "";
		int lineNum = 0;
		try {

			while ((line = fileIn.readLine()) != null) {

				String[] parsedData = line.split(" +");

				lineNum++;
				if (parsedData[0].trim().equals("F")) {
					String name = parsedData[1].trim();
					double height = Double.parseDouble(parsedData[2].trim());
					double weight = Double.parseDouble(parsedData[3].trim());
					double gpa = Double.parseDouble(parsedData[4].trim());
					double dashTime = Double.parseDouble(parsedData[5].trim());

					player = new FootBallPlayer(name, height, weight, gpa, dashTime);

				} else if (parsedData[0].trim().equals("V")) {
					String name = parsedData[1].trim();
					double height = Double.parseDouble(parsedData[2].trim());
					double weight = Double.parseDouble(parsedData[3].trim());
					double gpa = Double.parseDouble(parsedData[4].trim());
					int serviceAces = Integer.parseInt(parsedData[5].trim());
					int killsPerGame = Integer.parseInt(parsedData[6].trim());

					player = new VolleyballPlayer(name, height, weight, gpa, serviceAces, killsPerGame);

				} else if (parsedData[0].trim().equals("H")) {
					String name = parsedData[1].trim();
					double height = Double.parseDouble(parsedData[2].trim());
					double weight = Double.parseDouble(parsedData[3].trim());
					double gpa = Double.parseDouble(parsedData[4].trim());
					int goalsPerSeason = Integer.parseInt(parsedData[5].trim());
					double penaltyMinutesPerSeason = Double.parseDouble(parsedData[6].trim());
					int plusMinusNumber = Integer.parseInt(parsedData[7].trim());

					player = new HockeyPlayer(name, height, weight, gpa, goalsPerSeason, penaltyMinutesPerSeason,
							plusMinusNumber);
				} else {
					JOptionPane.showMessageDialog(null, "Error: Player type not found on line " + lineNum);
					System.exit(0);
				}

				playerList.add(player);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading file!\n" + e.getStackTrace());
			System.exit(0);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error parsing number on line " + lineNum + "!\n" + e.getMessage());
			System.exit(0);
		}
	}

	/**
	 * @return the playerList
	 */
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	/**
	 * @return the qualified list of players
	 */
	public ArrayList<Player> getQualifiedPlayerList() {
		ArrayList<Player> qualified = new ArrayList<>();

		for (Player player : getPlayerList()) {
			if (player.isCandidate()) {
				qualified.add(player);
			}
		}
		return qualified;
	}

}
