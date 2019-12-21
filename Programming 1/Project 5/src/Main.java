import javax.swing.JOptionPane;
/**
 * @author Richard Nader
 * Main program class, used for user input and output.
 */
public class Main {

	public static void main(String[] args) {new Main();}

	public Main() {

		// Get the formatted input
		String message = JOptionPane.showInputDialog("Input formatted message to be encrypted:");

		// Check if the country code and criticality code is valid.
		while(!Message.isValidCountry(new Message(message))) {
			message = 
					JOptionPane.showInputDialog("Invalid Country! Please Input a valid formatted message to be encrypted:");
		}

		while(!Message.isValidCriticalityCode(new Message(message))) {
			message = 
					JOptionPane.showInputDialog("Invalid Criticality Code! Please Input a valid formatted message to be encrypted:");
		}

		// Make new object with formatted message
		Message myMessage = new Message(message);

		// Output message data to embassy
		JOptionPane.showMessageDialog(null, myMessage.toString());

		System.out.println(EncryptionEngine.convertFromEncrypted(myMessage.getEncryptedMessage()));
		
		System.exit(0);
	}

}
