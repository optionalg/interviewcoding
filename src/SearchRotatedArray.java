
public class SearchRotatedArray
{

	private static boolean isStart(int[] array, int i)
	{
		return i > 0 && array[i] < array[i-1];
	}
	
	private static int findStart(int[] array, int left, int right)
	{
		if(right < left)
			return 0;
		
		int mid = (left + right) / 2;
		if(isStart(array, mid))
			return mid;
		
		if(array[mid] > array[left])
			return findStart(array, mid+1, right);
		else
			return findStart(array, left, mid-1);
	}
	
	private static int binarySearch(int[] array, int target, int left, int right)
	{
		while(left <= right)
		{
			int mid = (left + right) / 2;
			if(array[mid] == target)
				return mid;
			if(target < array[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
	
	public static int search(int[] array, int target)
	{
		int start = findStart(array, 0, array.length - 1);
		
		if(array[start] <= target && target <= array[array.length - 1])
			return binarySearch(array, target, start, array.length - 1);
		else
			return binarySearch(array, target, 0, start - 1);
	}
	
	public static void main(String[] args)
	{
		int result = search(new int[] {7,8,1,2,3,4,5,6}, 9);
		System.out.println(result);
	}

}
