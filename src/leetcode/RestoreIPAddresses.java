package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses
{

    public List<String> restoreIpAddresses(String s)
    {
        List<String> result = new ArrayList<String>();
        if(s == null || s.isEmpty() || s.length() < 4)
            return result;
            
        List<String> sections = new ArrayList<String>();
        restore(s, 0, sections, result);
        return result;
    }
    
    private void restore(String s, int start, List<String> sections, List<String> result)
    {
        if(sections.size() == 4)
        {
        		if(start < s.length() - 1)
        			return;
            result.add(String.join(".", sections));
            return;
        }
        
        for(int len = 1; len <= 3 && start + len < s.length(); ++len)
        {
            String section = s.substring(start, start + len);
            if(isValidSection(section))
            { 
                List<String> temp = new ArrayList<String>();
                temp.addAll(sections);
                temp.add(section);
                restore(s, start + len, temp, result);
            }
        }
    }
    
    private boolean isValidSection(String section)
    {
        int value = Integer.valueOf(section);
        return 0 <= value && value <= 255;
    }
    
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
