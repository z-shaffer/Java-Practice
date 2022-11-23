
public class Demo {
 
    public static void main(String[] args) {
	Flap flap = new Flap(); 
	NoFly nf = new NoFly();
	Duck	george = new MallardDuck("George", flap);
	Duck	martha = new RedheadDuck("Martha", flap);
	Duck    bob = new RubberDuck("Bob", nf);
	Duck    carl = new TealDuck("Carl", flap);

	george.display();
	george.quack();
	george.fly();	
	george.swim();

	martha.display();
	martha.quack();
	martha.fly();	
	martha.swim();

	bob.display();
	bob.quack();
	bob.fly();	
	bob.swim();

	carl.display();
	carl.quack();
	carl.fly();	
	carl.swim();


    }
}
