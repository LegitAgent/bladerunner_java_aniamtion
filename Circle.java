/**
	This class will draw a basic shape circle with its specified arguments. Uses built in Ellipse2D to make shape.
    Will draw from the center of the Circle outwards, rather than normal Ellipse2D method
	
	@author Joaquin Alonzo A. Salazar (237547), Martin Darius L. Alba (230179)
	@version March 6, 2024
**/

/*
	I have not discussed the Java language code in my program 
	with anyone other than my instructor or the teaching assistants 
	assigned to this course.

	I have not used Java language code obtained from another student, 
	or any other unauthorized source, either modified or unmodified.

	If any Java language code or documentation used in my program 
	was obtained from another source, such as a textbook or website, 
	that has been clearly noted with a proper citation in the comments 
	of my program.
*/
import java.awt.*;
import java.awt.geom.*;

public class Circle implements DrawingObject 
{
    //Variables to be used within the class
    private int x, y;
    private double size;
    private Color color;

    /** Constructor initializes variables
     *  @param x x coord of circle. Center of Circle
     *  @param y y coord of circle. Center of Circle
     *  @param size diameter of circle
     *  @param color 
     */
    public Circle(int x, int y, int size, Color color) 
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }
    
    /**Draws the circle from the origin
     * @param g2d Graphics2D component passed for shapes to be painted
    */
    @Override
    public void draw(Graphics2D g2d) 
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(x - size, y - size, size, size);
        g2d.setColor(color);
        g2d.fill(circle);
    }

    /** Moves the object in the x axis by x amount.
     *  @param x amount to be moved along x axis
     */
    @Override
    public void move(int x) 
    {
        this.x += x;
    }

    /**Draws an outline of the circle.
     * @param g2d Graphics2D component passed for shape to be painted
    */
    public void drawOutline(Graphics2D g2d, Color color)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(x - size, y - size, size, size);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(circle);
    }
}