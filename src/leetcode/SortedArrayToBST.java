package leetcode;

import leetcode.tree.TreeNode;

public class SortedArrayToBST
{

    public static TreeNode sortedArrayToBST(int[] num) {
        return build(num, 0, num.length - 1);
    }
    
    private static TreeNode build(int[] num, int left, int right)
    {
        if(left > right)
            return null;
        
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left  = build(num, left,    mid - 1);
        root.right = build(num, mid + 1, right);
        return root;
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
