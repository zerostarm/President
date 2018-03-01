
/**
 * TODO Put here a description of what this class does.
 *
 * @author Zeros. Created Feb 21, 2018.
 */
public class Card {
	private String FaceName = "";
	private String SuitName = "";
	private String[] faces = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
	Card(int face, int suit) {
		//System.out.println(faces.length);
		FaceName = faces[face];
		SuitName = suits[suit];
	}
	public String toString() {
		return FaceName + " of " + SuitName;
	}
	
}
