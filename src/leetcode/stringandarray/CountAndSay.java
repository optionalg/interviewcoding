package leetcode.stringandarray;

public class CountAndSay
{

	/**
	 * Generate the nth row of a countandsay sequence
	 * e.g.,
	 * 1
	 * 11
	 * 21
	 * 1211
	 */
    public static String countAndSay(int n)
    {
        String result = new String();
        if(n < 1)
            return result;
        
        String prev = new String();       // previous row
        for(int i = 1; i <= n; ++i)
        {
            result = countAndSay(prev);   // generate current row from prev
            prev = result;
        }
        return result;
    }
    
    private static String countAndSay(String prev)
    {
        if(prev.isEmpty())
            return "1";
        
        String result = new String();
        int  start = -1;    // start index of current digit
        char value = '0';   // current digit
        int i;
        for(i = 0; i < prev.length(); ++i)
        {
        		// found a new digit, speak the previous one
            if(prev.charAt(i) != value)
            {
                result += speak(value, i - start);
                start = i;
                value = prev.charAt(i);
            }
        }
        
        // the last one
        result += speak(value, i - start);
        return result;
    }
    
    /**
     * Convert one number
     * e.g., number = 5, count = 2 -> 52
     */
    private static String speak(char number, int count) {
        return number != '0' ? "" + count + number : "";
    }

    public static void main(String[] args)
    {
        System.out.println(countAndSay(5));
    }

}
