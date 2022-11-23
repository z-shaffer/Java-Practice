/*
 * This one source file has all generic coin stuff in it.
 * abstract class Coin
 * abstract class CoinFactory
 *
 * For concrete USD coin stuff look in USDCoin file.
 * Similarly for other countries...
 */

import java.util.Currency;
import java.util.Locale;
import java.text.DecimalFormat;
import java.rmi.*;

abstract class Coin {
    // Basic coin attributes, and constructor that uses them.
    private double multiplier;
    private Currency currency;
    private String serial;
    Coin(String code, double m) { 
	multiplier = m; 
	currency = Currency.getInstance(code);
	serial = null;
    }
    public void setSerial(String s) {
	    this.serial = s;
    }

    // Basic accessor methods
    public double value() {
	return multiplier;
    }
    public String serial() {
	    return serial;
    }
    public String toString() {
	// uses some private helper methods for currency symbols...
	String symbol = 
	    currency.getSymbol(getLocale(currency.getCurrencyCode()));
	String className = this.getClass().getName();
	return "(" + className + ")" + symbol + stringValue() + "(SERIAL: " + serial + ")";
    }


    // Smelting strategy delegate
    private Smelter smelter;
    public Smelter getSmelter() { return smelter; }
    public void setSmelter(Smelter s) { smelter = s; }


    // abstract methods
    //   Each coin does a unique imprinting
    //   Each coin must have an accept for the polymorphic dispatch resolution
    public abstract Coin imprint(Coin c);
    public abstract void accept(CoinVisitor v);


    // Helper methods for printing
    protected String getCurrencyCode() {
	    return currency.getCurrencyCode();  // USD, EUR, etc.
    }
    private Locale getLocale(String code) {
	    if ("USD".equals(code)) return Locale.US;
	    else if ("GBP".equals(code)) return Locale.UK;
	    else if ("EUR".equals(code)) return Locale.FRANCE;
	    else if ("CAD".equals(code)) return Locale.CANADA;
	    else return Locale.getDefault();
    }
    private String stringValue() {
	    DecimalFormat df = new DecimalFormat();
	    df.setMaximumFractionDigits(2);
	    df.setMinimumFractionDigits(2);
	    return df.format(multiplier);
    }


    // Null object design pattern for Coins
    static class NullCoin extends Coin {
	private NullCoin() { super("USD", 0.0); }
	public String toString() { return ""; }
	public void accept(CoinVisitor v) { v.visit(this); }
	public Coin imprint(Coin c) { return this; }
    }
    public static final Coin NULL = new NullCoin();
}







/************************************************* CoinFactory **************/

abstract class CoinFactory {
    String name;
    public CoinFactory(String name) {
	    this.name = name;
    }
    public String getName() { return name; }

    // doubles don't compare nicely sometimes, so this method is available
    // to all subclasses
    protected boolean eq(double a, double b) {
	    // Because doubles don't == nicely
	    return (Math.abs(a-b) < 0.00001);
    }
    

    // Factory method! (used by makeCoin public method)
    //  Pattern says: "Let the subclasses decide." 
    //  So here the USDFactory knows how to manufacture USD coins...
    protected abstract Coin manufactureCoin(double type);


    // Coin mutators; concrete coins do these specific to themselves.
    protected abstract Coin smelt(Coin c);
    protected abstract Coin imprint(Coin c);


    // Common part of making all coins
    protected final Coin makeCoin(double type) {
    
	// Use mint-specific factory method manufacture to get "raw" coin, 
	//   then finish processing of it
	Coin c = manufactureCoin(type); 
	if (c != Coin.NULL) {

	    // smelting and imprinting processes are specific to coin type
	    c = smelt(c);
	    c = imprint(c);

	    // common coin production processes
	    if (! (inspect(c) && smooth(c) && polish(c))) {
		        System.out.println("Failed to manufacture coin.");
		        c = Coin.NULL;
	    }
		else
	    {
		inscribe(c);
	    }
	}
	return c;
    }

    // Different steps in internal coin production process...
    public void inscribe(Coin c) {
	    System.out.print("Inscribing " + c.getClass().getName() + "...");
	    try {
		     IMF_Coin_SN service = (IMF_Coin_SN) Naming.lookup("//127.0.0.1/IMF_Coin_SN");
		     String code = c.getCurrencyCode();
		     String className = c.getClass().getName();
	    	     String newSerial = service.getUniqueSN(code, className);
		     c.setSerial(newSerial);
	    	     System.out.println("Assigned serial: " + c.serial());
            } catch (Exception e) {
                     e.printStackTrace();
            }
    }

    public boolean smooth(Coin c) {
	    System.out.print("Smoothing " + c.getClass().getName() + "...");
	    if (Randomizer.getInstance().oneIn(1000)) {
	        System.out.println("failed.");	   
	        return false;
	    }
	    else {
	        System.out.println("completed.");
	        return true;
	    }
    }

    protected boolean inspect(Coin c) {
	    System.out.print("Inspecting " + c.getClass().getName() + "...");
	    if (Randomizer.getInstance().oneIn(1000)) {
	        System.out.println("failed.");	   
	        return false;
	    }
	    else {
	        System.out.println("completed.");
	        return true;
	    }
    }

    protected boolean polish(Coin c) {
	    System.out.print("Polishing " + c.getClass().getName() + "...");
	    if (Randomizer.getInstance().oneIn(5)) {
	        System.out.println("failed.");	   
	        return false;
	    }
	    else {
	        System.out.println("completed.");
	        return true;
	    }
    }
}


