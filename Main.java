
/**
 * TODO Put here a description of what this class does.
 *
 * @author Stephen Armstrong and Ryan Druffel
 *         Created Mar 1, 2018.
 */
import java.util.*;

public class Main {
	private static Deck deck = new Deck();
	private static Scanner scan = new Scanner(System.in);
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static int[] points = { 0, 0, 0, 0 };

	public static void main(String[] args) {
		// Introductory phrases
		System.out.println("This is a game of Hearts you can play with 4 players");
		System.out.println("How many players should be human?");
		// Sets the players and computers for the game
		setPlayers();
		// Game execution
		for (int i = 0; i < 4; i++) {
			System.out.println("Round " + (i + 1));
			playRound(i);
		}
	}

	public static void playRound(int roundNum) {
		dealHand();
		passHand(roundNum);
		int strt = 0;
		boolean heartsBroken = false;
		for (int i = 0; i < 4; i++) {
			if (players.get(i).has2ofClubs()) {
				strt = i;
			}
		}
		for (int i = 0; i < 13; i++) {
			strt = playTrick(strt, i);
		}
		assignPoints();
		deck = new Deck();
		deck.shuffle();
	}

	public static void dealHand() {
		System.out.println("Hands have been dealt");
		deck.fillDeck();
		deck.shuffle();
		for (int i = 0; i < 52; i++) {
			players.get(i % 4).draw(deck.get(0));
			deck.remove(0);
		}
	}

	public static void assignPoints() {
		for (int i = 0; i < 4; i++) {
			int temp = players.get(i).countPoints();
			if (temp == 26) {
				System.out.println(players.get(i).toString() + " shot the moon!");
				for (int j = 0; j < 4; j++) {
					if (i != j) {
						points[j] += temp;
					}
					;
				}
			} else {
				points[i] += temp;
			}
		}
		for (int i = 0; i < 4; i++) {
			System.out.println(players.get(i).toString() + " has a total of " + points[i] + " points");
		}
	}

	public static void setPlayers() {
		int playnum = scan.nextInt();
		while (playnum > 4 || playnum < 0) {
			playnum = scan.nextInt();
		}
		scan.nextLine();
		for (int i = 0; i < 4; i++) {
			if (i < playnum) {
				System.out.println("What is player " + (i + 1) + "'s name?");
				String temp = scan.nextLine();
				players.add(new Player(temp));
			} else {
				players.add(playnum, new Computer("" + (4 - i), 0));
			}
		}
		System.out.println((4 - playnum) + " Computers added");
		/*
		 * This is testing for me to check the creation of the players for(int i =
		 * 0;i<players.size();i++){ System.out.println(players.get(i).toString()); }
		 */
	}

	public static int playTrick(int startingPlayer, int roundnum) {
		Trick trick = new Trick();
		for (int i = 0; i < 4; i++) {
			if (players.get((startingPlayer + i) % 4) instanceof Computer) { //Checks if Computer
				players.get((startingPlayer + i) % 4).takeTurn(trick, roundnum, trick.getTrump());
			}
			else { //Does this if Player
				players.get((startingPlayer + i) % 4).takeTurn(trick);
			}
		}
		int temp = trick.highCard();
		players.get((startingPlayer + temp) % 4).takeTrick(trick);
		System.out.println("The trick was: "+trick.toString());
		System.out.println("Player " + players.get((startingPlayer + temp) % 4).toString() + " took the trick");
		return (startingPlayer + temp) % 4;
	}

	public static void passHand(int roundNum) {
		if (roundNum != 3) {
			System.out.println("Cards will now be passed");
			Card[][] passingHands = new Card[4][2];
			for (int i = 0; i < 4; i++) {
				passingHands[i] = players.get(i).passHand();
			}
			for (int i = 0; i < 4; i++) {
				players.get(i).draw(passingHands[passDir(roundNum, i)][0]);
				players.get(i).draw(passingHands[passDir(roundNum, i)][1]);
			}
		} else {
			System.out.println("No cards will be passed this round");
		}
	}

	public static int passDir(int roundNum, int player) {
		if (roundNum == 0) {
			if (player == 0) {
				return 3;
			} else {
				return player - 1;
			}
		} else if (roundNum == 1) {
			if (player == 3) {
				return 0;
			} else {
				return player + 1;
			}
		} else {
			if (player == 0) {
				return 2;
			} else if (player == 2) {
				return 0;
			} else if (player == 3) {
				return 1;
			} else {
				return 3;
			}
		}
	}
}
