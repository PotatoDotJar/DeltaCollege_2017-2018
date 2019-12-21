// Delta College - CST 183 - Klingler
// This program parses out a line of integers into positive evens (with zero), 
// positive odds, and negatives

public class IntAnalysis 
{
    public static void main(String args[]) 
    {
        // Contains required array of integers
        int intList[] = {6,3,8,-3,12,-1,-17,-9,15,2,7,18,0,-5,4};
        
        System.out.println("Evens: ");
        for(int i : intList) {
        	if(i % 2 == 0) {
        		System.out.print(i + " ");
        	}
        }
        System.out.println();

        System.out.println("Odds: ");
        for(int i : intList) {
        	if(i % 2 != 0) {
        		System.out.print(i + " ");
        	}
        }
        System.out.println();
        
        System.out.println("Negatives: ");
        for(int i : intList) {
        	if(i * -1 > 0) {
        		System.out.print(i + " ");
        	}
        }
        System.out.println();
        

        System.exit(0);
    }
}