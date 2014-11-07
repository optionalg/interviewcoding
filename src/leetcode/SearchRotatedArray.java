package leetcode;

public class SearchRotatedArray
{

	public static int search(int[] array, int target) {
	    return search(array, 0, array.length-1, target);
    }
	
	private static int search(int[] array, int left, int right, int target)
	{
	    if(left > right)
	        return -1;
	    
	    int mid = (left + right) / 2;
	    if(array[mid] == target)
	        return mid;
	    
	    if(array[left] <= array[mid])  // left is sorted
	    {
	        if(array[left] <= target && target <= array[mid])
	            return search(array, left, mid-1, target);
	        else
	            return search(array, mid+1, right, target);
	    }
	    else
	    {
	        if(array[mid] <= target && target <= array[right])
	            return search(array, mid + 1, right, target);
	        else
	            return search(array, left, mid-1, target);
	    }
	}
	
	public static void main(String[] args)
	{
		int result = search(new int[] {1,3,1,1,1,1}, 3);
		System.out.println(result);
	}

}
