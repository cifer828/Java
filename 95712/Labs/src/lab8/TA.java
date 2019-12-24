// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package lab8;

public class TA implements Runnable, Comparable<TA>{
	static final int MAX_HELP_TIME = 120;  //One TA's total office hour time as 2 hours
	static int totalHelpTime;  //total help time given by a TA so far
	static int taCount; // keeps count of total TA objects created
	
	int studentsHelped; //number of students helped by a TA so far
	int helpTime; //total help time given by a TA so far
	int taID; //unique sequential ID starting with 1 assigned to each TA object as it is created

	TA() {
		taID = ++taCount;
	}

	@Override
	public void run() {
		while(helpTime < MAX_HELP_TIME && !JavaCourse.allDone) {
			Student student = null;
			
			synchronized (JavaCourse.studentQ) {
				student = JavaCourse.studentQ.poll();
			}
			
			// skip if there's no students in the queue
			if (student == null)
				continue;
			
			int questionTime = student.askQuestions();
			studentsHelped++;
			totalHelpTime += questionTime;
			helpTime += questionTime;
			
			// student ask question
			try {
				Thread.sleep(questionTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(spacer(taID) + "TA" + taID + ":Student" + student.studentID + ":" + questionTime + "min");
			if (totalHelpTime >= taCount * MAX_HELP_TIME) {
				JavaCourse.allDone = true;
			}
		}
	}

	@Override
	public int compareTo(TA o) {
		//write your code here
		return o.helpTime - this.helpTime;
	}


	//do not change this method
	String spacer(int taID) {
		StringBuilder spaces = new StringBuilder();
		for (int i = 1; i < taID; i++) {
			spaces.append("\t\t");
		}
		return spaces.toString();
	}
}
