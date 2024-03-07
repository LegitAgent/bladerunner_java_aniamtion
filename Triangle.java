/**
	This class will draw a triangle with its specified arguments.
	
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
public class Triangle implements DrawingObject 
{
    //Declares all variables to be used within the class.
    double x1, x2, x3, y1, y2, y3;
    Color color;

    /**Constructor initializes variables.
     * @param x1 is the x coordinate of point 1
     * @param y1 is the y coordinate of point 1
     * @param x2 is the x coordinate of point 2
     * @param y2 is the y coordinate of point 2
     * @param x3 is the x coordinate of point 3
     * @param y3 is the y coordinate of point 3
     * @param color is the color of the triangle
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3, Color color)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.color = color;
    }

    /**Draws the triangle
     * @param g2d Graphics2D component passed for object to be painted
     */
    public void draw(Graphics2D g2d)
    {
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(x1, y1);
        triangle.lineTo(x2, y2);
        triangle.lineTo(x3, y3);
        triangle.closePath();
        g2d.setColor(color);
        g2d.fill(triangle);
    }

    /**Moves the triangle
     * @param x moves it in the x axis by this amount
     */
    public void move(int x)
    {
        x1 += x;
        x2 += x;
        x3 += x;
    }
}
