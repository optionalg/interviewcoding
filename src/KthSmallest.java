public class KthSmallest
{
	public static int kthSmallest(int[] array, int k)
	{
		if(k < 1 || k > array.length)
			return -1;
		return kthSmallest(array, k, 0, array.length - 1);
	}
	
	private static int kthSmallest(int[] array, int k, int left, int right)
	{
		if(left > right || k < 1 || k > right - left + 1)
			return -1;
		
		int pivot = partition(array, left, right);
		if(pivot == left + k - 1)
			return pivot;
		if(pivot > left + k - 1)
			return kthSmallest(array, k, left, pivot - 1);
		else
			return kthSmallest(array, k - pivot + left - 1, pivot + 1, right);
	}
	
	private static int partition(int[] array, int left, int right)
	{
		int pivot = (int) (Math.random() * (right - left)) + left;
		int pivotValue = array[pivot];
		array[pivot]   = array[left];
		array[left]    = pivotValue;

		while(left < right)
		{
			while(left < right && array[right] >= pivotValue)
				right--;
			array[left] = array[right];
			while(left < right && array[left] <= pivotValue)
				left++;
			array[right] = array[left];
		}
		array[left] = pivotValue;
		return left;
	}

	public static void main(String[] args)
	{
		int[] array = new int[] {2, 4, 1, 5, 6, 3, 9, 0, 7, 8};
		for(int i = 1; i <= 10; ++i)
			System.out.println(kthSmallest(array, i));
	}

}
