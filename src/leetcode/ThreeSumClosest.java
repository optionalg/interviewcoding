package leetcode;

import java.util.Arrays;

public class ThreeSumClosest
{

    /**
     * Find 3 numbers that add up closest to target
     * @return the sum
     */
    public static int threeSumClosest(int[] num, int target)
    {
        int distance = Integer.MAX_VALUE;  // sum - target
        Arrays.sort(num);
        for(int i = 0; i < num.length - 2; ++i)
        {
            int j = i + 1;
            int k = num.length - 1;
            if(Math.abs(num[i] + num[j] + num[k] - target) < Math.abs(distance))
                distance = num[i] + num[j] + num[k] - target;
            while(j < k)
            {
                int threeSum = num[i] + num[j] + num[k];
                if(Math.abs(threeSum - target) < Math.abs(distance))
                    distance = threeSum - target;
                if(threeSum < target)
                    j ++;
                else if(threeSum > target)
                    k --;
                else
                    return target;
            }
        }
        return target + distance;
    }
    
    public static void main(String[] args)
    {
        System.out.println(threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }

}
