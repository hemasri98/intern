
/**
 * Write a description of class Url here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Url
{
    
    public void callUrl()
    {
        //FileResource fr = new FileResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String s : ur.lines()) {
            System.out.println(s); 
         }
    }
    public void testing() {
        callUrl();
    }
}
