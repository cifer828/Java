// Name: Qiuchen Zhang
// AndrewID: qiuchenz

package exam1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Library {
	int totalBookPages, totalMoviesDuration;
	Book[] books;
	Movie[] movies;
	String [] dataRecords;

	//DO NOT CHANGE THIS METHOD
	public static void main(String[] args) {
		Library library = new Library();
		String[] dataRecords = library.readData("Media.txt");
		library.processData(dataRecords);
		library.printCatalog(library.books);
		library.printCatalog(library.movies);
		library.printSummary();
	}

	/** readData() reads the data file, and returns an array of Strings with 
	 * each row of data as one string  */
	String[] readData(String filename) {
		//write your code here
		Scanner input = null;
		int lineNumber = 0;
		try {
			input = new Scanner(new File(filename));
			while(input.hasNextLine()) {
				lineNumber++;
				input.nextLine();
			}
			input = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataRecords = new String[lineNumber];
		int lineCount = 0;
		while(input.hasNextLine()) {
			dataRecords[lineCount++] = input.nextLine();
		}
		return dataRecords;
	}

	/**processData() processes the data in mediaData 
	 * to create books and movies arrays, 
	 * and to update totalBookPages and totalMovieDuration
	 */
	void processData(String[] mediaData) {
		//write your code here
		int bookCount = 0, movieCount = 0;
		for (String row: mediaData) {
			String cata = row.split(":")[0].trim();
			if (cata.equals("Book"))
				bookCount++;
			else if(cata.equals("Movie"))
				movieCount++;
		}
		books = new Book[bookCount];
		movies = new Movie[movieCount];
		bookCount = 0; movieCount = 0;
		totalBookPages = 0; totalMoviesDuration = 0;
		for (String row: mediaData) {
			String cata = row.split(":")[0].trim();
			String[] info = row.split(":")[1].split(",");
			if (cata.equals("Book")) {
				Book b = new Book();
				b.title = info[0].trim();
				b.author = info[1].trim();
				b.numPages = Integer.valueOf(info[2].trim());
				b.year = Integer.valueOf(info[3].trim());
				books[bookCount++] = b;
				totalBookPages += b.numPages;
			}
			else if(cata.equals("Movie")) {
				Movie m = new Movie();
				m.title = info[0].trim();
				m.director = info[1].trim();
				m.duration = Integer.valueOf(info[2].trim());
				m.year = Integer.valueOf(info[3].trim());
				movies[movieCount++] = m;
				totalMoviesDuration += m.duration;
			}
		}
	}

	//print Book Catalog section of output as shown in the handout
	void printCatalog(Book[] books) {
		//write your code here
		System.out.println("**********Book Catalog**********");
		int bookCount = 1;
		for (Book b: books) {
			System.out.printf("%-6s#.%-5d %-6s: %-30s %-10s: %-20s%n", "Book", bookCount++, "Title", b.title, "Author", b.author);
		}
	}

	//print Movie Catalog section of output as shown in the handout
	void printCatalog(Movie[] movies) {
		//write your code here
		System.out.println("**********Movie Catalog**********");
		int movieCount = 1;
		for (Movie m: movies) {
			System.out.printf("%-6s#.%-5d %-6s: %-30s %-10s: %-20s%n", "Movie", movieCount++, "Title", m.title, "Director", m.director);
		}
	}
	
	//print last two summary lines of output as shown in the handout
	void printSummary() {
		//write your code here
		System.out.printf("Total number of books: %d. Total number of Pages: %d\n", books.length, totalBookPages);
		System.out.printf("Total number of movies: %d. Total movie duration: %d hours %d minutes\n", movies.length, totalMoviesDuration / 60, totalMoviesDuration % 60);
	}
}
