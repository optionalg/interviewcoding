import java.util.Arrays;


public class SwapNumber
{
	public static void swap(int[] number, int times)
	{
		if(number == null || number.length < 2)
			return;
		swap(number, times, 0);
	}
	
//	s
//	012345678
//	512637984
	
	private static void swap(int[] number, int times, int start)
	{
		if(times <= 0 || start >= number.length)
			return;
		
		int right = Math.min(number.length - 1, start + times);
		for(int i = right; i >= start + 1 && times > 0; --i)
			if(number[i] > number[i-1])
			{
				int temp = number[i];
				number[i] = number[i-1];
				number[i-1] = temp;
				times --;
			}
		
		if(times > 0)
			swap(number, times, start + 1);
	}
	
    public static void main(String[] args)
    {
    		int[] number = new int[]{5,1,2,6,4,8,7};
    		swap(number, 4);
    		System.out.println(Arrays.toString(number));
    }

}
