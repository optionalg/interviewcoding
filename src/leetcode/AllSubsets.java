package leetcode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AllSubsets
{
	/**
	 * Generate all subsets of a set (chars in a String)
	 * Uses a bit bucket to represent what char to keep
	 * e.g., for "abc", 101 means ac
	 * Then, generate all the numbers from 0 to 2^n-1
	 * Each number represents a subset
	 */
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
			for(int j = 0; j < n; ++j)
				if(i.testBit(j))
					output += set.charAt(j);
			result.add(output);
		}
		
		return result;
	}
	
	/**
	 * Another way is to use recursion
	 */
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
	
	/**
	 * The 3rd method, also recursive
	 */
	public static List<List<Integer>> subsets(int[] S)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null || S.length == 0)
            return result;
            
        Arrays.sort(S);
        List<Integer> temp = new ArrayList<Integer>();
        subsets(S, 0, temp, result);
        return result;
    }
    
    private static void subsets(int[] S, int start, List<Integer> temp, List<List<Integer>> result)
    {
        if(start == S.length)
        {
            result.add(temp);
            return;
        }
        
        // not choose S[start]
        subsets(S, start + 1, temp, result);
        
        // choose S[start]
        List<Integer> newTemp = new ArrayList<Integer>(temp);
        newTemp.add(S[start]);
        subsets(S, start + 1, newTemp, result);
    }
    
    /**
     * 4th method, DP
     */
    public static List<List<Integer>> subsets2(int[] S)
    {
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null || S.length == 0)
            return result;
        
        Arrays.sort(S);
        result.add(new ArrayList<Integer>());
        for(int i = 0; i < S.length; ++i)
        {
        		int size = result.size();
        		for(int j = 0; j < size; ++j)
        		{
        			List<Integer> newSet = new ArrayList<Integer>(result.get(j));
        			newSet.add(S[i]);
        			result.add(newSet);
        		}
        }
        return result;
    }
    
    /**
     * S may contains duplicated numbers
     */
    public List<List<Integer>> subsetsWithDup(int[] S)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null || S.length == 0)
            return result;
        
        Arrays.sort(S);
        int start = 0;
        result.add(new ArrayList<Integer>());
        for(int i = 0; i < S.length; ++i)
        {
        		int size = result.size();
        		int j = i > 0 && S[i] != S[i-1] ? 0 : start;
        		start = size;
        		for(; j < size; ++j)
        		{
        			List<Integer> newSet = new ArrayList<Integer>(result.get(j));
        			newSet.add(S[i]);
        			result.add(newSet);
        		}
        }
        return result;
    }
	
	public static void main(String[] argvs)
	{
//		System.out.println(getAllSubsets("ABC"));
		System.out.println(subsets2(new int[]{1,2,2}));
	}
}