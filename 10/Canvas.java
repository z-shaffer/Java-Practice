/**
 * Canvas.java
 * 
 * @author Bruce Quig, Michael Kolling (mik)
 * @version 2008.03.30
 */
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Shape;
import java.awt.Rectangle;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example. 
 *
 * @author Bruce Quig
 * @author Michael Kolling (mik)

 * @version 2008.03.30
 */
public class Canvas
{
    //  ----- instance part -----

    private static Canvas canvasSingleton;
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private BufferedImage canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;    
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

    
    /**
     * Create a Canvas.
     * @param title    title to appear in Canvas Frame
     * @param width    the desired width for the canvas
     * @param height   the desired height for the canvas
     * @param bgColor the desired background color of the canvas
     */
    private Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
    }
    
    /**
     * Create a Canvas.
     * @param title    title to appear in Canvas Frame.
     * @param width    the desired width for the canvas.
     * @param height   the desired height for the canvas.
     * @param bgColor the desired background color of the canvas.
     * @param noFrame If this exists, make a no frame canvas.
     */
    private Canvas(String title, int width, int height, Color bgColor, 
        boolean noFrame)
    {
        //frame = new JFrame();
        frame = null;
        canvas = new CanvasPane();
        //frame.setContentPane(canvas);
        //frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setSize(new Dimension(width, height));
        backgroundColor = bgColor;
        //frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
    }

    /**
     * Factory method to get the canvas singleton object.
     * @return Return the current canvas.  Create a new canvas if one
     * does not currently exist.
     */
    public static Canvas getCanvas()
    {
        try
        {           
            if (canvasSingleton == null) 
            {
                canvasSingleton = new Canvas("Plotter", 300, 300, 
                    Color.white);
                             
            }
            canvasSingleton.setVisible(true);
        }
        catch (java.awt.HeadlessException e)
        {
            //Webcat will throw this exception because it doesnt
            //have X11 set up.  Ignore it and everything will
            //be fine.
            canvasSingleton = new Canvas("Plotter", 300, 300, 
                Color.white, false);
            canvasSingleton.setVisible(true);

        }
        return canvasSingleton;
    }    
    
    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        if (graphic == null) 
        {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = new BufferedImage(size.width, size.height, 
                BufferedImage.TYPE_INT_ARGB);
            graphic = (Graphics2D) canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
            drawAxes(graphic);
        }
        if (frame != null)
        {
            frame.setVisible(visible);
        }
    }
    
    /**
     * Draw the axes templates on the screen.
     * 
     * @param graphic The graphic object which contains
     * the canvas image data.
     */
    public void drawAxes(Graphics2D graphic)
    {
        graphic.setColor(Color.red);
        graphic.drawRect(0, 146, 300, 6);
        graphic.drawRect(146, 0, 6, 300);
        for (int i = 0; i < 17; i++)
        {
            if (i != 7)
            {
                graphic.drawRect(136, 6 + i * 20, 26, 6);
                graphic.drawRect(6 + i * 20, 136, 6, 26); 
            }
        }
        
        graphic.setColor(Color.yellow);
        graphic.fillRect(0, 147, 300, 5);
        graphic.fillRect(147, 0, 5, 300);
        for (int i = 0; i < 17; i++)
        {
            if (i != 7)
            {
                graphic.fillRect(137, 7 + i * 20, 25, 5);
                graphic.fillRect(7 + i * 20, 137, 5, 25); 
            }
        }
    }
    
    /**
     * Draw a given shape onto the canvas.
     * @param  referenceObject  an object to define identity for this shape
     * @param  color            the color of the shape
     * @param  shape            the shape object to be drawn on the canvas
     */
     // Note: this is a slightly backwards way of maintaining the shape
     // objects. It is carefully designed to keep the visible shape interfaces
     // in this project clean and simple for educational purposes.
    public void draw(Object referenceObject, String color, Shape shape)
    {
        // just in case it was already there add at the end
        objects.remove(referenceObject);   
        objects.add(referenceObject);      
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }
 
    /**
     * Erase a given shape's from the screen.
     * @param  referenceObject  the shape object to be erased 
     */
    public void erase(Object referenceObject)
    {
        // just in case it was already there 
        objects.remove(referenceObject);   
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Set the foreground color of the Canvas.
     * @param  colorString   the new color for the foreground of the Canvas 
     */
    public void setForegroundColor(String colorString)
    {
        if (colorString.equals("red")) 
        {
            graphic.setColor(Color.red);
        }
        else if (colorString.equals("black")) 
        {
            graphic.setColor(Color.black);
        }
        else if (colorString.equals("blue")) 
        {
            graphic.setColor(Color.blue);
        }
        else if (colorString.equals("yellow")) 
        {
            graphic.setColor(Color.yellow);
        }
        else if (colorString.equals("green")) 
        {
            graphic.setColor(Color.green);
        }
        else if (colorString.equals("magenta")) 
        {
            graphic.setColor(Color.magenta);
        }
        else if (colorString.equals("white")) 
        {
            graphic.setColor(Color.white);
        }
        else if (colorString.equals("gray")) 
        {
            graphic.setColor(Color.gray);
        }
        else 
        {
            graphic.setColor(Color.black);
        }
    }

    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  The number of seconds to sleep.
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
            System.out.println("");
        }
    }

    /**
     * Redraw all shapes currently on the Canvas.
     */
    private void redraw()
    {
        erase();
        drawAxes(graphic);
        for (Object shape : objects) 
        {
            shapes.get(shape).draw(graphic);
        }
        canvas.repaint();
    }
       
    /**
     * Return the list of shapes.
     * @return Hashmap of all of the shapes attached to this
     * canvas.
     */
    public HashMap<Object, ShapeDescription> getShapes()
    {
        return shapes;    
    }

    /**
     * Return the list of shapes.
     * @return Hashmap of all of the shapes attached to this
     * canvas.
     */
    public ArrayList<Square> getSquares()
    {
        ArrayList<Square> squares = new ArrayList<Square>();
        for (Object shape : objects) 
        {
            if (shape instanceof Square)
            {
                squares.add((Square) shape);
            }
        }        
        return squares;
    }
 
    /**
     * Count the number of squares at a given x coordinate.
     * @param x The x coordinate to check squares against.
     * @return count Count of squares at the given x coordinate.
     */
    public int countSquaresAtX(int x)
    {
        int count = 0;
        for (Object shape : objects) 
        {
            if (shape instanceof Square)
            {
                Square s = (Square) shape;
                if (s.getxPosition() == x)
                {
                    count++;
                }
            }
        }        
        return count;        
    }  
    /**
     * Count the number of squares at a given y coordinate.
     * @param y The y coordinate to check squares against.
     * @return count Count of squares at the given y coordinate.
     */
    public int countSquaresAtY(int y)
    {
        int count = 0;
        for (Object shape : objects) 
        {
            if (shape instanceof Square)
            {
                Square s = (Square) shape;
                if (s.getyPosition() == y)
                {
                    count++;
                }
            }
        }        
        return count;        
    }
    
    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    /**
     * Reset canvas.  Erase all shapes.  Delete all shapes.
     * Redraw axes.
     */
    public void resetCanvas()
    {
        erase();
        objects.clear();
        shapes.clear();
        drawAxes(graphic);
        canvas.repaint();        
    }
    
    /**
     * Count the number of shapes with the given color.
     * 
     * @param color Count shapes with this color.
     * 
     * @return Returns the number of shapes with the given color.
     */
    
    public int countShapesByColor(String color)
    {
        int count = 0;
        for (Object shape : objects) 
        {
            if (shapes.get(shape).getColor().equals(color))
            {
                count++;
            }
        }        
        return count;
    }
    /**
     * Count the number of squares that are off the screen.
     * 
     * @return Returns tne number of squares that have x or y
     * positions outside the bounds of the window.  That is
     * x or y < 0 or x or y > 299.
     */
    public int countOffscreenSquares()
    {
        int count = 0;
        for (Object shape : objects) 
        {
            if (shape instanceof Square)
            {
                Square s = (Square) shape;
                int x = s.getxPosition();
                int y = s.getyPosition();
                
                if (x < 0 || y < 0 || x > 299 || y > 299)
                {
                    count++;
                }
            }
        }        
        return count;        
    }
    
    /**
     * Get all circles that have been drawn.
     * 
     * @return Returns an ArrayList of circle objects.
     */
    public ArrayList<Circle> getCircles()
    {
        ArrayList<Circle> circles = new ArrayList<Circle>();
        
        int count = 0;
        for (Object shape : objects) 
        {
            if (shape instanceof Circle)
            {
                circles.add((Circle) shape);
            }
        }        
        return circles;        
    }    
    /**
     * Accessor for getting the canvas image.
     * @return Returns the image associated with this
     * canvas.
     */
    public BufferedImage getCanvasImage()
    {
        return canvasImage;
    }
    
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        /**
         * Paint the canvas image to the graphics object.
         * @param g The graphics object that will eventualy get painted to 
         * the screen.
         */
        
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class ShapeDescription
    {
        private Shape shape;
        private String colorString;

        /**
         * Parameterized constructor which sets the shape and the color
         * to draw that shape.
         * @param shape The shape to draw.
         * @param color The color with which to draw the shape.
         */
        public ShapeDescription(Shape shape, String color)
        {
            this.shape = shape;
            colorString = color;
        }

        /**
         * Return this shape description's color.
         * @return Returns the color as a string.
         */
        public String getColor()
        {
            return colorString;
        }
       
        
        /**
         * Draw this shape on the graphics object.
         * @param graphic The graphics object that will eventualy get
         * painted to the screen.
         */
        public void draw(Graphics2D graphic)
        {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }

}
