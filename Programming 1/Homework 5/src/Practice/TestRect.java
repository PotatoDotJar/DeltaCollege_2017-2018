package Practice;

//This program demonstrates various features of the Rectangle class

public class TestRect {
	public static void main(String[] args) {

		// Create a Rectangle object, passing 5.0 and
		// 15.0 as arguments to the constructor.
		Rectangle box1 = new Rectangle(5.0, 15.0);
		Cube cube1 = new Cube(5, 2, 4);

		// Display the dimensions box 1.
		System.out.println("The box 1 length is " + box1.getLength());
		System.out.println("The box 1 width is "  + box1.getWidth());

		// Display the area box 1.
		System.out.println("The box 1 area is " + box1.getArea());

		// Display the perimeter box 1.
		System.out.println("The box 1 perimeter is " + box1.getPerimeter());

		// Display the diagonal length box 1.
		System.out.println("The box 1 diagonal length is " + box1.getDiagonalLength());


		// Display the dimensions cube 1.
		System.out.println("The cube 1 length is " + cube1.getLength());
		System.out.println("The cube 1 width is "  + cube1.getWidth());
		System.out.println("The cube 1 breadth is "  + cube1.getBreadth());

		// Display the surface area cube 1.
		System.out.println("The cube 1 surface area is " + cube1.getSfcArea());

		// Display the volume of cube 1.
		System.out.println("The cube 1 volume is " + cube1.calcVolume());
	}
}