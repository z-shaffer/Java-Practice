import java.util.Scanner;
public class WordGame
{
    public static void main(String[] args)
    {
        String name, profession, college, animalType, animalName;
        int age;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        name = keyboard.nextLine();
        System.out.print("Enter a profession: ");
        profession = keyboard.nextLine();
        System.out.print("Enter the name of a college: ");
        college = keyboard.nextLine();
        System.out.print("Enter a type of animal: ");
        animalType = keyboard.nextLine();
        System.out.print("Enter a pet name: ");
        animalName = keyboard.nextLine();
        System.out.print("Enter your age: ");
        age = keyboard.nextInt();
        System.out.println();
        
        System.out.println("This is the story of " + name.toUpperCase() + ".");
        System.out.println(name.toUpperCase() + " was determined to become a " + profession.toUpperCase() + ".");
        System.out.println("So they went to college at " + college.toUpperCase() + ".");
        System.out.println(name.toUpperCase() + " worked really hard and achieved their dream at the age of " + age + "!");
        System.out.println(name.toUpperCase() + " decided to adopt a(n) " + animalType.toUpperCase() + " named " + animalName.toUpperCase() + ".");
        System.out.println(name.toUpperCase() + " and " + animalName.toUpperCase() + " both lived happily ever after or did they?");
    }
}
