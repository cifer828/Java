// Name: Qiuchen Zhang
// AndrewId: qiuchenz

package hw1;

public class HangmanRound extends GameRound{
	private int hitCount;
	private int missCount;
	
	public int getHitCount() {
		// getter for hitCount
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		// setter for hitCount
		this.hitCount = hitCount;
	}
	public int getMissCount() {
		// getter for missCount
		return missCount;
	}
	public void setMissCount(int missCount) {
		// setter for missCount
		this.missCount = missCount;
	}
}
