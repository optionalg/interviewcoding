package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, how many structurally unique BSTs that store values 1...n?
 */
public class UniqueBST
{

    public int numTrees(int n) {
        return numTrees(1, n);
    }
    
    private int numTrees(int start, int end)
    {
        if(start > end)
            return 0;
        if(start == end)
            return 1;
        
        int result = 0;
        for(int i = start; i <= end; ++i)
        {
            int left  = numTrees(start, i-1);
            int right = numTrees(i+1, end);
            if(left > 0 && right > 0)
                result += left * right;
            else
                result += Math.max(left, right);
        }
        return result;
    }
    
    public List<TreeNode> generateTrees(int n)
    {
        if(n == 0)
        {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end)
            return result;
        
        if(start == end)
        {
            result.add(new TreeNode(start));
            return result;
        }
        
        for(int i = start; i <= end; ++i)
        {
            List<TreeNode> lefts  = generateTrees(start, i-1);
            List<TreeNode> rights = generateTrees(i+1,   end);
            if(lefts.size() > 0 && rights.size() > 0)
            {
                for(TreeNode left: lefts)
                    for(TreeNode right: rights)
                    {
                        TreeNode node = new TreeNode(i);
                        node.left  = left;
                        node.right = right;
                        result.add(node);
                    }
            }
            else if(lefts.size() > 0)
            {
                for(TreeNode left: lefts)
                {
                    TreeNode node = new TreeNode(i);
                    node.left  = left;
                    node.right = null;
                    result.add(node);
                }
            }
            else
            {
                for(TreeNode right: rights)
                {
                    TreeNode node = new TreeNode(i);
                    node.left  = null;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
        UniqueBST a = new UniqueBST();
//        System.out.println(a.numTrees(1));
//        System.out.println(a.numTrees(2));
//        System.out.println(a.numTrees(3));
//        System.out.println(a.numTrees(4));
//        System.out.println(a.numTrees(5));
        List<TreeNode> trees = a.generateTrees(2);
    }

}
