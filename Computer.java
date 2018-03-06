
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

	Computer(String n) {
		name = "Computer " + n;
	}

	public void takeTurn(Trick trick) {
		switch (level) {
		case 1:
			level = 0;
			compEasy(Trick trick);
			break;
		case 2:
			level = 1;
			compMed(Trick trick);
			break;
		case 3:
			level = 2;
			compHard(Trick trick);
			break;
		}
	}

	private void compEasy(Trick trick) {
		int rand = (int) (Math.floor(Math.random()) * (hand.size()));
		trick.play(hand.get(rand));
		hand.remove(rand);
	}

	private void compMed(Trick trick) {

	}

	private void compHard(Trick trick) {

	}
}
