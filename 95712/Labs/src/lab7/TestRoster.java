package lab7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestRoster {
	
	static Roster roster = new Roster();
	
	@BeforeClass
	public static void setupClass() {
		roster.rosterData = roster.readRoster("roster.csv");
		roster.loadStudentMap();
		roster.loadMajorMap(roster.studentMap);
	}

	@Test
	public void testStudentMap() {
		assertEquals(203, roster.studentMap.size());
	}
	
	@Test
	public void testMajorMap() {
		assertEquals(2, roster.majorMap.size());
	}
	
	@Test
	public void testMajorBIDASize() {
		assertEquals(88, roster.majorMap.get("BIDA").size());
	}
	
	@Test
	public void testMajorISMSize() {
		assertEquals(115, roster.majorMap.get("ISM").size());
	}
	
	@Test
	public void testMatchedDuplicateStudentEquals() {
		Student student1 = new Student("abc", "Sam Smith", "XYZ");
		Student student2 = new Student("abc", "Sam Smith", "XYZ");
		assertTrue(student1.equals(student2));
	}
	
	@Test
	public void testMatchedDuplicateStudentHash() {
		Student student1 = new Student("abc", "Sam Smith", "XYZ");
		Student student2 = new Student("abc", "Sam Smith", "XYZ");
		assertTrue(student1.hashCode() == student2.hashCode());
	}
	
	@Test
	public void testMismatchedDuplicateStudentEquals() {
		Student student1 = new Student("abc", "Sam Smith", "XYZ");
		Student student2 = new Student("abc", "John Doe", "XYZ");
		assertFalse(student1.equals(student2));
	}
	
	@Test
	public void testMisMatchedDuplicateStudentHash() {
		Student student1 = new Student("abc", "Sam Smith", "XYZ");
		Student student2 = new Student("abc", "John Doe", "XYZ");
		assertFalse(student1.hashCode() == student2.hashCode());
	}
	
}
