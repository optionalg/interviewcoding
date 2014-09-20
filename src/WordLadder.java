import java.util.ArrayList;
import java.util.HashSet;


public class WordLadder
{

	public static ArrayList<ArrayList<String>> wordLadder(String start, String end, 
														  HashSet<String> dict)
	{
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>(); 
		if(start == null || start.isEmpty() || end == null || end.isEmpty())
			return result;
		
		ArrayList<String> path = new ArrayList<String>();
		wordLadder(start, end, dict, path, result);
		return result;
	}
	
	private static void wordLadder(String start, String end,
								   HashSet<String> dict, ArrayList<String> path,
								   ArrayList<ArrayList<String>> result)
	{
		path.add(start);
		if(start.equals(end))
		{
			result.add(path);
			path.remove(path.size() - 1);
			return;
		}
		
		for(int i = 0; i < start.length(); ++i)
		{
        		for(char c = 'a'; c <= 'z'; ++c)
        		{
        			StringBuffer buffer = new StringBuffer(start);
        			if(c != buffer.charAt(i))
        			{
        				buffer.setCharAt(i, c);
        				if(!dict.contains(buffer.toString()))
        					continue;
        				if(path.size() <= 1 || !path.get(path.size()-2).equals(buffer.toString()))
        					wordLadder(buffer.toString(), end, dict, path, result);
        			}
        		}
		}
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
