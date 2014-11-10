package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation
{
    public static void nextPermutation(int[] num)
    {
        // start from right, find the end of the increasing sequence
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i])
            i --;
        
        if(i > 0)
        {
            // start from right, find the 1st greater than num[i-1]
            for(int j = num.length - 1; j >= i; --j)
                if(num[j] > num[i-1])
                {
                    // swap j with i-1
                    swap(num, j, i - 1);
                    break;
                }
        }
        
        reverse(num, i);
    }
    
    private static void reverse(int[] num, int start)
    {
        int end = num.length - 1;
        while(start < end)
            swap(num, start++, end--);
    }
    
    private static void swap(int[] num, int i, int j)
    {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    
    public static List<List<Integer>> permute(int[] num)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] original = Arrays.copyOf(num, num.length);
        
        do {
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < num.length; ++i)
                list.add(num[i]);
            result.add(list);
            nextPermutation(num);
        }
        while(!Arrays.equals(num, original));
        
        return result;
    }
    
    /**
     * Return the kth (1 based) permutation of 1...n
     */
    public static String getPermutation(int n, int k)
    {
        int[] array = new int[n];
        for(int i = 0; i < n; ++i)
            array[i] = i + 1;
        
        for(int i = 0; i < k - 1; ++i)
            nextPermutation(array);
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; ++i)
            builder.append(Integer.toString(array[i]));
        return builder.toString();
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{1,2,3};
//        nextPermutation(array);
//        System.out.println(Arrays.toString(array));
        System.out.println(permute(array));
    }

}
