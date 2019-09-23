package exam1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLibrary {
	
	Library library;
	
	String[] mediaData = { 
			"Book: Core Java, Cornell, 100, 2018",
			"Movie: Jaws, Spielberg, 124, 1975", 
			"Book: Thinking Java, Eckel, 250, 2004",  
			"Movie: The Terminator, James Cameron, 107, 1984", 
			"Movie: The Titanic, Christopher Nolan, 195, 1997"
	};
	
	@Before
	public void setup() {
		library = new Library();
	}
	
	//Tests reading Media.txt and loading all data
	@Test
	public void test1_readMediaData() {
		assertEquals(10, library.readData("Media.txt").length);
	}
	
	//following test cases use mediaData[] defined above
	@Test
	public void test2_bookCatalogLength() {
		library.processData(mediaData);
		assertEquals(2, library.books.length);
	}
	
	@Test
	public void test3_bookCatalogPages() {
		library.processData(mediaData);
		assertEquals(350, library.totalBookPages);
	}
	
	@Test
	public void test4_movieCatalogLength() {
		library.processData(mediaData);
		assertEquals(3, library.movies.length);
	}
	
	@Test
	public void test5_movieCatalogMinutes() {
		library.processData(mediaData);
		assertEquals(426, library.totalMoviesDuration);
	}
}
