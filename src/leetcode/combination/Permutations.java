package leetcode.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations
{

    private void swap(List<Integer> num, int i, int j)
    {
        if(i != j)
        {
            // swap
            Collections.swap(num, i, j);
            
            // sort i-1 ... j
            // to ensure the result is lexicographically sorted
            Collections.sort(num.subList(i+1, j+1));
        }
    }
    
    public List<List<Integer>> permute(int[] num)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < num.length; ++i)
            array.add(num[i]);
        permute(array, 0, result);
        return result;
    }
    
    private void permute(List<Integer> num, int start, List<List<Integer>> result)
    {
        if(start == num.size())
            result.add(new ArrayList<Integer>(num));
        else
            for(int i = start; i < num.size(); ++i)
            {
                List<Integer> temp = new ArrayList<Integer>(num);
                swap(temp, start, i);
                permute(temp, start + 1, result);
            }
    }
    
    public static void main(String[] args)
    {
        Permutations p = new Permutations();
        System.out.println(p.permute(new int[]{1,2,3,4}));
    }

}
