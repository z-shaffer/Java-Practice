import java.util.Scanner;
/**
 * Short, one-line description of Circle class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author Zach Shaffer 
 * @version 9/18/20
 */
public class Circle
{
    private final double PI = 3.14159;
    private int radius;
    
    /**
     * No parameter constructor for objects of class Circle.
     */
    public Circle(int rad)
    {
        radius = rad;
    }
    
    public double area()
    {
        return radius*radius*PI;
    }
    
    public void setRadius(int rad)
    {
        radius = rad;
    }
    
    public int getRadius()
    {
        return radius;
    }
    
    public void askUser()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a radius: ");
        radius = keyboard.nextInt();
        System.out.printf("The area of this circle is %.2f.", 
                            (double)radius*radius*PI);
    }
}
