// Delta College - CST 183 
// This class includes a generic class that acts as the "back-end" information
// manager.  It effectively collects data that is "set" to it and then displays
// it with the 'toString()" method.

public class EvalData
{
    // --------------------------------------------------------------

    private String name;
    private String countyFrom;
    private boolean fullTime;
    private boolean cstMajor;
    private String course;
    private int courseRating;
    private int instructorRating;
    private String comments;

    // --------------------------------------------------------------
    
    // Constructors
    public EvalData()
    {
        // Allow default values
    }
    
    public EvalData(String n)
    {
        name = n;
    }

    // --------------------------------------------------------------
    
    // "Set" methods
    public void setName(String n)
    { name = n; }
    public void setCounty(String c)
    { countyFrom = c; }
    public void setCourse(String c)
    { course = c; }
    public void setCourseRating(int r)
    { courseRating = r; }
    public void setFullTimeCheck(boolean f)
    { fullTime = f; }
    public void setCStmajorCheck(boolean m)
    { cstMajor = m; }
    public void setComments(String c)
    { comments = c; }



    
    // --------------------------------------------------------------
    public String toString()
    {
        String outString = "";
        outString = "Data:"                             + "\n" + 
                    "   Student name:  " + name         + "\n" +
                    "   From county:   " + countyFrom   + "\n" +
                    "   For course:    " + course       + "\n" +
                    "   Course rating: " + courseRating + "\n";
        
        if (fullTime == true)
            outString += "   Full time" + "\n";
        if (cstMajor == true)
            outString += "   CST major" + "\n";
        outString += "   Comments: " + comments;
        
        return outString;
   }

}