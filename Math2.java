
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
    public static int max(int a, int b) {
        if(a>b){return a;} else {return b;}
    }
    public static double max(double a, double b) {
        if(a>b){return a;} else {return b;}
    }
    public static int min(int a, int b) {
        if(a<b){return a;} else {return b;}
    }
    public static double min(double a, double b) {
        if(a<b){return a;} else {return b;}
    }
    public static int getInt(int min, int max, Scanner in) {
        int temp = min - 1;
        boolean firstOffense = true;
        while(temp >= min && temp <= max) {
            temp = in.nextInt(); 
            if(firstOffense){System.out.println("Not an appropriate number");}
            firstOffense = false;
        }
        return temp;
    }
}
