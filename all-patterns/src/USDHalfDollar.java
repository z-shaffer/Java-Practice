/**
 * USDHalfDollar is a realization of the coin abstraction.
 *
 * @author Zach Shaffer
 * @version Nov 2021
 */

public class USDHalfDollar extends Coin {

    /**
       Constructor.

       USDHalfDollar knows its attribute values.
    */
    public USDHalfDollar() {
	super("Half Dollar", 0.50, "USD");
    smelt = new Smelt3();
    } 
}
