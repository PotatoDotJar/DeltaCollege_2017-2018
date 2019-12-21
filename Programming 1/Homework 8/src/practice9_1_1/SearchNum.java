package practice9_1_1;
//Delta College - CST 183 - Klingler  
//This application searchs a list of four-digit numbers (acquired from a file)
//for a match with user input

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner; 
import java.io.*;  

public class SearchNum extends JFrame 
{
// GUI components
private JTextField searchTargetText; 
private JLabel targetLabel;
private JButton searchButton;

private int numberData[];
private int listSize;

private final int MAX_ARRAY_SIZE = 5000;
private final String INPUT_FILENAME = "numbers.txt";

// set up GUI
public SearchNum() throws IOException
{
   // Access frame container and set to flowlayout
   Container frameContainer = getContentPane();
   frameContainer.setLayout( new FlowLayout() );
   
   // Initialize label & text field objects
   targetLabel = new JLabel("Target Number");
   searchTargetText = new JTextField( 8 );
  
   // Add commponents to GUI
   frameContainer.add( targetLabel );
   frameContainer.add( searchTargetText );
   
   // Initialize button and its label
   searchButton = new JButton("Search");
   frameContainer.add( searchButton );      

   // Register event handler for button
   ButtonHandler handler = new ButtonHandler();
   searchButton.addActionListener( handler );

   // Set application window attributes
   setTitle( "Number Search" );
   setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   setSize( 350, 200 );
   setVisible( true );
   
   // Build number list array
   buildNumberList();
} 

// Private inner class for event handling
private class ButtonHandler implements ActionListener 
{

   // Process button click
   public void actionPerformed( ActionEvent event )
   {
      // If user clicks button, grab text currently stored
      // in text field and display it in a dialog
      if ( event.getSource() == searchButton )
      {
         // Capture search target and store as int
         int targetNum = Integer.parseInt(searchTargetText.getText());
         int searchReturn = binarySearch(targetNum);
         
         // Display results of search
         if (searchReturn >= 0)
            JOptionPane.showMessageDialog( null, "Number Found" );
         else
            JOptionPane.showMessageDialog( null, "Number NOT Found" );        }
   } 
} 


    // --------------------------------------------------------
 // Constructor - build list from file
 public void buildNumberList() throws IOException
 {
     numberData =  new int[MAX_ARRAY_SIZE];
     
     // --------------------------------------------------------
     // INPUT FILE PROCESSING
     File inFileRef = new File(INPUT_FILENAME);
     Scanner inputFile = new Scanner(inFileRef);

     int i = 0;
     while (inputFile.hasNext())
     {
         // Read all data on one line
         numberData[i]    = inputFile.nextInt();
         i++;
     }
     listSize = i;    // Capture number of elements
     
     // Sort array
     sortArray(numberData);
     
     /*
     for(int j = 0; j < listSize; j++) {
    	 System.out.println(numberData[j]);
     }
     */
     
 }

    /**
  * The sequentialSearch method searches an array for a value.
  *
  * @param array The array to search.
  * @param value The value to search for.
  * @param numElems Number of valid array elements (numElems <= array.length)
  * @return The subscript of the value if found in the array, otherwise -1.
  */
 /*
  public int sequentialSearch(int value) 
 {
     int index;        
     int element;      
     boolean found;  

     index = 0;       
     element = -1;     
     found = false;   

     while (!found && index < listSize) 
     {
         if (numberData[index] == value) 
         {
             found = true;          
             element = index;      
         }
         index++;               
     }

     return element;
 }
  */
 
 /**
 * The binarySearch method searches an array for a value.
 *
 * @param value The value to search for.
 * @return The subscript of the value if found in the array, otherwise -1.
 */
 public int binarySearch(int value) 
 {
     int first;
     int last;
     int middle;
     int position;
     boolean found;
     
     first = 0;
     last = listSize - 1;
     position = -1;
     found = false;
     
     while(!found && first <= last) {
    	 middle = (first + last) / 2;
    	 
    	 if(numberData[middle] == value) {
    		 found = true;
    		 position = middle;
    	 }
    	 else if(numberData[middle] > value) {
    		 last = middle - 1;
    	 }
    	 else {
    		 first = middle + 1;
    	 }
     }
     
     if(found) {
    	 return position;
     }
     else {
    	 return -1;
     }
     
 }
 
 /**
 * The sortArray method sorts an array in an accending order.
 *
 * @param array The array to sort.
 */
 public void sortArray(int[] array) {
	 int startScan, index, minIndex, minValue;
	 
	 for(startScan = 0; startScan < (listSize-1); startScan++) {
		 minIndex = startScan;
		 minValue = array[startScan];
		 for(index = startScan + 1; index < listSize; index++) {
			 if(array[index] < minValue) {
				 minValue = array[index];
				 minIndex = index;
			 }
		 }
		 
		 array[minIndex] = array[startScan];
		 array[startScan] = minValue;
	 }
	 
 }
 

// Main method - to launch application
public static void main( String args[] ) throws IOException
{ 
   SearchNum application = new SearchNum();
}

} 