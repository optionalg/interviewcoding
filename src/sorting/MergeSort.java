package sorting;
import java.util.Arrays;


public class MergeSort
{

	public static void mergeSort(int[] array)
	{
		int[] dst = new int[array.length];
		mergeSort(array, dst, 0, array.length - 1);
		System.arraycopy(dst, 0, array, 0, array.length);
	}
	
	private static void mergeSort(int[] array, int[] dst, int start, int end)
	{
		if(start == end)
			dst[start] = array[start];
		else
		{
			int mid = (start + end) / 2;
			int[] temp = new int[array.length];
			mergeSort(array, temp, start, mid);
			mergeSort(array, temp, mid+1, end);
			merge(temp, dst, start, mid, end);
		}
	}
	
	private static void merge(int[] array, int[] dst, int start, int mid, int end)
	{
		int i = start;     // scan the 1st array
		int j = mid + 1;   // scan the 2nd
		int k = start;     // points to the destination array
		while(i <= mid && j <= end)
		{
			if(array[i] <= array[j])
				dst[k++] = array[i++];
			else
				dst[k++] = array[j++];
		}
		while(i <= mid)
			dst[k++] = array[i++];
		while(j <= end)
			dst[k++] = array[j++];
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[]{5,2,1,6,9,0,3,8,4,7};
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

}
