import java.util.Scanner;

public class Islands {

	public static boolean[][] map;
	public static boolean[][] visited;
	public static int N;
	public static int islands = 0;

	public static void main(String[] args) {
	
		Scanner kb = new Scanner(System.in);	
		N = kb.nextInt();
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1][N+1];
		String line;
		for (int i = 0; i < N; i++)
		{
			line = kb.next();
			for (int j = 0; j < N; j++)
			{
				if (line.charAt(j) == '*')
					map[i][j] = true;
			}	
		}
		
		for (int i = 0; i < N; i++) 
		{

			for (int j = 0; j < N; j++)
			{
				if (map[i][j] == true && visited[i][j] != true)
				{
					islands++;
					visited[i][j] = true;
					search(i, j);	
				}
			}		

		}
		System.out.println("The total number of islands is " + islands);
		
	}

	public static void search(int i, int j) {

		if (i > 0 && map[i-1][j] == true && visited[i-1][j] != true)
		{
			visited[i-1][j] = true;
			search(i-1, j);
		}

		if (j > 0 && map[i][j-1] == true && visited[i][j-1] != true)
		{
			visited[i][j-1] = true;
			search(i, j-1);
		}	

		if (i > 0 && j > 0 && map[i-1][j-1] == true && visited[i-1][j-1] != true)
		{
			visited[i-1][j-1] = true;
			search(i-1, j-1);
		}

		if (i < N && map[i+1][j] == true && visited[i+1][j] != true)
		{
			visited[i+1][j] = true;
			search(i+1, j);
		}

		if (j < N && map[i][j+1] == true && visited[i][j+1] != true)
		{
			visited[i][j+1] = true;
			search(i, j+1);
		}

		if (i < N && j < N && map[i+1][j+1] == true && visited[i+1][j+1] != true)
		{
			visited[i+1][j+1] = true;
			search(i+1, j+1);
		}

		if (i > 0 && j < N && map[i-1][j+1] == true && visited[i-1][j+1] != true)
		{
			visited[i-1][j+1] = true;
			search(i-1, j+1);
		}

		if (i < N && j > 0 && map[i+1][j-1] == true && visited[i+1][j-1] != true)
		{
			visited[i+1][j-1] = true;
			search(i+1, j-1);
		}	

	}

}
