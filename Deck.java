
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Deck {
	private List<Card> deck = new ArrayList<Card>();
	private List<Card> deck2 = new ArrayList<Card>();
	private Scanner in = new Scanner(System.in);

	public Deck() {
		//fillDeck();
		//shuffle();
	}

	public void fillDeck() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				deck.add(new Card(i, j));
			}
		}
	}

	public void draw(Player player, int num) {
		for (int i = 0; i < num; i++) {
			if (deck.size() != 0) {
				player.draw(deck.get(0));
				deck.remove(0);
			}
		}
	}

	public void discard(Card card) {
		deck.add(card);
	}

	public void print() {
		System.out.println("Deck 1");
		if (deck.size() == 0) {
			System.out.println("Your deck is empty");
		}
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i).toString());
		}
		if (deck.size() == 0) {
			System.out.println("Your deck2 is empty");
		} else {
			System.out.println("Deck 2");
		}
		for (int i = 0; i < deck2.size(); i++) {
			System.out.println(deck2.get(i).toString());
		}
	}

	public void split() {
		// System.out.println("Deck split");
		for (int i = (int) (deck.size() / 2) - 1; i >= 0; i--) {
			deck2.add(deck.get(i));
			deck.remove(i);
		}
	}

	public void merge() {
		// System.out.println("Decks merged");
		for (int i = deck2.size() - 1; i >= 0; i--) {
			deck.add(deck2.get(i));
			deck2.remove(i);
		}
	}

	public void shuffle() {
		// System.out.println("Decks shuffled");
		Collections.shuffle(deck);
		Collections.shuffle(deck2);
	}

	public void deal(ArrayList<Player> players) {
		while (deck.size() > 0) {
			players.get(deck.size() % 4).draw(deck.get(0));
			deck.remove(0);
		}
	}

	public String toString() {
		return deck.toString();
	}

	public int findLowest(int suit) {
		int min = 99;
		int index = 0;

		for (int i = 0; i < deck.size(); i++) {
			if (deck.get(i).getSuit() == suit && deck.get(i).getFace() < min) {
				index = i;
			}
		}
		return index;
	}

	public void add(Card card) {
		deck.add(card);
	}
	public void add(Trick trick) {
		for(int i = 0; i < trick.getTrickSize(); i++) {
			deck.add(trick.get(i));
		}
	}

	public int size() {
		return deck.size();
	}

	public Card get(int index) {
		return deck.get(index);
	}

	public void remove(int index) {
		deck.remove(index);
	}

}
