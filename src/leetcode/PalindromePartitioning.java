package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning
{

	/**
	 * Get all possible partitions of a given string that all sections are palindrome
	 */
    public static List<List<String>> partition(String s)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.isEmpty())
            return result;

        partition(s, new ArrayList<String>(), result);
        return result;
    }

    private static void partition(String s, List<String> t,
            						  List<List<String>> result)
    {
        if(s.isEmpty())
        {
            result.add(new ArrayList<String>(t));
            return;
        }
        if(s.length() == 1)
        {
            t.add(s);
            result.add(new ArrayList<String>(t));
            t.clear();
            return;
        }

        for(int i = 1; i <= s.length(); ++i)
        {
            String first = s.substring(0, i);
            if(isPalindrome(first))
            {
                List<String> temp = new ArrayList<String>(t);
                temp.add(first);
                String second = s.substring(i);
                partition(second, temp, result);
            }
        }
    }

    private static boolean isPalindrome(String str)
    {
        int left  = 0;
        int right = str.length() - 1;
        while(left < right)
            if(str.charAt(left++) != str.charAt(right--))
                return false;
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(partition("aabba"));
    }

}
