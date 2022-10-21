import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int x = 0;
        int y = 0;
        String command = "";

        System.out.println("Welcome! Your starting coordinates are (0, 0).");
        System.out.println("Acceptable commands are 'up', 'down', 'left', 'right' or 'exit'.");
        System.out.println("Next Move?");

        while (!(command.equals("exit")))
        {
            command = input.nextLine();
            switch (command)
            {
                case "left":
                if(x == 0)
                {
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                else
                {
                    x--;
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                case "right":
                if(x == 20)
                {
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                else
                {
                    x++;
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                case "down":
                if(y == 20)
                {
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                else
                {
                    y++;
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                case "up":
                if(y == 0)
                {
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                else
                {
                    y--;
                    System.out.println("You are now on (" + y + ", " + x 
                        + "). Next?");
                    break;
                }
                case "exit":
                System.out.println("Goodbye. You ended on (" + y + ", " 
                    + x + ").");
                break;
            }
            if (!(command.equals("exit")))
            {
                for (int c = 0; c < 20; c++)
                {
                    for (int r = 0; r < 20; r++)
                    {
                        if(r == x && c == y)
                        {
                            System.out.print("X");
                        }
                        else
                        {
                            System.out.print("-");
                        }
                    }
                    System.out.println("");
                }
            }
        }
    }
}