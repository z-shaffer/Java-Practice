
public class MallardDuck extends Duck {

    public MallardDuck(String name, FlyBehavior fb) {
	super(name, fb);
    }

    public void display() {
	System.out.println("I'm a Mallard duck named " + getName() + ".");
    }
}
