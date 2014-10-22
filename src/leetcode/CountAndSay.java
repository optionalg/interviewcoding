package leetcode;

public class CountAndSay
{

    public static String countAndSay(int n)
    {
        String result = new String();
        if(n < 1)
            return result;
        
        String prev = new String();
        for(int i = 1; i <= n; ++i)
        {
            result = countAndSay(prev);
            prev = result;
        }
        return result;
    }
    
    private static String countAndSay(String prev)
    {
        if(prev.isEmpty())
            return "1";
        
        String result = new String();
        int  start = -1;
        char value = '0';
        int i;
        for(i = 0; i < prev.length(); ++i)
        {
            if(prev.charAt(i) != value)
            {
                result += speak(value, i - start);
                start = i;
                value = prev.charAt(i);
            }
        }
        
        result += speak(value, i - start);
        return result;
    }
    
    private static String speak(char number, int count) {
        return number != '0' ? "" + count + number : "";
    }

    public static void main(String[] args)
    {
        System.out.println(countAndSay(5));
    }

}
