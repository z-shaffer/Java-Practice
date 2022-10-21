package solution;

public abstract class Animal
{
	String name;
	Zoo zoo;
	int hungerLevel = 0;

	public Animal(Zoo myZoo, String animalName)
	{
		zoo = myZoo;
		name = animalName;
		hungerLevel = 0;	
	}
	
	public int getHungerLevel()
	{
		return hungerLevel;
	}

	public void setHungerLevel(int hunger)
	{
		if(hunger > 10)
		{
			hungerLevel = 10;
		}
		else if (hunger < 0)
		{
			hungerLevel = 0;
		}
		else {
		hungerLevel = hunger;
		}
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String animalName)
	{
		name = animalName;
	}

	public void sleep()
	{
		System.out.println("sleeping...");
		setHungerLevel(10);
	}

	public void roam()
	{
		System.out.println("moving around...");
		setHungerLevel(hungerLevel + 1);
	}

	public abstract void makeNoise();

	public abstract void eat();
}
