// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Roster {
	List<String> rosterData = new ArrayList<>();
	Map<String, Student> studentMap = new HashMap<>();
	Map<String, List<Student>> majorMap = new HashMap<>(); 
	List<Student> matchedDuplicateRecords = new ArrayList<>();
	List<Student> mismatchedDuplicateRecords = new ArrayList<>();
	
	
	//do not change this method
	public static void main(String[] args) {
		Roster roster = new Roster();
		roster.rosterData = roster.readRoster("roster.csv");
		roster.loadStudentMap();
		roster.loadMajorMap(roster.studentMap);
		roster.printClassReport();
		roster.printDataReport();
	}
	
	//do not change this method
	List<String> readRoster(String filename) {
		List<String> result = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNext()) {
				result.add(input.nextLine());
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**loadStudentMap() reads data from rosterData
	 * and loads studentMap with key as andrewId and value as Student object.
	 * While loading, it also identifies duplicate and incorrect records, if any,
	 * and populates duplicateRecords and incorrectRecords with them, respectively.
	 */
	void loadStudentMap() {
 		//write your code here
		for (int i = 0; i < rosterData.size(); i++) {
			String [] line = rosterData.get(i).split(",");
			String id = line[0].trim();
			Student s = new Student(id, line[1].trim(), line[2].trim());
			// map.put will return the old value if the given key is already in the map
			Student oldS = studentMap.put(id, s);
			if (oldS != null && oldS.id.equals(s.id)) {
				if (s.equals(oldS) && !matchedDuplicateRecords.contains(s)) {
					matchedDuplicateRecords.add(oldS);
				}
				else if (!s.equals(oldS)) {
					mismatchedDuplicateRecords.add(s);
					mismatchedDuplicateRecords.add(oldS);
					// update map
					studentMap.put(id, s);
				}
			}
		}
	}
	
	/**loadMajorMap() takes studentMap created in loadStudentMap
	 * and creates majorMap. 
	 */
	void loadMajorMap(Map<String, Student> studentMap) {
		//write your code here
		for (Student s: studentMap.values()) {
			String major = s.major;
			if (majorMap.containsKey(major)) {
				majorMap.get(major).add(s);
			}
			else {
				List<Student> studentList = new ArrayList<>();
				studentList.add(s);
				majorMap.put(major, studentList);
			}
		}
	}
	
	
	/**printDataReport() prints data report 
	 * as shown in the handout
	 */
	void printDataReport() {
		//write your code here
		System.out.println("*** DATA REPORT ***");
		System.out.println("--- Matched Duplicate Records ---");
		for(Student s: matchedDuplicateRecords) {
			System.out.printf("%s %s %s\n", s.id, s.name, s.major);
		}
		System.out.println();
		
		System.out.println("--- Mismatched Duplicate Records ---");
		for(Student s: mismatchedDuplicateRecords) {
			System.out.printf("%s %s %s\n", s.id, s.name, s.major);
		}
	}
	
	/**printClassReport() prints class report 
	 * as shown in the handout
	 */
	void printClassReport() {
		//write your code here
		System.out.println("*** CLASS REPORT ***");
		int totalStudents = 0;
		StringBuilder output = new StringBuilder();
		for(Entry<String, List<Student>> entry: majorMap.entrySet()) {
			totalStudents += entry.getValue().size();
			output.append(String.format("Major: %s has %d students\n", entry.getKey(), entry.getValue().size()));
		}
		System.out.printf("Total students: %d\n%s\n", totalStudents, output.toString());
	}
}

