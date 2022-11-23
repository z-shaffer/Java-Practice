/**
 * CADDime is a realization of the coin abstraction.
 *
 * @author Chris Caggia
 * @version Nov 2021
 */

public class CADDime extends Coin {

    /**
       Constructor.

       CADDime knows its attribute values.
    */
    public CADDime() {
	super("Dime", 0.1, "CAD");
    smelt = new Smelt5();
    } 
}
