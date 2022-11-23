
/**
 * Toppings is an abstraction of cookie objects.
 *
 * @author Zach Shaffer
 * @version Fall 2021
 */

abstract class Toppings extends Cookie {
	
	/**
 	* Constructs a cookie decorator and passes it to the superconstructor.
 	**/ 

	public Toppings(Cookie newCookie) {
	super(newCookie.getDescription(), newCookie.calories(), newCookie.cost());
	}
}
