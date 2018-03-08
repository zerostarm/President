
/**
 * Write a description of class Math2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Math2
{
    public static int randInt(int low,int high) {
        return (int) Math.round((double) ((high - low) * Math.random() + low));
    }
    public static double degToRad(double deg) {
        return (double) deg * (Math.PI/180);
    }
    public static double radToDeg(double rad) {
        return (double) rad * (180*Math.PI);
    }
}
