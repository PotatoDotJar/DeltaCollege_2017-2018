
/**
 * Class representation of a single Hexadecimal value.
 * 
 * @author Richard Nader Jr.
 */
public class HexChar {

	// Value as a char
	private char value;

	// Value as a int
	private int intValue;

	// Initial constructor with default 0 value
	public HexChar() {
		this.value = '0';
		this.intValue = 0;
	}

	// Initial constructor with specified char value
	public HexChar(char value) {
		this.value = value;

		this.intValue = Integer.decode("0x" + String.valueOf(value));
	}

	// Initial constructor with specified int value
	public HexChar(int intValue) {
		if (intValue >= 0 && intValue <= 15) {
			this.value = Integer.toHexString(intValue).charAt(0);
			this.intValue = intValue;
		} else {
			System.err.println("Hexadecimal int can only be between 0 - 15");
		}
	}

	// Method to increment hex value
	public void increment() {
		if (value == 'f') {
			value = '0';
			intValue = 0;
		} else if (value == '9') {
			value = 'a';
			intValue = 10;
		} else {
			value++;
			intValue++;
		}
	}

	// Method to decrement value
	public void decrement() {
		if (value == 'a') {
			value = '9';
			intValue = 9;
		} else if (value == '0') {
			value = 'f';
			intValue = 15;
		} else {
			value--;
			intValue--;
		}
	}

	// Method to perform an AND operation on this value and
	// a passed value
	public HexChar and(HexChar hexChar) {
		int c = this.getIntValue() & hexChar.getIntValue();

		return new HexChar(c);
	}

	// Method to perform an OR operation on this value and
	// a passed value
	public HexChar or(HexChar hexChar) {
		int c = this.getIntValue() | hexChar.getIntValue();

		return new HexChar(c);
	}

	// Method to perform an XOR operation on this value and
	// a passed value
	public HexChar xor(HexChar hexChar) {
		int c = this.getIntValue() ^ hexChar.getIntValue();

		return new HexChar(c);
	}

	// Method to convert hex char to binary char array
	public char[] toBinary() {
		return Integer.toBinaryString(intValue).toCharArray();
	}

	// Getters and setters for hex char value
	public char getValue() {
		return value;
	}

	public int getIntValue() {
		return intValue;
	}

	// Method to convert hex char to string
	@Override
	public String toString() {
		return String.valueOf(value);
	}

}
