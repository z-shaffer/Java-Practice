import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * Tests employee class
 *
 * @author Joel Swanson - modified Brooke Tibbett
 * @version 02.07.2014 - modified 9/3/2020
 */
public class TestManyMethods
{
    private ManyMethods m;
    private Random random;

    public TestManyMethods()
    {
        random = new Random(System.currentTimeMillis());
    }
    
    @Test
    public void checkTemperatureHot()
    {
        String fb = "";
        int randomTemp = (random.nextInt(50) + 50);
        
        m = new ManyMethods();
        String result = m.temperature(randomTemp);

        fb += "Test for temperature failed.\n";    

        if (!(result.equals("hot")))
        {
            fb += "Your method did not return hot when temp is" 
                + " 50 or more.\n";
            fail(fb);
        }
    }

    
    @Test
    public void checkTemperatureCold()
    {
        String fb = "";
        int randomTemp = (random.nextInt(50));
        
        m = new ManyMethods();
        String result = m.temperature(randomTemp);

        fb += "Test for temperature failed.\n";    

        if (!(result.equals("cold")))
        {
            fb += "Your method did not return cold when temp is" 
                + " less than 50.\n";
            fail(fb);
        }
    }
    
    @Test
    public void checkCupcakesNotEnough()
    {
        String fb = "";
        int flour = 0;
        int sugar = (random.nextInt(3));
        int eggs = (random.nextInt(4));
        
        m = new ManyMethods();
        boolean result = m.cupcakes(flour, eggs, sugar);

        fb += "Test for cupcakes failed.\n";    

        if (result)
        {
            fb += "Your method did not return false when" 
                + " there are not enough ingredients.\n";
            fail(fb);
        }
    }
    
    @Test
    public void checkCupcakesEnough()
    {
        String fb = "";
        int flour = (random.nextInt(10) + 1);
        int sugar = (random.nextInt(10) + 2);
        int eggs = (random.nextInt(10) + 3);
        System.out.print(flour + " " + sugar + " " + eggs);
        m = new ManyMethods();
        boolean result = m.cupcakes(flour, sugar, eggs);

        fb += "Test for cupcakes failed.\n";    

        if (!result)
        {
            fb += "Your method did not return true when" 
                + " there are enough ingredients.\n";
            fail(fb);
        }
    }
    
    @Test
    public void testBlackjackHit()
    {
        String fb = "";
        int card1 = (random.nextInt(6) + 1);
        int card2 = (random.nextInt(4) + 1);
        int card3 = (random.nextInt(4) + 1);
        
        m = new ManyMethods();
        String result = m.blackjack(card1, card2, card3);

        fb += "Test for blackjack failed.\n";    

        if (!result.equals("hit"))
        {
            fb += "Your method did not return hit when" 
                + " the cards are less than 15.\n";
            fail(fb);
        }
    }
    
    @Test
    public void testBlackjackStay()
    {
        String fb = "";
        int card1 = (random.nextInt(9) + 1);
        int card2 = (random.nextInt(5) + 1);
        int card3 = 20 - card2 - card1;
        
        m = new ManyMethods();
        String result = m.blackjack(card1, card2, card3);

        fb += "Test for blackjack failed.\n";    

        if (!result.equals("stay"))
        {
            fb += "Your method did not return stay when" 
                + " the cards are less than 21.\n";
            fail(fb);
        }
    }
    
    @Test
    public void testBlackjackWin()
    {
        String fb = "";
        int card1 = (random.nextInt(11) + 1);
        int card2 = (random.nextInt(9) + 1);
        int card3 = 21 - card1 - card2;
        
        m = new ManyMethods();
        String result = m.blackjack(card1, card2, card3);

        fb += "Test for blackjack failed.\n";    

        if (!result.equals("win"))
        {
            fb += "Your method did not return win when" 
                + " the cards equal 21.\n";
            fail(fb);
        }
    }
    
    @Test
    public void testBlackjackFail()
    {
        String fb = "";
        int card1 = (random.nextInt(11) + 1);
        int card2 = (random.nextInt(11) + 1);
        int card3 = 30 - card1 - card2;
        
        m = new ManyMethods();
        String result = m.blackjack(card1, card2, card3);

        fb += "Test for blackjack failed.\n";    

        if (!result.equals("fail"))
        {
            fb += "Your method did not return fail when" 
                + " the cards are more than 21.\n";
            fail(fb);
        }
    }
}
