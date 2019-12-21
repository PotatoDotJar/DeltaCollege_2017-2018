
// Delta College - CST 283 - Klingler
// This application is a test driver for the Matrix class.

public class MatrixDriver {
	public static void main(String[] args) {
		Matrix matrix1 = new Matrix();
		System.out.println(matrix1.toString());

		Matrix matrix2 = new Matrix("matrix1.txt", 4, 4);
		System.out.println(matrix2.toString());

		Matrix matrix3 = new Matrix("matrix2.txt", 4, 4);
		System.out.println(matrix3.toString());

		Matrix matrix4 = matrix2.multiply(matrix3);
		System.out.println(matrix4.toString());

		Matrix matrix5 = matrix2.subtract(matrix3);
		System.out.println(matrix5.toString());

		System.exit(0);
	}
}
