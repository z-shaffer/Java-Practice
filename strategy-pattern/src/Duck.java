
public abstract class Duck {
    private String name;
    protected FlyBehavior fb;

    public Duck(String name, FlyBehavior fb) {
	this.name = name;
	this.fb = fb;
    }

    abstract public void display();
    public String getName() { return name; }

    public void fly() {
	fb.fly();
    }

    public void quack() {
	System.out.println("" + name + " says Quack.");
    }

    public void swim() {
	System.out.println("" + name + "'s webbed feet a paddlin'...");
    }
}
