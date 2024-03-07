/**
	This class will draw a Building composite shape out of Rectangle & Quadrilateral classes. 
    Will calculate and generate a 3d image based on the point of perspective of the canvas
	
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
import java.awt.geom.Line2D;

public class Building implements DrawingObject
{
    private int x, y, width, height, maxDepth, currentDepth;
    private Color frontColor, lightColor;

    private Rectangle r;
    private Quadrilateral q;

    //Points for quadrilateral
    private double x1, y1, x2, y2, x3, y3, x4, y4;

    //Creating Lines. There will always be 7
    //Square
    private Line rLine1;
    private Line rLine2;
    private Line rLine3;
    private Line rLine4;

    //Origin points
    private int oX;
    private int oY;

    /** Constructor initializes variables
     *  @param x starting x pos of shape. Top left of obj
     *  @param y starting y pos of shape. Top left of obj
     *  @param w width of building
     *  @param h height of building
     *  @param d depth of building
     *  @param front color of front side of building
     *  @param light color of light surrounding building
     *  @param canv SceneCanvas instance to be used
    */
    public Building(int x, int y, int w, int h, int d, Color front, Color light, SceneCanvas canv)
    {
        this.x = x;
        this.y = y;

        width = w;
        height = h;
        maxDepth = d;
        currentDepth = maxDepth;

        frontColor = front;
        lightColor = light;

        oX = canv.ORIGIN_X;
        oY = canv.ORIGIN_Y;

        //Initialize quad points to 0
        x1 = 0; 
        y1 = 0;
        
        x2 = 0;
        y2 = 0;

        x3 = 0;
        y3 = 0;

        x4 = 0;
        y4 = 0;
    }

    /**Draws the buildings with 3D AURA. 
     * @param g2d the graphics used for the building.
    */
    public void draw(Graphics2D g2d)
    {
        //Calculate points on quadrilateral
        setPoints();

        //Makes 2 new quadrilaterals
        q = new Quadrilateral(x1, y1, x2, y2, x3, y3, x4, y4, Color.BLACK);
        q.draw(g2d);
        q = new Quadrilateral(x1, y1, x2, y2, x3, y3, x4, y4, Color.BLACK);
        q.draw(g2d);

        //Quadrilateral Lines, Must use Line2D.Double; Creates smaller lines on top of each for light effect
        g2d.setColor(lightColor);
        g2d.setStroke(new BasicStroke(5));
        //Top Line
        Line2D.Double qLine1 = new Line2D.Double(x1, y1, x4, y4);
        g2d.draw(qLine1);

        //Bottom Line
        Line2D.Double qLine2 = new Line2D.Double(x2, y2, x3, y3);
        g2d.draw(qLine2);

        //Outer Line
        Line2D.Double qLine3 = new Line2D.Double(x4, y4, x3, y3);
        g2d.draw(qLine3);

        //Building main frame.
        r = new Rectangle(x, y, width, height, frontColor);
        r.draw(g2d);

        //Drawing Lines
        rLine1 = new Line(x, y, x+width, y, 5, lightColor); //Top
        rLine2 = new Line(x, y, x, y+height, 5, lightColor); //L
        rLine3 = new Line(x+width, y, x+width, y+height, 5, lightColor); //R
        rLine4 = new Line(x, y+height, x+width, y+height, 5, lightColor); //Bot
        
        rLine1.draw(g2d);
        rLine2.draw(g2d);
        rLine3.draw(g2d);
        rLine4.draw(g2d);

    }

    /** Moves the object in the x axis by x amount.
     *  @param x amount to be moved along x axis
     */
    public void move(int x)
    {
        this.x += x;
    }

    /** Sets points to be used on the quadrilaterals
     */
    private void setPoints()
    {
        /* Points to remember = Switch if on right side
         *
         * top left quad: (x + width, y)
         * bot left quad: (x + width, y + height)
         * 
         */
        //checks to see if the x value of the building are to the left side of the canvas.
        if(x < 400)
        {
            //Makes the right side value of the quadrilateral equal to the building
            x1 = x + width;
            y1 = y;

            x2 = x1;
            y2 = y + height;

            //Calculate for point 3
            x3 = x2 + currentDepth; //Already included depth so not necessary to make change to givenX
            y3 = y + height;

            //Calculate for point 4
            x4 = x1+ currentDepth; //Already included depth so not necessary to make change to givenX
            y4 = getYOnLine(y1, x1, x4);

            //checks if the value of x4 and x3 are past the left side
            if(x4 >= oX && x3 >= oX) 
            {
                //Does the same calculations except it limits the x and y axis of points 3 and 4
                x1 = x + width;
                y1 = y;
    
                x2 = x + width;
                y2 = y + height;

                x3 = oX;
                y3 = y + height;

                x4 = oX;
                y4 = oY;
            } 
        }
        //Checks if the coordinates of the building are to the right side of the canvas.
        else if(x > oX)
        {
            //Same concept for the previous if statement.
            x1 = x;
            y1 = y;
    
            x2 = x;
            y2 = y+height;
    
            //Calculate for point 3
            x3 = x2-currentDepth; //Already included depth so not necessary to make change to givenX
            y3 = y + height;
    
            //Calculate for point 4
            x4 = x1-currentDepth; //Already included depth so not necessary to make change to givenX
            y4 = getYOnLine(y1, x1, x4);
            if(x4 <= oX && x3 <= oX) 
            {
                x1 = x;
                y1 = y;
    
                x2 = x;
                y2 = y + height;

                x3 = oX;
                y3 = y + height;

                x4 = oX;
                y4 = oY;
            } 
        }
    }

    /**
     * Gets x coordinate of obj
     * @return x coordinate of building. Top left of obj
     */
    public int getXCoordinate() 
    {
        return x;
    }

    /** Gets the y coordinate of a point on the line to create the corners of the quadrilateral. 
     *  Uses 2 point formula
     *  Used to get y3 and y4
     * @param currentY y1 in 2-point formula. Start point for line
     * @param referenceX x1 in 2-point formula. Start point for line
     * @param depthX x coordinate AFTER depth calculation. x in 2-point formula
     * @return y coordinate of the point on line
     */
    //                              y1 or y2 |       x1 or x2  |  x3 or x4
    private double getYOnLine(double currentY, double referenceX, double depthX)
    {
        double yOnLine = 0;

        //Uses slope intercept to calculate the y value of the shadow.
        yOnLine = (((oY-currentY)/(oX-referenceX))*(depthX-referenceX)) + currentY;

        return yOnLine;
    }
}
