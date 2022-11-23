

/**
 * USDMint creates US coin objects.
 *
 * @author Adam Farshchi, Chris Caggia
 * @version Nov 2021
 */
public class CADMint extends Mint {

    private static CADMint instance;
    
    private CADMint()
    {
        super();
    }

    public static CADMint getInstance()
    {
        if(instance == null)
            instance = new CADMint();
        return instance;
    }

    protected Coin createCoin(double den)
    {

	int cents = (int)(den * 100);
	Coin c;

	switch(cents)
	{	
	  case 200: c = new CADToonie();
	  break;

	  case 100: c = new CADLoonie();
	  break;

	  case 50: c = new CADFiftyCent();
	  break;

	  case 25: c = new CADQuarter();
	  break;

	  case 10: c = new CADDime();
	  break;

	  case 05: c = new CADNickel();
	  break;

	  default:   c = Coin.NULL;
	}

	return c;
    }
}
