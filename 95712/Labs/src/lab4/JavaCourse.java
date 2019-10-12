// Name: Qiuchen Zhang
// AndrewID: qiuchenz
package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaCourse {

	String[] contentData;  //has rows of data from JavaCouser.csv
	Content[] contentObjects; 

	//DO NOT CHANGE THIS METHOD
	//read JavaContent.csv and load all rows in contentData
	void loadContentsData() {
		StringBuilder fileContents = new StringBuilder();
		try {
			Scanner input = new Scanner(new File("JavaContent.csv"));
			while (input.hasNext()) {
				fileContents.append(input.nextLine() + "\n");
			}
			input.close();
			contentData = fileContents.toString().split("\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/** loadContentObjects() reads the data from contentData array
	 * and creates the contentObjects array. 
	 * This array has all kinds of Content objects - Video, Lecture, and Practice. 
	 */
	void loadContentObjects() {
		//write your code here
		// create objects based on different study methods;
		contentObjects = new Content[contentData.length];
		for(int i = 0; i < contentObjects.length; i++) {
			String[] oneLine = contentData[i].split(",");
			String studyMethod = oneLine[0].trim();
			String content = oneLine[1].trim();
			int duration = Integer.parseInt(oneLine[2].trim());
			if (studyMethod.equals("Lecture"))
				contentObjects[i] = new Lecture(content, duration);
			else {
				int fileSize = Integer.parseInt(oneLine[3].trim());
				if (studyMethod.equals("Video"))
					contentObjects[i] = new Video(content, duration, fileSize);
				else if (studyMethod.equals("Practice"))
					contentObjects[i] = new Practice(content, duration, fileSize);
			}
				
		}
	}

	/** prints the Learning Activity Report as shown in the handout
	 * Hint: Iterate through contentObjects array and invoke 
	 * learn() and download() methods polymorphically.
	 */
	void printLearningActivitiesReport() {
		//write your code here
		int i = 1;
		for (Content content: contentObjects) {
			System.out.printf("%d. ", i++);
			if (content instanceof Downloadable) {
				((Downloadable) content).download();
			}
			content.learningMode.learn(content);
		}
	}

	//DO NOT CHANGE THIS METHOD
	public static void main(String[] args) {
		JavaCourse javaCourse = new JavaCourse();
		javaCourse.loadContentsData();
		javaCourse.loadContentObjects();
		System.out.println("*** Java course has the following content ***");
		System.out.println("---------------------------------");
		System.out.printf("%d Videos for %d minutes in %d MB files%n", Video.contentCount, Video.totalDuration, Video.totalFileSize);
		System.out.printf("%d Practice for %d minutes in %d MB files%n", Practice.contentCount, Practice.totalDuration, Practice.totalFileSize);
		System.out.printf("%d Lectures for %d minutes%n", Lecture.contentCount, Lecture.totalDuration);
		System.out.println("---------------------------------");
		System.out.printf("Total: %d contents for %d minutes in %d MB files%n", Content.contentCount, Content.totalDuration, Video.totalFileSize + Practice.totalFileSize);
		System.out.println("---------------------------------");
		System.out.println("Learning Activities Report");
		System.out.println("---------------------------------");
		javaCourse.printLearningActivitiesReport();
	}
}
