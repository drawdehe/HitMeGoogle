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
	public boolean checkIfValidWord(String word) {
		if (word.length() > 2 && word.charAt(0) == letter) {
			return true;
		} else {
			return false;
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
			int x = 0;
			int y = 0;
			letter = alphabet.charAt(rand.nextInt(alphabet.length()));
			
			System.out.println("\nRound: " + round);
			System.out.println("The letter is: " + letter + "\n");
			
			//THE METHOD DOES NOT REALLY WORK RIGHT NOW. Also, make this a private method instead
			while (x == 0) {
				System.out.println("Enter the word of " + p1.getName() + ": ");
				p1.setWord(scan.next());
				if (!checkIfValidWord(p1.getWord())) {
					System.out.println("That is not a valid word.\nThe word has to start with " + letter + " and be at least three letters.\n");
				} else {
					x = 1;
				}
			}
			while (y == 0) {
				System.out.println("Enter the word of " + p2.getName() + ": ");
				p2.setWord(scan.next());
				if (!checkIfValidWord(p1.getWord())) {
					System.out.println("That is not a valid word.\nThe word has to start with " + letter + " and be at least three letters.\n");
				} else {
					y = 1;
				}
			}
			
			System.out.println("\n" + p1.getName() + " wrote: " + p1.getWord());
			System.out.println(p2.getName() + " wrote: " + p2.getWord());
			
			//Implement scraper
			
			round++;
		}
	}
}
