package leetcode;

public class InsertionSortList
{
	/**
	 * Sort the list using insertion sort
	 */
	public static ListNode insertionSortList(ListNode head)
	{
		ListNode result = new ListNode(0);
		
		while(head != null)
		{
			ListNode next = head.next;
			
			// insert head to result
			insert(result, head);
			
			// move to the next node
			head = next;
		}
		
		return result.next;
	}
	
	/**
	 * Insert the given node into a sorted list
	 */
	private static void insert(ListNode head, ListNode node)
	{
		// find the first node that is greater than the given one
		while(head.next != null)
		{
			if(head.next.val > node.val)
				break;
			head = head.next;
		}
		
		// insert
		node.next = head.next;
		head.next = node;
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
		ListNode result = insertionSortList(node1);
	}

}
