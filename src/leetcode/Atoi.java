package leetcode;

public class Atoi
{

	public static int atoi(String str)
    {
        if(str == null || str.isEmpty())
            return 0;
            
        str = str.trim();
        boolean negative = false;
        int result = 0;
        for(int i = 0; i < str.length(); ++i)
        {
            if(i == 0 && str.charAt(i) == '-')
                negative = true;
            else if(i == 0 && str.charAt(i) == '+')
                negative = false;
            else
            {
                char ch = str.charAt(i);
                
                // invalid char
                if(!Character.isDigit(ch))
                    return output(result, negative);
                
                // check for overflow
                if(willOverflow(result, ch - '0'))
                	return negative ? output(Integer.MIN_VALUE, negative)
                					: output(Integer.MAX_VALUE, negative);
                	
                // add this char to result
                result = 10 * result + ch - '0';
            }
        }
        return output(result, negative);
    }
	
	private static boolean willOverflow(int value, int digit) {
		return 	value >  Integer.MAX_VALUE / 10 ||
				value == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10;
	}
	
	private static int output(int value, boolean negative) {
		return negative ? -value : value;
	}
	
	public static void main(String[] args)
	{
		System.out.println(atoi("2147483648"));
		System.out.println(atoi("-2147483648"));
		System.out.println(atoi(" 10522545459"));
	}

}
