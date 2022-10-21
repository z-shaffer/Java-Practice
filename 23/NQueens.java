import java.util.Scanner;

public class NQueens {

	private static int result = 0;
	private static int n;
	
	public static void check_row(int x, int[][] board) {

		for (int i = 0; i < n; i++)
		{
			if (valid(x, i, board)) {
				board[x][i] = 1;
				if (x < n-1)
				{
					check_row(x+1, board);
				}
				else if (x == n-1)
				{
					result++;
					return;
				}
				board[x][i] = 0;
			}
		}
	}

	public static boolean valid(int x, int y, int[][] board) {

		for (int i = 0; i < n; i++)
		{
			if (board[x][i] == 1 && i != y) return false;
			if (board[i][y] == 1 && i != x) return false;
			if ((x-i) > 0 && (y-i) > 0 && board[x-i][y-i] == 1 && i != 0) return false;
			if ((x+i) < n && (y+i) < n && board[x+i][y+i] == 1 && i != 0) return false;
		}	
		return true;
	}
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
        	System.out.print("Enter the number of queens: ");
		n = kb.nextInt();
		System.out.println();
		int[][] board = new int[n][n];
		check_row(0, board);
		System.out.println("The number of valid arrangements is " + result);
	}
}