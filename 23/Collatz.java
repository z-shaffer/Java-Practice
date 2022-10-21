import java.util.Scanner;

public class Collatz {
	private static long n = 0;
	private static long[] table = new long[100000000];
	
	public static long collatzLength(long x) {
		if (x % 2 == 0) 
		{
			if (x < 100000000 && table[(int)x] != 0)
			{
				return table[(int)x] + n;
			}
			else
			{
				n++;
				return collatzLength(x / 2);
			}
		}
		else if (x > 1)
		{
			n++;
			return collatzLength((3*x)+1);
		}
		n++;
		return n;
		
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
        	System.out.print("Enter the range: ");
        	long num1 = kb.nextLong();
        	long num2 = kb.nextLong();
		long max = 0;
		long maxLength = 0;
		if (num1 >= 1 && num2 >= 1 && num1 <= 100000000 && num2 <= 100000000)
		{
			for (long i = num1; i <= num2; i++)
			{
				table[(int)i] = collatzLength(i);
				if (table[(int)i] > maxLength) { max = i; maxLength = table[(int)i]; }
				n = 0;
			}
			System.out.println("The number with the maximum Collatz length in the range: " + max);
			System.out.println("Its Collatz length: " + maxLength);
		}
		else
		{
			System.out.println("Invalid input");
		}
	}
}