import java.util.ArrayList;


public class Permutation
{

	private static String swap(String str, int i, int j)
	{
		if(i == j)
			return str;
		
		StringBuilder builder = new StringBuilder(str);
		char c = str.charAt(i);
		builder.setCharAt(i, builder.charAt(j));
		builder.setCharAt(j, c);
		return builder.toString();
	}
	
	public static ArrayList<String> permutation(String str)
	{
		ArrayList<String> result = new ArrayList<String>();
		if(str.isEmpty())
			return result;
		if(str.length() == 1)
		{
			result.add(str);
			return result;
		}
		
		for(int i = 0; i < str.length(); ++i)
		{
			String s = swap(str, 0, i);
			ArrayList<String> subPermutation = permutation(s.substring(1));
			for(String p: subPermutation)
				result.add(s.charAt(0) + p);
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(permutation("ABC"));
	}

}
