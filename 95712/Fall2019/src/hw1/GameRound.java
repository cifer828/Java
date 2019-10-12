// Name: Qiuchen Zhang
// AndrewId: qiuchenz

package hw1;

public class GameRound {
	private String puzzleWord;
	private String clueWord;
	private boolean isRoundComplete;
	public String getPuzzleWord() {
		// getter for puzzleWord
		return puzzleWord;
	}
	public void setPuzzleWord(String puzzleWord) {
		// setter for puzzleWord
		this.puzzleWord = puzzleWord;
	}
	public String getClueWord() {
		// getter for clueWord
		return clueWord;
	}
	public void setClueWord(String clueWord) {
		// setter for clueWord
		this.clueWord = clueWord;
	}
	public boolean getIsRoundComplete() {
		// getter for isRoundComplete
		return isRoundComplete;
	}
	public void setIsRoundComplete(boolean roundComplete) {
		// setter for isRoundComplete
		this.isRoundComplete = roundComplete;
	}

}
