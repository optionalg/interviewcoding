package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode
{
    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
 

// Add extro info to TreeNode: parent and length of path
class Node
{
    public TreeNode treeNode;
    public Node     parent;
    public int      length;
    
    public Node(TreeNode treeNode, Node parent, int length)
    {
        this.treeNode = treeNode;
        this.parent   = parent;
        this.length   = length;
    }
    
    public boolean isLeaf() {
        return treeNode.left  == null && 
               treeNode.right == null;
    }
    
    public static List<Integer> getPath(Node node)
    {
        List<Integer> path = new LinkedList<Integer>();
        while(node != null)
        {
            path.add(0, node.treeNode.val);
            node = node.parent;
        }
        return path;
    }
}


public class PathSum
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        // a pre-order traversal
        Stack<Node> stack = new Stack<Node>();
        Node node = new Node(root, null, root.val);
        stack.push(node);
        
        while(!stack.isEmpty())
        {
            node = stack.pop();
            if(node.isLeaf() && node.length == sum)
                result.add(Node.getPath(node));
            
            TreeNode child  = node.treeNode.right;
            if(child != null)
                stack.push(new Node(child, node, node.length + child.val));
            
            child = node.treeNode.left;
            if(child != null)
                stack.push(new Node(child, node, node.length + child.val));
        }
        
        return result;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
