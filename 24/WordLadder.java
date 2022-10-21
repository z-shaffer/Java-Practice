import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordLadder {
	private static String start;
	private static String end;
	private static StringMap T;			// This map stores the dictionary of words.
	private static StringMap R = new StringMap();			// This map keeps track of all the words that are visited during breadth-first-search.
																	// The key field is the word that is visited, and its value field can hold the predecessor pointer.
	private static Queue Q = new Queue();					// A queue to perform the breadth-first-search.

	public static void main(String [] args) throws IOException {
		// Loading the dictionary of words into the StringMap T.
		T = new StringMap();
		File file = new File("dictionary4");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			String word = f.nextLine();
			T.insert(word, "");
		}
		f.close();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the start word: ");
		start = kb.nextLine();
		System.out.print("Enter the end word: ");
		end = kb.nextLine();

		// TODO: Solution to find the shortest set of words that transforms the start word to the end word.
		QNode startNode = new QNode(0, start);
		Q.enqueue(startNode);
		R.insert(start, "");
		while (!Q.isEmpty())
		{
			if (bfs(Q.dequeue()))
			{
				System.out.println("Yay! A word ladder is possible.");
				print(end);	
				return;			
			}
		}
		System.out.println("Duh! Impossible.");
	}

	public static boolean bfs(QNode node) {
		
		for (int i = 0; i < node.getWord().length(); i++)
		{
			StringBuilder newWord = new StringBuilder(node.getWord());
			for (int j = 97; j < 123; j++)
			{
				newWord.setCharAt(i, (char) j);
				if (T.find(newWord.toString()) != null) {
					if (R.find(newWord.toString()) == null) {
						QNode newNode = new QNode(node.getDist() + 1, newWord.toString());
						Q.enqueue(newNode);
						R.insert(newWord.toString(), node.getWord());

						if(newWord.toString().equals(end)) return true;
					}
				}	
			}
		}
		return false;
	}

	public static void print(String word) {
		if(R.find(word).getValue().equals(""))
		{
			System.out.println(R.find(word).getKey());
			return;
		} 
		print(R.find(word).getValue());
		System.out.println(R.find(word).getKey());	
	}
}
