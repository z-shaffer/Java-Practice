import java.util.Random;
/**
Create a Player class that has a name (String), maximum hit points (int),
current number of hitpoints (int), armor class (int), level (int),
movement speed (int), possible moves (Moves), and random number generator.
 */

public class Player
{
    private PlayerClass playerClass;
    private String name;
    private int hitpointMax;
    private int hitpointCurrent;
    private int armorClass;
    private int level;
    private int movementSpeed;
    private Random generator;
    private boolean encumbered;
    private Move basicMove;
    private Move rangedMove;
    private Move defenseMove;
    private Move moveMove;
    /**
     * The no-arg constructor should initialize the fields. 
     * The name should be Player1 and the class should be Fighter (from the PlayerClass enum).
     * You should initialize the generator field to a new Random object. 
     * This being a new player, the level field should be 1. Call the calculateHitPointMax
     * method which initializes the hitpointMax field (you will fill in the 
     * calculateHitPointMax method later). The hitpointCurrent field should equal
     * the hitpointMax field. Call the calculateArmorClass method which initializes 
     * the armorClass field (you will fill in the calculateArmorClass method later).
     * Call the calculateMovementSpeed method which initializes the movementSpeed 
     * field (you will fill in the calculateMovementSpeed method later). Initialize 
     * the basicMove, rangedMove, defenseMove, and moveMove fields of the player to be 
     * these 4 things: a Move with MoveType BasicAttack that has a range of 1, a Move with 
     * MoveType RangedAttack that has a range of HALF the movementSpeed (integer division 
     * is okay here), a Move with MoveType Defend that has a range of 0, a Move with MoveType 
     * Move that has a range the same as the movementSpeed field. Note: The Move constructor
     * takes a MoveType and an int for range.
     */
    public Player()
    {
        name = "Player1";
        playerClass = PlayerClass.FIGHTER;
        generator = new Random();
        level = 1;
        calculateHitPointMax();
        hitpointCurrent = hitpointMax;
        calculateArmorClass();
        calculateMovementSpeed();
        basicMove = new Move();
        rangedMove = new Move(MoveType.RANGEDATTACK, movementSpeed / 2);
        defenseMove = new Move(MoveType.DEFEND, 0);
        moveMove = new Move(MoveType.MOVE, movementSpeed);
    }

    /**
     * The argument constructor should take a name and player class. It should
     * set both fields to those values, then do the same as no-arg constructor.
     */
    public Player(String name, PlayerClass playerClass, Random generator)
    {
        this.name = name;
        this.playerClass = playerClass;
        this.generator = generator;
        level = 1;
        calculateHitPointMax();
        hitpointCurrent = hitpointMax;
        calculateArmorClass();
        calculateMovementSpeed();
        basicMove = new Move();
        rangedMove = new Move(MoveType.RANGEDATTACK, movementSpeed / 2);
        defenseMove = new Move(MoveType.DEFEND, 0);
        moveMove = new Move(MoveType.MOVE, movementSpeed);
    }

    /**
     * Creates a Player identical to the passed in Player
     */
    public Player(Player copy)
    {
        name = copy.getName();
        playerClass = copy.getPlayerClass();
        generator = new Random();
        level = copy.getLevel();
        hitpointMax = copy.getHitpointMax();
        hitpointCurrent = copy.getHitpointCurrent();
        armorClass = copy.getArmorClass();
        basicMove = copy.basicMove.copy();
        rangedMove = copy.rangedMove.copy();
        defenseMove = copy.defenseMove.copy();
        moveMove = copy.moveMove.copy();
    }

    /**
     * The calculateArmorClass method: The method sets the 
     * armorClass field of the player by using this formula: 
     * (level * class bonus) + ten. Then, if the resulting 
     * armorClass is greater than 17, the encumbered field is 
     * set to true, otherwise it is false.
     * 
     * Table of PlayerClass -> Armor Class Bonus can be
     * found in the instructions
     */
    public void calculateArmorClass()
    {
        if (playerClass == PlayerClass.FIGHTER)
        {
            armorClass = (level * 3) + 10;
        }
        else if (playerClass == PlayerClass.WIZARD)
        {
            armorClass = (level * 1) + 10;
        }
        else if (playerClass == PlayerClass.ROGUE)
        {
            armorClass = (level * 1) + 10;
        }
        else if (playerClass == PlayerClass.CLERIC)
        {
            armorClass = (level * 2) + 10;
        }
        else if (playerClass == PlayerClass.BARBARIAN)
        {
            armorClass = (level * 3) + 10;
        }
        else if (playerClass == PlayerClass.DRUID)
        {
            armorClass = (level * 2) + 10;
        }
        else if (playerClass == PlayerClass.BARD)
        {
            armorClass = (level * 1) + 10;
        }
        if (armorClass > 17)
        {
            encumbered = true;
        }
        else
        {
            encumbered = false;
        }
    }

    /**
     * The calculateHitPointMax method: The method sets 
     * the hitpointMax field of the player by simulating 
     * dice rolls (using the Random generator field). For each 
     * level of the player, roll the dice one time. Each 
     * PlayerClass will roll a different die. The sum of 
     * the rolls plus the player’s level is their hitpointMax. 
     * The dice chart is as follows:
     * --Class--|--Dice--
     * Fighter  |  D6 (six sides   - can roll 1 through 6)
     * Wizard   |  D4 (four sides  - can roll 1 through 4)
     * Rogue    |  D4 (four sides  - can roll 1 through 4)
     * Cleric   |  D6 (six sides   - can roll 1 through 6)
     * Barbarian|  D8 (eight sides - can roll 1 through 8)
     * Druid    |  D6 (six sides   - can roll 1 through 6)
     * Bard     |  D4 (four sides  - can roll 1 through 4)
     * Use the number associated with each PlayerClass to
     * determine the maximum number the generator will roll. 
     * For example, rolling a D43 (a dice with 43 sides) has a 
     * maximum number of 43 and a minimum number of 1.
     */
    public void calculateHitPointMax()
    {
        int sum = 0;
        if (playerClass.equals(PlayerClass.FIGHTER) || playerClass.equals(PlayerClass.CLERIC) || playerClass.equals(PlayerClass.DRUID))
        {
            for(int i = 0; i < level; i++)
            {
                sum += (generator.nextInt(6) + 1);
            }
        }
        else if (playerClass.equals(PlayerClass.WIZARD) || playerClass.equals(PlayerClass.ROGUE) || playerClass.equals(PlayerClass.BARD))
        {
            for(int i = 0; i < level; i++)
            {
                sum += (generator.nextInt(4) + 1);
            }
        }
        else if (playerClass.equals(PlayerClass.BARBARIAN))
        {
            for(int i = 0; i < level; i++)
            {
                sum += (generator.nextInt(8) + 1);
            }
        }
        hitpointMax = sum + level;
    }   

    /**
     * The method sets the movementSpeed field of the 
     * player by using this formula: level + base speed - 
     * encumbrance penalty. Each PlayerClass has a different 
     * base speed and encumbrance penalty. The speed and encumbrance 
     * chart is as follows:
     * --PlayerClass--|--Base Speed--|--Encumbered Penalty--
     * Fighter      |  3        |  2
     * Wizard       |  5        |  4
     * Rogue        |  3        |  1
     * Cleric       |  4        |  2
     * Barbarian    |  3        |  3
     * Druid        |  4        |  1
     * Bard         |  3        |  1
     * The movementSpeed cannot fall below 2. Ensure this will not happen.
     */
    public void calculateMovementSpeed()
    {
        if (playerClass == PlayerClass.FIGHTER)
        {
            if (encumbered == true)
            {
                movementSpeed = level + 3 - 2;
            }
            else
            {
                movementSpeed = level + 3;
            }
        }
        else if (playerClass == PlayerClass.WIZARD)
        {
            if (encumbered == true)
            {
                movementSpeed = level + 5 - 4;
            }
            else
            {
                movementSpeed = level + 5;
            }
        }
        else if (playerClass == PlayerClass.ROGUE)
        {
            if (encumbered == true)
            {
                movementSpeed = level + 3 - 1;
            }
            else
            {
                movementSpeed = level + 3;
            }
        }
        else if (playerClass == PlayerClass.CLERIC)
        {
            if (encumbered == true)
            {
                movementSpeed = level + 4 - 2;
            }
            else
            {
                movementSpeed = level + 4;
            }
        }
        else if (playerClass == PlayerClass.BARBARIAN)
        {
            if (encumbered == true)
            {
                movementSpeed = level + 3 - 3;
            }
            else
            {
                movementSpeed = level + 3;
            }
        }
        else if (playerClass == PlayerClass.DRUID)
        {
            if (encumbered == true)
            {
                movementSpeed = level + 4 - 1;
            }
            else
            {
                movementSpeed = level + 4;
            }
        }
        else if (playerClass == PlayerClass.BARD)
        {
            if (encumbered == true)
            {
                movementSpeed = level + 3 - 1;
            }
            else
            {
                movementSpeed = level + 3;
            }
        }
    }

    /**
     * This will level the Player up one level. Doing this, you will need to
     * redetermine the Player's max hitpoints, armor class, and movement speed.
     * You will then need to update their moves to reflect the updated movement
     * speed (HALF).
     */
    public void levelUp()
    {
        level++;
        calculateHitPointMax();
        calculateArmorClass();
        calculateMovementSpeed();
        rangedMove.setRange(movementSpeed / 2);
        moveMove.setRange(movementSpeed);
    }

    /**
    This should reduce the Player's current hitpoints equal to the
    value of the amount passed in, but not less than 0.
     */
    public void takeDamage(int amount)
    {
        hitpointCurrent -= amount;
        if (hitpointCurrent < 0)
        {
            hitpointCurrent = 0;
        }
    }

    /**
    This should increase the Player's current hitpoints equal to the
    value of the amount passed in, but not higher than the max.
     */
    public void heal(int amount)
    {
        hitpointCurrent += amount;
        if (hitpointCurrent > hitpointMax)
        {
            hitpointCurrent = hitpointMax;
        }
    }

    /**
     * The method will make a move for the player. Use 
     * the moveType parameter to determine which move will be 
     * performed. If any move that is an attack (ranged attack or 
     * basic attack) is performed, roll a D20 (a dice with 20 sides). 
     * If the result plus the player’s level is greater than 10, 
     * return “Hit”, otherwise “Miss”. If a defenseMove is performed,
     * roll a D20 for an attack made against the player and a D20 
     * for the player’s reaction. If the attack roll plus 10 is 
     * higher than the reaction roll plus the armorClass field, 
     * then return “Failed to Defend”, otherwise return “Defended”.
     * If a moveMove is performed, choose a random number between 1
     * and the movementSpeed and return “Moved n spaces” where n is
     * the random number.
     */
    public String makeMove(MoveType moveType)
    {
        String result = "";
        if (moveType.equals(MoveType.RANGEDATTACK) || moveType.equals(MoveType.BASICATTACK))
        {
            int roll = generator.nextInt(20) + 1;
            if (roll + level > 10)
            {
                result = "Hit";
            }
            else
            {
                result = "Miss";
            }
        }
        else if (moveType.equals(MoveType.DEFEND))
        {
            int attackRoll = generator.nextInt(20) + 1;
            int reactionRoll = generator.nextInt(20) + 1;

            if ((attackRoll + 10) > (reactionRoll + armorClass))
            {
                result = "Defended";
            }
            else
            {
                result = "Failed to Defend";
            }
        }
        else if (moveType.equals(MoveType.MOVE))
        {
            int roll = generator.nextInt(movementSpeed) + 1;
            result = String.format("Moved %d spaces", roll);
        }
        return result;
    }

    /**
     * This will return a String with the list of moves a Player
     * can make formated as follows:
     * BASICATTACK for #\n
     * RANGEDATTACK for #\n
     * DEFEND for #\n
     * MOVE for #

     * Where # is the range of each Move.
     */
    public String moveList()
    {
        return String.format("%s\n%s\n%s\n%s", basicMove.toString(), rangedMove.toString(), defenseMove.toString(), moveMove.toString());
    }

    /**
     * This should return a String representation of the Player like
     * the following:
     * "William Lvl6 DRUID with 23/45HP"
     */
    public String toString()
    {
        return String.format("%s Lvl%d %s with %d/%dHP", name, level, playerClass, hitpointCurrent, hitpointMax);
    }

    /**
     * This should compare the passed in Player to the current one.
     */
    public boolean equals(Player player)
    {
        return toString().equals(player.toString());
    }

    /**
     * Create getter for the BasicMove.
     */
    public Move getBasicMove()
    {
        return new Move(MoveType.BASICATTACK, basicMove.getRange());
    }

    /**
     * Create getter for the RangedMove.
     */
    public Move getRangedMove()
    {
        //TODO
        return new Move(MoveType.RANGEDATTACK, rangedMove.getRange());
    }

    /**
     * Create getter for the DefenseMove.
     */
    public Move getDefenseMove()
    {
        //TODO
        return new Move(MoveType.DEFEND, defenseMove.getRange());
    }

    /**
     * Create getter for the MoveMove.
     */
    public Move getMoveMove()
    {
        //TODO
        return new Move(MoveType.MOVE, moveMove.getRange());
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPlayerClass(PlayerClass playerClass)
    {
        this.playerClass = playerClass;
    }

    public String getName()
    {
        return this.name;
    }

    public PlayerClass getPlayerClass()
    {
        return this.playerClass;
    }

    public int getLevel()
    {
        return this.level;
    }

    public int getHitpointMax()
    {
        return this.hitpointMax;
    }

    public int getHitpointCurrent()
    {
        return this.hitpointCurrent;
    }

    public int getArmorClass()
    {
        return this.armorClass;
    }

    public int getMovementSpeed()
    {
        return this.movementSpeed;
    }
}
