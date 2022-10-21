/**
 * Square.java
 */

import java.awt.Rectangle;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30 
 */

public class Square
{
    private int size;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private boolean mvr;

    /**
     * Create a new square at default position with default color.
     */
    public Square()
    {
        size = 30;
        xPosition = 60;
        yPosition = 50;
        color = "blue";
        isVisible = false;
    }
    
    public Square(int x, int y)
    {
        size = 5;
        xPosition = x;
        yPosition = y;
        color = "black";
        makeVisible();
    }
    
    /**
     * Bring up a canvas with the axes on them.
     */
    public static void test()
    {
        Square s = new Square();
        s.changeColor("white");
        s.makeVisible();
    }
    
    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        setIsVisible(true);
        draw();
        mvr = true;
    }
    
    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        setIsVisible(false);
    }
    
    /**
     * Move the square a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the square a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the square a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the square a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the square horizontally by 'distance' pixels.
     * @param distance The distance in pixels to move this circle horizontally.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        setxPosition(getxPosition() + distance);
        draw();
    }

    /**
     * Move the square vertically by 'distance' pixels.
     * @param distance The distance in pixels to move this circle vertically.
     */
    public void moveVertical(int distance)
    {
        erase();
        setyPosition(getyPosition() + distance);
        draw();
    }

    /**
     * Slowly move the square horizontally by 'distance' pixels.
     * @param distance The distance in pixels to move this circle horizontally.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if (distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for (int i = 0; i < distance; i++)
        {
            setxPosition(getxPosition() + delta);
            draw();
        }
    }

    /**
     * Slowly move the square vertically by 'distance' pixels.
     * @param distance The distance in pixels to move this circle vertically.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if (distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for (int i = 0; i < distance; i++)
        {
            setyPosition(getyPosition() + delta);
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     * @param newSize Change the rectangle to the value specified.
     */
    public void changeSize(int newSize)
    {
        erase();
        setSize(newSize);
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * @param newColor Change the rectangle to this specified color.
     */
    public void changeColor(String newColor)
    {
        setColor(newColor);
        draw();
    }

    /**
     * Draw the square with current specifications on screen.
     */
    private void draw()
    {
        if (isIsVisible()) 
        {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, getColor(),
                new Rectangle(getxPosition(), 
                        getyPosition(), getSize(), getSize()));
            canvas.wait(10);
        }
    }

    /**
     * Erase the square on screen.
     */
    private void erase()
    {
        if (isIsVisible()) 
        {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    /**
     * @return the size
     */
    public int getSize() 
    {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) 
    {
        this.size = size;
    }

    /**
     * @return the xPosition
     */
    public int getxPosition() 
    {
        return xPosition;
    }

    /**
     * @param xPosition the xPosition to set
     */
    public void setxPosition(int xPosition) 
    {
        this.xPosition = xPosition;
    }

    /**
     * @return the yPosition
     */
    public int getyPosition() 
    {
        return yPosition;
    }

    /**
     * @param yPosition the yPosition to set
     */
    public void setyPosition(int yPosition) 
    {
        this.yPosition = yPosition;
    }

    /**
     * @return the color
     */
    public String getColor() 
    {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) 
    {
        this.color = color;
    }

    /**
     * @return the isVisible
     */
    public boolean isIsVisible() 
    {
        return isVisible;
    }
 
    /**
     * @return the mvr
     */
    public boolean isMvr() 
    {
        return mvr;
    }
    
    /**
     * @param isVisible the isVisible to set
     */
    public void setIsVisible(boolean isVisible) 
    {
        this.isVisible = isVisible;
    }
}
