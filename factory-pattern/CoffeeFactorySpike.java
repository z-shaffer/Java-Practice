/*
 * Playing with an idea for a simplified Factory Method
 * design pattern assignment.
 *
 * In Decorator (Star Buzz coffee drinks) the "Conversation
 * with a Decorator" mentioned that a difficulty was how
 * to nest Decorators when creating things. We said that a
 * factory pattern was a potential solution. So this is that.
 *
 * String base = "HouseBlend"; // other future options: Pine, Spruce
 * String[] addOns = {"Mocha", "Whip"};
 * Beverage drink = factory.makeTree(base, addIns);
 *
 * So, can we turn a String into an object of that name? Let's find out...
 * Turns, out (see below) that we CAN!! 
 */

public class CoffeeFactorySpike {
    public static void main(String[] args) {
	Beverage b = null;
	String[] items = {"HouseBlend", "Whip", "Whip"}; 
	for (String s : items) {
	    System.out.print("String to convert: ");
	    System.out.println(s);
	    Class c = null;
	    try {
		c = Class.forName(s);
	    } catch (ClassNotFoundException e) {
		System.err.println("Class not found.");
		e.printStackTrace();
	    }
	    System.out.println("Just converted a string into a class object!");
	    System.out.println(c);
	    System.out.println();
	    Object o = null;
	    try {
		o = c.newInstance();
	    } catch (InstantiationException e) {
		System.err.println("Not able to instantiate.");
		e.printStackTrace();
	    } catch (IllegalAccessException e) {
		System.err.println("Not able to access.");
		e.printStackTrace();
	    }
	    System.out.println("Just instantiated an object of that class");
	    System.out.println(o);
	    System.out.println();

	    if (b == null) {
		// first item so base tree
		b = (Beverage) o;
	    }
	    else {
		// not base so wrap
		((Decoration) o).wrap(b);
		b = (Beverage) o;
	    }
	    System.out.println("Just casted that object as a Beverage and possibly did some decorator stuf");
	    System.out.println(b);
	    System.out.println();
	}
	System.out.println();
	System.out.println("Final drink: " + b.name() 
			   + " costs $" + b.cost());
	System.out.println();
    }
}

abstract class Beverage {
    private String description;
    private float cost;

    public void setDescription(String d) { description = d; }
    public String getDescription() { return description; }
    public abstract float cost();
    public abstract String name();

    public String toString() {
	return "["+ getDescription() 
	    + "," + cost()
	    + "]";
    }
}

class HouseBlend extends Beverage {
    private static float HouseBlendCost = 1.99f;
    public HouseBlend() {
	super();
	setDescription("HouseBlend");
    }
    public float cost() { return HouseBlendCost; }
    public String name() { return " HouseBlend"; }
}

abstract class Decoration extends Beverage {
    protected Beverage component;
    public void wrap(Beverage t) { component = t; }
    public String toString() {
	return "["+ (component==null ? "null" : component.toString())
	    + ", " + getDescription() 
	    + "," + (cost()-(component==null ? 0 : component.cost()))
	    + "]";
    }
    public String name() {
	return (component==null) ? "" : component.name();
    }
}
class Whip extends Decoration {
    private static float WhipCost = .29f;
    public Whip() {
	super();
	setDescription("Whip");
    }
    public float cost() {
	return WhipCost + (component==null ? 0 : component.cost());
    }
    public String name() { return " Whip" + super.name(); }
}
