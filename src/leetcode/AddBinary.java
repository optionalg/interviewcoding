//package leetcode;
//
//public class AddBinary
//{
//
//	11101
//	   11
//   100000
//	public static String addBinary(String a, String b)
//	{
//		String result = new String();
//		
//		int i = a.length() - 1;
//		int j = b.length() - 1;
//		int carryOn = 0;
//		int sum = 0;
//		while(i >= 0 && j >= 0)
//		{
//			int digit1 = a.charAt(i) - '0';
//			int digit2 = b.charAt(i) - '0';
//			sum = digit1 + digit2 + carryOn;
//			carryOn = digit1 + digit2 == 2 ? 1 : 0;
//			int remaining = digit1 + digit2 - carryOn * 2;
//			result = String.valueOf(remaining) + result;
//		}
//		
//		while(i >= 0)
//			result = String.valueOf()
//		
//		return result;
//    }
//
//	public static void main(String[] args)
//	{
//		// TODO Auto-generated method stub
//
//	}
//
//}
