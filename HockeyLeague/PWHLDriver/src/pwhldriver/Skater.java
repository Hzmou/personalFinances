/***********************************************************************
 * REVISION HISTORY (Newest First)
 *********************************************************************** 
 *
 * 08/04/2016 - Anne Applin - formatting and JavaDoc
 * 2014 - David Briggs - original starting code and comments
 ***********************************************************************/ 

package pwhldriver;

/**
 * A class to represent non-goalie position players.
 * You must
 * <ol>
 * <li> define private data members for the additional
 *    attributes that are specific to non-goalie players,
 *    essentially additional hitting statistics</li>
 * <li> define a public constructor to take values for all the
 *    inherited and local data members, which sets their
 *    data members' values to the parameter values</li>
 * <li> define public getters for the data members to be 
 *    used in calculating aggregate statistics for the the team's hitting
 *    stats</li>
 * <li> define a public toString method that produces a
 *    String in the format needed for the lookup method of  
 *    Team <br>
 *    <pre>n is a position named name and has statistics
 *    PA: k  BB: m  SO: p  H: q  AB: r  BI: s  HR: t HBP: u BA: x  OBP: y </pre>
 *    which is discussed in the program assignment. The first 4 items 
 *    come from the super class toString()</li>
 * </ol>
 *    If you do extra credits, you may need to define more methods, but
 *    all data members must be private, so only object instances can
 *    directly access them.
 * @author dbriggs
 */
public class Skater extends Player{
    // class properties go here
    
    // class implementation goes here
    
    
    
    
    
/**
     * Unit test for PositionPlayer - creates a PositionPlayer by calling 
     * the constructor and then prints it out. There is no need to comment 
     * this out!  
     * * Do NOT Change.  Leave it at the bottom of the file!
     * @param args command line args 
     */
    public static void main (String[] args){
        Player skater = new Skater(25, "Alex Carpenter", 'F', 16, 8, 10, 0
             0, 3, 5, 1, 0, 174, 291, 60, 1, 3);
        // test toString
        System.out.println((Skater)skater);
        System.out.println("Expected:");
        System.out.println("GP: 16 G: 8 A: 10 PIM: 0 PTS: 18 +/-: 0 PPG: 3 "
                           + "PPA: 5 SHG: 1 SHA: 0 Pt/G: 1.13 FOW: 174 FO: 291 "
                           + "WF%: 59.8 PIMPG: 0.00 SH: 60 SH%: 13.3 SOG: 1 SOA: "
                           + "3 SOGW: 0 SO%: 33.3\n\n");
        // test accessors for Player class
        System.out.println(skater.getName() + " is a " 
                           + skater.getPositionWord());
        System.out.println("Expected:");
        System.out.println("Alex Carpenter is a forward\n\n");
        Player p = new Skater(29, "Marie-Philip Poulin", 'F', 16, 8, 9, 8
             9, 0, 1, 0, 0, 212, 370, 50, 1, 6);
        System.out.println((Skater)p);
        System.out.println("Expected:");
        System.out.println("GP: 16 G: 8 A: 9 PIM: 8 PTS: 17 +/-: 9 PPG: 0 "
                           + "PPA: 1 SHG: 0 SHA: 0 Pt/G: 1.06 FOW: 212 FO: 370 "
                           + "WF%: 57.3 PIMPG: 0.50 SH: 50 SH%: 16.0 SOG: 1 SOA: "
                           + "6 SOGW: 0 SO%: 16.7\n\n");
    }
}