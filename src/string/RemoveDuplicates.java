package string;

import java.util.HashSet;

/**
 * Remove all duplicated chars in a given string
 */
public class RemoveDuplicates
{

	/**
	 * Do it without extra storage
	 * Use last to hold the appending position
	 * For each i, check duplication in 0~i-1
	 * Copy str[i] to str[last] if no duplication, and i++, last ++
	 * Otherwise, i++
	 * Time: O(n^2)
	 * Space: O(1)
	 */
	public static void removeDuplicates(StringBuffer str)
	{
		if(str == null || str.length() < 2)
			return;
		
		int last = 1;
		for(int i = 1; i < str.length(); ++i)
		{
			int j;
			// search the prefix before i for duplicates
			for(j = 0; j < i; ++j)
			{
				// if duplicated, ignore current char
				if(str.charAt(j) == str.charAt(i))
					break;
			}
			
			// no duplication for i
			if(j == i)
			{
				str.setCharAt(last, str.charAt(i));
				last ++;
			}
		}
		
		str.setLength(last);
	}
	
	/**
	 * Use a HashSet or bucket to count
	 * Time: O(n)
	 * Space: O(m), m = range
	 */
	public static void removeDuplicatesUsingStorage(StringBuffer str)
	{
		if(str == null || str.length() < 2)
			return;
		
		HashSet<Character> set = new HashSet<Character>();
		set.add(str.charAt(0));
		int last = 1;
		for(int i = 1; i < str.length(); ++i)
		{
			char ch = str.charAt(i);
			if(!set.contains(ch))
			{
				str.setCharAt(last, ch);
				set.add(ch);
				last ++;
			}
		}
		
		str.setLength(set.size());
	}
	
	public static void main(String[] args)
	{
		StringBuffer str = new StringBuffer("zeabeccdaai");
		removeDuplicatesUsingStorage(str);
		System.out.println(str);
	}

}
