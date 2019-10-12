// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

public class Practice extends Content implements Downloadable{
	private int fileSize;
	static int contentCount;
	static int totalDuration;
	static int totalFileSize;
	
	Practice(String name, int duration, int fileSize) {
		super(name, duration);
		this.fileSize = fileSize;
		learningMode = new LearnByCoding();
		contentCount++;
		totalDuration += duration;
		totalFileSize += fileSize;
	}
	
	@Override
	public void download() {
		// TODO Auto-generated method stub
		System.out.printf("Downloading practice %s of %d MB. ", this.name, this.fileSize);
	}
	
}
