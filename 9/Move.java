/**
 * Represents a Move for the Player.
 */
public class Move
{
    private MoveType moveType;
    private int range;

    public Move()
    {
        this.moveType = MoveType.BASICATTACK;
        this.range = 1;
    }

    public Move(MoveType moveType, int range)
    {
        this.moveType = moveType;
        this.range = range;
    }

    public void setRange(int range)
    {
        this.range = range;
    }

    public MoveType getMoveType()
    {
        return this.moveType;
    }

    public int getRange()
    {
        return this.range;
    }

    /**
    * Make a toString method that returns
    * "$ for #"
    * where $ is the MoveType and # is the range.
    */
    public String toString()
    {
        return String.format("%s for %d", moveType, range);
    }

    /**
    * Make an equals method
    */
    public boolean equals(Move move)
    {
        return (moveType.equals(move.moveType) && range == move.range);
    }

    /**
    * Make a copy method
    */
    public Move copy()
    {
        Move moveCopy = new Move(moveType, range);
        return moveCopy;
    }
}