// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

public class LearnByWatching implements LearningMode{
	@Override
	public void learn(Content content) {
		System.out.printf("Watching %s video for %d minutes\n", content.name, content.duration);
	}
}
