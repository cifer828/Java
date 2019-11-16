package exam2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestThesaurus {
	
	static WordReference thesaurus;
	
	@BeforeClass 
	public static void setupClass() {
		thesaurus = new Thesaurus("Thesaurus.txt");
	}
		
	/******************* Thesaurus test cases ****************/
	
	@Test
	public void testThesaurusWordDataLenght() {
		assertEquals(1387, thesaurus.wordData.length);
	}

	@Test
	public void testThesaurusWordFoundCount() {
		String[] meanings = thesaurus.lookup("program");
		System.out.println(meanings.length);
		assertEquals(3, meanings.length);
	}
	
	@Test
	public void testThesaurusWordFoundContent() {
		String[] meanings = thesaurus.lookup("coffee");
		boolean found = false;
		for (String meaning: meanings) {
			if (meaning.trim().equalsIgnoreCase("java"))
				found = true;
		}
		assertTrue(found);
	}
	
	@Test
	public void testThesaurusWordNotFound() {
		assertTrue(thesaurus.lookup("abc") == null);
	}

}