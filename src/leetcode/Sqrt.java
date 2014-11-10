package leetcode;

public class Sqrt
{
    /**
     * Binary search
     * Pay attention to overflow
     */
//    public static int sqrt(int x)
//    {
//        if(x == 0 || x == 1)
//            return x;
//        
//        int left  = 0;
//        int right = Math.min(x, 46341);
//        while(left <= right)
//        {
//            int mid = (left + right) / 2;
//            if(mid == 46340 || mid * mid <= x && x < (mid + 1) * (mid + 1))
//                return mid;
//            else if(x < mid * mid)
//                right = mid;
//            else
//                left = mid;
//        }
//        return x;
//    }
    
    /**
     * Use bit manipulation
     * Start from the 31th bit
     * Try if this bit can be 1
     */
    public static int sqrt(int x)
    {
        long result = 0;
        for (int i = 31; i >= 0; i--)
        {
            if ((result + (1 << i)) * (result + (1 << i)) <= x)
                result += (1 << i);
        }
        return (int) result;
    }
    
    public static void main(String[] args)
    {
        int x = sqrt(2147483647);
        System.out.println(x);
    }

}
