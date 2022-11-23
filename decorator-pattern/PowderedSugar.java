
/**
 * PowderedSugar is an abstraction of topping objects.
 *
 * @author Zach Shaffer
 * @version Fall 2021
 */

public class PowderedSugar extends Toppings {
	Cookie wrappedCookie;
	private double cost = .35;
	private int calories = 160;

	/**
 	*  PowderedSugar constructor
 	*  @param newCookie Passes in the cookie object that will be decorated.	
  	**/

	public PowderedSugar(Cookie newCookie) {
		super(newCookie);
		wrappedCookie = newCookie;
	}	
	
	/**
 	* returns description with decorator added
 	* @return updated description
 	**/

	public String getDescription() {
		return wrappedCookie.getDescription() + ", Powdered Sugar";
	}

	/**
 	* calculates the new cost of the cookie
 	* @return returns the updated cost after decorating
 	**/

	public double cost() {
		return wrappedCookie.cost() + this.cost;
	}

	/**
 	* calculates the new total calories
 	* @return returns the updated calories after decorating
 	**/
	public int calories() {
		return wrappedCookie.calories() + this.calories;
	}

	/**
 	* Inserts the decorator object into the cookie's toString
 	* @return the updated toString with all the objects
 	**/
	public String toString() {
		return "[" + wrappedCookie.toString() + "Powdered Sugar" + "," + this.calories + "," + "$ " + this.cost + "]";
    }
}
