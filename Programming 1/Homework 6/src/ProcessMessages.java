// Delta College - CST 183 - Klingler                          
// This program reads a file of raw text message data, reformats it,
// and writes it to an output file in preparation to send.

import java.io.*;
import java.util.Scanner; 

public class ProcessMessages
{
    public final static String INPUT_FILENAME  = "data.txt";
    
    public static void main(String[] args) throws IOException
    {
        // Prepare input file
        File inFileRef = new File(INPUT_FILENAME);
        Scanner inputFile = new Scanner(inFileRef);
        
        // Read-process-write text messages one at a time
        while (inputFile.hasNext())
        {
            String rawInput = inputFile.nextLine();
            //System.out.println(rawInput);
            
            TextData aMessage = new TextData(rawInput);         
            System.out.println(aMessage.toString() + "\n");
        }

        inputFile.close();        // Close input file
        
        System.exit(0);
    }
}