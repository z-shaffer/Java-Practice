import java.lang.reflect.*;
/*
 * Cookie Factory class to make cookies to send to the store
 *
 * Author: Zach Shaffer
 * Date: Oct 2021
 */
public class CookieFactory
{
	/*
 	* A default no-arg constructor for the factory.
 	*/ 	
	public CookieFactory()
	{
	}

	/*
 	* The factory produces a cookie
 	* @param type Takes the type of cookie in and creates the base
 	* @param toppings Takes the list of toppings and adds them on/wraps the base
 	* @return cc Returns the final cookie to the store
 	*/	 	
	public Cookie createCookie(String type, String[] toppings) 
	{
		Cookie cc = null;
		Class cl = null;
		try {	cl = Class.forName(type); }
		catch (ClassNotFoundException e) 
		{ 
			System.err.println("Class not found."); 
			e.printStackTrace(); 
		}
		Object o = null;
		if (cc == null)
		{
			try 
			{ 
				o = cl.newInstance(); 
			} 	
			catch (InstantiationException e) 
			{
				System.err.println("Not able to instantiate."); 
				e.printStackTrace(); 
			}
			catch (IllegalAccessException e) 
			{ 
				System.err.println("Not able to access."); 
				e.printStackTrace(); 
			}
			cc = (Cookie) o;			
		}
		for (String s: toppings)
		{
			o = null;
			cl = null;
			try { cl = Class.forName(s); }
			catch (ClassNotFoundException e)
			{
				System.err.println("Class not found.");
				e.printStackTrace();
			}
			try
			{	
				o = Class.forName(s).getConstructor(Cookie.class).newInstance(cc);
			}
			catch (InstantiationException e) 
			{
				System.err.println("Not able to instantiate."); 
				e.printStackTrace(); 
			}
			catch (IllegalAccessException e) 
			{ 
				System.err.println("Not able to access."); 
				e.printStackTrace(); 
			}
			catch (NoSuchMethodException e)
			{
				System.err.println("No such method.");
				e.printStackTrace();
			}
			catch (InvocationTargetException e)
			{
				System.err.println("Invocation target exception");
				e.printStackTrace();
			}
			catch (ClassNotFoundException e)
			{
				System.err.println("Class not found.");
				e.printStackTrace();
			}	
			((Topping) o).wrap(cc);
			cc = (Cookie) o;
		}
		return cc;
	}
}
	
