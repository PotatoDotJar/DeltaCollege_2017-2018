
// This application prompts the user for a temperature in Fahrenheit.
// It then calculates and returns the equivalent Celsius temperature.

import java.util.*;
 
class FahrenhietToCelsius {
  public static void main(String[] args) {
    double temperature;
    Scanner in = new Scanner(System.in);      
 
    System.out.println("Enter temperature in Fahrenheit");
    temperature = in.nextDouble();
 
    temperature = (5 / 9) * (temperature - 32);
 
    System.out.println("Temperature in Celsius = " + temperature);
  }
}