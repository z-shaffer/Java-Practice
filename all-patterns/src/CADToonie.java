/**
 * CADToonie is a realization of the coin abstraction.
 *
 * @author Chris Caggia
 * @version Nov 2021
 */

public class CADToonie extends Coin {

    /**
       Constructor.

       CADToonie knows its attribute values.
    */
    public CADToonie() {
	super("Toonie", 2.0, "CAD");
    smelt = new Smelt5();
    } 
}
