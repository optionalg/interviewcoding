
public class MedianofTwoArrays
{

	public static int median(int[] a, int[] b)
	{
		if(a == null || b == null || a.length == 0 || b.length == 0)
			return -1;
		return median(a, 0, a.length - 1, b, 0, b.length - 1);
	}
	
	private static int median(int[] a, int starta, int enda, int[] b, int startb, int endb)
	{
		int mida = (starta + enda) / 2;
		int midb = (startb + endb) / 2;
		int len = Math.min(mida - starta, midb - startb);
		if(len == 0)
			return Math.max(a[mida], b[midb]);
		
		if(a[mida] < b[midb])
		{
			starta += len;
			endb   -= len;
		}
		else
		{
			startb += len;
			enda   -= len;
		}
		return median(a, starta, enda, b, startb, endb);			
	}
	
	public static void main(String[] args)
	{
		int[] a = new int[] {1,4,5,9,11};
		int[] b = new int[] {2,7,8,12};
		System.out.println(median(a, b));
	}

}
