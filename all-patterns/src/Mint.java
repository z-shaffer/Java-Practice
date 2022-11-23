/**
 * Mint abstraction.
 *
 * @author Adam Farshchi
 * @version Nov 2021
 */
public abstract class Mint {
    public Coin makeCoin(double den) {
        Coin c;
        boolean b = true;
        c = createCoin(den);

        if (c != Coin.NULL)
        {
            c.manufacture(c);
            b = c.inspect(c);
            if (!b)
            {
                return Coin.NULL;
            }
            b = c.smooth(c);
            if (!b)
            {
                return Coin.NULL;
            }
            b = c.buff(c);
            if (!b)
            {
                return Coin.NULL;
            }
        }
        
        return c;
    }

    protected abstract Coin createCoin(double den);
}
