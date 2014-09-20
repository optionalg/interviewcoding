import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum
{

	public static ArrayList<ArrayList<Integer>> 
							combinationSum(int[] candidates, int target)
	{
		Arrays.sort(candidates);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		combinationSum(candidates, target, 0, current, result);
		return result;
	}
	
	private static void combinationSum(int[] candidates, int target, int start,
									   ArrayList<Integer> current,
									   ArrayList<ArrayList<Integer>> result)
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
	
	
	public static void main(String[] args)
	{
		int[] candidates = new int[] {2,3,6,7};
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}

}
