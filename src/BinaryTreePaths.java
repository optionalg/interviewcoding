import java.util.ArrayList;


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
	
	public enum Order{PRE_ORDER, IN_ORDER, POST_ORDER};
	
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
	 * e.g., pre: ABCDEF, in: CBDAFE
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
		CharTreeNode root = buildTree("ABCDEF", "CBDAFE");
		System.out.println(root.dfs(TreeNode.Order.PRE_ORDER));
		System.out.println(root.dfs(TreeNode.Order.IN_ORDER));
		System.out.println(root.dfs(TreeNode.Order.POST_ORDER));
		System.out.println(printPaths(root));
	}

}
