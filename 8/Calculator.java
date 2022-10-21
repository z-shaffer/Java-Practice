/**
 * Short, one-line description of Calculator class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author Zach Shaffer
 * @version 9/18/20
 */
public class Calculator
{
    private int num1;
    private int num2;

    /**
     * No parameter constructor for objects of class Calculator.
     */
    public Calculator(int n1, int n2)
    {
        num1 = n1;
        num2 = n2;
    }

    public int add()
    {
        return num1 + num2;
    }

    public int sub()
    {
        return num1 - num2;
    }

    public int mult()
    {
        return num1 * num2;
    }

    public double div()
    {
        return (double)num1 / num2;
    }

    public void setNum1(int n1)
    {
        num1 = n1;
    }

    public int getNum1()
    {
        return num1;
    }    

    public void setNum2(int n2)
    {
        num2 = n2;
    } 

    public int getNum2()
    {
        return num2;
    }    

    public void prettyDiv()
    {
        System.out.printf("The quotient of " + num1 + " divided by " + num2 +
            " is %.2f.", (double)num1/num2);
    }
}
