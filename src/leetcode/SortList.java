package leetcode;

class ListNode
{
	public int      val;
	public ListNode next;

	ListNode(int x)
	{
		val  = x;
		next = null;
	}
}

public class SortList
{
	public static ListNode sortList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		ListNode mid = findMiddle(head);
		ListNode head1 = sortList(head);
		ListNode head2 = sortList(mid);
		return merge(head1, head2);
	}
	
	/**
	 * Merge 2 parts of sorted single linked list
	 * @return the head of the sorted list
	 */
	private static ListNode merge(ListNode head1, ListNode head2)
	{
		ListNode result = new ListNode(0);
		ListNode tail = result;
		while(head1 != null && head2 != null)
		{
			if(head1.val < head2.val)
			{
				tail.next = head1;
				head1 = head1.next;
				tail = tail.next;
			}
			else
			{
				tail.next = head2;
				head2 = head2.next;
				tail = tail.next;
			}
		}
		
		if(head1 == null)
			tail.next = head2;
		else
			tail.next = head1;
		
		return result.next;
	}
	
	/**
	 * Find the middle node of a list and split the original list into 2
	 */
	private static ListNode findMiddle(ListNode list)
	{
		ListNode fast = list;
		ListNode slow = list;
		ListNode tail = list;
		while(fast != null && fast.next != null)
		{
			fast = fast.next.next;
			tail = slow;
			slow = slow.next;
		}
		tail.next = null;
		return slow;
	}

	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(5);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode result = sortList(node1);
	}

}
