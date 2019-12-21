import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Class representation of a large hexadecimal string with various methods to
 * manipulate it
 * 
 * @author Richard Nader Jr.
 */
public class BigHex {

	// Store the list
	private LinkedList<HexChar> hexList;

	// Constructor using data from a specified filename/path
	public BigHex(String fileName) {

		hexList = new LinkedList<>();

		File file = new File(fileName);

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			int lineNum = 0;
			while ((line = br.readLine()) != null) {
				lineNum++;

				// Check if in string is larger than 1 char
				if (line.length() > 1) {
					JOptionPane.showMessageDialog(null, "Error on line " + lineNum);
					System.exit(0);
				}

				hexList.add(new HexChar(line.charAt(0)));
			}

			br.close(); // Close reader
			System.out.println("Loaded file \"" + fileName + "\" with " + lineNum + " lines.");

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error! \nFile " + fileName + " not found!");
			System.exit(0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading file!\n" + e.getMessage());
			System.exit(0);
		}
	}

	// Constructor with no data
	public BigHex() {
		hexList = new LinkedList<>();
	}

	// Copy constructor
	public BigHex(BigHex orig) {
		this.hexList = orig.hexList;
	}

	// Method to increment BigHex number
	public void increment() {
		Node<HexChar> start = this.hexList.getFirst();
		for (int i = 0; i < this.hexList.getCount(); i++) {
			start.value.increment();
			start = start.next;

		}
	}

	// Method to decrement BigHex number
	public void decrement() {
		Node<HexChar> start = this.hexList.getFirst();
		for (int i = 0; i < this.hexList.getCount(); i++) {
			start.value.decrement();
			start = start.next;
		}
	}

	// Method to perform an AND operation on this value and
	// a passed value
	public BigHex and(BigHex bigHex) {

		BigHex temp1 = new BigHex(this);
		BigHex temp2 = new BigHex(bigHex);

		BigHex newBigHex = new BigHex();

		if (this.hexList.getCount() > bigHex.hexList.getCount()) {
			System.out.println("Hex 1 is larger");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = temp2.getList().getFirst();

			for (int i = 0; i < bigHex.hexList.getCount(); i++) {
				if (two.next == null) {
					two.next = new Node<HexChar>(new HexChar('0'));
				}

				newBigHex.hexList.add(one.value.and(two.value));
				one = one.next;
				two = two.next;
			}

		} else if (temp1.hexList.getCount() < bigHex.hexList.getCount()) {

			System.out.println("Hex 2 is larger");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = bigHex.getList().getFirst();

			for (int i = 0; i < bigHex.hexList.getCount(); i++) {
				if (one.next == null) {
					one.next = new Node<HexChar>(new HexChar('0'));
				}

				newBigHex.hexList.add(one.value.and(two.value));
				one = one.next;
				two = two.next;
			}

		} else {

			System.out.println("Equal lists");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = bigHex.getList().getFirst();

			for (int i = 0; i < temp1.hexList.getCount(); i++) {
				newBigHex.hexList.add(one.value.and(two.value));
				one = one.next;
				two = two.next;
			}
		}

		return newBigHex;
	}

	// Method to perform an OR operation on this value and
	// a passed value
	public BigHex or(BigHex bigHex) {
		BigHex newBigHex = new BigHex();

		BigHex temp1 = new BigHex(this);
		BigHex temp2 = new BigHex(bigHex);

		if (temp1.hexList.getCount() > bigHex.hexList.getCount()) {
			System.out.println("Hex 1 is larger");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = bigHex.getList().getFirst();

			for (int i = 0; i < bigHex.hexList.getCount(); i++) {
				if (two.next == null) {
					two.next = new Node<HexChar>(new HexChar('0'));
				}

				newBigHex.hexList.add(one.value.or(two.value));
				one = one.next;
				two = two.next;
			}

		} else if (temp1.hexList.getCount() < bigHex.hexList.getCount()) {

			System.out.println("Hex 2 is larger");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = bigHex.getList().getFirst();

			for (int i = 0; i < bigHex.hexList.getCount(); i++) {
				if (one.next == null) {
					one.next = new Node<HexChar>(new HexChar('0'));
				}

				newBigHex.hexList.add(one.value.or(two.value));
				one = one.next;
				two = two.next;
			}

		} else {

			System.out.println("Equal lists");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = bigHex.getList().getFirst();

			for (int i = 0; i < temp1.hexList.getCount(); i++) {
				newBigHex.hexList.add(one.value.or(two.value));
				one = one.next;
				two = two.next;

			}

		}

		return newBigHex;
	}

	// Method to perform an XOR operation on this value and
	// a passed value
	public BigHex xor(BigHex bigHex) {
		BigHex newBigHex = new BigHex();

		BigHex temp1 = new BigHex(this);
		BigHex temp2 = new BigHex(bigHex);

		if (temp1.hexList.getCount() > temp2.hexList.getCount()) {
			System.out.println("Hex 1 is larger");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = temp2.getList().getFirst();

			for (int i = 0; i < temp2.hexList.getCount(); i++) {
				if (two.next == null) {
					two.next = new Node<HexChar>(new HexChar('0'));
				}

				newBigHex.hexList.add(one.value.xor(two.value));
				one = one.next;
				two = two.next;
			}

		} else if (temp1.hexList.getCount() < temp2.hexList.getCount()) {

			System.out.println("Hex 2 is larger");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = temp2.getList().getFirst();

			for (int i = 0; i < temp2.hexList.getCount(); i++) {
				if (one.next == null) {
					one.next = new Node<HexChar>(new HexChar('0'));
				}

				newBigHex.hexList.add(one.value.xor(two.value));
				one = one.next;
				two = two.next;
			}

		} else {

			System.out.println("Equal lists");
			Node<HexChar> one = temp1.getList().getFirst();
			Node<HexChar> two = temp2.getList().getFirst();

			for (int i = 0; i < temp1.hexList.getCount(); i++) {
				newBigHex.hexList.add(one.value.xor(two.value));
				one = one.next;
				two = two.next;
			}
		}

		return newBigHex;
	}

	// Get hex list object
	public LinkedList<HexChar> getList() {
		return hexList;
	}

	// Method to return a string representation of the BigHex
	@Override
	public String toString() {
		String out = "First 100 hex values: \n";

		Node<HexChar> start = hexList.getFirst();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				out += start.value;
				start = start.next;
			}
			out += "\n";
		}

		return out;
	}

}
