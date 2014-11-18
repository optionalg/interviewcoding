package leetcode;

import leetcode.list.ListNode;

public class PartitionList
{

    /**
     * Given a linked list and a value x, partition it such that all nodes 
     * less than x come before nodes greater than or equal to x.
     * You should preserve the original relative order of the nodes 
     * in each of the two partitions.
     * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5. 
     */
    public ListNode partition(ListNode head, int x)
    {
        // empty list
        if(head == null || head.next == null)
            return head;
            
        // a dummy head node removes corner cases
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        // small points to the end of the smaller nodes list
        ListNode small = new ListNode(0);
        ListNode smallHead = small;

        // current node and the one before it
        ListNode current = dummyHead.next;
        ListNode tail    = dummyHead;
        
        // scan the list and move the smaller ones to the small list
        while(current != null)
        {
            if(current.val < x)
            {
                small.next = current;        // append to the small list
                small      = current;
                current    = current.next;   // bypass current
                tail.next  = current;
            }
            else
            {
                tail    = current;            // move on
                current = current.next;
            }
        }
        
        small.next = dummyHead.next;
        return smallHead.next;
    }
    
}
