
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
		System.out.println("Your cards are:");
		for (int i = 0; i < hand.size(); i++) {
			System.out.println("The hand index is: " + i + "\nThe card is: " + hand.get(i));
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
		System.out.println("Your cards are:");
		for (int i = 0; i < hand.size(); i++) {
			System.out.println("The hand index is: " + i + "\nThe card is: " + hand.get(i));
		}
		System.out.println("Please choose which cards to give away (by hand index)");
		int crd1 = scan.nextInt();
		int crd2 = scan.nextInt();

		Card[] cards = new Card[2];

		cards[0] = hand.get(crd1);
		cards[1] = hand.get(crd2);

		hand.remove(crd1);
		hand.remove(crd2);

		return cards;
	}

	public String toString() {
		return name;
	}

	public int countPoints() {
		int hearts =0;
		for(int i =0; i< wonTricks.size(); i++) {
			if(wonTricks.get(i).getSuit() == 1) {
				points +=1;
			}
			if(wonTricks.get(i).getSuit() == 0 && )
		}
	}

}
