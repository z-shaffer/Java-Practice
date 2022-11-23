
public class Demo {
    public static void main(String[] args) {
	Cookie c = new Sprinkles(new Pecans(new SugarCookie()));
	System.out.println(c);
	System.out.println("Just made a " + c.getDescription() + " cookie.");
	System.out.println("This cookie has " + c.calories() + " calories.");
	System.out.println("This cookie costs " + c.cost() + ".");
	System.out.println("Contains nuts: " + c.hasNuts());
    }
}
