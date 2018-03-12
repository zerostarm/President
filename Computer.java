
/**
 * TODO Put here a description of what this class does.
 *
 * @author Zeros. Created Mar 1, 2018.
 */
public class Computer extends Player {
	private int level = 0;

	Computer() {
		name = "Computer";
	}

	Computer(String n, int l) {
		name = "Computer " + n;
		level = l;
	}

	public void takeTurn(Trick trick, int roundnum, int suit) {
		if (has2ofClubs() == true) {
			//System.out.println("You had the starting card, the Two of Clubs, and played it.");
			trick.play(hand.get(get2ofClubs()));
		} else {
			switch (level) {
			case 1:
				level = 0;
				compEasy(trick, roundnum, suit);
				break;
			case 2:
				level = 1;
				compMed(trick, roundnum, suit);
				break;
			case 3:
				level = 2;
				compHard(trick, roundnum, suit);
				break;
			}
		}
	}

	private void compEasy(Trick trick, int roundnum, int suit) {
		while (1 == 1) {
			int rand = (int) (Math.floor(Math.random()) * (hand.size()));
			if (hand.findLowest(suit) > -1 && roundnum == 0) {
				trick.play(hand.get(hand.findLowest(suit)));
				hand.remove(hand.findLowest(suit));
				System.out.println("Comp easy case 1");
				break;
			} else if (hand.get(rand).getSuit() == suit && roundnum > 0) {
				trick.play(hand.get(rand));
				hand.remove(rand);
				System.out.println("Comp easy case 2");
				break;
			} else if (hand.get(rand).getSuit() != suit && roundnum > 0) {
				trick.play(hand.get(rand));
				hand.remove(rand);
				System.out.println("Comp easy case 3");
				break;
			}
		}
	}

	private void compMed(Trick trick, int roundnum, int suit) {
		if (roundnum == 0) {

		}
	}

	private void compHard(Trick trick, int roundnum, int suit) {

	}

	public Card[] passHand() {
		int crd1;
		int crd2;
		Card[] cards;
		switch (level) {
		case 1:
			crd1 = (int) (Math.random() * (hand.size() - 1));
			crd2 = (int) (Math.random() * (hand.size() - 1));

			cards = new Card[2];

			cards[0] = hand.get(Math2.max(crd1, crd2));
			cards[1] = hand.get(Math2.min(crd1, crd2));

			hand.remove(Math2.max(crd1, crd2));
			hand.remove(Math2.min(crd1, crd2));

			return cards;
		case 2:
			crd1 = (int) (Math.random() * (hand.size() - 1));
			crd2 = (int) (Math.random() * (hand.size() - 1));

			cards = new Card[2];

			cards[0] = hand.get(Math2.max(crd1, crd2));
			cards[1] = hand.get(Math2.min(crd1, crd2));

			hand.remove(Math2.max(crd1, crd2));
			hand.remove(Math2.min(crd1, crd2));

			return cards;
		case 3:
		}
		Card[] temp = { hand.get(0), hand.get(1) };
		return temp;
	}
}
