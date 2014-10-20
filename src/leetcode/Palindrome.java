package leetcode;

public class Palindrome
{
    public static boolean isPalindrome(String s)
    {
        if(s == null || s.isEmpty())
            return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j)
        {
            char c1 = s.charAt(i);
            while(i < j && !Character.isLetter(c1) && !Character.isDigit(c1))
                c1 = s.charAt(++i);

            char c2 = s.charAt(j);
            while(i < j && !Character.isLetter(c2) && !Character.isDigit(c2))
                c2 = s.charAt(--j);

            if(i < j && Character.toLowerCase(c1) != 
                        Character.toLowerCase(c2))
                return false;
            ++i;
            --j;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome("a."));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("1a2"));
    }

}
