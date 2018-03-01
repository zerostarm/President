
/**
 * TODO Put here a description of what this class does.
 *
 * @author Stephen Armstrong and Ryan Druffel
 *         Created Mar 1, 2018.
 */
import java.util.*;

public class Main {
	private static Deck deck = new Deck();
	private static int compnum = 0;
	private static int playnum =0;
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Player> players;
	private static ArrayList<Computer> computers;

	
	public static void main(String[] args) {
		System.out.println("This is a game of Hearts you can play with 4 players and computers");
		System.out.println("How many players and computers would you like? ");
		playnum = scan.nextInt();
		compnum = scan.nextInt();
		
		
	}

}
