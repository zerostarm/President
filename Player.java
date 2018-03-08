
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Player {
	public Deck deck;
	public Deck hand = new Deck();
	public Deck wonTricks = new Deck();
	public int points = 0;

	public String name;
	private Scanner scan = new Scanner(System.in);

	Player() {
		name = "null";
	}

	Player(String n) {
		name = n;
	}

	public void draw(Card card) {
		hand.add(card);
	}

	private void organizeHand() {

	}

	public void discard(Deck deck, int num) {
		for (int i = 0; i < num; i++) {
			if (hand.size() != 0) {
				deck.discard(hand.get(0));
				hand.remove(0);
			}
		}
	}

	public void takeTrick(Trick trick) {
		wonTricks.add(trick);
	}

	public String showHand() {
		String temp = "";
		for (int i = 0; i < hand.size(); i++) {
			temp += hand.get(i).toString() + "\n";
		}
		return temp;
	}

	public void takeTurn(Trick trick) {
		System.out.println("It is " + name + "'s turn");
		System.out.println("      Index         Card");
		for (int i = 0; i < hand.size(); i++) {
			System.out.println("\t" + i + "\t " + hand.get(i));
		}
		System.out.println("The cards in the Trick so far are:\n " + trick);

		System.out.println("Please choose which card to play");

		int crd = 0;
		do {
			crd = scan.nextInt();
		} while (crd > hand.size() || crd < 0);

		Card card = hand.get(crd);
		hand.remove(crd);

		trick.play(card);
	}

	public Card[] passHand() {
		System.out.println("It is " + name + "'s turn to pass");
		System.out.println("      Index         Card");
		for (int i = 0; i < hand.size(); i++) {
			System.out.println("\t" + i + "\t " + hand.get(i));
		}
		System.out.println("Please choose which cards to give away (by hand index)");
		int crd1 = scan.nextInt();
		int crd2 = scan.nextInt();

		Card[] cards = new Card[2];

		cards[0] = hand.get(Math2.max(crd1, crd2));
		cards[1] = hand.get(Math2.min(crd1, crd2));

		hand.remove(Math2.max(crd1, crd2));
		hand.remove(Math2.min(crd1, crd2));

		return cards;
	}

	public String toString() {
		return name;
	}

	public int countPoints() {
		int hearts = 0;
		for (int i = 0; i < wonTricks.size(); i++) {
			if (wonTricks.get(i).getSuit() == 1) {
				points += 1;
			}
			if (wonTricks.get(i).getSuit() == 0 && wonTricks.get(i).getFace() == 11) {
				points += 25;
			}
		}

		return points;
	}

	public boolean has2ofClubs() {
		boolean temp = false;

		for (int i = 0; i < hand.size(); i++) {
			temp = hand.get(i).getFace() == 3 && hand.get(i).getSuit() == 11;
		}
		return temp;
	}
}
