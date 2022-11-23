import java.text.NumberFormat;
import java.util.Locale;

public class ClassicSingletonClient {
	public static void main(String[] args) {
	    long count = 1000000; // 1 million default
	    try {
		count = Long.parseLong(args[0]);
	    }
	    catch (Exception e) {
		System.err.println("Invalid argument");
		count = 1000000;
	    }

	    ClassicSingleton singleton=null;

	    // Instrument here for before timing
	    long before = System.currentTimeMillis();
	    for (long i=0; i < count; i++) {
		 singleton = ClassicSingleton.getInstance();
	    }
	    // Instrument here for after timing
	    long after = System.currentTimeMillis();
	    long elapsed = after - before;

	    System.out.println(singleton.getDescription());
	    System.out.print("Time to do ");
	    System.out.print(NumberFormat.getNumberInstance(Locale.US).format(count));
	    System.out.println(" instance accesses is " 
			       + elapsed + " milliseconds.");
	    System.out.println("" + (1.0 * elapsed / count) + " ms/access");
	    System.out.println();
	}
}
