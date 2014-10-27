package leetcode;

public class LinkedListCycle
{

	public static boolean hasCycle(ListNode head) {
        return detectCycle(head) != null;
    }
	
	public static ListNode detectCycle(ListNode head)
	{
		if(head == null || head.next == null)
			return null;
		
		if(head.next == head)
			return head;
		
		ListNode next = head.next;
		while(next != null)
		{
			if(next.next == next)
				return next;
			head.next = head;
			head = next;
			next = next.next;
		}
		return null;
    }

	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node1;
		ListNode node = detectCycle(node1);
	}

}
