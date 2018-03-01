
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Player {
	public Deck deck = new Deck();
	private List<Card> hand = new ArrayList<Card>();
	public String name;

	Player() {
	}

	Player(Deck deck1) {
		name = "null";
		deck = deck1;
	}

	Player(String n, Deck deck1) {
		name = n;
		deck = deck1;
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

	}
}
