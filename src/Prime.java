import java.util.ArrayList;
import java.util.Arrays;


public class Prime
{
	/**
	 * Check if a number if prime
	 */
	public static boolean isPrime(int n)
	{
		if(n <= 1)
			return false;
		
		for(int i = 2; i < Math.sqrt(n); ++i)
			if(n % i == 0)
				return false;
		return true;
	}

	/**
	 * Generate all the prime numbers less than n
	 */
	public static ArrayList<Integer> generatePrimes(int n)
	{
		boolean[] prime = new boolean[n+1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		prime[2] = true;
		for(int i = 2; i <= Math.sqrt(n); ++i)
		{
			if(prime[i])
			{
        			for(int j = i; j <= n; ++j)
        			{
        				if(prime[j])
        					for(int k = i*j; k <= n; k *= i)
        						prime[k] = false;
        			}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 2; i <= n; ++i)
			if(prime[i])
				result.add(i);
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(generatePrimes(100));
	}

}
