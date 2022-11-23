/**
 * USDPenny is a realization of the coin abstraction.
 *
 * @author Zach Shaffer
 * @version Nov 2021
 */

public class USDPenny extends Coin {

    /**
       Constructor.

       USDPenny knows its attribute values.
    */
    public USDPenny() {
	super("Penny", 0.01, "USD");
    smelt = new Smelt1();
    } 
}
