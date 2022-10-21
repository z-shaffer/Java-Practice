import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class NoSeventeens {

	public static int hash(String k) { 
		int x = 2917;
		int hash = 0;
		for (int i = 0; i < k.length(); i++) {
			hash = ((hash * x) + (int) k.charAt(i)) % (100000);
		}
		return hash;
	} 
	
	public static void main(String [] args) {

		File f = new File(args[0]);
		try {
			Scanner fsk = new Scanner(f); 			
			Scanner kb = new Scanner(System.in); 

			String input;
			int index;
			String[] seventeens = new String[100000];
			while (fsk.hasNextLine())
			{
				input = fsk.nextLine();
				index = hash(input);
				seventeens[index] = input;
			}
			 while (kb.hasNextLine())
			{
				input = kb.nextLine();
				index = hash(input);
				if (!input.equals(seventeens[index])) 
				{
					System.out.println(input);
				}
			 } 
		}
		catch (FileNotFoundException e) {
			System.out.println("Cannot open file " + f.getAbsolutePath());
			System.out.println(e);
		}
	}
}
