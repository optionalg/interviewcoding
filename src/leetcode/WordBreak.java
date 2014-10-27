package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak
{
//	public static boolean wordBreak(String s, Set<String> dict)
//	{
//		if(s.isEmpty())
//			return true;
//		if(dict.isEmpty())
//			return false;
//		
//		for(int i = 1; i <= s.length(); ++i)
//		{
//			String sub = s.substring(0, i);
//			if(dict.contains(sub))
//			{
//				String rest = s.substring(i);
//				if(wordBreak(rest, dict))
//					return true;
//			}
//		}
//		return false;
//    }
    
    /**
     * Given a string s and a dictionary of words dict, 
     * determine if s can be segmented into a sequence of one or more dictionary words.
     * e.g., dict = {"a", "aa", "aab"}, s = "aaaab", return true (aa, aab)
     * 
     * Use DP
     * breakable[i] represents whether substring i..n-1 is breakable
     * breakable[n-1] = dict.contains(s.charAt[n-1])
     * The final result is breakable[0]
     */
    public static boolean wordBreak(String s, Set<String> dict)
    {
        if(s.isEmpty())
            return true;
        if(dict.isEmpty())
            return false;

        boolean[] breakable = new boolean[s.length()];
        breakable[s.length() - 1] = dict.contains("" + s.charAt(s.length() - 1));
        
        for(int i = s.length() - 2; i >= 0; --i)
            for(int k = i + 1; k <= s.length(); ++k)
            {
                // take s[i..k-1] out
                String word = s.substring(i, k);
                if(dict.contains(word))
                {
                    // the rest is s[k..n-1]
                    String rest = s.substring(k);
                    if(rest.isEmpty())      // empty string is breakable
                        breakable[i] = true;
                    else if(breakable[k])   // s[k...n-1] is breakable
                        breakable[i] = true;
                }
            }
        
        return breakable[0];
    }
    
	public static void main(String[] args)
	{
		String[] dict = new String[]{"a"};
		boolean result = wordBreak("a", new HashSet<String>(Arrays.asList(dict)));
		System.out.println(result);
	}

}
