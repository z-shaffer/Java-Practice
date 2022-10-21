/**
 * Circle.java
 */

import java.awt.geom.Ellipse2D;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Circle
{
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    private boolean mvr;

    /**
     * Create a new circle at default position with default color.
     */
    public Circle()
    {
        diameter = 30;
        xPosition = 20;
        yPosition = 60;
        color = "blue";
        isVisible = false;
    }

    public Circle(int x, int y)
    {
        diameter = 10;
        xPosition = x;
        yPosition = y;
        color = "red";
        makeVisible();
    }

    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        setIsVisible(true);
        draw();
        mvr = true;
    }

    /**
     * Make this circle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        setIsVisible(false);
    }

    /**
     * Move the circle a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the circle a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the circle a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the circle a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the circle horizontally by 'distance' pixels.
     * @param distance The distance in pixels to move this circle horizontally.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        setxPosition(getxPosition() + distance);
        draw();
    }

    /**
     * Move the circle vertically by 'distance' pixels.
     * @param distance The distance in pixels to move this circle vertically.
     */
    public void moveVertical(int distance)
    {
        erase();
        setyPosition(getyPosition() + distance);
        draw();
    }

    /**
     * Slowly move the circle horizontally by 'distance' pixels.
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
     * Slowly move the circle vertically by 'distance' pixels.
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
     * @param newDiameter Change this circle's diameter to this given value.
     */
    public void changeSize(int newDiameter)
    {
        erase();
        setDiameter(newDiameter);
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     * @param newColor Change this circle's coloer to this given color.
     */
    public void changeColor(String newColor)
    {
        setColor(newColor);
        draw();
    }

    /**
     * Draw the circle with current specifications on screen.
     */
    private void draw()
    {
        if (isIsVisible()) 
        {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, getColor(), 
                new Ellipse2D.Double(getxPosition(), 
                    getyPosition(), getDiameter(), getDiameter()));
            canvas.wait(10);
        }
    }

    /**
     * Erase the circle on screen.
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
     * @return the diameter
     */
    public int getDiameter() 
    {
        return diameter;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(int diameter) 
    {
        this.diameter = diameter;
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
