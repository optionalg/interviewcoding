package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams
{

    public List<String> anagrams(String[] strs)
    {
        if(strs.length == 0)
            return new ArrayList<String>();
            
        Map<String, List<String>> hash = new HashMap<String, List<String>>();
        for(String str: strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
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
        
        List<String> result = new ArrayList<String>();
        for(List<String> list: hash.values())
            if(list.size() > 1)
                result.addAll(list);
                
        return result;
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
