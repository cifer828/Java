// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

public class LearnByAttending implements LearningMode{
	@Override
	public void learn(Content content) {
		System.out.printf("Attending %s lecture for %d minutes\n", content.name, content.duration);
	}
}
