package leetcode;

public class CanJump
{

    /**
     * DP
     */
    public boolean canJump(int[] A)
    {
        if(A == null || A.length == 0)
            return false;
            
        boolean[] jumpable = new boolean[A.length];
        int i = A.length - 1;
        jumpable[i] = true;
        while(--i >= 0)
        {
            for(int j = A[i]; i + j < A.length && j >= 1; --j)
                if(jumpable[i + j])
                {
                    jumpable[i] = true;
                    break;
                }
        }
        return jumpable[0];
    }
    
    public boolean canJump2(int[] A)
    {
        if(A == null || A.length == 0)
            return false;
        
        int farest = 0;
        for(int i = 0; i < A.length && i <= farest; ++i)
        {
            farest = Math.max(farest, i + A[i]);
            if(farest >= A.length - 1)
                return true;
        }
        return farest >= A.length - 1;
    }
}
