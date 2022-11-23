/*
 * CookieStore class that recieves cookies from the factory and passes them onto the user.
 *
 * Author: Zach Shaffer
 * Date: Oct 2021
 */

public class CookieStore {
	CookieFactory factory;	

	/*
 	* Single arc constructor that creates the store, linked to the factory.
 	* @param factory The factory the store is linked to.
 	*/ 

	public CookieStore(CookieFactory factory)
	{
		this.factory = factory;
	}

	/*
 	* Method for the customer to order a cookie.
 	* @param type Customer provides the base type of cookie.
 	* @param toppings Customer specifies the toppings they would like added.
 	* @return cookie Returns the finished cookied to the customer.
 	*/

	public Cookie orderCookie(String type, String[] toppings)
	{
		Cookie cookie;
		cookie = factory.createCookie(type, toppings);
		return cookie;
	}
}	
