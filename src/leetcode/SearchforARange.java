package leetcode;

import java.util.Arrays;

public class SearchforARange
{

    public int[] searchRange(int[] A, int target)
    {
        int left  = searchLeft (A, target, 0, A.length - 1);
        int right = searchRight(A, target, 0, A.length - 1);
        return A[left] == target ? new int[]{left, right} : new int[]{-1, -1};
    }
    
    private int searchLeft(int[] A, int target, int left, int right)
    {
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(A[mid] == target)
            {
                if(mid - 1 >= left && A[mid-1] == target)
                    right = mid - 1;
                else
                    return mid;
            }
            else if(target < A[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
    
    private int searchRight(int[] A, int target, int left, int right)
    {
        while(left < right)
        {
            int mid = (left + right) / 2;
            if(A[mid] == target)
            {
                if(mid + 1 <= right && A[mid+1] == target)
                    left = mid + 1;
                else
                    return mid;
            }
            else if(target < A[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }
    
    public static void main(String[] args)
    {
        SearchforARange s = new SearchforARange();
        System.out.println(Arrays.toString(s.searchRange(new int[]{1,1,2}, 1)));
    }

}
