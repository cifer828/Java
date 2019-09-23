// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FriendFinder {

	String[] persons;
	String[][] personFriends;

	public static void main(String[] args) {
		FriendFinder friendFinder = new FriendFinder();
		friendFinder.readFriends();
		friendFinder.getInputOutput();
	}

	//do not change this method
	void getInputOutput() {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("*** Find Friends ***");
			System.out.println("1. Find the number of friends a person has");
			System.out.println("2. Find the number of common friends between two people");
			System.out.println("3. Find the names of common friends between two people");
			System.out.println("4. Exit");
			choice = input.nextInt();
			input.nextLine(); //clear the Scanner
			switch (choice) {
			case 1: {
				System.out.println("Enter the person's name"); 
				String name = input.nextLine();
				System.out.printf("%s has %d friends%n", name, countFriends(name));
				break;
			}
			case 2: {
				System.out.println("Enter first person's name");
				String name1 = input.nextLine();
				System.out.println("Enter second person's name");
				String name2 = input.nextLine();
				System.out.printf("%s and %s have %d common friends%n", name1, name2, countCommonFriends(name1, name2));
				break;
			}
			case 3: {
				System.out.println("Enter first person's name");
				String name1 = input.nextLine();
				System.out.println("Enter second person's name");
				String name2 = input.nextLine();
				String[] names = findCommonFriends(name1, name2);
				System.out.println(names.length + " common friends");
				for (String s : names) System.out.println(s);
				break;
			}
			default: System.out.println("Goodbye!");break;
			}
		} while (choice != 4);
		input.close();
	}

	
	/** readFriends() reads friends.txt and 
	 * populates persons and personFriends arrays
	 */
	void readFriends() {
		//write your code here
		Scanner input = null;
		int lineCount = 0;
		try {
			input = new Scanner(new File("Friends.txt"));
			while(input.hasNextLine()) {
				// count line number
				input.nextLine();
				lineCount++;  
			}
			input = new Scanner(new File("Friends.txt")); // read the file from beginning again
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personFriends = new String[lineCount][];
		persons = new String[lineCount];
		int personCount = 0;
		while(input.hasNextLine()) {
			String [] oneLine = input.nextLine().split(":");
			persons[personCount] = oneLine[0].trim();
			String [] friends = oneLine[1].split(",");
			// remove the space and return in each friend name
			for (int i = 0; i < friends.length; i ++)
				friends[i] = friends[i].trim();
			personFriends[personCount] = friends;
			personCount++;
		}
		input.close();
	}

	/** given a name, returns how many friends a person has
	 */
	int countFriends(String name) {
		//write your code here
		for (int i = 0;i < persons.length; i++) {
			if (persons[i].toLowerCase().equals(name.toLowerCase())) {
				return personFriends[i].length;
			}
		}
		return -1;
	}

	/** given two names, returns how many commons 
	 * friends they have
	 */
	int countCommonFriends(String name1, String name2) {
		//write your code here
		int idx1 = -1, idx2 = -1;
		int commonCount = 0;
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].toLowerCase().equals(name1.toLowerCase())) 
				idx1 = i;
			else if(persons[i].toLowerCase().equals(name2.toLowerCase()))
				idx2 = i;
		}
		for (String f1: personFriends[idx1]) {
			for (String f2: personFriends[idx2]) {
				if (f1.equals(f2)) {
					commonCount++;
					break;
				}
			}
		}
		return commonCount;
	}

	/**given two names, returns an array of names of common friends
	 */
	String[] findCommonFriends(String name1, String name2) {
		//write your code here
		int idx1 = -1, idx2 = -1;
		String commonFriends = "";
		for (int i = 0; i < persons.length; i++) {
			if (persons[i].toLowerCase().equals(name1.toLowerCase())) 
				idx1 = i;
			else if(persons[i].toLowerCase().equals(name2.toLowerCase()))
				idx2 = i;
		}
		for (String f1: personFriends[idx1]) {
			for (String f2: personFriends[idx2]) {
				if (f1.equals(f2)) {
					commonFriends += f1 + ",";
					break;
				}
			}
		}
		if(commonFriends.length() > 0)
			return commonFriends.split(",");
		else 
			return new String [] {};
	}

}
