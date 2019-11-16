package exam2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDictionary {
	
	static WordReference dictionary;
	
	@BeforeClass 
	public static void setupClass() {
		dictionary = new Dictionary("Dictionary.txt");
	}
	
	/******************Dictionary test cases ******************/
	
	@Test
	public void testDictionaryWordDataLength() {
		System.out.println(dictionary.wordData.length);
		assertEquals(176046, dictionary.wordData.length);
	}
	

	@Test
	public void testDictionaryWordFoundCount() {
		String[] meanings = dictionary.lookup("world");
		assertEquals(9, meanings.length);
	}
	
	@Test
	public void testDictionaryWordFoundContent() {
		String[] meanings = dictionary.lookup("java");
		boolean found = false;
//		System.out.println(meanings);
		for (String meaning: meanings) {
//			System.out.println(meaning);
			if (meaning.trim().equalsIgnoreCase("Java coffee, a kind of coffee brought from Java."))
				found = true;
		}
		assertTrue(found);
	}
	
	@Test
	public void testDictionaryWordNotFound() {
		assertTrue(dictionary.lookup("abc") == null);
	}
	
}