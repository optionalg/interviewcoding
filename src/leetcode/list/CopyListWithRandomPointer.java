package leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 *  A linked list is given such that each node contains an additional 
 *  random pointer which could point to any node in the list or null.
 *  Return a deep copy of the list. 
 */

// Definition for singly-linked list with a random pointer.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class CopyListWithRandomPointer
{
    /**
     * The 1st solution uses a hash table to save the locations of the values,
     * so that we can find the node that the random pointer points to
     */
    public RandomListNode copyRandomList(RandomListNode head)
    {
        if(head == null)
            return null;
            
        // a hashtable to save the location(reference) of each value
        Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        
        // clone the list without the random pointers
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode tail = dummyHead;
        RandomListNode node = head;
        RandomListNode clone = null;
        while(node != null)
        {
            // clone current node
            clone = new RandomListNode(node.label);
            
            // save the location of the value
            map.put(clone.label, clone);
            
            // append the cloned node to the end of the cloned list
            tail.next = clone;
            tail = clone;
            
            node = node.next;
        }
        
        // scan the clone list and set the random pointers
        node  = head;
        clone = dummyHead.next;
        while(node != null)
        {
            // find the corresponding random node in the cloned list
            if(node.random != null)
            {
                RandomListNode random = map.get(node.random.label);
                clone.random = random;
            }
            
            node  = node.next;
            clone = clone.next;
        }

        return dummyHead.next;
    }
    
    /**
     * Reuse the next and random pointers
     * 
     * Clone the list without the random pointers, 
     * and set clone.random=node, node.next=clone
     * 
     * Then scan the clone list and reset the random pointers
     */
    public RandomListNode copyRandomList2(RandomListNode head)
    {
        if(head == null)
            return null;
            
        // clone the list without the random pointers
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode tail = dummyHead;
        RandomListNode node = head;
        RandomListNode clone = null;
        while(node != null)
        {
            // clone current node
            clone = new RandomListNode(node.label);
            
            // append the cloned node to the end of the cloned list
            tail.next = clone;
            tail = clone;
            
            // set clone.random to node, and node.next to clone
            clone.random = node;
            RandomListNode temp = node.next;
            node.next = clone;
            
            node = temp;
        }
        
        // scan the clone list and re-set the random pointers
        clone = dummyHead.next;
        while(clone != null)
        {
            // find the original node
            node = clone.random;
            
            // find the random node in the original list
            RandomListNode random = node.random;
            
            // re-set clone.random
            if(random != null)
                clone.random = random.next;

            clone = clone.next;
        }

        return dummyHead.next;
    }
}
