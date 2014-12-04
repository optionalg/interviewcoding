package leetcode.stringandarray;

public class Palindrome
{
    public static boolean isPalindrome(String s)
    {
        if(s == null || s.isEmpty())
            return true;
        
        int left  = 0;
        int right = s.length() - 1;
        while(left < right)
        {
        	// skip invalid chars
            char c1 = s.charAt(left);
            while(left < right && !valid(c1))
                c1 = s.charAt(++left);

            char c2 = s.charAt(right);
            while(left < right && !valid(c2))
                c2 = s.charAt(--right);

            // not palindrome
            if(left < right && Character.toLowerCase(c1) != 
                        		   Character.toLowerCase(c2))
                return false;
            
            ++left;
            --right;
        }
        return true;
    }
    
    // letter or digit
    private static boolean valid(char c) {
    		return Character.isLetter(c) || Character.isDigit(c);
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome("a."));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("1a2"));
    }

}
