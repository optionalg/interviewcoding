package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Pair implements Comparable<Pair>
{
    int first;
    int second;
    int[] num;
    
    public Pair(int f, int s, int[] n)
    {
        first  = f;
        second = s;
        num = n;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;
        
        if(!(obj instanceof Pair))
            return false;
        
        Pair that = (Pair) obj;
        return this.first  == that.first &&
               this.second == that.second;
    }

    @Override
    public int compareTo(Pair that) {
        return num[this.first] - that.num[that.first];
    }
    
    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}

public class FourSum
{
    public static List<List<Integer>> fourSum(int[] num, int target)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; ++i)
        {
            if(i > 0 && num[i] == num[i - 1]) // avoid duplication
                continue;
            for(int j = i + 1; j < num.length; ++j)
            {
                if(j > i + 1 && num[j] == num[j - 1]) // avoid duplication
                    continue;
            
                for(int k = j + 1; k < num.length; ++k)
                {
                    if(k > j + 1 && num[k] == num[k - 1]) // avoid duplication
                        continue;
                    int l = binarySearch(num, target - num[i] - num[j] - num[k], k + 1, num.length - 1);
                    if(l != -1)
                    {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[l]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
    
    private static int binarySearch(int[] num, int target, int left, int right)
    {
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(num[mid] == target)
                return mid;
            else if(target < num[mid])
                right = mid - 1;
            else if(target > num[mid])
                left = mid + 1;
        }
        return left == right && num[left] == target ? left : -1;
    }
    
    /**
     * Use a hash map to find the 3rd
     */
    public static List<List<Integer>> fourSum2(int[] num, int target)
    {
        Arrays.sort(num);
        
        // pair sum -> list of pairs
        Map<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
        for(int i = 0; i < num.length; ++i)
            for(int j = i+1; j < num.length; ++j)
            {
                int sum = num[i] + num[j];
                Pair pair = new Pair(i, j, num);
                List<Pair> set = map.get(sum);
                if(set == null)
                {
                    set = new ArrayList<Pair>();
                    set.add(pair);
                    map.put(sum, set);
                }
                else
                    set.add(pair);
            }
        
        Set<List<Integer>> result = new TreeSet<List<Integer>>();
        for(int i = 0; i < num.length; ++i)
        {
            if(i > 0 && num[i] == num[i-1])
                continue;
            
            for(int j = i+1; j < num.length; ++j)
            {
                if(j > i+1 && num[j] == num[j-1])
                    continue;
                
                List<Pair> pairs = map.get(target - num[i] - num[j]);
                if(pairs != null)
                {
                    for(Pair pair: pairs)
                    {
                        if(pair.first > j)
                        {
                            List<Integer> list = new ArrayList<Integer>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[pair.first]);
                            list.add(num[pair.second]);
                            result.add(list);
                        }
                    }
                }
            }
        }
//        List<List<Integer>> list = new ArrayList<List<Integer>>();
//        list.addAll(result);
//        return list;
        return null;
    }

    public static void main(String[] args)
    {
//        System.out.println(fourSum (new int[]{-3,-2,-1,0,0,1,2,3}, 0));
//        System.out.println(fourSum2(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        System.out.println(fourSum2(new int[]{0,0,0,0}, 0));
    }

}
