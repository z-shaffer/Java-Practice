import java.util.ArrayList;

public class CheckerBoard
{
    private ArrayList<Row> rowList;

    public CheckerBoard()
    {
        rowList = new ArrayList<Row>();
        for (int i = 0; i < 8; i++)
        {
            rowList.add(new Row(i));
        }
        reverseColors();
    }

    public void reverseColors()
    {
        for (int i = 1; i < rowList.size(); i += 2)
        {
            rowList.get(i).changeOddToBlack();
        }
    }

    public void delay(long waitAmountMillis)
    {

    }

    public void extraCreditAnimation()
    {

    }

    public ArrayList<Row> getRowList()
    {
        return rowList;
    }

    public void setRowList(ArrayList<Row> rowList)
    {
        this.rowList = rowList;
    }
}
