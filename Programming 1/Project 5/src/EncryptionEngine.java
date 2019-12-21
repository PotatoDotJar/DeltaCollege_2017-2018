import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * @author Richard Nader
 * Class for handling the string encryption 
 * and decryption using a specified key file.
 */
public class EncryptionEngine {

	// Path to encryptionKeyFile
	public static String encryptionKeyFilePath = "encryptionKey.txt";
	Scanner encryptionKeyFileIn = null;

	// [0] == normal key, [1] == what the normal key is translated to.
	static String[] keys = new String[2];

	public EncryptionEngine() {
		// Encryption Key File Reading
		try {
			File encryptionKeyFile = new File(encryptionKeyFilePath);
			encryptionKeyFileIn = new Scanner(encryptionKeyFile);
		} catch (FileNotFoundException e) {
			System.err.println("Encryption Engine: Error Reading Encryption Key File!");
			e.printStackTrace();
			System.exit(0);
		}

		for(int line = 0; line < 3 && encryptionKeyFileIn.hasNextLine(); line++) {
			keys[line] = encryptionKeyFileIn.nextLine();
		}

		// System.out.println("Encryption Engine: Initialized Successfully");

	}

	// Method to encrypt a string using the loaded file key.
	public static String convertFromMessage(String message) {
		String newMessage = "";

		message = new StringBuilder(message).reverse().toString();

		// Swap every other character
		StringBuilder organizedString = new StringBuilder();
		char[] chars = message.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (i % 2 == 0)
			{
				if((i+1) < chars.length )
				{
					organizedString.append(chars[i + 1]);
				}
				organizedString.append(chars[i]);
			}
		}
		message = organizedString.toString();

		// Loop through message
		for(int i = 0; i < message.length(); i++) {
			char currentChar = message.charAt(i);
			// If current char is a space then replace it with an underscore
			if(currentChar == ' ') {
				newMessage += "_";
				// Else continue with letter encryption
			} else {
				/* 
				 * If the current char is not on the encryption
				 * file then add it to the encrypted string
				 * else convert the char to encrypted char.
				 */
				if(keys[0].indexOf(currentChar) == -1) {
					newMessage += currentChar;
				} else {
					newMessage += keys[1].charAt(keys[0].indexOf(currentChar));
				}
			}
		}

		return newMessage;

	}
	// Method to translate a encrypted string to the original message
	// using the loaded file key.
	public static String convertFromEncrypted(String message) {
		String newMessage = "";
		// Loop through message
		for(int i = 0; i < message.length(); i++) {

			char currentChar = message.charAt(i);
			// If current char is a space then replace it with an underscore
			if(currentChar == '_') {
				newMessage += " ";
				// Else continue with letter decryption
			} else {
				/* 
				 * If the current char is not on the encryption
				 * file then add it to the decrypted string
				 * else convert the char to decrypted char.
				 */
				if(keys[1].indexOf(currentChar) == -1) {
					newMessage += currentChar;
				} else {
					newMessage += keys[0].charAt(keys[1].indexOf(currentChar));
				}
			}
		}

		// Swap every other character
		StringBuilder organizedString = new StringBuilder();
		char[] chars = newMessage.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (i % 2 == 0)
			{
				if((i+1) < chars.length )
				{
					organizedString.append(chars[i + 1]);
				}
				organizedString.append(chars[i]);
			}
		}
		
		// Reverse string
		newMessage = organizedString.reverse().toString();
		return newMessage;

	}



}
