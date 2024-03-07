/**
	This class will draw a trapezoid with its specified arguments. made using Path2D function to create shape
	
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


import java.awt.geom.*;
import java.awt.*;

public class Trapezoid implements DrawingObject
{
    //Declares all variables to be used within the class
    int xStart, yStart, baseBase, baseTop, height, distanceTriangle;
    Color color;

    /**Constuctor initializes all variables
     * @param xStart x start of the trapezoid
     * @param yStart y start of the trapezoid
     * @param baseBase width of the base of the trapezoid
     * @param baseTop width of the top of the trapezoid
     * @param height height of the trapezoid
     * @param color color of the trapezoid
     */
    public Trapezoid(int xStart, int yStart, int baseBase, int baseTop, int height, Color color)
    {
        this.xStart = xStart;
        this.yStart = yStart;

        this.baseBase = baseBase;
        this.baseTop = baseTop;

        this.height = height;
        this.color = color;

        //Gets the distance from the edge point and the top/bottom width.
        distanceTriangle = (baseBase - baseTop) / 2;
    }

    /**Draws the trapezoid
     * @param g2d Graphics2D component passed for object to be painted
     */
    public void draw(Graphics2D g2d) 
    {

        Path2D.Double trapezoid = new Path2D.Double();
        trapezoid.moveTo(xStart, yStart + height);
        trapezoid.lineTo(xStart + baseBase, yStart + height);
        trapezoid.lineTo(xStart + baseBase - distanceTriangle, yStart);
        trapezoid.lineTo(xStart + distanceTriangle, yStart);
        trapezoid.closePath();
        g2d.setColor(color);
        g2d.fill(trapezoid);
        
    }

    /**Moves the trapezoid
     * @param x moves the trapezoid on the x axis by this amount
     */
    public void move(int x) 
    {
        this.xStart += x;
    }
}
