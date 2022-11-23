

/**
 * USDMint creates US coin objects.
 *
 * @author Adam Farshchi, Chris Caggia
 * @version Nov 2021
 */
public class USDMint extends Mint {

    private static USDMint instance;
    
    private USDMint()
    {
        super();
    }

    public static USDMint getInstance()
    {
        if(instance == null)
            instance = new USDMint();
        return instance;
    }

    protected Coin createCoin(double den) {

	int cents = (int) (den * 100);

	Coin c;

	switch(cents)
	{
	  case 100: c = new USDDollar();
	  break;

	  case 50: c = new USDHalfDollar();
	  break;

	  case 25: c = new USDQuarter();
	  break;

	  case 10: c = new USDDime();
	  break;

	  case 5: c = new USDNickel();
	  break;

	  case 1: c = new USDPenny();
	  break;
	  
	  default: c = Coin.NULL;
	}
	

	return c;
		
    }
}
