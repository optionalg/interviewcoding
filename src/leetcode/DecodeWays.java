package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays
{
    /**
     * D&D
     */
    public static int numDecodings(String s)
    {
        if(s == null || s.isEmpty())
            return 0;
        
        return numDecodings(s, 0, s.length() - 1);
    }

    private static int numDecodings(String s, int start, int end)
    {
        if(end < start)
            return 0;
        if(end == start)
            return 1;

        int result = 0;
        for(int i = start + 1; i <= end + 1 && i <= start + 2; ++i)
        {
            String head = s.substring(start, i);
            if(valid(head))
            {
                if(i == end + 1)
                    result ++;
                else
                {
                    int subResult = numDecodings(s, i, end);
                    result += subResult;
                }
            }
        }
        return result;
    }
    
    private static boolean valid(String s)
    {
        if(s.startsWith("0"))
            return false;
        int value = Integer.valueOf(s);
        return 1 <= value && value <= 26;
    }
    
    /**
     * Using DP
     * f(i) represents the number of decodings for s[i...n-1]
     * f(n) = 1;
     * f(i) = f(i+1) + if(s[i, i+1] is valid) f(i+2)
     */
    public static int numDecodings2(String s)
    {
        if(s == null || s.isEmpty())
            return 0;
        
        int n = s.length();
        int[] f = new int[n + 1];
        f[n] = 1;
        for(int i = n - 1; i >= 0; --i)
        {
            if(valid(s.substring(i, i + 1)))
                f[i] += f[i + 1];
            if(i + 1 < n && valid(s.substring(i, i + 2)))
                f[i] += f[i + 2];
        }
        return f[0];
    }
    
    /**
     * Using DP
     * O(1) space
     */
    public static int numDecodings3(String s)
    {
        if(s == null || s.isEmpty())
            return 0;
        
        int n = s.length();
        int far  = 1;
        int near = 1;
        int current = 0;
        for(int i = n - 1; i >= 0; --i)
        {
            current = 0;
            if(valid(s.substring(i, i + 1)))
                current += near;
            if(i + 1 < n && valid(s.substring(i, i + 2)))
                current += far;
            far  = near; 
            near = current;
        }
        return current;
    }
    
    /**
     * Print all the possible decodings
     */
    public static List<List<String>> decode(String s)
    {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null || s.isEmpty())
            return result;
        
        int n = s.length();
        List<List<String>> far  = new ArrayList<List<String>>();
        List<List<String>> near = new ArrayList<List<String>>();
        List<List<String>> current = null;
        for(int i = n - 1; i >= 0; --i)
        {
            current = new ArrayList<List<String>>();
            String head = s.substring(i, i + 1); 
            if(valid(head))
            {
                ArrayList<String> self = null;
                if(near.isEmpty())
                {
                    self = new ArrayList<String>();
                    self.add(head);
                    current.add(self);
                }
                else
                    for(List<String> list: near)
                    {
                        self = new ArrayList<String>();
                        self.add(head);
                        self.addAll(list);
                        current.add(self);
                    }
            }
            
            if(i + 1 < n)
            {
                head = s.substring(i, i + 2);
                if(valid(head))
                {
                    ArrayList<String> self = null;
                    if(far.isEmpty())
                    {
                        self = new ArrayList<String>();
                        self.add(head);
                        current.add(self);
                    }
                    else
                        for(List<String> list: far)
                        {
                            self = new ArrayList<String>();
                            self.add(head);
                            self.addAll(list);
                            current.add(self);
                        }
                }
            }
            far  = near;
            near = current;
        }
        return current;
    }
    
    public static void main(String[] args)
    {
        System.out.println(decode("12123"));
    }

}
