/**
	This class will hold presets for the tilesets on the SceneCanvas. 
    There are 3 tilesets: Commercial, Residential, Entertainment
	
	@author Joaquin Alonzo A. Salazar (237547), Martin Darius L. Alba (230179)
	@version March 3, 2024
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

public class Window implements DrawingObject
{  
    //Variables to be used within the class.
    private int x, y, size, emissionSize;
    private final Color base = new Color(255, 215, 69);

    //Transulcent color from javadocs https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
    private final Color emission = new Color(255, 215, 69, 70);

    /**Constructor initializes variables
     * @param x x coordinate of the object.
     * @param y y coordinate of the object.
     * @param size size of the square.
     */
    public Window(int x, int y, int size)
    {
        this.x = x;
        this.y = y;
        this.size = size;
        emissionSize = this.size + (int) (size*0.4);
    }

    /**Draws the window
     * @param g2d Graphics2D component passed for object to be painted
     */
    public void draw(Graphics2D g2d)
    {
        Rectangle r = new Rectangle(x, y, size, size, base);
        Circle c = new Circle(x+emissionSize-emissionSize/6, y+emissionSize-emissionSize/6, emissionSize, emission);

        r.draw(g2d);
        c.draw(g2d);
    }

    /**Moves the window in the x axis by x amount
     * @param x amount to be moved in the x axis
     */
    public void move(int x)
    {
        this.x += x;
    }
}
