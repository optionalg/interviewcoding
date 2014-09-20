public class Bits
{
	public static int setBits(int n, int m, int i, int j)
	{
		if(i > j)
			return n;
	
		// generate a mask of 0s between i and j
		// e.g, i = 6, j = 2
		int length = j - i + 1;
		int mask = (1 << (length+1)) - 1;    // 11111
		mask = mask << j;                    // 000000001111100
		mask = ~mask;                        // 111111110000011
		
		// apply the sub mask to n: clear up the portion and add m to it
		return (n & mask) | (m << i);		
	}
	
	public static int divide(int numerator, int denominator)
	{
		int current  = 1;   // current bit
		int quotient = 0;

	    if(denominator > numerator) 
	        return 0;

	    if(denominator == numerator)
	        return 1;

	    // align numerator and denominator
	    while(denominator <= numerator)
	    {
	    		denominator <<= 1;
	        current     <<= 1;
	    }
	    denominator >>= 1;
	    current     >>= 1;

	    while(current > 0)
	    {
	        if(numerator >= denominator)
	        {
	        		numerator -= denominator;
	            quotient |= current;
	        }
	        current     >>= 1;
			denominator	>>= 1;
	    }    
	    return quotient;
	}
	
	public static void main(String[] argv)
	{
		int i = -1;
//		System.out.println(Integer.toBinaryString(i));
//		System.out.println(Integer.toBinaryString(i >>> 5));
//		System.out.println(Integer.toBinaryString(i >> 5));
		System.out.println(divide(15, 3));
//		System.out.println(setBits(0x400, 0x15, 2, 4));
	}
}
