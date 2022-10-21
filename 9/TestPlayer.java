/**
 * TestTire2.java
 */
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout; 
import java.util.Random;
import org.junit.Before;   

/**
 * Describe TestTire2 here.
 *
 * @author Joel Swanson modified Brooke Tibbett
 * @version 03.08.2014 modified 10.16.20
 */
public class TestPlayer
{
    private Random random;  

    @Rule
    public Timeout timeout = new Timeout(30000);    

    public TestPlayer()
    {
        random = new Random();
    }

    /**
     * Check mutators to make sure setName and setSsn work
     * properly.
     */
    @Test
    public void checkMoveAccessors()
    {
        checkBasicMoveA();
        checkRangedMoveA();
        checkDefenseMoveA();
        checkMoveMoveA();
    }      

    /**
     * Check the constructors.
     */
    @Test
    public void checkConstructors()
    {
        checkNoArgConstructor();
        checkArgConstructor();
        checkCopyConstructor();
    }

    /**
     * Check calculateArmorClass method.
     */
    @Test
    public void checkCalculateArmorClass()
    {
        String fb = "";
        int[] res1 = checkCMFighter(1);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateArmorClass method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMWizard(1);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateArmorClass method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMRogue(1);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateArmorClass method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMCleric(1);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateArmorClass method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBarbarian(1);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateArmorClass method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMDruid(1);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateArmorClass method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBard(1);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateArmorClass method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }        
    }

    /**
     * Check CalculateHitpointMax method.
     */
    @Test
    public void checkCalculateHitpointMax()
    {
        String fb = "";
        int[] res1 = checkCMFighter(2);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "CalculateHitpointMax method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMWizard(2);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "CalculateHitpointMax method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMRogue(2);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "CalculateHitpointMax method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMCleric(2);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "CalculateHitpointMax method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBarbarian(2);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "CalculateHitpointMax method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMDruid(2);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "CalculateHitpointMax method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBard(2);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "CalculateHitpointMax method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }        
    }    

    /**
     * Check calculateArmorClass method.
     */
    @Test
    public void checkCalculateMovementSpeed()
    {
        String fb = "";
        int[] res1 = checkCMFighter(3);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateMovementSpeed method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMWizard(3);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateMovementSpeed method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMRogue(3);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateMovementSpeed method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMCleric(3);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateMovementSpeed method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBarbarian(3);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateMovementSpeed method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMDruid(3);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateMovementSpeed method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBard(3);
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "calculateMovementSpeed method failed\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }        
    }

    /**
     * Check LevelUp method.
     */
    @Test
    public void checkLevelUp()
    {
        String fb = "";
        int[] res1 = checkCMFighter(4);
        String portion = res1[2] == 0 ? "Level" :
            res1[2] == 1 ? "HitpointMax" :
            res1[2] == 2 ? "ArmorClass" :
            res1[2] == 3 ? "MovementSpeed" :
            res1[2] == 4 ? "RangedMove Range" :
            "MoveMove Range";
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "LevelUp method failed\n";
            fb += "on " + portion + " field\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMWizard(4);
        portion = res1[2] == 0 ? "Level" :
        res1[2] == 1 ? "HitpointMax" :
        res1[2] == 2 ? "ArmorClass" :
        res1[2] == 3 ? "MovementSpeed" :
        res1[2] == 4 ? "RangedMove Range" :
        "MoveMove Range";
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "LevelUp method failed\n";
            fb += "on " + portion + " field\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMRogue(4);
        portion = res1[2] == 0 ? "Level" :
        res1[2] == 1 ? "HitpointMax" :
        res1[2] == 2 ? "ArmorClass" :
        res1[2] == 3 ? "MovementSpeed" :
        res1[2] == 4 ? "RangedMove Range" :
        "MoveMove Range";
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "LevelUp method failed\n";
            fb += "on " + portion + " field\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMCleric(4);
        portion = res1[2] == 0 ? "Level" :
        res1[2] == 1 ? "HitpointMax" :
        res1[2] == 2 ? "ArmorClass" :
        res1[2] == 3 ? "MovementSpeed" :
        res1[2] == 4 ? "RangedMove Range" :
        "MoveMove Range";
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "LevelUp method failed\n";
            fb += "on " + portion + " field\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBarbarian(4);
        portion = res1[2] == 0 ? "Level" :
        res1[2] == 1 ? "HitpointMax" :
        res1[2] == 2 ? "ArmorClass" :
        res1[2] == 3 ? "MovementSpeed" :
        res1[2] == 4 ? "RangedMove Range" :
        "MoveMove Range";
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "LevelUp method failed\n";
            fb += "on " + portion + " field\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMDruid(4);
        portion = res1[2] == 0 ? "Level" :
        res1[2] == 1 ? "HitpointMax" :
        res1[2] == 2 ? "ArmorClass" :
        res1[2] == 3 ? "MovementSpeed" :
        res1[2] == 4 ? "RangedMove Range" :
        "MoveMove Range";
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "LevelUp method failed\n";
            fb += "on " + portion + " field\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }

        res1 = checkCMBard(4);
        portion = res1[2] == 0 ? "Level" :
        res1[2] == 1 ? "HitpointMax" :
        res1[2] == 2 ? "ArmorClass" :
        res1[2] == 3 ? "MovementSpeed" :
        res1[2] == 4 ? "RangedMove Range" :
        "MoveMove Range";
        if(res1[0] != -1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "LevelUp method failed\n";
            fb += "on " + portion + " field\n";
            fb += "expected: " + res1[0] + "\n";
            fb += "your answer: " + res1[1] + "\n";
            fail(fb);
        }        
    }

    /**
     * Check the TakeDamage method.
     */
    @Test
    public void checkTakeDamage()
    {
        String fb = "";
        PlayerClass pc = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player = new Player("test", pc, new Random());
        int hp = player.getHitpointCurrent();
        player.takeDamage(hp / 2);

        if ((hp - (hp / 2)) != player.getHitpointCurrent()
            || player.getHitpointCurrent() == player.getHitpointMax())
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "takeDamage failed.\n";
            fb += "expected: " + (hp - (hp / 2)) + "\n";
            fb += "your answer: " + player.getHitpointCurrent() + "\n";
            fail(fb);
        }

        PlayerClass pc2 = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player2 = new Player("test", pc, new Random());
        player.takeDamage(1000000);

        if (0 != player.getHitpointCurrent())
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "takeDamage failed.\n";
            fb += "expected: 0\n";
            fb += "your answer: " + player.getHitpointCurrent() + "\n";
            fail(fb);
        }
    }

    /**
     * Check the Heal method.
     */
    @Test
    public void checkHeal()
    {
        String fb = "";
        PlayerClass pc = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player = new Player("test", pc, new Random());
        player.takeDamage(10000);
        int hp = player.getHitpointCurrent();
        player.heal(hp / 2);

        if ((hp / 2) != player.getHitpointCurrent()
            || player.getHitpointCurrent() == player.getHitpointMax())
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "heal failed.\n";
            fb += "expected: " + (hp / 2) +"\n";
            fb += "your answer: " + player.getHitpointCurrent() + "\n";
            fb += "(takeDamage needs to be working first)\n";
            fail(fb);
        }

        PlayerClass pc2 = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player2 = new Player("test", pc, new Random());
        player.heal(1000000);

        if (player.getHitpointCurrent() != player.getHitpointMax())
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "heal failed.\n";
            fb += "expected: " + player.getHitpointMax() + "\n";
            fb += "your answer: " + player.getHitpointCurrent() + "\n";
            fail(fb);
        }
    }

    /**
     * Check the MakeMove method.
     */
    @Test
    public void checkMakeMove()
    {
        String fb = "";
        Player player = new Player("test", PlayerClass.BARD, new Random(111));
        String res = player.makeMove(MoveType.BASICATTACK);
        if (!res.equals("Hit"))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "makeMove BASICATTACK failed.\n";
            fb += "expected: Hit\n";
            fb += "your answer: " + res + "\n";
            fail(fb);
        }
        res = player.makeMove(MoveType.RANGEDATTACK);
        if (!res.equals("Hit"))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "makeMove RANGEDATTACK failed.\n";
            fb += "expected: Hit\n";
            fb += "your answer: " + res + "\n";
            fail(fb);
        }
        res = player.makeMove(MoveType.DEFEND);
        if (!res.equals("Defended"))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "makeMove DEFENDED failed.\n";
            fb += "expected: Defended\n";
            fb += "your answer: " + res + "\n";
            fail(fb);
        }
        res = player.makeMove(MoveType.MOVE);
        if (!res.equals("Moved 1 spaces"))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "makeMove MOVE failed.\n";
            fb += "expected: Moved 1 spaces\n";
            fb += "your answer: " + res + "\n";
            fail(fb);
        }
        res = player.makeMove(MoveType.BASICATTACK);
        if (!res.equals("Miss"))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "makeMove BASICATTACK failed.\n";
            fb += "expected: Miss\n";
            fb += "your answer: " + res + "\n";
            fail(fb);
        }
        player.makeMove(MoveType.BASICATTACK);
        player.makeMove(MoveType.BASICATTACK);
        res = player.makeMove(MoveType.RANGEDATTACK);
        if (!res.equals("Miss"))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "makeMove RANGEDATTACK failed.\n";
            fb += "expected: Miss\n";
            fb += "your answer: " + res + "\n";
            fail(fb);
        }
        res = player.makeMove(MoveType.DEFEND);
        if (!res.equals("Failed to Defend"))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "makeMove DEFENDED failed.\n";
            fb += "expected: Failed to Defend\n";
            fb += "your answer: " + res + "\n";
            fail(fb);
        }
    }

    /**
     * Check the MoveList method.
     */
    @Test
    public void checkMoveList()
    {
        String fb = "";
        PlayerClass pc = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player = new Player("test", pc, new Random());
        String res = player.moveList();
        String cor = "";
        for(int i = 0; i < 4; i++)
        {
            cor += "" + new Move(MoveType.values()[i],
                calcRange(MoveType.values()[i], player.getMovementSpeed())) ;
            if(i != 3)
                cor += "\n";
        }
        if(!res.equals(cor))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "moveList failed.\n";
            fb += "expected: \n" + cor + "\n";
            fb += "your answer: \n" + res + "\n";
            fail(fb);
        }
    }

    /**
     * Check the toString method.
     */
    @Test
    public void checkToString()
    {
        String fb = "";
        PlayerClass pc = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player = new Player("test", pc, new Random());
        String res = player.toString();
        if (!(checkString(player.getName(), player.getLevel()
            , player.getPlayerClass(), player.getHitpointCurrent()
            , player.getHitpointMax()).equals(player.toString())))
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "toString failed.\n";
            fb += "expected:      " + checkString(player.getName(), player.getLevel()
            , player.getPlayerClass(), player.getHitpointCurrent()
            , player.getHitpointMax()) + "\n";
            fb += "your answer: " + player + "\n";
            fail(fb);
        }
    }

    /**
     * Check the equals method.
     */
    @Test
    public void checkEquals()
    {
        String fb = "";
        int cardinal = random.nextInt(PlayerClass.values().length);
        Player p1 = new Player("" + cardinal, PlayerClass.values()[cardinal],
                new Random(cardinal));
        Player p2 = new Player("" + cardinal + 1, PlayerClass.values()[cardinal],
                new Random(cardinal));
        Player p3 = new Player("" + cardinal,
                PlayerClass.values()[(cardinal + 1) % PlayerClass.values().length],
                new Random(cardinal));
        Player p4 = new Player("" + cardinal, PlayerClass.values()[cardinal],
                new Random(cardinal));
        if(p1.equals(p2) || p1.equals(p3))
        {
            fb = "Fail in TestPlayer.\n";
            fb += "The equals method returned true when";
            fb += " the objects were different.\n";
            fail(fb); 
        }
        if(!p1.equals(p4))
        {
            fb = "Fail in TestPlayer.\n";
            fb += "The equals method returned false when";
            fb += " the objects were the same.\n";
            fail(fb);
        }
        p4.levelUp();
        if(p1.equals(p4))
        {
            fb = "Fail in TestPlayer.\n";
            fb += "The equals method returned true when";
            fb += " the objects were different.\n";
            fail(fb); 
        }
        p1.levelUp();
        if(!p1.equals(p4))
        {
            fb = "Fail in TestPlayer.\n";
            fb += "The equals method returned false when";
            fb += " the objects were the same.\n";
            fail(fb);
        }
    }

    /**
     * Check the name accessor and mutator with normal valid data.
     * @param testData The name to set for testing.
     */
    public void checkBasicMoveA()
    {
        String fb = "";
        Player player = new Player("", 
                PlayerClass.values()[random.nextInt(PlayerClass.values().length)]
            , new Random());
        Move basic = player.getBasicMove();
        int range = basic.getRange();
        int range2 = random.nextInt(20);
        while(range2 == basic.getRange())
        {
            range2 = random.nextInt(20);
        }
        basic.setRange(range2);
        int range3 = player.getBasicMove().getRange();

        if (range3 == range2 || range3 != range
        || player.getBasicMove().getRange() != 1)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "Accessor for Move did not return a copy of";
            fb += " basic move field";
            fail(fb);                
        }            
    }  

    /**
     * Check the name accessor and mutator with normal valid data.
     * @param testData The name to set for testing.
     */
    public void checkRangedMoveA()
    {
        String fb = "";
        Player player = new Player("", 
                PlayerClass.values()[random.nextInt(PlayerClass.values().length)]
            , new Random());
        Move basic = player.getRangedMove();
        int range = basic.getRange();
        int range2 = random.nextInt(20);
        while(range2 == basic.getRange())
        {
            range2 = random.nextInt(20);
        }
        basic.setRange(range2);
        int range3 = player.getRangedMove().getRange();

        if (range3 == range2 || range3 != range
        || player.getRangedMove().getRange() != (player.getMovementSpeed() / 2)
        || player.getRangedMove().getMoveType() != 
        MoveType.RANGEDATTACK)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "Accessor for Move did not return a copy of";
            fb += " ranged move field";
            fail(fb);                
        }            
    }  

    /**
     * Check the name accessor and mutator with normal valid data.
     * @param testData The name to set for testing.
     */
    public void checkDefenseMoveA()
    {
        String fb = "";
        Player player = new Player("", 
                PlayerClass.values()[random.nextInt(PlayerClass.values().length)]
            , new Random());
        Move basic = player.getDefenseMove();
        int range = basic.getRange();
        int range2 = random.nextInt(20);
        while(range2 == basic.getRange())
        {
            range2 = random.nextInt(20);
        }        
        basic.setRange(range2);
        int range3 = player.getDefenseMove().getRange();

        if (range3 == range2 && range3 != range
            || player.getDefenseMove().getRange() != 0
            || player.getDefenseMove().getMoveType() != 
            MoveType.DEFEND)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "Accessor for Move did not return a copy of";
            fb += " defense move field";
            fail(fb);                
        }            
    }      

    /**
     * Check the name accessor and mutator with normal valid data.
     * @param testData The name to set for testing.
     */
    public void checkMoveMoveA()
    {
        String fb = "";
        Player player = new Player("", 
                PlayerClass.values()[random.nextInt(PlayerClass.values().length)]
            , new Random());
        Move basic = player.getMoveMove();
        int range = basic.getRange();
        int range2 = random.nextInt(20);
        while(range2 == basic.getRange())
        {
            range2 = random.nextInt(20);
        }        
        basic.setRange(range2);
        int range3 = player.getMoveMove().getRange();

        if (range3 == range2 && range3 != range
            || player.getMoveMove().getRange() != player.getMovementSpeed()
            || player.getMoveMove().getMoveType() != 
            MoveType.MOVE)
        {
            fb += "Fail in TestPlayer.\n";
            fb += "Accessor for Move did not return a copy of";
            fb += " move move field";
            fail(fb);                
        }            
    }       

    /**
     * Test the no argument constructor.
     */
    public void checkNoArgConstructor()
    {
        String fb = "";
        Player player = new Player();
        if (!player.getName().equals("Player1") 
        || player.getPlayerClass() != PlayerClass.FIGHTER
        || player.getLevel() != 1
        || player.getHitpointMax() == 0
        || player.getArmorClass() == 0
        || player.getBasicMove() == null
        || player.getBasicMove().getMoveType() != MoveType.BASICATTACK
        || player.getRangedMove() == null
        || player.getRangedMove().getMoveType() != MoveType.RANGEDATTACK
        || player.getDefenseMove() == null
        || player.getDefenseMove().getMoveType() != MoveType.DEFEND
        || player.getMoveMove() == null
        || player.getMoveMove().getMoveType() != MoveType.MOVE)
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "No-arg constructor failed.\n";
            fail(fb);
        }
    }

    /**
     * Test argument constructor.
     */
    public void checkArgConstructor()
    {
        String fb = "";
        PlayerClass pc = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player = new Player("test", pc, new Random());
        if (!player.getName().equals("test") 
        || player.getPlayerClass() != pc
        || player.getLevel() != 1
        || player.getHitpointMax() == 0
        || player.getArmorClass() == 0
        || player.getBasicMove() == null
        || player.getBasicMove().getMoveType() != MoveType.BASICATTACK
        || player.getRangedMove() == null
        || player.getRangedMove().getMoveType() != MoveType.RANGEDATTACK
        || player.getDefenseMove() == null
        || player.getDefenseMove().getMoveType() != MoveType.DEFEND
        || player.getMoveMove() == null
        || player.getMoveMove().getMoveType() != MoveType.MOVE)
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "Arg constructor failed.\n";
            fail(fb);
        }
    }  

    /**
     * Test argument constructor.
     */
    public void checkCopyConstructor()
    {
        String fb = "";
        PlayerClass pc = PlayerClass.values()[random.nextInt(PlayerClass.values().length)];
        Player player = new Player("test", pc, new Random());
        Player player2 = new Player(player);
        if (!player2.getName().equals("test") 
        || player2.getPlayerClass() != pc
        || player2.getLevel() != 1
        || player2.getHitpointMax() != player.getHitpointMax()
        || player2.getArmorClass() != player.getArmorClass()
        || !player2.getBasicMove().equals(player.getBasicMove())
        || !player2.getRangedMove().equals(player.getRangedMove())
        || !player2.getDefenseMove().equals(player.getDefenseMove())
        || !player2.getMoveMove().equals(player.getMoveMove())
        || player2.getBasicMove() == player.getBasicMove()
        || player2.getRangedMove() == player.getRangedMove()
        || player2.getDefenseMove() == player.getDefenseMove()
        || player2.getMoveMove() == player.getMoveMove())
        {
            fb += "Fail in TestPlayer.\n";            
            fb += "Copy constructor failed. Did not create a copy of parameter.\n";
            fb += "Remember to make copies of the Move objects.\n";
            fail(fb);
        }
    }  

    public String checkString(String n, int l, PlayerClass pc, int h, int hM)
    {
        return n + " Lvl" + l + " " + pc + " with " + h + "/" + hM + "HP";
    }

    public int[] checkCMFighter(int x)
    {
        if(x == 1)
        {
            Player player = new Player("", PlayerClass.FIGHTER, new Random());
            int res = (player.getLevel() * 3) + 10;
            int[] arr = new int[2];
            if(player.getArmorClass() != res)
            {
                arr[0] = res;
                arr[1] = player.getArmorClass();
            } else
            {
                arr[0] = -1;
                arr[0] = -1;
            }
            return arr;
        } else if(x == 2)
        {
            Player player = new Player("", PlayerClass.FIGHTER, new Random(121));
            int[] arr = new int[2];
            player.levelUp();
            player.levelUp();
            if(player.getHitpointMax() == 16)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 16;
                arr[1] = player.getHitpointMax();
                return arr;
            }
            player.levelUp();
            if(player.getHitpointMax() == 13)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 13;
                arr[1] = player.getHitpointMax();
            }
            return arr;
        } else if(x == 3)
        {
            Player player = new Player("", PlayerClass.FIGHTER, new Random());
            int[] arr = new int[2];
            player.levelUp();
            if(player.getMovementSpeed() == 5)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                return arr;
            }
            player.levelUp();
            player.levelUp();
            player.levelUp();
            if(player.getMovementSpeed() == 6)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 6;
                arr[1] = player.getMovementSpeed();
            }
            return arr;
        } else
        {
            Player player = new Player("", PlayerClass.FIGHTER, new Random(753));
            player.levelUp();
            int[] arr = {-1, -1, -1};
            if(player.getLevel() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getLevel();
                arr[2] = 0;
                return arr;
            }
            if(player.getHitpointMax() != 9)
            {
                arr[0] = 9;
                arr[1] = player.getHitpointMax();
                arr[2] = 1;
                return arr;
            }
            if(player.getArmorClass() != 16)
            {
                arr[0] = 16;
                arr[1] = player.getArmorClass();
                arr[2] = 2;
                return arr;
            }
            if(player.getMovementSpeed() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                arr[2] = 3;
                return arr;
            }
            if(player.getRangedMove().getRange() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getRangedMove().getRange();
                arr[2] = 4;
                return arr;
            }
            if(player.getMoveMove().getRange() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMoveMove().getRange();
                arr[2] = 5;
                return arr;
            }
            return arr;
        }
    }

    public int[] checkCMWizard(int x)
    {
        if(x == 1)
        {
            Player player = new Player("", PlayerClass.WIZARD, new Random());
            int res = (player.getLevel() * 1) + 10;
            int[] arr = new int[2];        
            if(player.getArmorClass() != res)
            {
                arr[0] = res;
                arr[1] = player.getArmorClass();
            } else
            {
                arr[0] = -1;
                arr[0] = -1;
            }
            return arr;
        } else if(x == 2)
        {
            Player player = new Player("", PlayerClass.WIZARD, new Random(369));
            int[] arr = new int[2];
            player.levelUp();
            player.levelUp();
            if(player.getHitpointMax() == 10)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 10;
                arr[1] = player.getHitpointMax();
                return arr;
            }
            player.levelUp();
            if(player.getHitpointMax() == 14)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 14;
                arr[1] = player.getHitpointMax();
            }
            return arr;
        } else if(x == 3)
        {
            Player player = new Player("", PlayerClass.WIZARD, new Random());
            int[] arr = new int[2];
            player.levelUp();
            if(player.getMovementSpeed() == 7)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 7;
                arr[1] = player.getMovementSpeed();
                return arr;
            }
            player.levelUp();
            player.levelUp();
            player.levelUp();
            if(player.getMovementSpeed() == 10)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 8;
                arr[1] = player.getMovementSpeed();
            }
            return arr;
        } else
        {
            Player player = new Player("", PlayerClass.WIZARD, new Random(753));
            player.levelUp();
            int[] arr = {-1, -1, -1};
            if(player.getLevel() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getLevel();
                arr[2] = 0;
                return arr;
            }
            if(player.getHitpointMax() != 7)
            {
                arr[0] = 7;
                arr[1] = player.getHitpointMax();
                arr[2] = 1;
                return arr;
            }
            if(player.getArmorClass() != 12)
            {
                arr[0] = 12;
                arr[1] = player.getArmorClass();
                arr[2] = 2;
                return arr;
            }
            if(player.getMovementSpeed() != 7)
            {
                arr[0] = 7;
                arr[1] = player.getMovementSpeed();
                arr[2] = 3;
                return arr;
            }
            if(player.getRangedMove().getRange() != 3)
            {
                arr[0] = 3;
                arr[1] = player.getRangedMove().getRange();
                arr[2] = 4;
                return arr;
            }
            if(player.getMoveMove().getRange() != 7)
            {
                arr[0] = 7;
                arr[1] = player.getMoveMove().getRange();
                arr[2] = 5;
                return arr;
            }
            return arr;
        }
    }

    public int[] checkCMRogue(int x)
    {
        if(x == 1)
        {
            Player player = new Player("", PlayerClass.ROGUE, new Random());
            int res = (player.getLevel() * 1) + 10;
            int[] arr = new int[2];
            if(player.getArmorClass() != res)
            {
                arr[0] = res;
                arr[1] = player.getArmorClass();
            } else
            {
                arr[0] = -1;
                arr[0] = -1;
            }
            return arr;      
        } else if(x == 2)
        {
            Player player = new Player("", PlayerClass.ROGUE, new Random(258));
            int[] arr = new int[2];
            player.levelUp();
            player.levelUp();
            if(player.getHitpointMax() == 13)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 13;
                arr[1] = player.getHitpointMax();
                return arr;
            }
            player.levelUp();
            if(player.getHitpointMax() == 11)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 11;
                arr[1] = player.getHitpointMax();
            }
            return arr;
        } else if(x == 3)
        {
            Player player = new Player("", PlayerClass.ROGUE, new Random());
            int[] arr = new int[2];
            player.levelUp();
            if(player.getMovementSpeed() == 5)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                return arr;
            }
            player.levelUp();
            player.levelUp();
            player.levelUp();
            if(player.getMovementSpeed() == 8)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 8;
                arr[1] = player.getMovementSpeed();
            }
            return arr;
        } else
        {
            Player player = new Player("", PlayerClass.ROGUE, new Random(753));
            player.levelUp();
            int[] arr = {-1, -1, -1};
            if(player.getLevel() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getLevel();
                arr[2] = 0;
                return arr;
            }
            if(player.getHitpointMax() != 7)
            {
                arr[0] = 7;
                arr[1] = player.getHitpointMax();
                arr[2] = 1;
                return arr;
            }
            if(player.getArmorClass() != 12)
            {
                arr[0] = 12;
                arr[1] = player.getArmorClass();
                arr[2] = 2;
                return arr;
            }
            if(player.getMovementSpeed() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                arr[2] = 3;
                return arr;
            }
            if(player.getRangedMove().getRange() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getRangedMove().getRange();
                arr[2] = 4;
                return arr;
            }
            if(player.getMoveMove().getRange() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMoveMove().getRange();
                arr[2] = 5;
                return arr;
            }
            return arr;
        }
    }

    public int[] checkCMCleric(int x)
    {
        if(x == 1)
        {
            Player player = new Player("", PlayerClass.CLERIC, new Random());
            int res = (player.getLevel() * 2) + 10;
            int[] arr = new int[2];
            if(player.getArmorClass() != res)
            {
                arr[0] = res;
                arr[1] = player.getArmorClass();
            } else
            {
                arr[0] = -1;
                arr[0] = -1;
            }
            return arr;     
        } else if(x == 2)
        {
            Player player = new Player("", PlayerClass.CLERIC, new Random(147));
            int[] arr = new int[2];
            player.levelUp();
            player.levelUp();
            if(player.getHitpointMax() == 15)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 15;
                arr[1] = player.getHitpointMax();
                return arr;
            }
            player.levelUp();
            if(player.getHitpointMax() == 13)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 13;
                arr[1] = player.getHitpointMax();
            }
            return arr;
        } else if(x == 3)
        {
            Player player = new Player("", PlayerClass.CLERIC, new Random());
            int[] arr = new int[2];
            player.levelUp();
            if(player.getMovementSpeed() == 6)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 6;
                arr[1] = player.getMovementSpeed();
                return arr;
            }
            player.levelUp();
            player.levelUp();
            player.levelUp();
            if(player.getMovementSpeed() == 7)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 7;
                arr[1] = player.getMovementSpeed();
            }
            return arr;
        } else
        {
            Player player = new Player("", PlayerClass.CLERIC, new Random(753));
            player.levelUp();
            int[] arr = {-1, -1, -1};
            if(player.getLevel() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getLevel();
                arr[2] = 0;
                return arr;
            }
            if(player.getHitpointMax() != 9)
            {
                arr[0] = 9;
                arr[1] = player.getHitpointMax();
                arr[2] = 1;
                return arr;
            }
            if(player.getArmorClass() != 14)
            {
                arr[0] = 14;
                arr[1] = player.getArmorClass();
                arr[2] = 2;
                return arr;
            }
            if(player.getMovementSpeed() != 6)
            {
                arr[0] = 6;
                arr[1] = player.getMovementSpeed();
                arr[2] = 3;
                return arr;
            }
            if(player.getRangedMove().getRange() != 3)
            {
                arr[0] = 3;
                arr[1] = player.getRangedMove().getRange();
                arr[2] = 4;
                return arr;
            }
            if(player.getMoveMove().getRange() != 6)
            {
                arr[0] = 6;
                arr[1] = player.getMoveMove().getRange();
                arr[2] = 5;
                return arr;
            }
            return arr;
        }
    }

    public int[] checkCMBarbarian(int x)
    {
        if(x == 1)
        {
            Player player = new Player("", PlayerClass.BARBARIAN, new Random());
            int res = (player.getLevel() * 3) + 10;
            int[] arr = new int[2];
            if(player.getArmorClass() != res)
            {
                arr[0] = res;
                arr[1] = player.getArmorClass();
            } else
            {
                arr[0] = -1;
                arr[0] = -1;
            }
            return arr;       
        } else if(x == 2)
        {
            Player player = new Player("", PlayerClass.BARBARIAN, new Random(789));
            int[] arr = new int[2];
            player.levelUp();
            player.levelUp();
            if(player.getHitpointMax() == 17)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 17;
                arr[1] = player.getHitpointMax();
                return arr;
            }
            player.levelUp();
            if(player.getHitpointMax() == 20)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 20;
                arr[1] = player.getHitpointMax();
            }
            return arr;
        } else if(x == 3)
        {
            Player player = new Player("", PlayerClass.BARBARIAN, new Random());
            int[] arr = new int[2];
            player.levelUp();
            if(player.getMovementSpeed() == 5)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                return arr;
            }
            player.levelUp();
            player.levelUp();
            player.levelUp();
            if(player.getMovementSpeed() == 5)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
            }
            return arr;
        } else
        {
            Player player = new Player("", PlayerClass.BARBARIAN, new Random(753));
            player.levelUp();
            int[] arr = {-1, -1, -1};
            if(player.getLevel() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getLevel();
                arr[2] = 0;
                return arr;
            }
            if(player.getHitpointMax() != 11)
            {
                arr[0] = 11;
                arr[1] = player.getHitpointMax();
                arr[2] = 1;
                return arr;
            }
            if(player.getArmorClass() != 16)
            {
                arr[0] = 16;
                arr[1] = player.getArmorClass();
                arr[2] = 2;
                return arr;
            }
            if(player.getMovementSpeed() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                arr[2] = 3;
                return arr;
            }
            if(player.getRangedMove().getRange() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getRangedMove().getRange();
                arr[2] = 4;
                return arr;
            }
            if(player.getMoveMove().getRange() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMoveMove().getRange();
                arr[2] = 5;
                return arr;
            }
            return arr;
        }
    }

    public int[] checkCMDruid(int x)
    {
        if(x == 1)
        {
            Player player = new Player("", PlayerClass.DRUID, new Random());
            int res = (player.getLevel() * 2) + 10;
            int[] arr = new int[2];
            if(player.getArmorClass() != res)
            {
                arr[0] = res;
                arr[1] = player.getArmorClass();
            } else
            {
                arr[0] = -1;
                arr[0] = -1;
            }
            return arr;  
        } else if(x == 2)
        {
            Player player = new Player("", PlayerClass.DRUID, new Random(456));
            int[] arr = new int[2];
            player.levelUp();
            player.levelUp();
            if(player.getHitpointMax() == 18)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 18;
                arr[1] = player.getHitpointMax();
                return arr;
            }
            player.levelUp();
            if(player.getHitpointMax() == 13)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 13;
                arr[1] = player.getHitpointMax();
            }
            return arr;
        } else if(x == 3)
        {
            Player player = new Player("", PlayerClass.DRUID, new Random());
            int[] arr = new int[2];
            player.levelUp();
            if(player.getMovementSpeed() == 6)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 6;
                arr[1] = player.getMovementSpeed();
                return arr;
            }
            player.levelUp();
            player.levelUp();
            player.levelUp();
            if(player.getMovementSpeed() == 8)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 8;
                arr[1] = player.getMovementSpeed();
            }
            return arr;
        } else
        {
            Player player = new Player("", PlayerClass.DRUID, new Random(753));
            player.levelUp();
            int[] arr = {-1, -1, -1};
            if(player.getLevel() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getLevel();
                arr[2] = 0;
                return arr;
            }
            if(player.getHitpointMax() != 9)
            {
                arr[0] = 9;
                arr[1] = player.getHitpointMax();
                arr[2] = 1;
                return arr;
            }
            if(player.getArmorClass() != 14)
            {
                arr[0] = 14;
                arr[1] = player.getArmorClass();
                arr[2] = 2;
                return arr;
            }
            if(player.getMovementSpeed() != 6)
            {
                arr[0] = 6;
                arr[1] = player.getMovementSpeed();
                arr[2] = 3;
                return arr;
            }
            if(player.getRangedMove().getRange() != 3)
            {
                arr[0] = 3;
                arr[1] = player.getRangedMove().getRange();
                arr[2] = 4;
                return arr;
            }
            if(player.getMoveMove().getRange() != 6)
            {
                arr[0] = 6;
                arr[1] = player.getMoveMove().getRange();
                arr[2] = 5;
                return arr;
            }
            return arr;
        }
    }

    public int[] checkCMBard(int x)
    {
        if(x == 1)
        {
            Player player = new Player("", PlayerClass.BARD, new Random());
            int res = (player.getLevel() * 1) + 10;
            int[] arr = new int[2];
            if(player.getArmorClass() != res)
            {
                arr[0] = res;
                arr[1] = player.getArmorClass();
            } else
            {
                arr[0] = -1;
                arr[0] = -1;
            }
            return arr;  
        } else if(x == 2)
        {
            Player player = new Player("", PlayerClass.BARD, new Random(123));
            int[] arr = new int[2];
            player.levelUp();
            player.levelUp();
            if(player.getHitpointMax() == 10)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 10;
                arr[1] = player.getHitpointMax();
                return arr;
            }
            player.levelUp();
            if(player.getHitpointMax() == 16)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 16;
                arr[1] = player.getHitpointMax();
            }
            return arr;
        } else if(x == 3)
        {
            Player player = new Player("", PlayerClass.BARD, new Random());
            int[] arr = new int[2];
            player.levelUp();
            if(player.getMovementSpeed() == 5)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                return arr;
            }
            player.levelUp();
            player.levelUp();
            player.levelUp();
            if(player.getMovementSpeed() == 8)
            {
                arr[0] = -1;
                arr[1] = -1;
            } else {
                arr[0] = 8;
                arr[1] = player.getMovementSpeed();
            }
            return arr;
        } else
        {
            Player player = new Player("", PlayerClass.BARD, new Random(753));
            player.levelUp();
            int[] arr = {-1, -1, -1};
            if(player.getLevel() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getLevel();
                arr[2] = 0;
                return arr;
            }
            if(player.getHitpointMax() != 7)
            {
                arr[0] = 9;
                arr[1] = player.getHitpointMax();
                arr[2] = 1;
                return arr;
            }
            if(player.getArmorClass() != 12)
            {
                arr[0] = 16;
                arr[1] = player.getArmorClass();
                arr[2] = 2;
                return arr;
            }
            if(player.getMovementSpeed() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMovementSpeed();
                arr[2] = 3;
                return arr;
            }
            if(player.getRangedMove().getRange() != 2)
            {
                arr[0] = 2;
                arr[1] = player.getRangedMove().getRange();
                arr[2] = 4;
                return arr;
            }
            if(player.getMoveMove().getRange() != 5)
            {
                arr[0] = 5;
                arr[1] = player.getMoveMove().getRange();
                arr[2] = 5;
                return arr;
            }
            return arr;
        }
    }

    public int calcRange(MoveType move, int ms)
    {
        return move == MoveType.BASICATTACK ? 1: 
        move == MoveType.RANGEDATTACK ? ms / 2:
        move == MoveType.DEFEND ? 0:
        ms;
    }
}
