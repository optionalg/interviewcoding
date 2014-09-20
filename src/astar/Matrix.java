package astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Cell
{
	public int row;
	public int col;
	public boolean occupied;
	public int cost;      // cost so far, i.e., distance to the origin
	public int distance;  // estimated distance to the destination
	public Cell prev;
	
	public Cell(int r, int c, boolean o)
	{
		row = r;
		col = c;
		occupied = o;
		cost = Integer.MAX_VALUE;
	}
	
	public int value() {
		return cost + distance;
	}
	
	public void updateCost(Cell prev)
	{
		if(prev == null) {
			cost = 0;
		}
		else if(prev.cost + 1 < cost)
		{
			cost = prev.cost + 1;
			this.prev = prev;
		}
	}
	
	public void updateDistance(Cell end) {
		distance = Math.abs(end.row - row) + Math.abs(end.col - col);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;
		
		if(!(obj instanceof Cell))
			return false;
		
		Cell that = (Cell) obj;
		return this.row == that.row && this.col == that.col;
	}
	
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";  
	}
}

class CellComparator implements Comparator<Cell>
{
	@Override
	public int compare(Cell c1, Cell c2) {
		return c1.value() - c2.value();
	}
}

public class Matrix
{
	private final Cell[][] matrix;
	private final PriorityQueue<Cell> open;
	private final PriorityQueue<Cell> close;
	
	public Matrix(int[][] array)
	{
		open  = new PriorityQueue<Cell>(array.length * array.length, new CellComparator());
		close = new PriorityQueue<Cell>(array.length * array.length, new CellComparator());
		
		matrix = new Cell[array.length][array[0].length];
		for(int i = 0; i < array.length; ++i)
			for(int j = 0; j < array[0].length; ++j)
				matrix[i][j] = new Cell(i, j, array[i][j] == 1);
	}
	
	private Cell getCell(int row, int col)
	{
		return (0 <= row && row < matrix   .length &&
				0 <= col && col < matrix[0].length) ? matrix[row][col] : null;
	}
	
	private ArrayList<Cell> getOpenNeighbors(Cell current)
	{
		ArrayList<Cell> result = new ArrayList<Cell>();
		
		Cell top = getCell(current.row - 1, current.col);
		if(top != null && !top.occupied && !close.contains(top))
			result.add(top);
		
		Cell bottom = getCell(current.row + 1, current.col);
		if(bottom != null && !bottom.occupied && !close.contains(bottom))
			result.add(bottom);
		
		Cell left = getCell(current.row, current.col - 1);
		if(left != null && !left.occupied && !close.contains(left))
			result.add(left);
		
		Cell right = getCell(current.row, current.col + 1);
		if(right != null && !right.occupied && !close.contains(right))
			result.add(right);
		
		return result;
	}
	
	public ArrayList<Cell> findPath(int row1, int col1, int row2, int col2)
	{
		Cell start = getCell(row1, col1);
		Cell end   = getCell(row2, col2);
		ArrayList<Cell> path = new ArrayList<Cell>();
		if(start == null || end == null)
			return path;
		
		// add start to the open list
		start.updateCost(null);
		start.updateDistance(end);
		open.add(start);
		
		// try all possible cells
		while(!open.isEmpty())
		{
			// pick one from the open list with smallest target function
			Cell smallest = open.poll();

			// is it the destination?
			if(smallest.equals(end))
				break;
			
			// move to this one to close
			close.add(smallest);
			
			// for each neighbor, calculate target function and add it to open
			ArrayList<Cell> neighbors = getOpenNeighbors(smallest);
			for(Cell cell: neighbors)
			{
				cell.updateCost(smallest);
				cell.updateDistance(end);
				open.add(cell);
			}
		}
		
		// reconstruct path
		Cell cell = end;
		while(cell != null)
		{
			path.add(cell);
			cell = cell.prev;
		}
		Collections.reverse(path);
		return path;
	}
	
	public static void main(String[] args)
	{
		int[][] array = new int[][] {
			{0, 1, 0, 0, 0, 0},
			{0, 1, 0, 0, 1, 0},
			{0, 1, 0, 0, 1, 0},
			{0, 1, 0, 0, 0, 0},
			{0, 1, 0, 0, 1, 0},
			{0, 0, 0, 0, 1, 0}
		};
		Matrix matrix = new Matrix(array);
		System.out.println(matrix.findPath(0, 0, 5, 5));
	}

}
