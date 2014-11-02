package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReverseLinkedList
{
	/**
	 * Reverse a linked list from position m (1 based) to n. 
	 * Do it in-place and in one-pass.
	 */
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if(head == null || m == n)
            return head;    
            
        // create a header node to remove corner cases (m==1)
        ListNode header = new ListNode(0);
        header.next = head;
        
        // find the start node (the m-1 th node)
        ListNode start = header;
        int i;
        for(i = 1; i <= m - 1; ++i)
             start = start.next;
            
        // reverse the links until right reaches the nth node
        ListNode left  = start.next;
        ListNode right = start.next.next;
        for(; i <= n - 1; ++i)
        {
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }

        // reconnect the reversed part
        start.next.next = right;
        start.next = left;
        return header.next;
    }
    
    public static void main(String[] args)
    {
    }
}