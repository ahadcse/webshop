package se.tacton.webshop;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Test;
import se.tacton.numbers.Numbers;

public class NumberTest
{
	@Test
	public void testNumbers()
	{
		BigInteger result1 = new BigInteger("8");
		BigInteger result2 = new BigInteger("21");
		// A big number. Just for fun!!!
		BigInteger result3 = new BigInteger(
				"7291993184377412737043195648396979558721167948342308637716205818587400148912186579874409368754354848994831816250311893410648104792440789475340471377366852420526027975140687031196633477605718294523235826853392138525");

		assertEquals(Numbers.getValue(6), result1);
		assertEquals(Numbers.getValue(8), result2);
		assertEquals(Numbers.getValue(1025), result3);
	}
}
