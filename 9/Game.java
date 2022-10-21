import java.io.*;
import java.util.*;

public class Game
{
    /**
     * You will complete the main method in the Game class.
     * Print: "Welcome! Please enter a name or EXIT". Grab the user’s response. 
     * If the user types "EXIT" say "Goodbye" and do nothing else. Otherwise, ask 
     * the user for a PlayerClass by printing: 
     * "What class is your Player or EXIT?" 
     * "Fighter, Rogue, Cleric, Wizard, Bard, or Barbarian?" 
     * If the user types "EXIT" say "Goodbye" and do nothing else. 
     * If the User fails to type in one of the options, ask again. 
     * Otherwise, create a Player with the entered name and PlayerClass 
     * (remember the user typed in a String so you might need a switch to get 
     * the correct PlayerClass value based on the String).
     * Notify the User of their new Player by printing: 
     * "You created a Player:" 
     * "William Lvl1 DRUID with 13/13HP" (this comes from the player’s toString method)
     * Print "What would you like to do?". Then, print out the Player's movelist 
     * (you wrote a method to do this). Grab the user’s choice.
     * If the User types "EXIT" say "Goodbye" and do nothing else. Otherwise, 
     * make the Move on the Player that the User specified (use the makeMove method).
     * If the User chose DEFEND, and makeMove resulted in "Failed to Defend", roll a D6
     * (1-6) and deal that much damage to the Player (there’s a takeDamage method in Player).
     * Print the damage taken as follows:
     * "You took d damage." (where d is the amount of damage taken).
     * Then, (regardless of the type of Move chosen by the user) roll a D4 (1-4) and 
     * heal the Player that amount (there is a heal method). Print the healing as follows:
     * “You healed for h health.” (where h is the amount healed)
     * Continue prompting the User for the move they would like to make (repeating 
     * the code you wrote) until they enter "EXIT"
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome! Please enter a name or EXIT");
        String name = keyboard.nextLine();
        if (name.equals("EXIT"))
        {
            System.out.println("Goodbye");
            return;
        }
        System.out.println("What class is your Player or EXIT?");
        System.out.println("Fighter, Rogue, Cleric, Wizard, Bard, or Barbarian?");
        String playerClass = keyboard.nextLine();
        while (!playerClass.equals("Fighter") && !playerClass.equals("Rogue") && !playerClass.equals("Cleric") && !playerClass.equals("Wizard") && !playerClass.equals("Bard") && !playerClass.equals("Barbarian") && !playerClass.equals("EXIT"))
        {
            System.out.println("What class is your Player or EXIT?");
            System.out.println("Fighter, Rogue, Cleric, Wizard, Bard, or Barbarian?");
            playerClass = keyboard.nextLine();
        }
        PlayerClass pClass = PlayerClass.FIGHTER;
        if (playerClass.equals("EXIT"))
        {
            System.out.println("Goodbye");
            return;
        }
        else if (playerClass.equals("Fighter"))
        {
            pClass = PlayerClass.FIGHTER;
        }
        else if (playerClass.equals("Rogue"))
        {
            pClass = PlayerClass.ROGUE;
        }
        else if (playerClass.equals("Cleric"))
        {
            pClass = PlayerClass.CLERIC;
        }
        else if (playerClass.equals("Wizard"))
        {
            pClass = PlayerClass.WIZARD;
        }
        else if (playerClass.equals("Bard"))
        {
            pClass = PlayerClass.BARD;
        }
        else if (playerClass.equals("Barbarian"))
        {
            pClass = PlayerClass.BARBARIAN;
        }

        Player player = new Player(name, pClass, new Random());
        System.out.printf("You created a Player:\n" + player.toString() + "\n");

        Random rand = new Random();
        int heal = 0;
        String moveChoice = "";
        do 
        {
            System.out.println("What would you like to do?");
            System.out.println(player.moveList());
            moveChoice = keyboard.nextLine();
            switch (moveChoice) 
            {
                case "BASICATTACK":
                System.out.println(player.makeMove(MoveType.BASICATTACK));
                break;

                case "RANGEDATTACK":
                System.out.println(player.makeMove(MoveType.RANGEDATTACK));
                break;

                case "DEFEND":
                if (player.makeMove(MoveType.DEFEND).equals("Failed to Defend"))
                {
                    int damage = rand.nextInt(6) + 1;
                    System.out.println("Failed to Defend");
                    System.out.println("You took " + damage + " damage.");
                    player.takeDamage(damage);
                }
                else
                {
                    System.out.println("Defended");
                }
                break;

                case "MOVE":
                System.out.println(player.makeMove(MoveType.MOVE));
                break;

                case "EXIT":
                System.out.println("Goodbye");
                return;
            }  
            heal = rand.nextInt(4) + 1;
            player.heal(heal);
            System.out.println("You healed for " + heal + " health.");
            System.out.println(player.toString());
        } while (!moveChoice.equals("EXIT"));
    }
}
