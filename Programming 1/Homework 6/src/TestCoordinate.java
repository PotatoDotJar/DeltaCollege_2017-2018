/**
 * This program demonstrates use of the Coordinate class
*/

public class TestCoordinate
{
   public static void main(String[] args)
   {
      // Create a Coordinate object
      Coordinate aPoint = new Coordinate();

      // Set the x and y positions of the coordinate
      aPoint.setX(10.0);
      aPoint.setY(20.0);
      
      // Display the coordinate and the distance from the origin
      System.out.println(aPoint.toString() + " | Distance from origin: " + aPoint.distFromOrigin());
      
   }
}