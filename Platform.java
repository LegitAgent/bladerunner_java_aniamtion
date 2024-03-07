/**
	This class will draw the platform for RyanGosling class to stand on. Composite shape made out of multiple Rectangle classes
	
	@author Joaquin Alonzo A. Salazar (237547), Martin Darius L. Alba (230179)
	@version February 29, 2024
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

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Platform implements DrawingObject 
{
    final int METAL_BEAM_COUNT = 15;
    int x, y, length, width;
    ArrayList<Rectangle> metalBeams = new ArrayList<>();
    /**
     * Constructor initializes variables
     * @param x x coordinate origin of platform
     * @param y y coordinate origin of platform
     * @param length length of platform
     * @param width width of platform
     */
    public Platform(int x, int y, int length, int width)
    {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    /**
     * Draws platform
     * @param g2d Graphics2D component passed for object to be painted
     */
    @Override
    public void draw(Graphics2D g2d) 
    {
        int distanceY = y, width = length, height = 5;
        for(int i = 1; i <= METAL_BEAM_COUNT; i++)
        {
            if(i % 2 == 0)
            {
                metalBeams.add(new Rectangle(x, distanceY, width, height, Color.GRAY));
            }
            else
            {
                metalBeams.add(new Rectangle(x, distanceY, width, height, Color.darkGray));
            }
            distanceY = distanceY + height;
        }

        for(Rectangle beam : metalBeams)
        {
            beam.draw(g2d);
        }
    }

    /**Moves the platform by an amount in the x axis.
     * @param x amount to be moved
    */
    @Override
    public void move(int x)
    {
        this.x += x;
    }
    
}
