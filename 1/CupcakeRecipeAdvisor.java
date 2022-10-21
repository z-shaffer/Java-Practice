import java.util.Scanner;
public class CupcakeRecipeAdvisor
{
    public static void main(String[] args)
    {
        int cupcakes;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many cupcakes would you like to make?");
        cupcakes = keyboard.nextInt();
        double sugar = 3.0 / 36, milk = 1.5 / 36, vegetableOil = .75 / 36;
        System.out.println("To make " + cupcakes + " cupcakes, you will need:");
        System.out.println("\t" + sugar * cupcakes + " cups of sugar");
        System.out.println("\t" + milk * cupcakes + " cups of milk");
        System.out.print("\t" + vegetableOil * cupcakes + " cups of vegetable oil");
    }
}
