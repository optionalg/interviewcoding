package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SurroundedRegions
{

    public static void solve(char[][] board)
    {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[0].length; ++j)
                if(!visited[i][j] && board[i][j] == 'O')
                    searchAndFlip(board, i, j, visited);
    }
    
    /**
     * Search for a region starting from (row, col)
     * If a region is found, flip it by changing all the o to x
     */
    private static void searchAndFlip(char[][] board, int row, int col, boolean[][] visited)
    {
        boolean reachedBorder = false;               // if the search has reached the border
        List<Cell> region = new ArrayList<Cell>();   // cells in this region
        Stack<Cell> stack = new Stack<Cell>();       // for dfs
        
        // start dfs
        stack.push(new Cell(row, col));
        while(!stack.isEmpty())
        {
            Cell cell = stack.pop();
            
            // check border
            if(cell.row == 0 || cell.row == board   .length - 1 || 
               cell.col == 0 || cell.col == board[0].length - 1)
                reachedBorder = true;
            
            // save the cell to the region
            region.add(cell);
            
            // a cell only needs to be visited once, no matter it is in a region or not
            visited[cell.row][cell.col] = true;
            
            // neighbors
            if(cell.row - 1 >= 0 && board[cell.row-1][cell.col] == 'O' && !visited[cell.row-1][cell.col])
                stack.push(new Cell(cell.row - 1, cell.col));
            if(cell.col + 1 < board[0].length && board[cell.row][cell.col+1] == 'O' && !visited[cell.row][cell.col+1])
                stack.push(new Cell(cell.row, cell.col+1));
            if(cell.row + 1 < board.length && board[cell.row+1][cell.col] == 'O' && !visited[cell.row+1][cell.col])
                stack.push(new Cell(cell.row + 1, cell.col));
            if(cell.col - 1 >= 0 && board[cell.row][cell.col-1] == 'O' && !visited[cell.row][cell.col-1])
                stack.push(new Cell(cell.row, cell.col-1));
        }
        
        // it is a region, flip all the cells in it
        if(!reachedBorder)
            for(Cell cell: region)
                board[cell.row][cell.col] = 'X';
    }

    public static void main(String[] args)
    {
        char[][] board = {"XXXX".toCharArray(),
                          "XOOX".toCharArray(),
                          "XXOX".toCharArray(),
                          "XOXX".toCharArray()};
        solve(board);
    }

}
