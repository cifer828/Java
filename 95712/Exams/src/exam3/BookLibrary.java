// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package exam3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookLibrary {

	List<Book> booksList;  //stores all books
	Map<String, List<Book>> authorsMap;  //stores all authors' names as keys and their list of books as value
	String[] bookRecords; //carries data read from the file

	//do not change this method
	public static void main(String[] args) {
		
		BookLibrary bookLibrary = new BookLibrary();
		bookLibrary.readFile("BookAuthors.txt");
		bookLibrary.loadBooksList();
		bookLibrary.loadAuthorsMap();
		
		Scanner input = new Scanner(System.in);
		System.out.println("*** Welcome to Book Library ***");
		System.out.println("1. Print Books List");
		System.out.println("2. Print Authors Map");
		switch (input.nextInt()) {
		case 1: bookLibrary.printBooksList(); break;
		case 2: bookLibrary.printAuthorsMap(); break;
		default: break;
		}
		System.out.println("** Bye Bye! **"); 
		input.close();
	}

	
	//do not change this method
	void readFile(String filename) {
		StringBuilder fileData = new StringBuilder();
		try {
			Scanner input = new Scanner(new File(filename));
			while (input.hasNext()) {
				fileData.append(input.nextLine() + "\n");
			}
			bookRecords = fileData.toString().split("\n");
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	/**loadBooksList() loads data from bookRecords into
	 * booksList
	 */
	void loadBooksList() {
		booksList = new ArrayList<>();
		for (String line: bookRecords) {
			String[] items = line.split("\t");
			Book book = new Book(items[0].trim());
			for (int i = 1; i < items.length; i++) {
				book.authors.add(items[i].trim());
			}
			booksList.add(book);
		}
	}

	/**loadAuthorsMap() loads data from booksList into
	 * authorsMap
	 */
	void loadAuthorsMap() {
		authorsMap = new HashMap<>();
		for (Book book: booksList) {
			for (String author: book.authors) {
				// add the book to list if author has been visited
				if (authorsMap.containsKey(author)) {
					authorsMap.get(author).add(book);
				}
				// create new list if not
				else {
					List<Book> newList = new ArrayList<>();
					newList.add(book);
					authorsMap.put(author, newList);
				}
			}
		}
	}

	/**printBooksList() prints the output
	 * as shown in the handout
	 */
	void printBooksList() {
		Collections.sort(booksList);
		int cnt = 1;
		for (Book book: booksList) {
			System.out.printf("%d. %s: ", cnt++, book.title);
			for (String author: book.authors) {
				System.out.print(author + "; ");
			}
			System.out.println();
		}
	}
	
	/**printAuthorsMap prints the output
	 * as shown in the handout. 
	 */
	void printAuthorsMap() {
		// sort author keys in the authorsMap
		List<String> authorList = new ArrayList<>(authorsMap.keySet());
		Collections.sort(authorList);
		
		for (String author: authorList) {
			int cnt = 1;
			List<Book> bookList = authorsMap.get(author);
			System.out.println("Books by " + author);
			for (Book book: bookList) {
				System.out.printf("%d. %s\n", cnt++, book.title);
			}
		}
	}

}
