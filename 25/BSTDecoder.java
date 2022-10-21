import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class BSTDecoder {
	private BSTNode root; 

	public BSTDecoder() {
		root = null;
	}

	private static void print(BSTNode T) {
		if (T == null) return;
		if (T.key.equals("null"))
		{
			return;
		}
		else
		{
			 System.out.println(T.key);
		}
		print(T.left);
		print(T.right);
	}

	public static void main(String [] args) {

		File f = new File(args[0]);
		int size = 500000;
		BSTNode[] stack = new BSTNode[size];
		int count = 0;
		try {
			Scanner fsk = new Scanner(f);
			while (fsk.hasNext())
			{
				String input = fsk.next();
				if (count == size)
				{
					BSTNode[] tempStack = new BSTNode[size * 2];
					for (int i = 0; i < count; i++)
					{
						tempStack[i] = stack[i];
					}
					stack = tempStack;
					size = size * 2;
				}
				if (input.equals("("))
				{
					//count++;
					//stack[count] = input;
				}
				else if (input.equals(")"))
				{
					stack[count - 2] = new BSTNode(stack[count-1], stack[count-2], stack[count]);
					count--;
					count--;
				}
				else
				{
					count++;
					stack[count] = new BSTNode(input);
				}
			}
			print(stack[count]);
		}
		catch (FileNotFoundException e) {
			System.out.println("Cannot open file " + f.getAbsolutePath());
			System.out.println(e);
		}
	}

}
