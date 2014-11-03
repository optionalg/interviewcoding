package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses
{

	/**
	 * Restore an ip address without separator to all possible separated format
	 * e.g., 19216801 -> 192.168.0.1, 19.21.68.01, ...
	 */
    public List<String> restoreIpAddresses(String s)
    {
        List<String> result = new ArrayList<String>();
        if(s == null || s.isEmpty() || s.length() < 4)
            return result;
            
        List<String> sections = new ArrayList<String>();
        restore(s, 0, sections, result);
        return result;
    }
    
    /**
     * Recursive method
     * @param s			the string
     * @param start		start index
     * @param sections	temp for currently collected sections
     * @param result	result
     */
    private void restore(String s, int start, List<String> sections, List<String> result)
    {
    	// have collected 4 sections
        if(sections.size() == 4)
        {
        	// and the input string is exhausted, add the sections as a result
        	if(start == s.length())
        		result.add(sections.get(0) + "." + 
        				   sections.get(1) + "." + 
        				   sections.get(2) + "." + 
        				   sections.get(3));
        	// otherwise just return
            return;
        }
        
        // try start ~ start + 2 as current section
        for(int len = 1; len <= 3 && start + len <= s.length(); ++len)
        {
            String section = s.substring(start, start + len);
            if(isValidSection(section))
            { 
                sections.add(section);
                restore(s, start + len, sections, result);
                sections.remove(sections.size() - 1);
            }
        }
    }
    
    /**
     * Check if a section is valid
     * 0-255
     * no leading 0 (0XX), unless the whole section is 0
     */
	private boolean isValidSection(String section)
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
