import java.math.BigInteger;
import java.util.ArrayList;


public class AllSubsets
{
	public static ArrayList<String> getAllSubsets(String set)
	{
		ArrayList<String> result = new ArrayList<String>();
		int n = set.length();
		if(n < 1)
			return result;
		
		// generate 0 - 2^n-1
		int max = (int) Math.pow(2, n);
		for(BigInteger i = new BigInteger("0");
			i.compareTo(BigInteger.valueOf(max)) < 0; 
			i = i.add(new BigInteger("1")))
		{
			// for each i, check the bits and generate an output
			String output = new String();
			for(int j=0; j<n; ++j)
				if(i.testBit(j))
					output += set.charAt(j);
			result.add(output);
		}
		
		return result;
	}
	
	public static ArrayList<String> getAllSubsets2(String set)
	{
		ArrayList<String> result = new ArrayList<String>();
		int n = set.length();
		if(n < 1)
			return result;
		
		// for each char in the set
		for(int i = 0; i < set.length(); ++i)
		{
			// pick one as the start
			result.add("" + set.charAt(i));
			
			// get the subsets of the rest chars
			ArrayList<String> subsets = getAllSubsets2(set.substring(i+1));
			
			// append to the start
			for(String s: subsets)
				result.add(set.charAt(i) + s);
		}
		return result;
	}
	
	public static void main(String[] argvs)
	{
		System.out.println(getAllSubsets2("ABC"));
	}
}