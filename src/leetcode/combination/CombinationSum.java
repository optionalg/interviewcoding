package leetcode.combination;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class CombinationSum
{

	public static List<List<Integer>> 
							combinationSum(int[] candidates, int target)
	{
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		combinationSum(candidates, target, 0, current, result);
		return result;
	}
	
	private static void combinationSum(int[] candidates, int target, int start,
									   List<Integer> current,
									   List<List<Integer>> result)
	{
		if(target == 0)
		{
			result.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i = start; i < candidates.length; ++i)
		{
			if(candidates[i] > target)
				return;
			current.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, current, result);
			current.remove(current.size() - 1);
		}
	}
	
	/**
	 * Each num can only be used once
	 * Simple solution: use a set to avoid duplication
	 */
	public static List<List<Integer>> combinationSum2(int[] num, int target)
	{
        Arrays.sort(num);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        combinationSum2(num, target, 0, current, set);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.addAll(set);        
        return result;
    }
    
    private static void combinationSum2(int[] candidates, int target, int start,
                                       List<Integer> current,
                                       Set<List<Integer>> result)
    {
        if(target == 0)
        {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for(int i = start; i < candidates.length; ++i)
        {
            if(candidates[i] > target)
                return;
            current.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], i+1, current, result);
            current.remove(current.size() - 1);
        }
    }
	
	public static void main(String[] args)
	{
		int[] candidates = new int[] {1,1,2,5,6,10};
		int target = 8;
		System.out.println(combinationSum2(candidates, target));
	}

}
