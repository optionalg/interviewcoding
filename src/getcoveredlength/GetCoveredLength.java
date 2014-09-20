package getcoveredlength;

import java.util.concurrent.atomic.AtomicInteger;

class Interval
{
	private int start;
	private int end;
	
	public Interval(int start, int end)
	{
		this.setStart(start);
		this.setEnd(end);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd()	{
		return end;
	}

	public void setEnd(int end)	{
		this.end = end;
	}
	
	public int getLength() {
		return end - start;
	}
	
	@Override
	public String toString() {
		return "" + start + "-" + end;
	}
	
	public boolean overlaps(Interval another) {
		return !(this.end < another.start || another.end < this.start);
	}
	
	public void merge(Interval another)
	{
		if(!overlaps(another))
			return;
		
		this.start = Math.min(this.start, another.start);
		this.end   = Math.max(this.end,   another.end);
	}
}

class TreeNode
{
	private Interval value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(Interval value)
	{
		this.setValue(value);
		setLeft(null);
		setRight(null);
	}

	public Interval getValue() {
		return value;
	}

	public void setValue(Interval value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
}

class BinarySearchTree
{
	private TreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insert(Interval interval)
	{
		if(root == null)
			root = new TreeNode(interval);
		else
			insert(root, null, interval);
	}
	
	private void insert(TreeNode node, TreeNode parent, Interval interval)
	{
		if(node == null)
		{
			if(interval.getEnd() < parent.getValue().getStart())
				parent.setLeft(new TreeNode(interval));
			else
				parent.setRight(new TreeNode(interval));
		}
		else
		{
			if(node.getValue().overlaps(interval))
				node.getValue().merge(interval);
			else if(interval.getEnd() < node.getValue().getStart())
				insert(node.getLeft(), node, interval);
			else
				insert(node.getRight(), node, interval);
		}
	}
	
	public int getTotalCoveredLength()
	{
		AtomicInteger sum = new AtomicInteger(0);
		dfs(root, sum);
		return sum.get();
	}
	
	private void dfs(TreeNode node, AtomicInteger sum)
	{
		if(node != null)
		{
			sum.set(sum.get() + node.getValue().getLength());
			dfs(node.getLeft(),  sum);
			dfs(node.getRight(), sum);
		}
	}
}


public class GetCoveredLength
{
	
	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(new Interval(3, 6));
		tree.insert(new Interval(8, 9));
		tree.insert(new Interval(1, 5));
		System.out.println(tree.getTotalCoveredLength());
	}

}
