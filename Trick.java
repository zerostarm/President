
/**
 * Write a description of class Trick here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Trick
{
    // instance variables - replace the example below with your own
    public int trump = 4;//The value 4 signifies that there is no trump suit yet
    private ArrayList<Card> trick = new ArrayList<Card>(4);
    
    public Trick() {}

    public void play(Card card)
    {
        if(trick.size()==0){
            trump = card.getSuit();
        }
        trick.add(card);
    }
    
    public ArrayList<Card> getTrick() {
        return trick;
    }
    
    public int getTrickSize() {
        return trick.size();
    }
    
    public int highCard() {
        int temp = 0;
        int tempVal = 0;
        for(int i = 0; i<4; i++) {
            if(trick.get(i).getFace()>tempVal) {tempVal = trick.get(i).getFace(); temp = i;}
        }
        return temp;
    }
}