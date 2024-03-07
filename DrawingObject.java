/**
	DrawingObject is an interface and will extend every shape that will be used
    in this animation. It uses several methods that you can use on each shape or object.
	
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
public interface DrawingObject {
    /**
	 * Draws each object
	 * @param g2d Graphics2D component to be used in drawing an obj
	 */
    public void draw(Graphics2D g2d);
	
    /**
	 * Moves each object by x along x axis
	 * @param x amount to be moved
	*/
    public void move(int x);
}
