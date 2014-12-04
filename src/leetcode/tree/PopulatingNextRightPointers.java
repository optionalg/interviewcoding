package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL
 */

class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }
 
class QueueNode
{
    TreeLinkNode node;
    int          level;
    
    QueueNode(TreeLinkNode node, int level)
    {
        this.node  = node;
        this.level = level;
    }
}

public class PopulatingNextRightPointers
{
    public void connect(TreeLinkNode root)
    {
        if(root == null || root.left == null && root.right == null)
            return;
        
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
        queue.offer(new QueueNode(root, 1));
        
        QueueNode prev = null;
        while(!queue.isEmpty())
        {
            // do the threading
            QueueNode current = queue.poll();
            if(prev != null && prev.level == current.level)
                prev.node.next = current.node;
            prev = current;
            
            // add 2 children to the queue
            if(current.node.left != null)
                queue.offer(new QueueNode(current.node.left,  current.level + 1));
            if(current.node.right != null)
                queue.offer(new QueueNode(current.node.right, current.level + 1));
        }
    }
}