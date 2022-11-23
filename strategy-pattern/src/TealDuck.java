
public class TealDuck extends Duck {

    public TealDuck(String name, FlyBehavior fb) {
	super(name, fb);
    }

    public void display() {
	System.out.println("I'm a Teal duck named " + getName() + ".");
    }
}
