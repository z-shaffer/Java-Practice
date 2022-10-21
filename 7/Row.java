import java.util.ArrayList;

public class Row
{
    private ArrayList<Square> sqList;
    int y = 0;
    public Row()
    {
        sqList = new ArrayList<Square>();
        addSquaresToList();
        delay(400);
        changeSquareSize(48);
        delay(400);
        changeEvenToBlack();
        delay(400);
    }

    public Row(int rowNumber)
    {
        sqList = new ArrayList<Square>();
        addSquaresToList();
        changeSquareSize(48);
        moveVertically(rowNumber * 50);
        if (rowNumber % 2 == 0)
        {
            changeEvenToBlack();
        }
        else
        {
            changeOddToBlack();
        }
    }

    public void addSquaresToList()
    {
        int x = 0;
        while (sqList.size() < 8)
        {
            sqList.add(new Square(x, y, 50, "red"));
            x += 50;
        }
    }

    public void moveVertically(int amountToMove)
    {
        for (int i = 0; i < sqList.size(); i++)
        {
            sqList.get(i).setY(sqList.get(i).getY() + amountToMove);
        }
    }

    public void changeSquareSize(int size)
    {
        for (int i = 0; i < sqList.size(); i++)
        {
            sqList.get(i).setSize(size);
        }
    }

    public void changeEvenToBlack()
    {
        for (int i = 0; i < sqList.size(); i += 2)
        {
                sqList.get(i).setColor("black");
        }
    }

    public void changeOddToBlack()
    {
        for (int i = 1; i < sqList.size(); i += 2)
        {
            sqList.get(i).setColor("black");
        }
    }

    public void delay(long waitAmountMillis)
    {
        long x = System.currentTimeMillis() + waitAmountMillis;
        while (System.currentTimeMillis() < x)
        {

        }
    }

    public ArrayList<Square> getSqList()
    {
        return sqList;
    }

    public void setSqList(ArrayList<Square> sqList)
    {
        this.sqList = sqList;
    }
}
