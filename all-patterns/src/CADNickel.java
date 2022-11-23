/**
 * CADNickel is a realization of the coin abstraction.
 *
 * @author Chris Caggia
 * @version Nov 2021
 */

public class CADNickel extends Coin {

    /**
       Constructor.

       CADNickel knows its attribute values.
    */
    public CADNickel() {
	super("Nickel", 0.05, "CAD");
    smelt = new Smelt5();
    } 
}
