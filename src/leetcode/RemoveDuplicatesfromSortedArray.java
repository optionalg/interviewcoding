package leetcode;

public class RemoveDuplicatesfromSortedArray
{

    /**
     * Remove the duplicates from a sorted array
     * e.g., 1,1,2,3,3,4 -> 1,2,3,4
     * @return the size of the new array
     */
    public int removeDuplicates(int[] A)
    {
        if(A.length <= 1)
            return A.length;
        
        // end points to the end of non duplicated subarray
        int end = 0;
        for(int i = 1; i < A.length; ++i)
            if(A[i] != A[end])
                A[++end] = A[i];
        return end + 1;
    }
    
    /**
     * Duplicates are allowed at most twice
     * e.g., 1,1,1,2,2,3 -> 1,1,2,2,3
     */
    public int removeDuplicates2(int[] A)
    {
        if(A == null)
            return 0;
        if(A.length <= 2)
            return A.length;
        
        // end points to the end of non duplicated subarray
        int end = 1;
        for(int i = 2; i < A.length; ++i)
            if(A[i] != A[end] || A[i] != A[end-1])
                A[++end] = A[i];
        return end + 1;
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
