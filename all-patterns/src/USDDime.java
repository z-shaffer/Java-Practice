/**
 * USDDime is a realization of the coin abstraction.
 *
 * @author Zach Shaffer
 * @version Nov 2021
 */

public class USDDime extends Coin {

    /**
       Constructor.

       USDDime knows its attribute values.
    */
    public USDDime() {
	super("Dime", 0.10, "USD");
    smelt = new Smelt3();
    } 
}
