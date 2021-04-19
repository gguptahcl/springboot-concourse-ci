// GIT https://github.com/in28minutes/JUnitIn28Minutes


	
package com.gg.springboot.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringHelperTest {

	StringHelper helper; 
	
	@Before
	public void setup() {
		 System.out.println("inside setup");
		 helper = new StringHelper();
	}
	
	@Test
	public void test_TruncateAInFirst2Positions() {
		//fail("Not yet implemented");
		String actual = helper.truncateAInFirst2Positions("ABCD");
		String expected = "BCD" ;
		assertEquals(expected, actual);
	}

	@Test
	public void test_TruncateAInFirst2Positions_withOnlyTwoChars() {
		//fail("Not yet implemented");
		String actual = helper.truncateAInFirst2Positions("AA");
		String expected = "" ;
		assertEquals(expected, actual);
	}
	
	@Test(expected = NullPointerException.class)
	public void test_TruncateAInFirst2Positions_withNull() {
		//fail("Not yet implemented");
		String actual = helper.truncateAInFirst2Positions(null);
		System.out.println("actual :"+ actual);
		String expected = "" ;
		assertEquals(expected, actual);
	}
	/*
	 * @Test public void test_AreFirstAndLastTwoCharsSame() {
	 * //fail("Not yet implemented"); boolean result =
	 * helper.areFirstAndLastTwoCharactersTheSame("AAAA"); //assertEquals(result,
	 * true); assertTrue(result); }
	 * 
	 * @Test public void test_AreFirstAndLastTwoCharsSame_different() {
	 * //fail("Not yet implemented"); boolean result =
	 * helper.areFirstAndLastTwoCharactersTheSame("ABCD"); //assertEquals(result,
	 * true); assertFalse(result); }
	 * 
	 * @Test(expected = NullPointerException.class) public void
	 * test_AreFirstAndLastTwoCharsSame_withNull() { //fail("Not yet implemented");
	 * boolean actual = helper.areFirstAndLastTwoCharactersTheSame(null);
	 * System.out.println("actual :"+ actual); String expected = "" ;
	 * assertEquals(expected, actual); }
	 */
}
