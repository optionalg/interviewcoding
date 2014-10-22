package leetcode;

public class RegularExpressionMatching
{

    // public static boolean isMatch(String str, String pattern)
    // {
    // if(str == null || pattern == null)
    // return false;
    //
    // int i = 0;
    // int j = 0;
    //
    // while(i < str.length() && j < pattern.length())
    // {
    // char p1 = pattern.charAt(j);
    // char s = str.charAt(i);
    // if(j < pattern.length() - 1)
    // {
    // char p2 = pattern.charAt(j + 1);
    // if(p2 == '*')
    // {
    // if(p1 == '.' || s == p1)
    // ++i;
    // else
    // j += 2;
    // continue;
    // }
    // }
    //
    // if(p1 == '.')
    // {
    // ++ i;
    // ++ j;
    // continue;
    // }
    //
    // if(p1 == s)
    // {
    // ++i;
    // ++j;
    // continue;
    // }
    // return false;
    // }
    // return i == str.length() &&
    // (j == pattern.length() ||
    // j == pattern.length() - 2 && pattern.charAt(j+1) == '*');
    // }

    private static boolean matchFirst(char[] s, int i, char[] p, int j)
    {
        if(i > s.length - 1 || j > p.length - 1)
            return false;
        return s[i] == p[j] ||
                p[j] == '.';
    }

    private static boolean isMatch(char[] s, int i, char[] p, int j)
    {
        if(j >= p.length)
            return i >= s.length;

        if(j >= p.length - 1 || p[j + 1] != '*')
        {
            if(!matchFirst(s, i, p, j))
                return false;
            return isMatch(s, i + 1, p, j + 1);
        }
        else
        {
            if(isMatch(s, i, p, j + 2))
                return true; // try the length of 0
            while(matchFirst(s, i, p, j))
                // try all possible lengths
                if(isMatch(s, ++i, p, j + 2))
                    return true;
        }
        return false;
    }

    public static boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    public static void main(String[] args)
    {
        System.out.println(isMatch("a", "a"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("a", "b"));
        System.out.println(isMatch("ab", "a"));
        System.out.println(isMatch("ab", "a."));
        System.out.println(isMatch("ab", ".."));
        System.out.println(isMatch("ab", ".b"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("abc", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("a", "ab*"));
    }

}
