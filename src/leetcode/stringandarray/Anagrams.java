package leetcode.stringandarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams
{

	/**
	 * Collect all anagrams
	 * e.g., abc, cba, bac are anagrams
	 * Store anagram groups in a hashmap: key -> list
	 * Sort each word and use the sorted word as the key for the hashmap
	 */
    public static List<String> anagrams(String[] strs)
    {
        if(strs.length == 0)
            return new ArrayList<String>();
            
        Map<String, List<String>> hash = new HashMap<String, List<String>>();
        for(String str: strs)
        {
        		// sort the word
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            // check for existing group
            List<String> list = hash.get(sorted);
            if(list == null)
            {
                list = new ArrayList<String>();
                list.add(str);
                hash.put(sorted, list);
            }
            else {
                list.add(str);
            }
        }
        
        // output groups with 1+ words
        List<String> result = new ArrayList<String>();
        for(List<String> list: hash.values())
            if(list.size() > 1)
                result.addAll(list);
                
        return result;
    }
    
    public static void main(String[] args)
    {
    		System.out.println(anagrams(new String[]{"ba", "ab"}));
    }

}
