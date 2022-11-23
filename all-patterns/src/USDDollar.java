/**
 * USDDollar is a realization of the coin abstraction.
 *
 * @author Zach Shaffer
 * @version Nov 2021
 */

public class USDDollar extends Coin {

    /**
       Constructor.

       USDDollar knows its attribute values.
    */
    public USDDollar() {
	super("Dollar", 1.00, "USD");
    smelt = new Smelt4();
    } 
}
