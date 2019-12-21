import java.util.Scanner;

public class ValidNumber {

	public static void main(String[] args) {
		int input;

		// Instantiate scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		// Prompt for and read user input
		System.out.print("Enter number: ");
		input = keyboard.nextInt();

		// Validate that the number is 3, 7, or 11 only
		
		while(input != 3 && input != 7 && input != 11) {
			System.out.print("Enter number: ");
			input = keyboard.nextInt();
		}

		// Output
		System.out.println("The number you entered was: " + input);

		System.exit( 0 );

	}

}
