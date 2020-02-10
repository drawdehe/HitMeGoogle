/**
 * 
 * @author drawde
 *
 * A game where two players battle to get the most Google hits.
 * 
 * Rules: Every round, the game randomly selects a letter. The players are supposed to find a word of at least
 * 3 letters that has the most hits on Google. After 11 rounds, the game ends. The person with the highest score wins.
 *
 */
import java.util.Random;
//import java.util.Timer;
import java.util.Scanner;

public class Game {
	private Player playerOne;
	private Player playerTwo;
	private char letter;
	private Random rand;
	private Scanner scan;
	private String alphabet;
	private int round;
	//private Timer timer;
	
	public Game(Player playerOne, Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		rand = new Random();
		scan = new Scanner(System.in);
		round = 1;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	//Might delete this method
	public void generateLetter() {
		letter = alphabet.charAt(rand.nextInt(alphabet.length()));
	}
	public char getLetter() {
		return letter;
	}
	public int getRound() {
		return round;
	}
	public Player getLeader() {
		if (playerOne.getScore() == playerTwo.getScore()) {
			return null;
		}
		if (playerOne.getScore() > playerTwo.getScore()) {
			return playerOne;
		} else {
			return playerTwo;
		} 
	}
	public void startGame() {
		System.out.println("Enter the name of player one: ");
		Player p1 =  new Player(scan.next());
		System.out.println("Enter the name of player two: ");
		Player p2 =  new Player(scan.next());
		
		playerOne = p1;
		playerTwo = p2;
		
		while (round < 12) {
			letter = alphabet.charAt(rand.nextInt(alphabet.length()));
			
			System.out.println("\nRound: " + round);
			System.out.println("The letter is: " + letter + "\n");
			
			System.out.println("Enter the word of " + p1.getName() + ": ");
			p1.setWord(scan.next());
			
			System.out.println("Enter the word of " + p2.getName() + ": ");
			p2.setWord(scan.next());
			
			System.out.println("\n" + p1.getName() + " wrote: " + p1.getWord());
			System.out.println(p2.getName() + " wrote: " + p2.getWord());
			
			//Implement scraper
			
			round++;
		}
	}
	public static void main (String args[]) {
		
		//Only for test purposes
		
		/*Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int round = 1;
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char letter;
		
		System.out.println("Enter the name of player one: ");
		Player p1 =  new Player(scan.next());
		System.out.println("Enter the name of player two: ");
		Player p2 =  new Player(scan.next());
		Game game = new Game(p1, p2);
		
		while (round < 12) {
			letter = alphabet.charAt(rand.nextInt(alphabet.length()));
			System.out.println();
			
			System.out.println("Round: " + round);
			System.out.println("The letter is: " + letter + "\n");
			
			System.out.println("Enter the word of player one: ");
			p1.setWord(scan.next());
			
			System.out.println("Enter the word of player two: ");
			p2.setWord(scan.next());
			System.out.println();
			
			System.out.println("Player one wrote: " + p1.getWord());
			System.out.println("Player two wrote: " + p2.getWord());
			
			round++;
		}*/
	}
}