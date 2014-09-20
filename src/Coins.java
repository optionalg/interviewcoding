import java.util.ArrayList;


public class Coins
{
	
	public static ArrayList<ArrayList<Integer>> coins(int cents)
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		genCoins(cents, 25, array, result);
		return result;
	}
	
	private static void step(int cents, ArrayList<Integer> a, 
							 ArrayList<ArrayList<Integer>> result)
	{
		ArrayList<Integer> array = new ArrayList<Integer>(a);
		if(cents == 0)
		{
			result.add(array);
			return;
		}
		
		if(cents >= 25)
		{
			array.add(25);
			step(cents - 25, array, result);
		}
		else if(cents >= 10)
		{
			array.add(10);
			step(cents - 10, array, result);
		}
		else if(cents >= 5)
		{
			array.add(5);
			step(cents - 5, array, result);
		}
		else if(cents >= 1)
		{
			array.add(1);
			step(cents - 1, array, result);
		}
	}
	
	private static int nextDenominator(int denominator)
	{
		switch(denominator)
		{
		case 25:
			return 10;
		case 10:
			return 5;
		case 5:
			return 1;
		default:
			return 0;
		}
	}
	
	private static void genCoins(int cents, int denominator, ArrayList<Integer> array, 
								 ArrayList<ArrayList<Integer>> result)
	{
		if(cents == 0)
		{
			result.add(array);
			return;
		}
		
		do
		{
			if(cents >= denominator)
			{
				ArrayList<Integer> newArray = new ArrayList<Integer>(array);
				newArray.add(denominator);
				genCoins(cents - denominator, denominator, newArray, result);
			}
			denominator = nextDenominator(denominator);
		}
		while(denominator > 0);
	}

	public static void main(String[] args)
	{
		System.out.println(coins(10));
	}
}
