/**
	Hovercars to be created as instances that fly around bg of the scene. Composite shapes made up of Rectangle & Trapezoid
	
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
import java.awt.geom.AffineTransform;
public class Hovercar implements DrawingObject{
    //Declares all variables to be used within the class
    private Color colorBody, colorHood, colorThruster;
    private int size, x ,y, velocity;
    private int distanceTriangle;

    /**
     * Constructor initializes variables
     * @param x x coordinate origin of object
     * @param y y coordinate origin of object
     * @param size size of Hovercar
     * @param velocity velocity of hovercar movement
     * @param colorBody color of hovercar body
     * @param colorThruster color of hovercar thruster
     * @param colorHood color of hovercar hood
     */
    public Hovercar(int x, int y, int size, int velocity, Color colorBody, Color colorThruster, Color colorHood)
    {
        this.size = size;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.colorBody = colorBody;
        this.colorHood = colorHood;
        this.colorThruster = colorThruster;
    }

    /**Draws the HoverCar object.
     * @param g2d Graphics2D component passed for object to be painted
    */
    @Override
    public void draw(Graphics2D g2d)
    {

        AffineTransform reset = g2d.getTransform();

        Rectangle body1 = new Rectangle(x, y, size * 3, size, colorBody);
        body1.draw(g2d);

        distanceTriangle = (size * 4 - size * 3) / 2;
        Trapezoid bottom = new Trapezoid(x + size*3 - distanceTriangle, y + size, -size * 3, -size * 4, size/2, colorThruster);
        g2d.rotate(Math.toRadians(15), x + size*3, y + size);
        bottom.draw(g2d);
        g2d.setTransform(reset);

        Trapezoid hood = new Trapezoid(x + size/2, y - size/3, size * 2, size , size/3, colorHood);
        hood.draw(g2d);
    }
    
    /**
     * Draws Hovercar obj flipped
     * @param g2d Graphics2D component passed for object to be painted
     */
    public void inverseDraw(Graphics2D g2d)
    {
        AffineTransform reset = g2d.getTransform();
        Rectangle body = new Rectangle(x, y, size * 3, size, colorBody);
        body.draw(g2d);

        distanceTriangle = (size * 3 - size * 2) / 2;
        Trapezoid bottom = new Trapezoid(x + distanceTriangle, y + size, size * 3, size * 4, size/2, colorThruster);
        g2d.rotate(Math.toRadians(-15),x,y+size);
        bottom.draw(g2d);
        g2d.setTransform(reset);

        Trapezoid hood = new Trapezoid(x + size/2, y - size/3, size * 2, size , size/3, colorHood);
        hood.draw(g2d);
    }

    /**Moves the hovercar by an amount in the x axis.
     * @param x amount to be moved
    */
    @Override
    public void move(int x)
    {
        this.x += x;
    }

    /**
     * Gets x coordinate of car
     * @return x coordinate
     */
    public int getXCoordinate()
    {
        return x;
    }

    /**
     * Sets the movement to a constant rate
     */
    public void constantSpeed()
    {
        x += velocity;
    }
}
