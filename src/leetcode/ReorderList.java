package leetcode;

import java.util.ArrayList;

import leetcode.list.ListNode;

public class ReorderList
{

	public static void reorderList(ListNode head)
	{
		if(head == null)
			return;
		
		ArrayList<ListNode> nodes = new ArrayList<ListNode>();
		while(head != null)
		{
			nodes.add(head);
			head = head.next;
		}
		
		int i = 0;
		int j = nodes.size() - 1;
		while(i < j - 1)
		{
			nodes.get(j).next = nodes.get(i).next;
			nodes.get(i).next = nodes.get(j);
			i++;
			j--;
		}
		nodes.get(j).next = null;
    }

	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
//		ListNode node4 = new ListNode(4);
//		node1.next = node2;
//		node2.next = node3;
//		node3.next = node4;
		reorderList(node1);
	}

}
