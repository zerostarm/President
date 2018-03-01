
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Deck
{
    private List<Card> deck = new ArrayList<Card>(52);
    private List<Card> deck2 = new ArrayList<Card>(52);
    private Scanner in = new Scanner(System.in);
    public Deck() {
        fillDeck();
        shuffle();
    }

    public void fillDeck() {
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i,j));
            }
        }
    }

    public void draw(Player player, int num) {
        for(int i = 0; i < num;i++){
            if(deck.size()!=0){
                player.draw(deck.get(0));
                deck.remove(0);
            }
        }
    }

    public void discard(Card card) {
        deck.add(card);
    }

    public static void print() {
        System.out.println("Deck 1");
        if(deck.size()==0){
            System.out.println("Your deck is empty");
        }
        for(int i = 0; i < deck.size();i++) {
            System.out.println(deck.get(i).toString());
        }
        if(deck.size()==0){
            System.out.println("Your deck2 is empty");
        } else {
            System.out.println("Deck 2");
        }
        for(int i = 0; i < deck2.size();i++) {
            System.out.println(deck2.get(i).toString());
        }
    }

    public static void commandSplit() {
        System.out.println("Deck split");
        for(int i = (int)(deck.size()/2)-1; i >= 0;i--){
            deck2.add(deck.get(i));
            deck.remove(i);
        }
    }

    public static void commandMerge() {
        System.out.println("Decks merged");
        for(int i = deck2.size()-1;i>=0;i--) {
            deck.add(deck2.get(i));
            deck2.remove(i);
        }
    }

    public void shuffle() {
        System.out.println("Decks shuffled");
        Collections.shuffle(deck);
        Collections.shuffle(deck2);
    }

    public static void commandHelp() {
        System.out.println("command\t\tfunction\n");
        System.out.println("stop\t\tstop program");
        System.out.println("draw\t\tdraw cards");
        System.out.println("check\t\tsee your hand");
        System.out.println("discard\t\tdiscard your hand");
        System.out.println("print\t\tprint the deck");
        System.out.println("split\t\tput half deck one into deck two");
        System.out.println("merge\t\tput decks back together");
        System.out.println("shuffle\t\tshuffles the decks");
        System.out.println("help\t\tshow commands");
    }
}
