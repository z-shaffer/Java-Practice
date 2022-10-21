import java.util.*;

public class CoyoteCoupon {

	public static int n;
	public static int k;
	public static int a;
	public static int b;
	public static int[] prices;
	public static boolean[] coupons;

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		k = kb.nextInt();
		a = kb.nextInt();
		b = kb.nextInt();
		prices = new int[n];
		coupons = new boolean[b+1];
		int[] array = new int[k];
		for(int i = 0; i < n; i++)	
		{
			while (prices[i] == 0)
			{
				try { prices[i] = kb.nextInt(); }			
				catch (InputMismatchException e){ kb.nextLine(); }
			}
		}
		for (int i = 0; i <= n; i++)
		{			
			combine(array, 0, i);
		}
		for (int i = a; i <= b; i++)
		{
			if (coupons[i] == false)
				System.out.println(i);
		}
	}

	public static void combine(int[] array, int x, int y) {
		int sum = 0;
		if (x == k || y == n)
			return;
		array[x] = prices[y];
		for (int i = 0; i <= x; i++)
		{
			sum += array[i];	
		}
		if (sum >= a && sum <= b)
			coupons[sum] = true;
		combine(array, x+1, y+1);
		combine(array, x, y+1);
	}
}

