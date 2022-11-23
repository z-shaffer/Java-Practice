
public class RubberDuck extends Duck {

    public RubberDuck(String name, FlyBehavior fb) {
	super(name, fb);
    }

    public void display() {
	System.out.println("I'm a Rubber duck named " + getName() + ".");
    }

    public void quack() {
	System.out.println("" + getName() + " says squeak.");
    }

    public void swim() {
	System.out.println("" + getName() + "'s floatin'...");
    }
}
