package practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTwister {

	Twister twister = new Twister();
	
	@Test
	public void test1_StringTwister() {
		String[] names = {"Jim", "Tim"};
		String[] twisted = Twister.twist(names);
		assertEquals("miT", twisted[0]);
		assertEquals("miJ", twisted[1]);
	}
	
	@Test
	public void test2_NumTwister() {
		int[] numbers = {89, 1234};
		int[] twisted = Twister.twist(numbers);
		assertEquals(4321, twisted[0]);
		assertEquals(98, twisted[1]);
	}

}
