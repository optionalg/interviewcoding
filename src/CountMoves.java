
public class CountMoves
{
	public static int countMoves(int n)
	{
		if(n < 1)
			return 0;
		return countMoves(0, 0, n);
	}
	
	private static int countMoves(int i, int j, int n)
	{
		if(i == n-1 && j == n-1)
			return 1;
		if(i == n-1)
			return countMoves(i, j+1, n);
		if(j == n-1)
			return countMoves(i+1, j, n);
		return countMoves(i+1, j, n) + countMoves(i, j+1, n);
	}
	
	public static void main(String[] argv)
	{
		System.out.println(countMoves(3));
	}
}
