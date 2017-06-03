package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.StringUtils;

public class StringUtilsTest {

	private StringUtils classUnderTest;
	
	@Before
	public void setUp(){
		classUnderTest = new StringUtils();
	}
	
	@Test
	public void isValidZipCodeTest()
	{
		Assert.assertTrue(classUnderTest.isValidZipCode("55-080"));
		Assert.assertFalse(classUnderTest.isValidZipCode("5-080"));
		Assert.assertFalse(classUnderTest.isValidZipCode("55-0"));
		Assert.assertFalse(classUnderTest.isValidZipCode("55540"));
		Assert.assertFalse(classUnderTest.isValidZipCode("-"));
		Assert.assertFalse(classUnderTest.isValidZipCode(""));
	}
	
	@Test
	public void toUpperCase(){
		String slowo = classUnderTest.toUpperCase("Jacek");
		Assert.assertEquals("JACEK", slowo);
		slowo = classUnderTest.toUpperCase("JACEK");
		Assert.assertEquals("JACEK", slowo);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void toUpperCaseIllegal(){
		classUnderTest.toUpperCase("woünica");
		classUnderTest.toUpperCase("wo5nica");
		classUnderTest.toUpperCase("gggd%");
	}
	
	@Test
	public void toLowerCase(){
		String slowo = classUnderTest.toLowerCase("Jacek");
		Assert.assertEquals("jacek", slowo);
		slowo = classUnderTest.toLowerCase("JACEK");
		Assert.assertEquals("jacek", slowo);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void toLowerCaseIllegal(){
		classUnderTest.toLowerCase("woünica");
		classUnderTest.toLowerCase("wo5nica");
		classUnderTest.toLowerCase("gggd%");
	}
	
	@Test
	public void isFemaleNameTest(){
		Assert.assertTrue(classUnderTest.isFemaleName("AgatA"));
		Assert.assertTrue(classUnderTest.isFemaleName("Agata"));
		Assert.assertFalse(classUnderTest.isFemaleName("Tomek"));
	}
	@Test (expected = NullPointerException.class)
	public void isFemaleNameTestNull(){
		classUnderTest.isFemaleName(null);
	}
	
	@Test
	public void replaceSpacesWithUnderscoreTest(){
		String sentence = classUnderTest.replaceSpacesWithUnderscore("Jacek  ");
		Assert.assertEquals("Jacek__", sentence);
		sentence = classUnderTest.replaceSpacesWithUnderscore("  ");
		Assert.assertEquals("__", sentence);
		sentence = classUnderTest.replaceSpacesWithUnderscore("Ala ma kota");
		Assert.assertEquals("Ala_ma_kota", sentence);
	}
	
	@Test
	public void countWordsInSentenceTest(){
		int ile = classUnderTest.countWordsInSentence("Ala ma kota.");
		Assert.assertEquals(3, ile);
		ile = classUnderTest.countWordsInSentence("Ala ma  kota. ");
		Assert.assertEquals(3, ile);
		ile = classUnderTest.countWordsInSentence("  kota");
		Assert.assertEquals(1, ile);

	}
	
}
