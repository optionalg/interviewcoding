package leetcode;

public class StrStr
{
	public static int strStr(String haystack, String needle)
	{
		if(haystack == null || haystack.isEmpty() || needle == null || needle.isEmpty())
			return -1;
		
		int i = 0; 
		int j = 0;
		while(i < haystack.length() && j < needle.length())
		{
			if(haystack.charAt(i) == needle.charAt(j))
			{
				i ++;
				j ++;
			}
			else
			{
				i -= j - 1;
				j = 0;
			}
		}
		if(j == needle.length())
			return i - j;
		return -1;
	}
	
	public static void main(String[] args)
	{
		System.out.println(strStr("abdabbcce", "abc"));
	}

}
