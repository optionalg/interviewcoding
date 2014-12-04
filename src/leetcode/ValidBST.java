package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.TreeNode;

/**
 * Check whether a BST is valid
 */
public class ValidBST
{

    // Solution 1: inorder traverse the tree and see if the path is ascending
    public boolean isValidBST(TreeNode root)
    {
        // run an inorder traversal
        List<Integer> path = new ArrayList<Integer>();
        inorder(root, path);
        
        // check if the path is ascending
        if(path.size() < 2)
            return true;
        for(int i = 0; i < path.size() - 1; ++i)
            if(path.get(i) >= path.get(i+1))
                return false;
        return true;
    }
    
    private void inorder(TreeNode node, List<Integer> path)
    {
        if(node != null)
        {
            inorder(node.left, path);
            path.add(node.val);
            inorder(node.right, path);
        }
    }
    
    // Solution 2: keep a record of current value range and check if the root is in the range
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max)
    {
        if(root == null)
            return true;
            
        if(root.val <= min || root.val >= max)
            return false;
            
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
