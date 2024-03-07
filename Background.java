/**
	This class will draw the background of the canvas. Uses a gradient against a solid background to create
    effect of light diffusion
	
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

public class Background implements DrawingObject{
    int x, y;
    Color grad1, grad2;

    /**Declares the variables of this class through the constructor.
     * @param x x coord of draw. Top left of shape
     * @param y y coord of draw. Top left of shape
     * @param grad1 start Color of gradient
     * @param grad2 end Color of gradient
     */
    public Background(int x, int y, Color grad1, Color grad2)
    {
        this.grad1 = grad1;
        this.grad2 = grad2;
        this.x = x;
        this.y = y;
    }

    /**Draws the background with its corresponding colors.
     * @param g2d Graphics2D component passed for shapes to be painted
    */
    @Override
    public void draw(Graphics2D g2d) 
    {
        GradientPaint gradient = new GradientPaint(x, y, grad1, 0, 300, grad2);
        g2d.setPaint(gradient);
        Rectangle2D.Double r = new Rectangle2D.Double(x,y,800,300);
        g2d.fill(r);

    }

    /**Moves the background in the x axis by x amount.
     * @param x amount for obj to be moved in x axis
    */
    @Override
    public void move(int x)
    {
	    this.x += x;
    }
    
}
