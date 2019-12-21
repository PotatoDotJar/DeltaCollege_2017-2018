// Delta College - CST 183 - Klingler
// This class searches a list of names stored in a file for a matching
// last name.

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;
         
public class NameSearch 
{
    public static final String inputFilename = "names.txt";  
    
    public static void main(String[] args) throws IOException
    {
        int commaPos;       
        String inputString, lastname;
        String targetLastName;
        String outputName = "";   // Initialize search output to blank
        
        targetLastName = JOptionPane.showInputDialog("Enter Last Name");
      
        File inFileRef = new File(inputFilename);
        Scanner inputFile = new Scanner(inFileRef);

        while (inputFile.hasNext())
        {
            inputString  = inputFile.nextLine();  // Read line of file
            
            // Parse out last name - beginning of string to comma
            commaPos = inputString.indexOf(",");
            lastname = inputString.substring(0,commaPos);
            
            // If matching last name found, overwrite blank output name
            if (lastname.equals(targetLastName)) {
            	String[] formattedName = inputString.split(" ", 3);
                outputName = formattedName[1] + " " + formattedName[2] + " " + formattedName[0].substring(0, formattedName[0].length()-1);
            }
        }
        
        // Report results of search.  If a name found, variable outputName
        // will be non-blank.
        if (!outputName.equals(""))
            JOptionPane.showMessageDialog( null, "Name Found:\n" + outputName);
        else
            JOptionPane.showMessageDialog( null, "Name NOT Found");
    }
    
 
}