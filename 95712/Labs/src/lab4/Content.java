// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

public abstract class Content {
	
	//DO NOT CHANGE THIS CLASS
	
	String name;
	int duration;
	LearningMode learningMode;
	static int contentCount;
	static int totalDuration;
	
	Content(String name, int duration) {
		this.name = name;
		this.duration = duration;
		totalDuration += duration;
		contentCount++;
	}
}
