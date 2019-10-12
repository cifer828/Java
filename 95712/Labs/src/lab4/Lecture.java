// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

public class Lecture extends Content{
	static int contentCount;
	static int totalDuration;
	Lecture(String name, int duration) {
		super(name, duration);
		this.learningMode = new LearnByAttending();
		contentCount++;
		totalDuration += duration;
	}
	
}
