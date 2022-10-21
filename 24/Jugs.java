import java.util.Scanner;

public class Jugs {
	
	private static int N;
	private static int A = 0;
	private static int B = 0;
	private static int Amax;
	private static int Bmax;
	private static int C;
	private static int goal;

	private static boolean process (int state) {
		if (state % 4 == 0 && state > 0) B = 0;	
		else if (state % 2 == 0) A = Amax;
		else if (state % 2 == 1 && state < N/2) 
		{
			while (A != 0 && B != Bmax)
			{
				A--;
				B++;
			}
		}
		else if (state % 2 == 1 && state >= N/2) 
		{
			while (A != Amax && B != 0)
			{
				B--;
				A++;
			}
		}
		if (A + B == C)
		{
			goal = state;
			return true;
		}
		return false;
	} 

	private static boolean dfs (int state) {
		if (state < 0 || state >= N) return false;
		if (process(state)) return true;
		else
		{
			state++;
			if (dfs(state)) return true;
		}
		return false;
	}
	
	private static void print ()
	{
		A = 0;
		B = 0;
		for (int i = 0; i <= goal; i++)
		{
			if (i % 4 == 0 && i > 0)
			{
				B = 0;
				System.out.println("Empty Jug 2 [a = " + A +", b = " + B + "]");			
			}	
			else if (i % 2 == 0)
			{
				A = Amax;
				System.out.println("Fill Jug 1 [a = " + A +", b = " + B + "]");
			} 
			else if (i % 2 == 1 && i < N/2) 
			{
				while (A != 0 && B != Bmax)
				{
					A--;
					B++;
				}
				System.out.println("Pour Jug 1 -> Jug 2 [a = " + A +", b = " + B + "]");
			}
			else if (i % 2 == 1 && i > N/2) 
			{
				while (A != Amax && B != 0)
				{
					B--;
					A++;
				}
				System.out.println("Pour Jug 2 -> Jug 1 [a = " + A +", b = " + B + "]");
			}			
		}
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter A: ");
		Amax = kb.nextInt();
		System.out.print("Enter B: ");
		Bmax = kb.nextInt();
		System.out.print("Enter C: ");
		C = kb.nextInt();	
		if (A > 1000 || B > 1000) return;
		N = Amax * Bmax;
		if (dfs(0))
		{
			System.out.println("Yay! Found a solution.");
			print();
			return;
		}
		System.out.println("Impossible!");
	}
}
