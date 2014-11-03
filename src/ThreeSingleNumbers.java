
public class ThreeSingleNumbers
{
    /**
     * All the numbers in the array appear twice, except for 3 numbers
     * Find one of the single numbers
     * 
     * @param array
     * @return
     */
	public static int findSingleNumber(int[] array)
	{
		int count = 0;  // # of 1 in current bit
		int sum1  = 0;  // XOR sum of the numbers with bit 1
		int sum0  = 0;  //                                 0
		
		// for each bit
		for(int i = 0; i <= 32; ++i)
		{
			count = 0;
			sum1  = 0;
			sum0  = 0;
			
			// for each number
			for(int j = 0; j < array.length; ++j)
			{
				// if the ith bit is 1
				if((array[j] & (1 << i)) == 1)
				{
					count ++;
					sum1 ^= array[j];
				}
				else
					sum0 ^= array[j];
			}
			
			// after counting 1, we've divide the array into 2 groups
			// the single numbers might exist in one of the group
			if(count % 2 == 1)
			{
				// if the size of group1 is odd, then
				// (1) group1 has 1 single numbers => group0 has 2 => sum0 != 0
				// (2) group1 has 3 single numbers => group0 has 0 => sum0 == 0
				if(sum0 != 0)
					return sum1;  // in case (1), sum1 is the single number
			}
			else
			{
				// if the size of group1 is even, then
				// (1) group1 has 0 single numbers => group0 has 3 => sum1 == 0
				// (2) group1 has 2 single numbers => group0 has 1 => sum1 != 0
				if(sum1 != 0)
					return sum0;  // in case (2), sum0 is the single number
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		System.out.println(findSingleNumber(new int[] {1,1,2,2,3,3,4,4,5,7,8}));
	}

}
