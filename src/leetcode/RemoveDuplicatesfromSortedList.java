package leetcode;

public class RemoveDuplicatesfromSortedList
{

    /**
     * Given a sorted linked list, delete all duplicates 
     * such that each element appear only once. 
     */
    public ListNode deleteDuplicates(ListNode head)
    {
        // 0 or 1 node
        if(head == null || head.next == null)    
            return head;
            
        ListNode end     = head;
        ListNode current = end.next;
        while(current != null)
        {
            // bypass duplicated
            if(current.val == end.val)
                end.next = current.next;
            else
                end = end.next;
           
            // move on
            current = current.next;
        }
        
        return head;
    }
    
    /**
     *  Given a sorted linked list, delete all nodes that have duplicate numbers, 
     *  leaving only distinct numbers from the original list.
     *  For example, Given 1->2->3->3->4->4->5, return 1->2->5.
     */
    public ListNode deleteDuplicates2(ListNode head)
    {
        // 0 or 1 node
        if(head == null || head.next == null)
            return head;
            
        ListNode dummyHead = new ListNode(0);
        dummyHead.next     = head;
        
        ListNode tail    = dummyHead;
        ListNode current = head;
        
        while(current != null)
        {
            // found duplicates, search for the range
            if(current.next != null && current.next.val == current.val)
            {
                // keep moving current until the next is different
                while(current.next != null && current.next.val == current.val)
                    current = current.next;
                
                // bypass current
                tail.next = current.next;
            }
            else
                tail = current;
                
            current = current.next;
        }
        
        return dummyHead.next;
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
