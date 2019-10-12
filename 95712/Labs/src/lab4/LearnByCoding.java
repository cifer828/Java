// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

public class LearnByCoding implements LearningMode{

	@Override
	public void learn(Content content) {
		System.out.printf("Coding %s problem for %d minutes\n", content.name, content.duration);
	}
	
}
