import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class HeapSort
{

	public static void heapSort(int[] array)
	{
		if(array == null || array.length < 2)
			return;
		
		// make the array a max heap by adjusting all higher half of the nodes
		for(int i = array.length / 2 - 1; i >= 0; --i)
			adjustHeap(array, i, array.length - 1);
		
		// swap the top with the bottom and re-adjust the top for n-1 times
		for(int end = array.length - 1; end > 0; --end)
		{
			int temp = array[0];
			array[0] = array[end];
			array[end] = temp;
			adjustHeap(array, 0, end - 1);
		}
	}
	
	/**
	 * Adjusting one node of the heap
	 * @param array
	 * @param parent		the node to be adjusted
	 * @param end		the last node of the array
	 */
	private static void adjustHeap(int[] array, int parent, int end)
	{
		// save parent value
		int parentValue = array[parent];
		
		// try moving parent down until the bottom or a safe position
		while(parent < (end + 1) / 2)
		{
			// find the bigger of the 2 children
			int candidate = parent * 2 + 1;
			if(candidate + 1 <= end && array[candidate + 1] > array[candidate])
				candidate ++;
			
			// the child is larger than the parent, move it up
			if(array[candidate] > parentValue)
			{
				array[parent] = array[candidate];
			
				// move parent down
				parent = candidate;
			}
			// otherwise, the job is done
			else
				break;
		}
		
		// put parent back
		array[parent] = parentValue;
	}
	
	public static void heapSort2(int[] array)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < array.length; ++i)
			pq.offer(array[i]);
		
		for(int i = 0; i < array.length; ++i)
			array[i] = pq.poll();
	}
	
	public static int kthSmallest(int[] array, int k)
	{
		// build a max heap with the first k numbers O(k)
		int[] heap = new int[k];
		int i;
		for(i = 0; i < k; ++i)
			heap[i] = array[i];
		for(int j = k / 2 - 1; j >= 0; --j)
			adjustHeap(heap, j, k-1);
		
		// for each of the rest n-k numbers
		// if the number is large than the top
		// replace the top and adjust the top
		// (n-k)O(lgn)
		for(; i < array.length; ++i)
		{
			if(array[i] < heap[0])
			{
				heap[0] = array[i];
				adjustHeap(heap, 0, k-1);
			}
		}
		
		// the smallest k numbers will remain in the heap
		return heap[0];
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[]{9,1,3,6,2,4,5,0,7,8};
		System.out.println("The smallest 4th number is: " + kthSmallest(array, 4));
//		heapSort2(array);
//		System.out.println(Arrays.toString(array));
	}
//	      9
//	    /   \
//     1     3
//   /  \   / \
//  6    2  4  5
// / \  /
// 0 7 8
//	     0
//	  1     2
//	3  4  5  6
//          1
//       2    3
//     4  5  6  7
}
