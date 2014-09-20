import java.util.ArrayList;
import java.util.Arrays;

public class Queen
{

	public static ArrayList<int[]> queen(int n)
	{
		ArrayList<int[]> result = new ArrayList<int[]>();
		if(n < 1)
			return result;
		
		int[] columns = new int[n];
		doQueen(columns, 0, result);
		return result;
	}
	
	private static boolean isSafe(int[] columns, int x, int y)
	{
		// scan all existing queens
		for(int row = 0; row < x; ++row)
		{
			int col = columns[row];
			if(col == y)                                 // same column
				return false;
			if(Math.abs(col - y) == Math.abs(row - x))   // diagonal (|dx| = |dy|)
				return false;
		}
		return true;
	}
	
	private static void doQueen(int[] columns, int row, 
								ArrayList<int[]> result)
	{
		if(columns.length == row)
		{
			result.add(Arrays.copyOf(columns, columns.length));
			return;
		}
		
		for(int col = 0; col < columns.length; ++col)
		{
			if(isSafe(columns, row, col))
			{
				columns[row] = col;
				doQueen(columns, row+1, result);
			}
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<int[]> result = queen(4);
		for(int i = 0; i < result.size(); ++i)
			System.out.println(Arrays.toString(result.get(i)));
	}

}
