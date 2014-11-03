package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle
{

    public static int minimumTotal(List<List<Integer>> triangle)
    {
        final int height = triangle.size();
        final int width  = triangle.get(height-1).size();
        
        // current[j] stores the min path length for (i, j), i being current row
        int[] current = new int[width];
        
        // temp for the row below the current one
        int[] below = null;
        
        // for each row
        for(int i = height - 1; i >= 0; --i)
        {
            // for each col
            for(int j = 0; j <= i; ++j)
            {
                // the last row is the same as the triangle
                if(i == height - 1) {
                    current[j] = triangle.get(i).get(j);
                }
                else
                {
                    // otherwise, find the min of 3 possible cells in the row below current
                    int min = below[j];
                    if(j + 1 <= below.length-1)
                        min = Math.min(min, below[j+1]);
                        
                    // current[j] = min + (i, j);
                    current[j] = min + triangle.get(i).get(j);
                }
            }
            
            // make current the new below (history)
            below = Arrays.copyOf(current, current.length);
        }
        return current[0];
    }
    
    public static void main(String[] args)
    {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(new Integer[]{-1}));
        triangle.add(Arrays.asList(new Integer[]{-2, -3}));
        System.out.println(minimumTotal(triangle));
    }

}
