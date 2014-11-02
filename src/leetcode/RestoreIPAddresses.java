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
        	if(start == s.length())
        		result.add(sections.get(0) + "." + 
        				   sections.get(1) + "." + 
        				   sections.get(2) + "." + 
        				   sections.get(3));
            return;
        }
        
        for(int len = 1; len <= 3 && start + len <= s.length(); ++len)
        {
            String section = s.substring(start, start + len);
            if(isValidSection(section, sections.size() - 1))
            { 
                List<String> temp = new ArrayList<String>();
                temp.addAll(sections);
                temp.add(section);
                restore(s, start + len, temp, result);
            }
        }
    }
    
    private boolean isValidSection(String section, int index)
    {
        int value = Integer.valueOf(section);
        if(value < 0 || value > 255)
        	return false;
        if(section.length() > 1 && section.charAt(0) == '0')
        	return false;
        return true;
    }
    
	public static void main(String[] args)
	{
		RestoreIPAddresses a = new RestoreIPAddresses();
		System.out.println(a.restoreIpAddresses("98765"));
		System.out.println(a.restoreIpAddresses("25525522235"));
		System.out.println(a.restoreIpAddresses("0000"));
		System.out.println(a.restoreIpAddresses("010010"));
	}

}
