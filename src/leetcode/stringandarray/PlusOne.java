package leetcode.stringandarray;

/**
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.
 * The digits are stored such that the most significant digit is 
 * at the head of the list.
 */
public class PlusOne
{
    public int[] plusOne(int[] digits)
    {
        if(digits == null || digits.length == 0)
            return null;
            
        int[] result = new int[digits.length];
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; --i)
        {
            int sum = carry + digits[i];
            carry = sum / 10;
            result[i] = sum - carry * 10;
        }
        if(carry == 1)
        {
            int[] result2 = new int[result.length + 1];
            System.arraycopy(result, 0, result2, 1, result.length);
            result2[0] = 1;
            return result2;
        }
        else
            return result;
    }
}
