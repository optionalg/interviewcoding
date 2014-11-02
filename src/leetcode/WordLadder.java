package leetcode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class QueueEntry
{
    QueueEntry(String word, QueueEntry parent)
    {
        this.word   = word;
        this.parent = parent;
    }
    
    ArrayList<String> print()
    {
        ArrayList<String> result = new ArrayList<String>();
        QueueEntry entry = this;
        while(entry != null)
        {
            result.add(entry.word);
            entry = entry.parent;
        }
        Collections.reverse(result);
        return result;
    }
    
    String      word;
    QueueEntry  parent;  
}

public class WordLadder
{

	public static ArrayList<String> wordLadder(String start, String end, 
											   HashSet<String> dict)
	{
		if(start == null || start.isEmpty() || end == null || end.isEmpty())
			return null;

		Queue<QueueEntry> queue = new LinkedList<QueueEntry>();
	    QueueEntry root = new QueueEntry(start, null);
        queue.add(root);
	    
	    while(!queue.isEmpty())
	    {
	        QueueEntry node = queue.poll();
	        if(node.word.equals(end))
	            return node.print();
	        
	        start = node.word;
	        for(int i = 0; i < start.length(); ++i)
	        {
	            for(char c = 'a'; c <= 'z'; ++c)
	            {
	                char[] buffer = start.toCharArray();
	                if(c != buffer[i])   // not the same as parent
	                {
	                    buffer[i] = c;   // generate a child candidate
	                    
	                    // found the path
	                    if(end.equals(new String(buffer)))
	                        return new QueueEntry(end, node).print();
	                    
	                    // get a new child
	                    if(!dict.contains(new String(buffer)))
	                        continue;
	                    
	                    // add the child to queue
	                    QueueEntry child = new QueueEntry(new String(buffer), node);
	                    queue.add(child);
	                }
	            }
	        }
	    }
		
		return null;
	}
	
	public static void main(String[] args)
	{
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(wordLadder("hit", "cog", dict));
	}

}
