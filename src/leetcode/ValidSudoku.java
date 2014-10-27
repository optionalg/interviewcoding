package leetcode;

public class ValidSudoku
{
    public static boolean isValidSudoku(char[][] board)
    {
        for(int i = 0; i < board.length; ++i)
        {
            if(!checkRow(board[i]))
                return false;
            if(!checkCol(board, i))
                return false;
        }
        
        for(int i = 0; i < board.length; i += 3)
        {
            int top    = i;
            int bottom = i + 2;
            for(int j = 0; j < board[i].length; j += 3)
            {
                int left  = j;
                int right = j + 2;
                if(!checkSquare(board, left, right, top, bottom))
                    return false;
            }
        }
        return true;
    }
    
    private static boolean checkRow(char[] row)
    {
        int[] counter = new int[10];
        for(int i = 0; i < row.length; ++i)
        {
            if(row[i] == '.')
                continue;
            int value = row[i] - '0'; 
            if(counter[value] == 0)
                counter[value] = 1;
            else
                return false;
        }
        return true;
    }
    
    private static boolean checkCol(char[][] board, int col)
    {
        int[] counter = new int[10];
        for(int i = 0; i < board[0].length; ++i)
        {
            if(board[i][col] == '.')
                continue;
            int value = board[i][col] - '0'; 
            if(counter[value] == 0)
                counter[value] = 1;
            else
                return false;
        }
        return true;
    }
    
    private static boolean checkSquare(char[][] board, int left, int right, int top, int bottom)
    {
        int[] counter = new int[10];
        for(int i = top; i <= bottom; ++i)
            for(int j = left; j <= right; ++j)
            {
                if(board[i][j] == '.')
                    continue;
                int value = board[i][j] - '0'; 
                if(counter[value] == 0)
                    counter[value] = 1;
                else
                    return false;
            }
        return true;
    }

    public static void main(String[] args)
    {
        char[][] board = {"53..7....".toCharArray(),
                          "6..195...".toCharArray(),
                          ".98....6.".toCharArray(),
                          "8...6...3".toCharArray(),
                          "4..8.3..1".toCharArray(),
                          "7...2...6".toCharArray(),
                          ".6....28.".toCharArray(),
                          "...419..5".toCharArray(),
                          "....8..79".toCharArray()};
        System.out.println(isValidSudoku(board));
    }

}
