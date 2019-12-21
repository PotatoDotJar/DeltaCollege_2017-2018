import java.util.Scanner;

public class DeltaCollegeStamp {

	public static void main(String[] args) {
		
		// Variables 
		String firstName, lastName, stampMessage;
		
		// Name input
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter your first name:");
		firstName = in.nextLine();
		
		System.out.println("Please enter your last name:");
		lastName = in.nextLine();
		
		// Combining the string
		stampMessage = firstName + " " + lastName + "\n";
		stampMessage += "Delta College \n";
		stampMessage += "1961 Delta Road \n";
		stampMessage += "University Center, MI  48710";
		
		// Print message
		System.out.println(stampMessage);
		

	}

}
