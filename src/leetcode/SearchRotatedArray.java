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
	    
	    // target is smaller, start is on the left, target smaller than A[left]
	    // go left if
	    // 111
	    // 110
	    // 100
	    // 010
	    boolean targetSmaller         = target < array[mid];
	    boolean startLeft             = array[left] > array[mid];
	    boolean targetSmallerThanLeft = target < array[left];
	    boolean goLeft = targetSmaller  && startLeft ||
	                     targetSmaller  && !startLeft && !targetSmallerThanLeft ||
	                     !targetSmaller && startLeft  && !targetSmallerThanLeft;
	    
	    return goLeft ? search(array, left,    mid - 1, target)
	                  : search(array, mid + 1, right,   target); 
	}
	
	public static void main(String[] args)
	{
		int result = search(new int[] {7,8,1,2,3,4,5,6}, 0);
		System.out.println(result);
	}

}
