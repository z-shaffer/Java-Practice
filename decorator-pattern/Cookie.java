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
 * @author Zach Shaffer
 * @version Fall 2021
 */
public abstract class Cookie {
    private String description;
    private int calories;
    private double cost;

    /**
       Constructor.
       
       @param d is cookie description text, cal is number of calories, cst is cost of cookie.
    */
    public Cookie(String d, int cal, double cst) {
	description = d;
	calories = cal;
	cost = cst;
    }

    /**
       Returns object description attribute value.
       
       @return description attribute value.
    */
    public String getDescription() {
	return description;
    }

    /**
       Determines number of calories in cookie.

       Abstract cookie does not know value, so subclass must implement.

       @return number of calories in cookie (int)
    */
    public int calories() {
	return calories;
    }

    /**
       Determines cost of cookie.

       Abstract cookie does not know value, so subclass must implement.

       @return cost of cookie (double)
    */
    public double cost() {
	return cost;
    }
    
    /**
 	Determins if the cookie contains nuts.
	@return true if cookie contains nuts, false otherwise.
    */
    public boolean hasNuts() {
	return (getDescription().contains("Walnuts") || getDescription().contains("Pecans"));
	}
	
    /**
       Concise output of object attributes (not wordy like description).

       Abstract cookie does not know value, so subclass must implement.

       @return object attributes string (String)
    */
    public String toString() {
	return "[" + description + "," + calories + "," + "$ " + cost + "]";
    }
}

