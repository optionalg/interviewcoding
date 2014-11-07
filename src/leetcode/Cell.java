package leetcode;

public class Cell
{
    public int row;
    public int col;
    
    public Cell(int r, int c)
    {
        row = r;
        col = c;
    }
    
    @Override
    public String toString() {
        return "" + row + "," + col;
    }
}