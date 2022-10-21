public class PatternsIntro
{
    public PatternsIntro()
    {
        tediousTenSquares();
        tenSquaresWhileLoop();
        tenSquaresForLoop();
        rowOfSquares(8, "black", 100, 300, 30, 20);
    }

    /**
     * Creates a row of 10 blue squares, each is 40x40 pixels, repeated every 50
     * pixels on the x-axis. The top-left corner of the row is at (x,y) =
     * (100,100)
     */
    public void tediousTenSquares() 
    {
        new Square(100, 100, 40, "blue");
        new Square(150, 100, 40, "blue");
        new Square(200, 100, 40, "blue");
        new Square(250, 100, 40, "blue");
        new Square(300, 100, 40, "blue");
        new Square(350, 100, 40, "blue");
        new Square(400, 100, 40, "blue");
        new Square(450, 100, 40, "blue");
        new Square(500, 100, 40, "blue");
        new Square(550, 100, 40, "blue");
    }

    public void tenSquaresWhileLoop()
    {
        int i = 0;
        int x = 100;
        while(i < 10)
        {
            new Square(x, 200, 20, "red");
            x += 50;
            i++;
        }
    }

    public void tenSquaresForLoop() 
    {
        int x = 100;
        for(int i = 0; i < 10; i++)
        {
            new Square(x, 250, 20, "green");
            x += 50;
        }
    }

    public void rowOfSquares(int numSquares, String color,
    int x, int y, int size, int spacing)
    {
        for(int i = 0; i < numSquares; i++)
        {
            new Square(x, y, size, color);
            x += size + spacing;
        }
    }
}
