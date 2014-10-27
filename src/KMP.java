public class KMP
{

	private static int match(String base, String pattern, int start)
	{
		if(base == null || base.isEmpty() || pattern == null || pattern.isEmpty())
			return 0;
		
		int[] next = calculateNext(pattern);
		int i = start;
		int j = 0;
		while(i < base.length() && j < pattern.length())
		{
			if(j == -1 || base.charAt(i) == pattern.charAt(j))
			{
				i ++;
				j ++;
			}
			else
				j = next[j];
		}
		return j == pattern.length() ? i - pattern.length() : -1;
	}
	
	private static int[] calculateNext(String str)
	{
		if(str == null || str.isEmpty())
			return null;
		
		int[] next = new int[str.length()];
		int k = -1;
		int j = 0;
		next[j] = k;
		while(j < str.length() - 1)
		{
			if(k == -1 || str.charAt(j) == str.charAt(k))
			{
				k++;
				j++;
		    	next[j] = k;
			}
			else
				k = next[k];
		}
		return next;
	}
	
	public static void main(String[] args)
	{
		String base    = new String("abcabcabdc");
		String pattern = new String("abcabd");
		System.out.println(match(base, pattern, 0));
	}

}
