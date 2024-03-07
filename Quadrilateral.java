/**
	This class will draw a quadrilateral with its specified arguments. made using Path2D function to create shape.
    Takes in 4 points to be corners of the quadrilateral
	
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

public class Quadrilateral implements DrawingObject
{
    private double x1, y1, x2, y2, x3, y3, x4, y4;
    private Color color;

    /**
     * Constructor initializes variables
     * @param x1 x coord top left of quadrilateral
     * @param y1 y coord top left of quadrilateral
     * @param x2 x coord bottom left of quadrilateral
     * @param y2 y coord bottom left of quadrilateral
     * @param x3 x coord top right of quadrilateral
     * @param y3 y coord top right of quadrilateral
     * @param x4 x coord bottom right of quadrilateral
     * @param y4 y coord bottom right of quadrilateral
     * @param color color of quadrilateral
     */
    public Quadrilateral(double x1, double y1, double x2, double y2, 
                        double x3, double y3, double x4, double y4, 
                        Color color)
    {
        this.x1 = x1;
        this.y1 = y1;
        
        this.x2 = x2;
        this.y2 = y2;
        
        this.x3 = x3;
        this.y3 = y3;

        this.x4 = x4;
        this.y4 = y4;

        this.color = color;
    }

    /**
     * Draws base of quadrilateral
     * @param g2d Graphics2D component passed for object to be painted
     */
    @Override
    public void draw(Graphics2D g2d)
    {
        Path2D.Double q = new Path2D.Double();

        q.moveTo(x1, y1);
        q.lineTo(x2, y2);
        q.lineTo(x3, y3);
        q.lineTo(x4, y4);
        q.closePath();
        
        g2d.setColor(color);
        g2d.fill(q);
    }

    /**Moves the quadrilateral by an amount in the x axis.
     * @param x amount to be moved
    */
    @Override
    public void move(int x)
    {
        this.x1+=x;
        this.x2+=x;
        this.x3+=x;
        this.x4+=x;
    }

    /**
     * Draws outline of the quadrilateral. Used in creating lights
     * @param g2d Graphics2D component passed for object to be painted
     * @param color Color of outline
     */
    public void drawOutline(Graphics2D g2d, Color color)
    {
        Path2D.Double q = new Path2D.Double();

        q.moveTo(x1, y1);
        q.lineTo(x2, y2);
        q.lineTo(x3, y3);
        q.lineTo(x4, y4);
        q.closePath();

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(q);
        
        g2d.setStroke(new BasicStroke(1));
        float alpha = (float) 0.3;
        g2d.setColor(new Color(1,1,1,alpha));
        g2d.draw(q);
    }
}
