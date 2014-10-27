package leetcode;

public class LongestCommonPrefix
{

	public String longestCommonPrefix(String[] strs)
    {
        if(strs == null || strs.length == 0)
            return "";
            
        if(strs.length == 1)
            return strs[0];
        
        String result = new String();
        boolean stop = false;
        int i = 0;
        while(!stop)
        {
            if(i >= strs[0].length())
                break;
            char ch = strs[0].charAt(i);
            
            for(int j = 1; j < strs.length; ++j)
            {
                if(i >= strs[j].length() || strs[j].charAt(i) != ch)
                {
                    stop = true;
                    break;
                }
            }
            if(!stop)
            {
                result += ch;
                ++ i;
            }
        }
        return result;
    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
