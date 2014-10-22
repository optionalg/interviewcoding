package leetcode;


public class AddBinary
{
    
  public static String addBinary(String a, String b)
  {
      String result = new String();
      
      int i = a.length() - 1;
      int j = b.length() - 1;
      int carry = 0;
      while(i >= 0 || j >= 0)
      {
          int digit = 0;
          if(i >= 0)
              digit += a.charAt(i--) - '0';
          if(j >= 0)
              digit += b.charAt(j--) - '0';
          digit += carry;
          if(digit > 1)
          {
              carry = 1;
              digit = digit - 2;
          }
          else
              carry = 0;
          result = (char) ('0' + digit) + result;
      }
      
      if(carry > 0)
          result = '1' + result;
      return result;
    }

	public static void main(String[] args)
	{
		System.out.println(addBinary("11", "11"));
	}

}
