import java.util.Scanner;

public class RunwayReservation {
	private static int n;
	private static int k;

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // The total number of requests.
		k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		String cmd;
		int time = 0;
		String flightname = null;
		String flightnumber = null;
		String source = null;
		String destination = null;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Requests [] reqs = new Requests[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext()) {
			cmd = kb.next();

			if (cmd.equals("r")) {
				time = kb.nextInt();
				flightname = kb.next();
				flightnumber = kb.next();
				source = kb.next();
				destination = kb.next();

				reqs[i++] = new Requests(cmd, time, flightname, flightnumber, source, destination);					
			}
			else {
				time = kb.nextInt();
				reqs[i++] = new Requests(cmd, time);
			}
			kb.nextLine();
		}

		// TODO: Code to process each request and solve the Runway Reservation problem.
		BST tree = new BST();
		int a = 0;
		tree.insert(reqs[0].getTime(), 0);
		for (int z = 1; z < (n - 1); z++)
		{
			if (reqs[z].getCommand().equals("r"))
			{
				if ((tree.pred(reqs[z].getTime()) != null && tree.succ(reqs[z].getTime()) != null) && (reqs[z].getTime() > curtime))
				{
					if (((tree.pred(reqs[z].getTime()).getTime()) + k) <= reqs[z].getTime())
					{
						if (((tree.succ(reqs[z].getTime()).getTime()) - k) >= reqs[z].getTime())
						{
							tree.insert(reqs[z].getTime(), z);
						}
					}
				}
				else if ((tree.pred(reqs[z].getTime()) != null) && (reqs[z].getTime() > curtime))
				{
					if (((tree.pred(reqs[z].getTime()).getTime()) + k) <= reqs[z].getTime())
					{
						tree.insert(reqs[z].getTime(), z);
					}
				}
				else if ((tree.succ(reqs[z].getTime()) != null) && (reqs[z].getTime() > curtime))
				{
					if (((tree.succ(reqs[z].getTime()).getTime()) - k) >= reqs[z].getTime())
					{
						tree.insert(reqs[z].getTime(), z);
					}
				}
				else if ((reqs[z].getTime() > curtime))
				{
					tree.insert(reqs[z].getTime(), z);
				}
			}
			else
			{
				curtime += reqs[z].getTime();
				System.out.println("Current time = " + curtime + " units");
				while (tree.min().getTime() <= curtime)
				{
					if (tree.min() != null)
					{
						a = tree.min().getReq_index();
						System.out.println(reqs[a].getAirline().toString());
						a = tree.min().getTime();
						tree.delete(a);
					}
				}
			}
		}
		curtime = reqs[n - 1].getTime() + 1;
		System.out.println("Current time = " + curtime + " units");
		//for (int j = 0; j < curtime; j++)
		//{
			while (tree.min() != null)
			{
				a = tree.min().getReq_index();
				System.out.println(reqs[a].getAirline().toString());
				a = tree.min().getTime();
				tree.delete(a);
			}
		//}
	}
}
