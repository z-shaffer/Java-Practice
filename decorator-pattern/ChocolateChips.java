
/**
 * ChocolateChips is an abstraction of topping objects.
 *
 * @author Zach Shaffer
 * @version Fall 2021
 */

public class ChocolateChips extends Toppings {
	Cookie wrappedCookie;
	private int calories = 180;
	private double cost = .45;
	/**
 	*  ChocolateChip constructor
 	*  @param newCookie Passes in the cookie object that will be decorated.	
  	**/

	public ChocolateChips(Cookie newCookie) {
		super(newCookie);
		wrappedCookie = newCookie;
	}	
	
	/**
 	* returns description with decorator added
 	* @return updated description
 	**/

	public String getDescription() {
		return wrappedCookie.getDescription() + ", Chocolate Chips";
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
		return "[" + wrappedCookie.toString() + "Chocolate Chips" + "," + this.calories + "," + "$ " + this.cost + "]";
    }
}
