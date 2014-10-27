package leetcode;

public class GasStation
{

//    public static int canCompleteCircuit(int[] gas, int[] cost)
//    {
//        for(int i = 0; i < gas.length; ++i)
//            if(canComplete(gas, cost, i, i, 0) >= 0)
//                return i;
//        return -1;
//    }
//    
//    private static int canComplete(int[] gas, int[] cost, int start, int end, int remaining)
//    {
//        if(end == (start + 1) % gas.length)
//            return gas[start] + remaining - cost[start];
//        remaining = canComplete(gas, cost, start, (start + 1) % gas.length, remaining);
//        if(remaining >= 0)
//            return canComplete(gas, cost, (start + 1) % gas.length, end, remaining);
//        return -1;
//    }
    
    public static int canCompleteCircuit(int[] gas, int[] cost)
    {
        int totalGas  = 0;
        int totalCost = 0;
        int remaining = 0;
        int start = 0;
        for(int i = 0; i < gas.length; ++i)
        {
            totalGas  += gas[i];
            totalCost += cost[i];
            remaining += gas[i] - cost[i];
            
            // start over
            // keep a record of last start
            if(remaining < 0)
            {
                start = i + 1;
                remaining = 0;
            }
        }
        
        // there must be a solution if the total gas is greater than total cost
        return totalGas >= totalCost ? start : -1;
    }
    
    public static void main(String[] args)
    {
        System.out.println(canCompleteCircuit(new int[]{5,3,3,4}, new int[]{6,2,4,3}));
    }

}
