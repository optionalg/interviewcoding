package leetcode.stringandarray;

public class MaxProductSubarray
{
	/**
	 * Find the subarray with the max product
	 * DP
	 * L[i] is the max product of all subarrays ending with i
	 * S[i] is the min product of all subarrays ending with i
	 */
	public static int maxProduct(int[] A)
	{
		if(A.length == 0)
			return 0;
		
        int[] L = new int[A.length];
        int[] S = new int[A.length];
        L[0] = A[0];
        S[0] = A[0];
        for(int i = 1; i < A.length; ++i)
        {
        		// current one is positive
	        	if(A[i] > 0)
	        	{
	        		// if L[i-1] is positive, multiply A[i] with it to make L[i] maximum
	        		// otherwise just use A[i]
	        		L[i] = L[i-1] > 0 ? A[i] * L[i-1] : A[i];
	        		
	        		// if S[i-1] is negative, multiply A[i] with it to make S[i] minimum
	        		// otherwise just use A[i]
	        		S[i] = S[i-1] > 0 ? A[i] : A[i] * S[i-1];
	        	}
	        	// vise versa
	        	else
	        	{
	        		L[i] = S[i-1] > 0 ? A[i] : A[i] * S[i-1];
	        		S[i] = L[i-1] > 0 ? A[i] * L[i-1] : A[i];
	        	}
        }
        
        // find the max in L
        int max = L[0];
        for(int i = 1; i < L.length; ++i)
        	if(L[i] > max)
        		max = L[i];
        return max;
    }
	
	public static void main(String[] args)
	{
		System.out.println(maxProduct(new int[]{-5, -2, 3, -4, 6}));
	}

}
