class Cell
{
	public int row;
	public int col;
	
	public Cell(int r, int c)
	{
		row = r;
		col = c;
	}
}

public class SortedMatrix
{

	public static Cell search(int[][] matrix, int target)
	{
		if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return new Cell(-1, -1);
		
		return binarySearch(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
	}
	
	private static Cell binarySearch(int[][] matrix, int target, 
									 int top, int bottom, int left, int right)
	{
		if(bottom - top <= 1 || right - left <= 1)
		{
			for(int i = top; i <= bottom; ++i)
				for(int j = left; j <= right; ++j)
					if(matrix[i][j] == target)
						return new Cell(i, j);
			return new Cell(-1, -1);
		}
		
		int midRow = (top  + bottom) / 2;
		int midCol = (left + right ) / 2;
		if(matrix[midRow][midCol] == target)
			return new Cell(midRow, midCol);
		
		if(target < matrix[midRow][midCol])
			return binarySearch(matrix, target, top, midRow, left, midCol);
		else
			return binarySearch(matrix, target, midRow, bottom, midCol, right);
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{1,5,8,10},
						  {3,7,9,13},
						  {4,12,15,18},
						  {6,20,24,30}};
		Cell cell = search(matrix, 120);
		System.out.println(cell.row + " " + cell.col);
	}

}
