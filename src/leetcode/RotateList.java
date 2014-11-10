package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RotateList
{
    public ListNode rotateRight(ListNode head, int n)
    {
        if(head == null)
            return null;
            
        List<ListNode> nodes = new ArrayList<ListNode>();
        ListNode node = head;
        while(node != null)
        {
            nodes.add(node);
            node = node.next;
        }
        
        n = n % nodes.size();
        if(n == 0)
            return head;
            
        nodes.get(nodes.size() - 1).next = nodes.get(0);
        nodes.get(nodes.size() - n - 1).next = null;
        return nodes.get(nodes.size() - n);
    }
}
