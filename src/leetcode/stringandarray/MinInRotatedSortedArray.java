package leetcode.stringandarray;

public class MinInRotatedSortedArray
{
	public static int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }
	
	/**
	 * Binary search
	 */
	private static int findMin(int[] array, int left, int right)
	{
		// length 1
		if(right <= left)
			return array[left];
		
		// check mid
		int mid = (left + right) / 2;
		if(isMin(array, mid))
			return array[mid];
		
		// binary search
		if(array[mid] > array[right])
			return findMin(array, mid+1, right);
		else
			return findMin(array, left, mid-1);
	}
	
	// check if index i is the min in the array
	private static boolean isMin(int[] array, int i)
	{
		// get the circularly previous index
		int prev = (i - 1 + array.length) % array.length;
		return array[prev] > array[i];
	}

	public static void main(String[] args)
	{
		System.out.println(findMin(new int[]{2}));
	}

}
