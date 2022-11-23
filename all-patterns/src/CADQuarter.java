/**
 * CADQuarter is a realization of the coin abstraction.
 *
 * @author Chris Caggia
 * @version Nov 2021
 */

public class CADQuarter extends Coin {

    /**
       Constructor.

       USDQuarter knows its attribute values.
    */
    public CADQuarter() {
	super("Quarter", 0.25, "CAD");
    smelt = new Smelt5();
    } 
}
