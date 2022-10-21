/**
 * ManyMethods.java
 * 
 */


//Put any imports below this line.
 
 
/**
 * Short, one-line description of ManyMethods class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ManyMethods
{
    //Put instance variables below this line.  
    
    
    /**
     * No parameter constructor for objects of class ManyMethods.
     */
    public ManyMethods()
    {
    }
    
    /**
     * An example of a method.  Describe this method here.
     * 
     * @param  y     A sample parameter for this method.
     * @return     Double the parameter and return it. 
     */
    public String temperature(int temp)
    {
        if(temp < 50)
        return "cold";
        else 
        return "hot";
    }
    
    public boolean cupcakes(int flour, int sugar, int eggs)
    {
        if(flour >= 1 && sugar >= 2 && eggs >= 3)
        return true;
        else 
        return false;
    }

    public String blackjack(int card1, int card2, int card3)
    {
        if(card1 + card2 + card3 < 15)
        return "hit";
        else if(card1 + card2 + card3 < 21 && card1 + card2 + card3 >=15 )
        return "stay";
        else if(card1 + card2 + card3 == 21)
        return "win";
        else
        return "fail";
    }    
    
    public double paycheck(int hours, double payRate, boolean twoWeeks)
    {
        if(twoWeeks == true)
        {
            if(hours <= 40)
            return hours * payRate;
            else
            {
                int o = hours - 40;
                return (40 * payRate) + (payRate * 1.5 * o);
            }
        }
        else
        return 0.0;
        
    }
}
