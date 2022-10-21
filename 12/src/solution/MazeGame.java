package solution;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A maze game.
 * 
 * @author Zach Shaffer
 * @version 2/1
 *
 */
public class MazeGame
{
    /**
     * The size of each side of the game map.
     */
    private final static int HEIGHT = 19;
    private final static int WIDTH = 39;

    /**
     * The game map, as a 2D array of ints.
     */
    private boolean[][] blocked;
    
    /**
     * The current location of the player vertically.
     */
    private int userCol;
    /**
     * The current location of the player horizontally.
     */
    private int userRow;

    /**
     * The scanner from which each move is read.
     */
    private Scanner moveScanner = new Scanner(System.in);

    /**
     * The row and column of the goal.
     */
    private int goalCol;
    private int goalRow;

    /**
     * The row and column of the start.
     */
    private int startCol;
    private int startRow;

    private boolean[][] visited = new boolean[HEIGHT][WIDTH];
    
    private int moves = 0;
    /**
     * Constructor initializes the maze with the data in 'mazeFile'.
     * @param mazeFile the input file for the maze
     */
    public MazeGame(String mazeFile)
    {
        loadMaze(mazeFile);
        setMoveScanner(new Scanner(System.in));
    }

    /**
     * Constructor initializes the maze with the 'mazeFile' and the move 
     * scanner with 'moveScanner'.
     * @param mazeFile the input file for the maze
     * @param moveScanner the scanner object from which to read user moves
     */
    public MazeGame(String mazeFile, Scanner moveScanner)
    {
        loadMaze(mazeFile);
        setMoveScanner(moveScanner);
    }

    /**
     * getMaze returns a copy of the current maze for testing purposes.
     * 
     * @return the grid
     */
    public boolean[][] getMaze()
    {
        if (blocked == null)
        {
            return null;
        }
        boolean[][] copy = new boolean[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++)
        {
            for (int j = 0; j < WIDTH; j++)
            {
                visited[i][j] = false;
                copy[i][j] = blocked[i][j];
            }
        }
        return copy;
    }

    /**
     * setMaze sets the current map for testing purposes.
     * 
     * @param maze
     *            another maze.
     */
    public void setMaze(boolean[][] maze)
    {
        this.blocked = maze;
    }
    /**
     * getBlocked
     * 
     * @return
     *            another maze.
     */
    public boolean[][] getBlocked()
    {
        return blocked;
    }
    /**
     * setBlocked
     * 
     * @param b
     *            another maze.
     */
    public void setBlocked(boolean[][] b)
    {
        blocked = b;
    }
    /**
     * getUserCol
     * 
     * @return 
     *            another maze.
     */
    public int getUserCol()
    {
        return userCol;
    }
    /**
     * setUserCol
     * 
     * @param u
     *            another maze.
     */
    public void setUserCol(int u)
    {
        userCol = u;
    }
    /**
     * getUserRow
     * 
     * @return
     *            another maze.
     */
    public int getUserRow()
    {
        return userRow;
    }
    /**
     * setUserRow
     * 
     * @param u
     *            another maze.
     */
    public void setUserRow(int u)
    {
        userRow = u;
    }
    /**
     * getMoveScanner
     * 
     * @return
     *            another maze.
     */
    public Scanner getMoveScanner()
    {
        return moveScanner;
    }
    /**
     * setMoveScanner
     * 
     * @param m
     *            another maze.
     */
    public void setMoveScanner(Scanner m)
    {
        moveScanner = m;
    }
    /**
     * Function loads the data from the maze file and creates the 'blocked' 
     * 2D array.
     *  
     * @param mazeFile the input maze file.
     */
    private void loadMaze(String mazeFile)
    {
        Scanner scanner = null;
        File file = new File(mazeFile);
        blocked = new boolean[HEIGHT][WIDTH];
        try
        { 
            scanner = new Scanner(file);  
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found");
        }
        for (int i = 0; i < blocked.length; i++)
        {
            for (int j = 0; j < blocked[i].length; j++)
            {
                String x = scanner.next();
                switch (x)
                {
                    case "1":
                        blocked[i][j] = true;
                        break;
                    case "0":
                        blocked[i][j] = false;
                        break;
                    case "S":
                        blocked[i][j] = false;
                        userRow = i;
                        userCol = j;
                        startRow = i;
                        startCol = j;
                        break;
                    case "G":
                        blocked[i][j] = false;
                        goalRow = i;
                        goalCol = j;
                        break;
                    default:                        
                }
            }
        }
    }

    /**
     * Actually plays the game.
     */
    public void playGame()
    {
        /*printMaze();
        System.out.println("");
        System.out.println("Would you like to move Up, Down, Left or Right?");
        makeMove(moveScanner.next());
        //if(playerAtGoal())
        //{
        //  
        //}
        else
        {
            System.out.println("");
            playGame();
        }*/
        while (!playerAtGoal())
        {
            printMaze();
            System.out.println("");
            System.out.println("Would you like to move" 
                + "Up, Down, Left or Right?");
            makeMove(moveScanner.next());
            if (moves == -1)
            {
                return;
            }
        }
        printMaze();
        System.out.println("");
        System.out.println("You won in " + moves + "moves!");
        return;
    }

    /**
     * Checks to see if the player has won the game.
     * @return true if the player has won.
     */
    public boolean playerAtGoal()
    {
        if (userRow == goalRow && userCol == goalCol)
        {
            return true;
        }
        return false;
    }

    /**
     * Makes a move based on the String.
     * 
     * @param move
     *            the direction to make a move in.
     * @return whether the move was valid.
     */
    public boolean makeMove(String move)
    {
        switch (move.toLowerCase())
        {
            case "up":
                if (userRow - 1 >= 0 && blocked[userRow - 1][userCol] == false)
                {
                    userRow -= 1;
                    moves++;
                    return true;
                }
                else
                {
                    System.out.print("Invalid move");
                    return false;
                }
            case "down":
                if (userRow + 1 < HEIGHT 
                    && blocked[userRow + 1][userCol] == false)
                {
                    userRow += 1;
                    moves++;
                    return true;
                }
                else
                {
                    System.out.print("Invalid move");
                    return false;
                }
            case "left":
                if (userCol - 1 >= 0 && blocked[userRow][userCol - 1] == false)
                {
                    userCol -= 1;
                    moves++;
                    return true;
                }
                else
                {
                    System.out.print("Invalid move");
                    return false;
                }
            case "right":
                if (userCol + 1 < WIDTH 
                    && blocked[userRow][userCol + 1] == false)
                {
                    userCol += 1;
                    moves++;
                    return true;
                }
                else
                {
                    System.out.print("Invalid move");
                    return false;
                }
            case "quit":
                System.out.println("");
                printMaze();
                moves = -1;
                return true;       
            default:
        }
        return false;
    }

    /**
     * Prints the map of the maze.
     */
    public void printMaze()
    {
        System.out.print("*");
        for (int a = 0; a < WIDTH; a++)
        {
            System.out.print("-");
        }
        System.out.println("*");
        for (int i = 0; i < blocked.length; i++)
        {
            System.out.print("|");
            for (int j = 0; j < blocked[i].length; j++)
            {
                if (i == userRow && j == userCol)
                {
                    System.out.print("@");
                    visited[userRow][userCol] = true;
                    visited[startRow][startCol] = false;
                }
                if (blocked[i][j] == false && visited[i][j] == false)
                {
                    if ((i == startRow 
                        && j == startCol) && (userRow != i || userCol != j))
                    {
                        System.out.print("S");
                    }
                    else if ((i != startRow || j != startCol) 
                        && (i != goalRow || j != goalCol) 
                        && (i != userRow || j != userCol))
                    {
                        System.out.print(" ");
                    }
                    else if ((i == goalRow && j == goalCol) 
                        && (userRow != i || userCol != j))
                    {
                        System.out.print("G");
                    }
                }
                else if (blocked[i][j] == false && visited[i][j] == true)
                {
                    if ((i != startRow || j != startCol)
                        && (i != userRow || j != userCol) 
                        && (i != goalRow || j != goalCol))
                    {
                        System.out.print(".");
                    }
                }
                else if (blocked[i][j] == true)
                {
                    System.out.print("X");
                }
            }
            System.out.println("|");
        }
        System.out.print("*");
        for (int b = 0; b < WIDTH; b++)
        {
            System.out.print("-");
        }
        System.out.print("*");
    }

    /**
     * Creates a new game, using a command line argument file name, if one is
     * provided.
     * 
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
        String mapFile = "args[0]";
        Scanner scan = new Scanner(System.in);
        MazeGame game = new MazeGame(mapFile, scan);
        game.playGame();
    }
}
