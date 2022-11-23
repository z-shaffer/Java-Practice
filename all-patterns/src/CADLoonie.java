/**
 * CADLoonie is a realization of the coin abstraction.
 *
 * @author Chris Caggia
 * @version Nov 2021
 */

public class CADLoonie extends Coin {

    /**
       Constructor.

       CADLoonie knows its attribute values.
    */
    public CADLoonie() {
	super("Loonie", 1.0, "CAD");
    smelt = new Smelt5();
    } 
}
