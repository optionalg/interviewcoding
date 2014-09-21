package tree;
import java.util.ArrayList;
import java.util.Stack;


class TreeNode<T>
{
	private T value;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	public TreeNode(T v)
	{
		value = v;
		left  = null;
		right = null;
	}
	
	public T getValue() {
		return value;
	}
	
	public TreeNode<T> getLeft() {
		return left;
	}
	
	public TreeNode<T> getRight() {
		return right;
	}
	
	public void setValue(T v) {
		value = v;
	}
	
	public void setLeft(TreeNode<T> l) {
		this.left = l;
	}
	
	public void setRight(TreeNode<T> r) {
		right = r;
	}
	
	public boolean isLeaf() {
		return left == null && right == null;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	public enum Order{PRE_ORDER, IN_ORDER, POST_ORDER, 
					  PRE_ORDER_ITERATIVE, IN_ORDER_ITERATIVE, POST_ORDER_ITERATIVE};
	
	public String dfs(Order order)
	{
		StringBuilder builder = new StringBuilder();
		switch(order)
		{
		case PRE_ORDER:
			preOrder(this, builder);
			break;
		case IN_ORDER:
			inOrder(this, builder);
			break;
		case POST_ORDER:
			postOrder(this, builder);
			break;
		case PRE_ORDER_ITERATIVE:
			preOrderIterative(this, builder);
			break;
		case IN_ORDER_ITERATIVE:
			inOrderIterative(this, builder);
			break;
		case POST_ORDER_ITERATIVE:
			postOrderIterative(this, builder);
			break;
		default:
			break;
		}
		return builder.toString();
	}
	
	private void preOrder(TreeNode<T> root, StringBuilder builder)
	{
		if(root != null)
		{
			builder.append(root.getValue());
			preOrder(root.getLeft (), builder);
			preOrder(root.getRight(), builder);
		}
	}
	
	private void inOrder(TreeNode<T> root, StringBuilder builder)
	{
		if(root != null)
		{
			inOrder(root.getLeft (), builder);
			builder.append(root.getValue());
			inOrder(root.getRight(), builder);
		}
	}
	
	private void postOrder(TreeNode<T> root, StringBuilder builder)
	{
		if(root != null)
		{
			postOrder(root.getLeft (), builder);
			postOrder(root.getRight(), builder);
			builder.append(root.getValue());
		}
	}
	
	private void preOrderIterative(TreeNode<T> root, StringBuilder builder)
	{
		if(root == null)
			return;
		
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode<T> node = stack.pop();
			builder.append(node.getValue());
			if(node.getRight() != null)
				stack.push(node.getRight());
			if(node.getLeft() != null)
				stack.push(node.getLeft());
		}
	}
	
	private void inOrderIterative(TreeNode<T> root, StringBuilder builder)
	{
		if(root == null)
			return;
		
		TreeNode<T> node = root;
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		while(!stack.isEmpty() || node != null)
		{
			while(node != null)
			{
				stack.push(node);
				node = node.getLeft();
			}
			
			node = stack.pop();
			builder.append(node);
			
			node = node.getRight();
		}
	}
	
	private void postOrderIterative(TreeNode<T> root, StringBuilder builder)
	{
		if(root == null)
			return;
		
		Stack<TreeNodeAdapter<T>> stack = new Stack<TreeNodeAdapter<T>>();
		stack.push(new TreeNodeAdapter<T>(root, 0));
		while(!stack.isEmpty())
		{
			TreeNodeAdapter<T> node = stack.pop();
			switch(node.getCount())
			{
			case 0:
				node.setCount(node.getCount() + 1);
				stack.push(node);
				TreeNode<T> left = node.getNode().getLeft(); 
				if(left != null)
					stack.push(new TreeNodeAdapter<T>(left, 0));
				break;
			case 1:
				node.setCount(node.getCount() + 1);
				stack.push(node);
				TreeNode<T> right = node.getNode().getRight(); 
				if(right != null)
					stack.push(new TreeNodeAdapter<T>(right, 0));
				break;
			case 2:
				builder.append(node.getNode());
				break;
			default:
				break;
			}
		}
	}
}

class TreeNodeAdapter<T>
{
	TreeNode<T> node;
	int         count;
	
	public TreeNodeAdapter(TreeNode<T> node, int count)
	{
		this.node  = node;
		this.count = count;
	}
	
	public TreeNode<T> getNode() {
		return node;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}

class CharTreeNode extends TreeNode<Character>
{
	public CharTreeNode(char v)	{
		super(v);
	}
}

public class BinaryTreePaths
{

	public static ArrayList<String> printPaths(CharTreeNode root)
	{
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder path = new StringBuilder();
		printPaths(root, path, result);
		return result;
	}
	
	private static void printPaths(CharTreeNode root, StringBuilder path, ArrayList<String> output)
	{
		if(root == null)
			return;
		
		path.append(root.getValue());
		if(root.isLeaf()) {
			output.add(path.toString());
		}
		else
		{
			printPaths((CharTreeNode) root.getLeft(),  new StringBuilder(path), output);
			printPaths((CharTreeNode) root.getRight(), new StringBuilder(path), output);
		}
	}

	/**
	 * Build a binary tree from its pre-order and in-order
	 */
	public static CharTreeNode buildTree(String preOrder, String inOrder)
	{
		if(preOrder == null || preOrder.isEmpty() || 
		   inOrder  == null || inOrder .isEmpty() ||
		   preOrder.length() != inOrder.length())
			return null;
		return buildTree(preOrder, 0, preOrder.length() - 1, inOrder, 0, inOrder.length() - 1);
	}
	
	/**
	 * Build a binary tree from its pre-order and in-order
	 * e.g., pre: DBACFE, in: ABCDEF
	 * result:
	 *        D
	 *      /   \
	 *     B     F
	 *    / \   /
	 *   A  C  E
	 * @param preOrder	pre-order traverse result
	 * @param preStart	start index of the pre-order result
	 * @param preEnd		end   ...
	 * @param inOrder	in-order traverse result
	 * @param inStart	start index of the in-order result
	 * @param inEnd		end   ...
	 * @return
	 */
	private static CharTreeNode buildTree(String preOrder, int preStart, int preEnd, 
									  	  String inOrder,  int inStart,  int inEnd)
	{
		if(preEnd < preStart || inEnd < inStart || 
		   preStart < 0 || preStart >= preOrder.length() ||
		   inStart  < 0 || inStart  >= inOrder .length())
			return null;
		
		// the first char of pre-order is the root
		char rootValue = preOrder.charAt(preStart);
		CharTreeNode root = new CharTreeNode(rootValue);
		
		// find the root in in-order, and split the in-order into 2 subtrees
		int rootIndex = inOrder.indexOf(rootValue);
		if(rootIndex == -1)
			return null;
		
		// locate the nodes of the left subtree
		int preLeftStart = preStart + 1;
		int preLeftEnd   = preStart + rootIndex - inStart;
		int inLeftStart  = inStart;
		int inLeftEnd    = rootIndex - 1;
		root.setLeft(buildTree(preOrder, preLeftStart, preLeftEnd, 
		                       inOrder,  inLeftStart,  inLeftEnd));
		
		// locate the nodes of the right subtree
		int preRightStart = preLeftEnd + 1;
		int preRightEnd   = preEnd;
		int inRightStart  = rootIndex + 1;
		int inRightEnd    = inEnd;
		root.setRight(buildTree(preOrder, preRightStart, preRightEnd,
		                        inOrder,  inRightStart,  inRightEnd));
		return root;
	}
	
	public static void main(String[] args)
	{
		CharTreeNode root = buildTree("DBACFE", "ABCDEF");
//		System.out.println(root.dfs(TreeNode.Order.PRE_ORDER));
//		System.out.println(root.dfs(TreeNode.Order.IN_ORDER));
//		System.out.println(root.dfs(TreeNode.Order.POST_ORDER));
		System.out.println(root.dfs(TreeNode.Order.PRE_ORDER_ITERATIVE));
		System.out.println(root.dfs(TreeNode.Order.IN_ORDER_ITERATIVE));
		System.out.println(root.dfs(TreeNode.Order.POST_ORDER_ITERATIVE));
//		System.out.println(printPaths(root));
	}

}
