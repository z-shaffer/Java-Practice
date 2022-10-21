/**
 * dog.java
 * 
 */

//Put any imports below this line.

/**
 * Short, one-line description of dog class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dog
{
    private String name;
    private int age;
    private String breed;

    /**
     * No parameter constructor for objects of class dog.
     */
    public Dog()
    {
        name = "";
        age = 0;
        breed = "";
    }

    public Dog(String n, int a, String b)
    {
        name = n;
        age = a;
        breed = b;
    }

    public String bark()
    {
        return "bark!";
    }

    public String bark(String noun)
    {
        return "barking at " + noun + "!";
    }

    public void increaseAge()
    {
        age++;
    }

    public String getName()
    {
        return name;
    }

    public String getBreed()
    {
        return breed;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int a)
    {
        age = a;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setBreed(String b)
    {
        breed = b;
    }

    public String toString()
    {
        return String.format("name: %s\nage: %d\nbreed: %s", name, age, breed);
    }

    public boolean equals(Dog other)
    {
        return (breed.equals(other.breed) && age == other.age && name.equals(other.name));
    }
}
