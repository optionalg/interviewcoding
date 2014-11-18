package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class UndirectedGraphNode
{
    public int                       label;
    public List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x)
    {
        label     = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
    
    @Override
    public String toString() {
        return "" + label;
    }
};
    
public class CloneGraph
{
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if(node == null)
            return null;
        
        Queue<UndirectedGraphNode> queue   = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode>   visited = new HashSet<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
        queue.offer(node);
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(node.label, result);
        
        while(!queue.isEmpty())
        {
            UndirectedGraphNode parent = queue.poll();
            if(visited.contains(parent))
                continue;
            visited.add(parent);
            UndirectedGraphNode parentClone = map.get(parent.label);
            
            for(UndirectedGraphNode neighbor: parent.neighbors)
            {
                if(!visited.contains(neighbor))
                {
                    queue.offer(neighbor);
                    UndirectedGraphNode neighborClone;
                    if(map.containsKey(neighbor.label))
                        neighborClone = map.get(neighbor.label);
                    else {
                        neighborClone = new UndirectedGraphNode(neighbor.label);
                        map.put(neighbor.label, neighborClone);
                    }
                    
                    parentClone.neighbors.add(neighborClone);
                    neighborClone.neighbors.add(parentClone);
                }
                else if(neighbor == parent)
                {
                    parentClone.neighbors.add(parentClone);
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        UndirectedGraphNode node0 = new UndirectedGraphNode(-1);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
//        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
//        node0.neighbors.add(node2);
        node1.neighbors.add(node0);
//        node1.neighbors.add(node2);
//        node2.neighbors.add(node0);
//        node2.neighbors.add(node1);
//        node2.neighbors.add(node2);
        UndirectedGraphNode clone = cloneGraph(node0);
    }

}
