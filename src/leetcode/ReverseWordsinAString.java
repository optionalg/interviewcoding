package leetcode;

public class ReverseWordsinAString
{
//	public static String reverseWords(String s)
//    {
//		if(s == null || s.isEmpty())
//			return "";
//		
//        String[] words = s.trim().split("\\s+");
//        
//        String result = new String();
//        for(int i = words.length - 1; i >= 0; --i)
//        {
//        		result += words[i];
//        		if(i > 0)
//        			result += " ";
//        }
//        return result;
//    }
	
	public static String reverseWords(String s)
    {
		if(s == null || s.isEmpty())
			return "";
		
		int i = 0;
		int len = s.length();
		String result = new String();
		while(i < len)
		{
			while(i < len && s.charAt(i) == ' ')
				i++;
			
			if(i == len)
				break;

			if(result.length() > 0)
				result = ' ' + result;
			String word = new String();
			while(i < len && s.charAt(i) != ' ')
				word += s.charAt(i++);

			result = word + result;
		}
        return result;
    }

	public static void main(String[] args)
	{
		System.out.println(reverseWords(" hello   world !!  "));
	}

}
