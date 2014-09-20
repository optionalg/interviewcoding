import java.util.Arrays;


public class Shuffle
{

	private static void swap(int[] array, int i, int j)
	{
		if(i != j)
		{
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	
	public static void shuffle(int[] array)
	{
		for(int i = array.length - 1; i > 0; --i)
		{
			int index = (int) (Math.random() * i);   // 0~i-1
			swap(array, index, i);
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = new int[]{1,2,3,4,5,6,7,8,9,0};
		shuffle(array);
		System.out.println(Arrays.toString(array));
	}

}
