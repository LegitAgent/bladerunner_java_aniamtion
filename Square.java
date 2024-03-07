/**
	This class will draw a square with its specified arguments. Uses built-in Rectangle2D to make shape
	
	@author Joaquin Alonzo A. Salazar (237547), Martin Darius L. Alba (230179)
	@version February 26, 2024
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

public class Square implements DrawingObject 
{

    private int x, y;
    private double size;
    private Color color;
    
    /**
     * Constructor initializes variables
     * @param x x coordinate of Square. Top left
     * @param y y coordinate of square. Top left
     * @param size width and height of square
     * @param color Color of square
     */
    public Square(int x, int y, int size, Color color) 
    {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * Draws square
     * @param g2d Graphics2D component passed for object to be painted
     */
    @Override
    public void draw(Graphics2D g2d) 
    {
        Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(square);
    }

    /**Moves the square by an amount in the x axis.
     * @param x amount to be moved
    */
    @Override
    public void move(int x) 
    {
        this.x += x;
    }

}
