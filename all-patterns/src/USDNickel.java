/**
 * USDNickel is a realization of the coin abstraction.
 *
 * @author Zach Shaffer
 * @version Nov 2021
 */

public class USDNickel extends Coin {

    /**
       Constructor.

       USDNickel knows its attribute values.
    */
    public USDNickel() {
	super("Nickel", 0.05, "USD");
    smelt = new Smelt2();
    } 
}
