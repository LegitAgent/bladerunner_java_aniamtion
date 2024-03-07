/**
	This class will draw a rectangle with its specified arguments. Uses built in Rectangle2D to make shape
	
	@author Joaquin Alonzo A. Salazar (237547), Martin Darius L. Alba (230179)
	@version February 27, 2024
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

public class Rectangle implements DrawingObject
{
    int x, y, width, height;
    Color color;
    
    /**
     * Constructor initializes variables
     * @param x x coord origin of rectangle. Top left
     * @param y y coord origin of rectangle. Top left
     * @param width width of rectangle
     * @param height height of rectangle
     * @param color color of rectangle
     */
    public Rectangle(int x, int y, int width , int height, Color color)
    {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;
        
        this.color = color;
    }

    /**
     * Draws base of rectangle
     * @param g2d Graphics2D component passed for object to be painted
     */
    @Override
    public void draw(Graphics2D g2d)
    {
        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(rectangle);
    }
    
    /**Moves the rectangle by an amount in the x axis.
     * @param x amount to be moved
     */
    @Override
    public void move(int x)
    {
        this.x += x;
    }
    
    /**
     * Draws outline of rectangle. Used in creating lights
     * @param g2d Graphics2D component passed for object to be painted
     * @param color color of rectangle outline
     */
    public void drawOutline(Graphics2D g2d, Color color)
    {
        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(rectangle);
        
        g2d.setStroke(new BasicStroke(1));
        float alpha = (float) 0.3;
        g2d.setColor(new Color(1,1,1,alpha));
        g2d.draw(rectangle);
    }
}