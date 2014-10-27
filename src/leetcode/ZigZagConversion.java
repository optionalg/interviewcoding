package leetcode;

public class ZigZagConversion
{

	public static String convert(String s, int nRows)
    {
		if(s == null || s.isEmpty() || nRows < 1)
			return "";
		
		if(nRows == 1 || nRows >= s.length())
			return s;
		
		int nCols = (s.length() / (nRows - 1) / 2 + 1) * (nRows - 1);
		char[][] matrix = new char[nRows][nCols];
		
		int row = 0;
		int col = 0;
		boolean down = true;
		for(int i = 0; i < s.length(); ++i)
		{
			char ch = s.charAt(i);
			matrix[row][col] = ch;
			if(down)
			{
				if(row == nRows - 1)
				{
					down = false;
					row --;
					col ++;
				}
				else
				{
					row ++;
				}
			}
			else
			{
				if(row == 0)
				{
					down = true;
					row ++;
				}
				else
				{
					row --;
					col ++;
				}
			}
		}
		
		String result = new String();
		for(int i = 0; i < matrix.length; ++i)
			for(int j = 0; j < matrix[i].length; ++j)
				if(matrix[i][j] != '\0')
					result += matrix[i][j];
		return result;
    }
	
	public static void main(String[] args)
	{
		System.out.println(convert("PAYPALISHIRING", 100));
	}

}
