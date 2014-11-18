package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.list.ListNode;

public class SortedListToBST
{

    public static TreeNode sortedListToBST(ListNode head)
    {
        List<Integer> list = new ArrayList<Integer>();
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); ++i)
            array[i] = list.get(i);
        return SortedArrayToBST.sortedArrayToBST(array);
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
