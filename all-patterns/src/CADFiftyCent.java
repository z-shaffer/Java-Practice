/**
 * CADFiftyCent is a realization of the coin abstraction.
 *
 * @author Chris Caggia
 * @version Nov 2021
 */

public class CADFiftyCent extends Coin {

    /**
       Constructor.

       CADFiftyCent knows its attribute values.
    */
    public CADFiftyCent() {
	super("FiftyCent", 0.5, "CAD");
    smelt = new Smelt5();
    } 
}
