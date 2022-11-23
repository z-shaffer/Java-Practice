
abstract public class Topping extends Cookie {
    
    private Cookie baseCookie;

    public Topping(String name, int calories, double cost, Cookie base) {
	super(name, calories, cost);
	baseCookie = base;
    }

    public String toString() {
	return "[" 
	    + baseCookie.toString()
	    + super.getDescription() + "," 
	    + super.calories() + "," 
	    + "$ " + super.cost() 
	    + "]";
    }
    public int calories() {
	return super.calories() + baseCookie.calories();
    }
    public double cost() {
	return super.cost() + baseCookie.cost();
    }
    public boolean hasNuts() {
	return super.hasNuts() || baseCookie.hasNuts();
    }
    public void wrap(Cookie c) {
   	baseCookie = c;
    }
}
