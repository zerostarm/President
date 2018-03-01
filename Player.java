
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Player
{
    private List<Card> hand = new ArrayList<Card>();
    private String name;
    public Player() {name = "null";}
    public Player(String n) {name = n;}
    public void draw(Card card) {
        hand.add(card);
    }
    public void discard(Deck deck, int num) {
        for(int i = 0; i < num;i++){
            if(hand.size()!=0){
                deck.discard(hand.get(0));
                hand.remove(0);
            }
        }
    }
    public String showHand() {
        String temp = "";
        for(int i = 0;i<hand.size();i++){
            temp += hand.get(i).toString()+"\n";
        }
        return temp;
    }
}
