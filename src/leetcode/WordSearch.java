package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch
{
    public static boolean exist(char[][] board, String word)
    {
        if(board == null || board.length == 0 || word == null || word.isEmpty())
            return false;
            
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[i].length; ++j)
            {
                // try to start from each cell
                clearVisited(visited);
                if(exist(board, word, 0, i, j, visited))
                    return true;
            }
        return false;
    }
    
    private static boolean exist(char[][] board, String word, int i, int x, int y, boolean[][] visited)
    {
        if(visited[x][y])
            return false;
        
        if(word.charAt(i) != board[x][y])
            return false;
            
        // visit current cell
        visited[x][y] = true;
        
        // finish the entire word
        if(i == word.length() - 1)
            return true;
            
        Queue<Cell> queue = new LinkedList<Cell>();
        queue.offer(new Cell(x, y));
        while(!queue.isEmpty())
        {
            Cell cell = queue.poll();
            
        }
        
        // try 4 directions
        if(x > 0 && exist(board, word, i + 1, x - 1, y, visited))
            return true;
        if(x < board.length - 1 && exist(board, word, i + 1, x + 1, y, visited))
            return true;
        if(y > 0 && exist(board, word, i + 1, x, y - 1, visited))
            return true;
        if(y < board[0].length - 1 && exist(board, word, i + 1, x, y + 1, visited))
            return true;
        
        return false;
    }
    
    private static void clearVisited(boolean[][] visited) {
        for(int i = 0; i < visited.length; ++i)
            for(int j = 0; j < visited[i].length; ++j)
                visited[i][j] = false;
    }
    
    public static void main(String[] args)
    {
        char[][] board = new char[][]{
                                new String("ABCE").toCharArray(),
                                new String("SFCS").toCharArray(),
                                new String("ADEE").toCharArray()};
        System.out.println(exist(board, "ABCCED"));
    }

}
