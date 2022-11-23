public class Walnuts extends Topping {
    public Walnuts(Cookie base) {
	super("Walnuts", 290, 0.10, base);
    }
    public boolean hasNuts() { return true; }
}
