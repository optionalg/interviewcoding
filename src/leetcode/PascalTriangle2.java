package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2
{

    public static List<Integer> getRow(int rowIndex)
    {
        List<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0)
            return result;

        result.add(1);
        for(int i = 0; i < rowIndex; ++i)
            result = getRow(result);
        
        return result;
    }
    
    /**
     * Generate a new row based on the previous one
     */
    private static List<Integer> getRow(List<Integer> previous)
    {
        List<Integer> result = new ArrayList<Integer>();
        int right = previous.size();
        for(int col = 0; col <= right; ++col)
        {
            if(col == 0 || col == right)
                result.add(1);
            else
                result.add(previous.get(col-1) + previous.get(col));
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        System.out.println(getRow(3));
    }

}
