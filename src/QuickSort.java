import java.util.Arrays;

public class QuickSort
{

	public static void quickSort(int[] array)
	{
		qSort(array, 0, array.length - 1);
	}
	
	private static void qSort(int[] array, int left, int right)
	{
		if(left < right)
		{
			int pivot = partition(array, left, right);
			qSort(array, left, pivot - 1);
			qSort(array, pivot + 1, right);
		}
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
		int[] array = new int[] {9,8,7,6,5,4,3,2,1,0};
		quickSort(array);
		System.out.println(Arrays.toString(array));
	}

}
