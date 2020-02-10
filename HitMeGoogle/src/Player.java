public class Player {
	private String name;
	private String word;
	private int hits;
	private int score;
	
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	public void setWord(String newWord) {
		word = newWord;
	}
	public String getWord() {
		return word;
	}
	public int getHits() {
		return hits;
	}
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int newScore) {
		score = newScore;
	}
}