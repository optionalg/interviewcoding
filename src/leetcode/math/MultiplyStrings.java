package leetcode.math;

public class MultiplyStrings
{
    public static String multiply(String num1, String num2)
    {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.equals("1"))
            return num2;
        if(num2.equals("1"))
            return num1;
            
        String result = new String();
        for(int i = num1.length() - 1; i >= 0; --i)
        {
            String product = multiply1(num2, num1.charAt(i));
            
            for(int j = 0; j < num1.length() - 1 - i; ++j)
                product += "0";
            result = add(result, product);
        }
        return result;
    }

    private static String multiply1(String num1, char digit)
    {
        if(digit == '0')
            return "0";
        if(digit == '1')
            return num1;
            
        String result = new String();
        int digitValue = digit - '0';
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; --i)
        {
            int product = (num1.charAt(i) - '0') * digitValue + carry;
            carry = product / 10;
            result = "" + (product - carry * 10) + result;
        }
        if(carry > 0)
            result = "" + carry + result;
        return result;
    }
    
    private static String add(String num1, String num2)
    {
        if(num1.equals("0"))
            return num2;
        if(num2.equals("0"))
            return num1;
            
        String result = new String();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0)
        {
            int sum = carry;
            if(i >= 0)
                sum += num1.charAt(i--) - '0';
            if(j >= 0)
                sum += num2.charAt(j--) - '0';
            carry = sum >= 10 ? 1 : 0;
            result = "" + (sum - carry * 10) + result;
        }
        if(carry > 0)
            result = "1" + result;
        return result;
    }
    
    public static void main(String[] args)
    {
        System.out.println(multiply("123", "45"));
    }
}
