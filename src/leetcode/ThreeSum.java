package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum
{

    /**
     * Sort and use binary search for the 3rd number
     */
    public static List<List<Integer>> threeSum(int[] num)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; ++i)
        {
            if(i > 0 && num[i] == num[i-1])  // avoid duplication
                continue;
            for(int j = i+1; j < num.length; ++j)
            {
                if(j > i+1 && num[j] == num[j-1])  // avoid duplication
                    continue;
                int k = binarySearch(num, 0-num[i]-num[j], j + 1, num.length - 1);
                if(k != -1)
                {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
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
    public static List<List<Integer>> threeSum2(int[] num)
    {
        Arrays.sort(num);
        
        // value->list of indexes
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < num.length; ++i)
        {
            List<Integer> list = map.get(num[i]);
            if(list == null)
            {
                list = new ArrayList<Integer>();
                list.add(i);
                map.put(num[i], list);
            }
            else
                list.add(i);
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < num.length; ++i)
        {
            if(i > 0 && num[i] == num[i-1])
                continue;
            for(int j = i+1; j < num.length; ++j)
            {
                if(j > i+1 && num[j] == num[j-1])
                    continue;
                
                List<Integer> indexes = map.get(0-num[i]-num[j]);
                if(indexes != null)
                    for(int k: indexes)
                    {
                       if(k > j)
                       {
                           List<Integer> list = new ArrayList<Integer>();
                           list.add(num[i]);
                           list.add(num[j]);
                           list.add(num[k]);
                           result.add(list);
                           break;
                       }
                    }
            }
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        int[] a = new int[]{5,-9,-11,9,9,-4,14,10,-11,1,-13,11,10,14,-3,-3,-4,6,-15,6,6,-13,7,-11,-15,10,-8,13,-14,-12,12,6,-6,8,0,10,-11,-8,-2,-6,8,0,12,3,-9,-6,8,3,-15,0,-6,-1,3,9,-5,-5,4,2,-15,-3,5,13,-11,7,6,-4,2,11,-5,7,12,-11,-15,1,-1,-9,10,-8,1,2,8,11,-14,-4,-3,-12,-2,8,5,-1,-9,-4,-3,-13,-12,-12,-10,-3,6,1,12,3,-3,12,11,11,10};
        System.out.println(threeSum (a));
        System.out.println(threeSum2(a));
    }

}
