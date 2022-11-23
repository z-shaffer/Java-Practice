/**
 * Cookie.java
 *
 * Cookie abstraction.
 *
 * @author Jay Fenwick
 * @version Summer 2020
 *
 * COPYRIGHT (C) 2020 Jay Fenwick. All Rights Reserved.
 * Rights granted to AppState CS students to copy/modify for educational 
 * purposes.
 */

/**
 * Cookie is an abstraction of cookie objects.
 *
 * @author Jay Fenwick
 * @version Summer 2020
 */
public abstract class Cookie {
    private String description;
    private int calories;
    private double cost;

    /**
       Constructor.
       
       @param d is cookie description text
    */
    public Cookie(String d, int c, double cost) {
	description = d;
	calories = c;
	this.cost = cost;
    }

    /**
       Returns object description attribute value.
       
       @return description attribute value.
    */
    public String getDescription() {
	return description;
    }

    /**
       Number of calories in cookie.

       @return number of calories in cookie (int)
    */
    public int calories() { return calories; }

    /**
       Cost of cookie.

       @return cost of cookie (double)
    */
    public double cost() { return cost; }

    /**
       Concise output of object attributes (not wordy like description).


       @return object attributes string (String)
    */
    /**
       Concise string of object attribute values.

       @return object attribute values string-ified (String)
    */
    public String toString() {
	return "[" 
	    + getDescription() + "," 
	    + calories() + "," 
	    + "$ " + cost 
	    + "]";
    }

    public boolean hasNuts() { return false; }
}

