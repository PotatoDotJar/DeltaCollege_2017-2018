
// Delta College - CST 283 - Klingler                  
// This application demonstrates basic operations for an ordered linked list

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestListOrderList {
	private static final String inputFilename1 = "fractData1.txt";
	private static final String inputFilename2 = "fractData2.txt";

	public static void main(String[] args) {
		OrderedLinkedList<Rational> list1 = new OrderedLinkedList<Rational>();
		buildList(list1, inputFilename1);
		System.out.println(list1 + "\n\n");

		OrderedLinkedList<Rational> list2 = new OrderedLinkedList<Rational>();
		buildList(list2, inputFilename2);
		System.out.println(list2 + "\n\n");

		list1.mergeWith(list2);
		System.out.println(list1 + "\n\n");
	}

	// ---------------------------------------------------------------------------
	public static void buildList(OrderedLinkedList<Rational> aList, String filename) {
		int num1, den1, num2, den2;
		String slash;

		try {
			File inFileRef = new File(filename);
			Scanner inputFile = new Scanner(inFileRef);

			while (inputFile.hasNext()) {
				// Read elements of fractions from file
				num1 = inputFile.nextInt();
				slash = inputFile.next();
				den1 = inputFile.nextInt();

				num2 = inputFile.nextInt();
				slash = inputFile.next();
				den2 = inputFile.nextInt();

				// Instantiate fractions and multiply
				Rational fraction1 = new Rational(num1, den1);
				Rational fraction2 = new Rational(num2, den2);
				Rational fractionResult = fraction1.multiply(fraction2);

				// Add fractions to ordered linked list
				aList.add(fractionResult);
			}
		} catch (IOException e) {
			System.out.println("Input File Error");
		}
	}

}