package se.tacton.webshop;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WebshopTest extends TestCase
{

	public WebshopTest(String testName)
	{
		super(testName);
	}

	public static Test suite()
	{
		return new TestSuite(WebshopTest.class);
	}

	/**
	 * Dummy Test
	 */
	public void testApp()
	{
		assertTrue(true);
	}

}
