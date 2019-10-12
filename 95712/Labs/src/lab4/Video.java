// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

public class Video extends Content implements Downloadable{
	private int fileSize;
	static int contentCount;
	static int totalDuration;
	static int totalFileSize;
	
	Video(String name, int duration, int fileSize) {
		super(name, duration);
		this.fileSize = fileSize;
		this.learningMode = new LearnByWatching();
		contentCount++;
		totalDuration += duration;
		totalFileSize += fileSize;
	}
	
	@Override
	public void download() {
		System.out.printf("Downloading video %s of %d MB. ", this.name, this.fileSize);
	}
}
