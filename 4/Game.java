import java.util.Scanner;

/**
 * Short, one-line description of Game class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author Zach Shaffer
 * @version 9/30/2020
 */
public class Game
{   
    /**
     * No parameter constructor for objects of class Game.
     */
    public Game()
    {
    }

    /**
     * An example of a method.  Describe this method here.
     * 
     * @param  y     A sample parameter for this method.
     * @return     Double the parameter and return it. 
     */
    public static void main(String[] args)
    {
        int x = 0;
        int y = 0;
        int exit = 0;
        Scanner keyboard = new Scanner(System.in);
        String move;
        System.out.println("Welcome! Your starting coordinates are (0, 0).");
        System.out.println("Acceptable commands are 'up', 'down', 'left'," + 
            " 'right' or 'exit'.");
        System.out.println("Next Move?");
        do
        {
            move = keyboard.nextLine();
            switch (move)
            {
                case "up":
                    y++;
                    System.out.println("You are now on (" + x + ", " + y + "). Next?");
                    break;
                case "down":
                    y--;
                    System.out.println("You are now on (" + x + ", " + y + "). Next?");
                    break;
                case "left":
                    x--;
                    System.out.println("You are now on (" + x + ", " + y + "). Next?");
                    break;
                case "right":
                    x++;
                    System.out.println("You are now on (" + x + ", " + y + "). Next?");
                    break;
                case "exit":
                    exit = 1;
                    System.out.println("Goodbye. You ended on (" + x + ", " + y + ").");
                    break;
            }
        }
        while(exit == 0);
    }

}
