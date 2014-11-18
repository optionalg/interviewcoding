package leetcode.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation
{
	/**
	 * Get next of current one in a lexically sorted permutation
	 * e.g., the permutation of 123 is
	 * 123
	 * 132
	 * 213
	 * 231
	 * 312
	 * 321
	 * The next permutation of 213 is 231
	 */
    public static void nextPermutation(int[] num)
    {
        // start from right, find the end of the increasing sequence
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i])
            i --;
        
        if(i > 0)
        {
            // in [n-1...i], find the 1st greater than num[i-1]
            for(int j = num.length - 1; j >= i; --j)
                if(num[j] > num[i-1])
                {
                    // swap j with i-1
                    swap(num, j, i - 1);
                    break;
                }
        }
        
        // reverse [i...n-1]
        reverse(num, i);
    }
    
    // reverse an array starting from index start
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
    
    /**
     * Generate all the permutations of the given array
     */
    public static List<List<Integer>> permute(int[] num)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] original = Arrays.copyOf(num, num.length);
        
        do {
        		// convert the current array to a list and add it to the result
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < num.length; ++i)
                list.add(num[i]);
            result.add(list);
            
            // generate the next permutation of the current list
            nextPermutation(num);
        }
        while(!Arrays.equals(num, original));  // until it reaches the starting array
        
        return result;
    }
    
    /**
     * Return the kth (1 based) permutation of 1...n
     * Based on nextPermutation
     */
    public static String getPermutation(int n, int k)
    {
    		// starting array = 1,2,3,...n
        int[] array = new int[n];
        for(int i = 0; i < n; ++i)
            array[i] = i + 1;
        
        // run k-1 times of nextPermutation
        for(int i = 0; i < k - 1; ++i)
            nextPermutation(array);
        
        // convert the int array to a string
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
        System.out.println(getPermutation(3, 2));
    }

}
