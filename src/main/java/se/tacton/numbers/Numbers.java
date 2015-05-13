package se.tacton.numbers;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Numbers
{
	private static Map<Integer, BigInteger> fiboNum = new HashMap<Integer, BigInteger>();
	static
	{
		fiboNum.put(1, new BigInteger("1"));
		fiboNum.put(2, new BigInteger("1"));
	}

	public static final void main(String args[])
	{
		try
		{	System.out.println("Enter the n:th index: ");		
			Scanner n = new Scanner(System.in);
			String inNumber = n.nextLine();
			System.out.println("The n:th number is:\n" + getValue(Integer.parseInt(inNumber)));
			n.close();
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
		}
	}

	public static BigInteger getValue(int inIndex)
	{
		if (inIndex <= 2 || fiboNum.get(inIndex) != null)
		{
			return fiboNum.get(inIndex);
		}

		fiboNum.put(inIndex, getValue(inIndex - 1).add(getValue(inIndex - 2)));

		return fiboNum.get(inIndex);
	}
}
