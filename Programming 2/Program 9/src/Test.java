/**
 * Driver class for as an example
 * 
 * @author Richard Nader Jr.
 */
public class Test {

	public static void main(String[] args) {
		BigHex hex1 = new BigHex("hex1.txt");

		BigHex hex2 = new BigHex("hex2.txt");

		hex1.increment();
		BigHex hex3 = hex1.and(hex2);
		hex2 = hex1.xor(hex3);
		hex2.decrement();
		hex1 = hex3.or(hex2);
		System.out.println(hex1);
		System.out.println(hex2);
		System.out.println(hex3);

	}

}
