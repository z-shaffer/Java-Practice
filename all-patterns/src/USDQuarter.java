/**
 * USDQuarter is a realization of the coin abstraction.
 *
 * @author Zach Shaffer
 * @version Nov 2021
 */

public class USDQuarter extends Coin {

    /**
       Constructor.

       USDQuarter knows its attribute values.
    */
    public USDQuarter() {
	super("Quarter", 0.25, "USD");
    smelt = new Smelt3();
    } 
}
