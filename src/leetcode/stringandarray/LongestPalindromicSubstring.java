package leetcode.stringandarray;

public class LongestPalindromicSubstring
{

    public String longestPalindrome(String s)
    {
        String result = new String();
        for(int i = 1; i < s.length(); ++i)
        {
            int[] range = probePalindrome(s, i);
            if(range[1] - range[0] > result.length())
                result = s.substring(range[0], range[1] + 1);
        }
        return result;
    }
    
    private int[] probePalindrome(String s, int center)
    {
        // try even length
        int i = 0;
        while(true)
        {
            int left  = center - i;
            int right = center + 1 + i;
            if(left < 0 || right > s.length() - 1 || s.charAt(left) != s.charAt(right))
                break;
            ++i;
        }
        int evenLen = i * 2;
        
        // try odd length
        int j = 0;
        while(true)
        {
            int left  = center - j;
            int right = center + j;
            if(left < 0 || right > s.length() - 1 || s.charAt(left) != s.charAt(right))
                break;
            ++j;
        }
        int oddLen = (j - 1) * 2 + 1;
        
        if(evenLen > oddLen)
            return new int[]{center - i, center + 1 + i};
        else
            return new int[]{center - j, center + j};
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
