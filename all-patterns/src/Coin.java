import java.util.Random;

/**
 * Coin is an abstraction of coin objects.
 *
 * @author Zach Shaffer
 * @version Nov 2021
 */
public abstract class Coin {
    private String type;
    private double value;
    private String code;
    public Smelting smelt;

    /**
       Constructor.
       
       @param t is the coin's type I.E. Quarter
	@param v is the coin's value I.E. 0.25
	@param c is the coin's code I.E. USD
    */
    public Coin(String t, double v, String c) {
	type = t;
	value = v;
	code = c;
    }

    /**
       Get the type of coin.
       
       @return the type.
    */
    public String getType() {
	return type;
    }

    /**
       Get the value of this coin.

       @return The value
    */
    public double getValue() { return value; }

    /**
       Get the country code of the coin.

       @return country code
    */
    public String getCode() { return code; }

    /**
       Concise string of object attribute values.

       @return object attribute values string-ified (String)
    */
    public String toString() {
	return "[" 
	    + getCode() + getType() + ": worth $" + String.format("%.2f", getValue())  + "]";
    }

    /**
     * Null coin nested class to handle failures when making coins.
     */
    private static class NullCoin extends Coin {
        private NullCoin()
        {
            super("", 0, "");
        }
        

        public String toString() {
            return "Could not manufacture coin.";
        }

        
    }

    public static Coin NULL = new NullCoin();


    protected static Random rng = new Random(System.currentTimeMillis());
	/**
	 * Takes a coin object, and returns true if it passes inspection or false if it fails.
	 * 		Will fail 1 / 12 times.
	 */
	public boolean inspect(Coin c) {
		if(rng.nextInt(12) + 1 == 1) {
			System.out.println("Inspection of " + c.getCode() +  " " + c.getType() + " Failed.");
			return false;
		}
		System.out.println("Inspection of " + c.getCode() +  " " + c.getType() + " Passed.");
		return true;
	}
	/**
	 * Takes a coin object, and returns true if it passes smoothing or false if it fails.
	 * 		Will fail 1 / 1000 times.
	 */
	public boolean smooth(Coin c) {
		if(rng.nextInt(1000) + 1 == 1) {
			System.out.println("Smoothing of " + c.getCode() +  " " + c.getType() + " Failed.");
			return false;
		}
		System.out.println("Smoothing of " + c.getCode() +  " " + c.getType() + " Passed.");
		return true;
	}
	/**
	 * Takes a coin object, and returns true if it passes buffing or false if it fails.
	 * 		Will fail 1 / 1000 times.
	 */
	public boolean buff(Coin c) {
		if(rng.nextInt(1000) + 1 == 1) {
			System.out.println("Buffing of " + c.getCode() +  " " + c.getType() + " Failed.");
			return false;
		}
		System.out.println("Buffing of " + c.getCode() +  " " + c.getType() + " Passed.");
		return true;	
	}

    public void manufacture(Coin c) {
        System.out.print("Smelting " + c.getCode() +  " " + c.getType() + " using ");
        smelt.manufacture();
    }
}
