import java.util.Scanner;

public class ScannerInput {

	public static void main(String[] args) {
		int anInteger;
		double aDouble;
		String aString;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please Enter an integer:");
		anInteger = in.nextInt();
		System.out.println("You entered an integer " + anInteger + "\n");
		
		System.out.println("Please Enter an double:");
		aDouble = in.nextDouble();
		System.out.println("You entered a double " + aDouble + "\n");
		
		System.out.println("Please Enter a String:");
		aString = in.next();
		System.out.println("You entered a String " + aString + "\n");
	}

}
