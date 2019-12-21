
/**
   This program demonstrates the recursive factorial method.
*/

import javax.swing.JOptionPane;

public class RecurseMethods {
	public static void main(String[] args) {
		int base = 3;
		int exponent = 4;
		JOptionPane.showMessageDialog(null, base + "^" + exponent + "=" + pow(3, 4));

		int aNumber = 123456789;
		JOptionPane.showMessageDialog(null, aNumber + " has " + numDigits(aNumber) + " digits");

		int list[] = { 55, 33, 77, 88, 22, 11, 99, 44, 22 };
		int searchTarget = 11;
		JOptionPane.showMessageDialog(null,
				searchTarget + " found at index " + searchRecurse(list, searchTarget, list.length - 1));
		searchTarget = 66;
		JOptionPane.showMessageDialog(null,
				searchTarget + " found at index " + searchRecurse(list, searchTarget, list.length - 1));
		System.exit(0);
	}

	// This method recursively raises base to the power of exp
	private static int pow(int base, int exp) {
		int answer = 1;
		for (int i = 0; i < exp; i++) {
			answer *= base;
		}

		return answer;
	}

	// This method determines the number of digits for the number passed in.
	// Pre: Parameter is integer between 1 and 1 billion
	private static int numDigits(int number) {
		int temp = number;
		int digits = 0;
		while (temp > 0) {
			temp /= 10;
			digits++;
		}
		return digits;

	}

	// This method performs a sequential search (recursively) on a list of
	// integers.
	private static int searchRecurse(int list[], int target, int index) {

		for (int i = 0; i < index; i++) {
			if (list[i] == target) {
				return i;
			}
		}
		return -1;
	}

}

/*
 * 
 * 
 * 
 * 
 * 
 * Define a method called numFactors which computes the number of factors of
 * integer n within the range 1...n.
 * 
 * 
 * 
 * Write a method that performs a linear search recursively.
 * 
 */