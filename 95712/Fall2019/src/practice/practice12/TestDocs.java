package practice.practice12;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestDocs {
	CSVDoc csvDoc = new CSVDoc();
	RegularDoc regularDoc = new RegularDoc();
	
	@Before
	public void setUp() throws Exception {
		csvDoc.readFile("books.csv");
		csvDoc.getDocInfo();
		regularDoc.readFile("sample.txt");
		regularDoc.getDocInfo();
	}

	@Test
	public void test1_csvRowCount() {
		assertEquals("Test csv row count", 6, csvDoc.rowCount);
	}
	
	@Test
	public void test2_csvColumnCount() {
		assertEquals("Test csv column count", 4, csvDoc.columnCount);
	}
	
	@Test
	public void test3_regularWordCount() {
		assertEquals("Test regular word count", 24, regularDoc.wordCount);
	}
	
}
