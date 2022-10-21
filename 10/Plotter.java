import java.util.Scanner;
/**
 * Short, one-line description of Plotter class here.
 */
public class Plotter
{
    public static void main(String[] args)
    {
        Plotter plotter = new Plotter();
        plotter.drawAxes();
        Scanner keyboard = new Scanner(System.in);
        plotter.plotPointsProper(keyboard);
    }

    public void drawXAxis()
    {
        for (int x = 0; x < 296; x += 5)
        {
            new Square(x, 147);
        }
    }

    public void drawOneXTick(int x)
    {
        for (int y = 137; y < 162; y += 5)
        {
            new Square(x, y);
        }
    }

    public void drawAllXTicks()
    {
        for (int x = 7; x < 290; x += 20)
        {
            drawOneXTick(x);
        }
    }

    public void drawYAxis()
    {
        for (int y = 0; y < 296; y += 5)
        {
            new Square(147, y);
        }
    }

    public void drawOneYTick(int y)
    {
        for (int x = 137; x < 162; x += 5)
        {
            new Square(x, y);
        }
    }

    public void drawAllYTicks()
    {
        for (int y = 7; y < 290; y += 20)
        {
            drawOneYTick(y);
        }
    }

    public void drawAxes()
    {
        drawXAxis();
        drawYAxis();
        drawAllXTicks();
        drawAllYTicks();
    }

    public void plotPoints(Scanner keyboard)
    {
        while (1 < 2)
        {
            System.out.print("Enter an x and y coordinate: ");
            //Read x from user
            int x = keyboard.nextInt();
            //Read y from user
            int y = keyboard.nextInt();
            if (x >= 0 && x <= 290 && y >= 0 && y <= 290)
            {
                new Circle(x,y);
            }
            else
            {
                System.out.println("Done");
                return;
            }
        }
    }

    public void plotPointsProper(Scanner keyboard)
    {
        while (1 < 2)
        {
            System.out.print("Enter an x and y coordinate: ");
            //Read x from user
            int x = keyboard.nextInt();
            //Read y from user
            int y = keyboard.nextInt();
            if (x >= -150 && x <= 140 && y >= -140 && y <= 150)
            {
                x += 144;
                y = 144 - y;
                new Circle(x,y);
            }
            else
            {
                System.out.println("Done");
                return;
            }
        }
    }
}
