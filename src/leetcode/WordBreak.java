package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak
{
	public static boolean wordBreak(String s, Set<String> dict)
	{
		if(s.isEmpty())
			return true;
		if(dict.isEmpty())
			return false;
		
		for(int i = 1; i <= s.length(); ++i)
		{
			String sub = s.substring(0, i);
			if(dict.contains(sub))
			{
				String rest = s.substring(i);
				if(wordBreak(rest, dict))
					return true;
			}
		}
		return false;
    }

	public static void main(String[] args)
	{
		String[] dict = new String[]{"a", "aa", "aaa", "aaab"};
		boolean result = wordBreak("aaaaaab", new HashSet<String>(Arrays.asList(dict)));
		System.out.println(result);
	}

}
