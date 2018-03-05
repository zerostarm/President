
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

	
	public static void main(String[] args) {
		System.out.println("This is a game of Hearts you can play with 4 players");
		System.out.println("How many players should be human?");
		int playnum = scan.nextInt();
		while(playnum>4||playnum<0){
		    playnum = scan.nextInt();
		}
		scan.nextLine();
		for(int i = 0;i<4;i++){
		    if(i<playnum){
		    System.out.println("What is player "+(i+1)+"'s name?");
		    String temp = scan.nextLine();
		    players.add(new Player(deck, temp));
		  } else {
		    players.add(playnum, new Computer(deck, ""+(4-i)));
		  }
		}
		System.out.println((4-playnum)+" Computers added");
		for(int i = 0;i<players.size();i++){
		   System.out.println(players.get(i).toString()); 
		  }
	}

}
