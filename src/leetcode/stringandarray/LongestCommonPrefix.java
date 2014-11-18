package leetcode.stringandarray;

public class LongestCommonPrefix
{

	/**
	 * Get the longest common prefix of a list of strings
	 */
	public static String longestCommonPrefix(String[] strs)
    {
        if(strs == null || strs.length == 0)
            return "";
            
        if(strs.length == 1)
            return strs[0];
        
        String result = new String();
        for(int i = 0; i < strs[0].length(); ++i)
        {
        		// get the current char of the 1st string
        		char ch = strs[0].charAt(i);
        		
        		// for the remaining strings
        		// check if the corresponding chars are the same as ch
        		for(int j = 1; j < strs.length; ++j)
                    if(i >= strs[j].length() || strs[j].charAt(i) != ch)
                        return result;
        		result += ch;
        }
        
        
        return result;
    }
	
	public static void main(String[] args)
	{
		System.out.println(longestCommonPrefix(new String[]{"hello", "her", "hell"}));
	}

}
