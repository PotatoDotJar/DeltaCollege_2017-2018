/**
   This class stores data about an instructor.
*/

public class Instructor
{
   private String lastName;     	// Last name   
   private String firstName;    	// First name
   private String officeNumber; 	// Office number
   private String phoneExtention;	// Phone extension

   /**
      This constructor initializes the last name,
      first name, and office number.
      @param lname The instructor's last name.
      @param fname The instructor's first name.
      @param office The office number.
   */

   public Instructor(String lname, String fname,
                     String office, String phoneExt)
   {
      lastName = lname;
      firstName = fname;
      officeNumber = office;
      phoneExtention = phoneExt;
   }

   /**
      The copy constructor initializes the object
      as a copy of another Instructor object.
      @param object2 The object to copy.
   */
   
   public Instructor(Instructor object2)
   {
      lastName = object2.lastName;
      firstName = object2.firstName;
      officeNumber = object2.officeNumber;
      phoneExtention = object2.phoneExtention;
   }

   /**
      The set method sets a value for each field.
      @param lname The instructor's last name.
      @param fname The instructor's first name.
      @param office The office number.
      @param phoneExt The phone extension.
   */
   
   public void set(String lname, String fname,
                   String office, String phoneExt)
   {
      lastName = lname;
      firstName = fname;
      officeNumber = office;
      phoneExtention = phoneExt;
   }
   
   /**
      toString method
      @return A string containing the instructor
              information.
   */

   public String toString()
   {
      // Create a string representing the object.
      String str = "Last Name: " + lastName +
                   "\nFirst Name: " + firstName +
                   "\nOffice Number: " + officeNumber +
                   "\nPhone Extention: " + phoneExtention;

      // Return the string.
      return str;
   }
}