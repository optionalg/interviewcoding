package leetcode;

public class Pow
{
    /**
     * Divide and conquer
     */
    public double pow(double x, int n)
    {
        if(x == 0.0)
            return x;
        if(n == 0)
            return 1;

        double half = pow(x, n/2);
        if(n % 2 == 0)
            return half * half;
        else
            return n > 0 ? half * half * x 
                         : half * half / x;
    }
    
    /**
     * Iterative
     */
    public static double pow2(double x, int n)
    {
        double result = 1.0;
        for(int i = n; i > 0; i /= 2, x *= x)
            if(i % 2 > 0)
                result *= x;
        return n < 0 ? 1.0 / result : result;
    }
    
    public static void main(String[] args)
    {
        System.out.println(pow2(2, 7));
    }
}
