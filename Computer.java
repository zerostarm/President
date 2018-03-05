
/**
 * TODO Put here a description of what this class does.
 *
 * @author Zeros.
 *         Created Mar 1, 2018.
 */
public class Computer extends Player{
	
	Computer(Deck deck1){
		name = "Computer"; 
		deck = deck1;
	}
	Computer(Deck deck1, String n) {
		name = n;
		deck = deck1;
	}
}
