import java.util.ArrayList;

public class Parenthesis
{

	public static ArrayList<String> parenthesis(int n)
	{
		ArrayList<String> result = new ArrayList<String>();
		if(n < 1)		
			return result;
		
		char[] array = new char[n*2];
		fill(n, n, 0, array, result);
		
		return result;
	}
	
	private static void fill(int left, int right, int idx, 
							 char[] array, ArrayList<String> result)
	{
		if(right < left)
			return;
		
		if(left == 0 && right == 0)
		{
			result.add(String.valueOf(array));
			return;
		}
		
		if(left > 0)
		{
			array[idx] = '(';
			fill(left-1, right, idx + 1, array, result);
		}
		if(right > left)
		{
			array[idx] = ')';
			fill(left, right-1, idx + 1, array, result);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(parenthesis(3));
	}

}
