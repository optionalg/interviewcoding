package leetcode;

/**
 * DP
 */
public class UniquePaths
{
    public int uniquePaths(int m, int n)
    {
        int[][] nPaths = new int[m][n];
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j)
            {
                if(i == 0 && j == 0)
                    nPaths[i][j] = 1;
                else
                {
                    int top  = i > 0 ? nPaths[i-1][j] : 0;
                    int left = j > 0 ? nPaths[i][j-1] : 0;
                    nPaths[i][j] = top + left;
                }
            }
        return nPaths[m-1][n-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] nPaths = new int[m][n];
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j)
            {
                if(obstacleGrid[i][j] == 1)
                    nPaths[i][j] = 0;
                else
                {
                    if(i == 0 && j == 0)
                        nPaths[i][j] = 1;
                    else
                    {
                        int top  = i > 0 ? nPaths[i-1][j] : 0;
                        int left = j > 0 ? nPaths[i][j-1] : 0;
                        nPaths[i][j] = top + left;
                    }
                }
            }
        return nPaths[m-1][n-1];
    }
}
