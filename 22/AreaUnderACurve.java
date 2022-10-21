import java.util.Scanner;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		// TODO: Please compute an approximation for the area under the curve here.
		Interval x = new Interval(a, b);
		PriorityQueue q = new PriorityQueue(100);
		q.insert(x);
		double area = (b - a) * f(b);
		double oldarea = 0;
		Interval one;
		Interval two;
		while (Math.abs(oldarea - area) > error)
		{
			one = q.remove_max();
			oldarea = area;
			area = area - (one.getLength() * f(one.getEnd()));
			two = new Interval(one.getStart() + (one.getLength()/2), one.getEnd());
			one = new Interval(one.getStart(), one.getStart() + (one.getLength()/2));
			q.insert(one);
			q.insert(two);
			area = area + (one.getLength() * f(one.getEnd()));
			area = area + (two.getLength() * f(two.getEnd()));	
		}
		//area = 0;
		//Interval k;
		//for (int i = 1; i < q.getnumElements(); i++)
		//{ 
		//	k = q.remove_max();
		//	area = area + (k.getLength() * f(k.getEnd()));
		//}
		return area; // Remove this statement and return the computed area.
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
	}
}
