package lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumParser {
	
	NumParser np = new NumParser();

	@Test
	public void testNoInput() {
		np.parseCalculate("");
		assertEquals("Test sum", 0, np.sum, 0);
		assertEquals("Test max", 0, np.max, 0);
		assertEquals("Test min", 0, np.min, 0);
		assertEquals("Test count", 0, np.count, 0);
	}
	
	@Test
	public void testIntsAndSpaces() {
		np.parseCalculate("12 22 -5");
		assertEquals("Test sum", 29, np.sum, 0);
		assertEquals("Test max", 22, np.max, 0);
		assertEquals("Test min", -5, np.min, 0);
		assertEquals("Test count", 3, np.count, 0);
	}
	
	@Test
	public void testMixed() {
		np.parseCalculate("10.5, 23, -32");
		assertEquals("Test sum", 1.5, np.sum, 0);
		assertEquals("Test max", 23, np.max, 0);
		assertEquals("Test min", -32, np.min, 0);
		assertEquals("Test count", 3, np.count, 0);
	}
	
	@Test
	public void testSomeGarbage() {
		np.parseCalculate("23 abc 42, -33.5, 2a");
		assertEquals("Test sum", 31.5, np.sum, 0);
		assertEquals("Test max", 42, np.max, 0);
		assertEquals("Test min", -33.5, np.min, 0);
		assertEquals("Test count", 3, np.count, 0);
	}
	
	@Test
	public void testAllGarbage() {
		np.parseCalculate("cb 4jf +4f */$");
		assertEquals("Test sum", 0, np.sum, 0);
		assertEquals("Test max", 0, np.max, 0);
		assertEquals("Test min", 0, np.min, 0);
		assertEquals("Test count", 0, np.count, 0);
	}

}
