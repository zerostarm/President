
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Player {
    public Deck deck;
    private List<Card> hand = new ArrayList<Card>();
    private List<Card> tricks = new ArrayList<Card>();
    public String name;
    private Scanner scan = new Scanner(System.in);

    Player() {
        name = "null";
    }

    Player(String n) {
        name = n;
    }

    public void draw(Card card) {
        hand.add(hand.size() - 1, card);
    }

    public void discard(Deck deck, int num) {
        for (int i = 0; i < num; i++) {
            if (hand.size() != 0) {
                deck.discard(hand.get(0));
                hand.remove(0);
            }
        }
    }

    public String showHand() {
        String temp = "";
        for (int i = 0; i < hand.size(); i++) {
            temp += hand.get(i).toString() + "\n";
        }
        return temp;
    }

    public void takeTurn(List<Card> trick) {
    	System.out.println("It is " + name + "'s turn");
    	System.out.println("Your cards are:");
    	for(int i = 0; i<hand.size(); i++) {
    		System.out.println("The hand index is: " + i + "\nThe card is: "+hand.get(i));
    	}
    	System.out.println("Please choose which cards to give away");
    	int crd1 = scan.nextInt();
    	
    }

    public String toString() {
        return name;
    }
}
