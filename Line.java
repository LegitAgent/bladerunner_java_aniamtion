/**
	This class will draw a line with its specified arguments. Uses built-in functions to create line, a basic shape
	
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

public class Line implements DrawingObject 
{

    private int x1, y1, x2, y2, thick;
    private Color color;

    /**
     * Constructor initializes variables
     * @param x1 x coord of 1st point on line
     * @param y1 y coord of 1st point on line
     * @param x2 x coord of 2nd point on line
     * @param y2 x coord of 2nd point on line
     * @param thick thickness of line
     * @param color color of line
     */
    public Line(int x1, int y1, int x2, int y2, int thick, Color color) 
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.thick = thick;
        this.color = color;
    }

    /**
     * Draws Line
     * @param g2d Graphics2D component passed for object to be painted
     */
    @Override
    public void draw(Graphics2D g2d) 
    {
        Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thick));
        g2d.draw(line);
    }

    /**Moves the line by an amount in the x axis.
     * @param x amount to be moved
    */
    public void move(int x) 
    {
        x1 += x;
        x2 += x;
    }

    /**
     * Gets x coordinate of 1st point on line
     * @return x coordinate on 1st point on line
     */
    public int getX1Coordinate()
    {
        return x1;
    }
}
