package leetcode;

public class SingleNumber
{

    /**
     * Given an array of integers, every element appears twice except for one. 
     * Find that single one.
     * 
     * XOR all of them, duplicated numbers will be negated, leaving the single one
     */
    public static int singleNumber(int[] A)
    {
        int result = 0;
        for(int i = 0; i < A.length; ++i)
            result ^= A[i];
        return result;
    }

    /**
     * Given an array of integers, every element appears three times except for one. 
     * Find that single one.
     */
    public static int singleNumber2(int[] A)
    {
        int result = 0;
        
        // for each bit
        for(int i = 0; i < 32; ++i)
        {
            // count the number of 1 in that bit
            int count = 0;
            for(int j = 0; j < A.length; ++j)
                count += (A[j] >> i) & 1;  // take the i-th bit of A[j]
            
            // if the count is not times of 3, 
            // then the single number must have a 1 in this bit
            if(count % 3 > 0)
                result |= (1 << i);        // set the i-th bit of result to 1
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(singleNumber (new int[]{1,3,2,1,4,2,4}));
        System.out.println(singleNumber2(new int[]{5,3,4,4,5,4,5}));
    }

}
