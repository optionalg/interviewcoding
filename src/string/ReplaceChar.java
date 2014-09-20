package string;

/**
 * Replace all the instances of a char in a string to a string
 */
public class ReplaceChar
{
	public static void replaceChar(StringBuffer str, char from, String to)
	{
		// calculate the new length of the str
		int count = 0;
		for(int i = 0; i < str.length(); ++i)
			if(str.charAt(i) == from)
				count ++;
		
		// resize the str
		int src = str.length() - 1;
		str.setLength(str.length() + count * (to.length() - 1));
		
		// copy the chars from back to front
		int dst = str.length() - 1;
		while(src >= 0)
		{
			if(str.charAt(src) != from)
				str.setCharAt(dst--, str.charAt(src--));
			else
			{
				for(int i = to.length() - 1; i >= 0; --i)
					str.setCharAt(dst--, to.charAt(i));
				src --;
			}
		}
	}
	
	public static void replaceSubString(StringBuffer str, String from, String to)
	{
		if(from.length() <= to.length())
		{
			// count the instances of from
			int count = 0;
			int i = str.indexOf(from);
			while(i > -1)
			{
				count ++;
				i = str.indexOf(from, i + 1);
			}
			
			// resize the string
			int src = str.length() - 1;
			str.setLength(str.length() + count * (to.length() - from.length()));
			
			// copy the chars from back to front
			int dst = str.length() - 1;
			while(src >= from.length() - 1)
			{
				// try to find from
				int j;
				for(j = 0; j < from.length(); ++j)
					if(from.charAt(j) != str.charAt(src - from.length() + 1 + j))
						break;
				
				// no match
				if(j < from.length())
					str.setCharAt(dst--, str.charAt(src--));
				// found a match
				else {
					for(int k = to.length() - 1; k >= 0; --k)
						str.setCharAt(dst--, to.charAt(k));
					src -= to.length() - 1;
				}
			}
		}
		else
		{
			
		}
	}

	public static void main(String[] args)
	{
		StringBuffer str = new StringBuffer("aaaaa");
		replaceSubString(str, "aa", "XYZ");
		System.out.println(str);
	}

}
