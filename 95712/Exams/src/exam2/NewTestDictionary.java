package exam2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class NewTestDictionary {
	
	static WordReference dictionary;
	
	@BeforeClass 
	public static void setupClass() {
		dictionary = new Dictionary("NewDictionary.txt");
	}
	
	/******************Dictionary test cases ******************/
	
	@Test
	public void testDictionaryWordDataLength() {
		assertEquals(510, dictionary.wordData.length);
	}
	

	@Test
	public void testDictionaryWordFoundCount() {
		String[] meanings = dictionary.lookup("aband");
		assertEquals(2, meanings.length);
	}
	
	@Test
	public void testDictionaryWordFoundContent() {
		String[] meanings = dictionary.lookup("aband");
		boolean found = false;
		for (String meaning: meanings) {
			if (meaning.trim().equalsIgnoreCase("To abandon."))
				found = true;
		}
		assertTrue(found);
	}
	
	@Test
	public void testDictionaryWordNotFound() {
		assertTrue(dictionary.lookup("abc") == null);
	}
	
}