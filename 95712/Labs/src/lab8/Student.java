// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package lab8;

import java.util.Random;

public class Student {
	final static int MIN_QUESTION_TIME = 5;
	final static int MAX_QUESTION_TIME = 30;
	static int totalStudentsCreated;
	static int totalStudentsHelped;
	int studentID;
	public Student() {
		// TODO Auto-generated constructor stub
		studentID = ++totalStudentsCreated;
	}
	int askQuestions(){
		totalStudentsHelped++;
		Random rand = new Random();
		return rand.nextInt(MAX_QUESTION_TIME - MIN_QUESTION_TIME + 1) + MIN_QUESTION_TIME;
	}
}
