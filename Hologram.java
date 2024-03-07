/**
	This class will draw the Holograms projected in each building. Each hologram is 
    to be attached to a Building in the Tileset class. Composite shape made up of Rectangle, Rectangle2D and Triangle
	
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Hologram implements DrawingObject
{
    //All variables to be used in this class that are declared in the constructor
    private int x, y, originX, originY;
    private int width, height, hologramState;

    //Alpha argument in color from javadocs
    private final int alpha = 100;

    //Colors to be used in the holograms
    private Color main, light;
    
    //Objects to be used to make a projection screen for the holograms.
    private Triangle projector;
    private Rectangle base;

    /**
     * Constructor initializes variables
     * @param x x coordinate of origin. Top left of shape
     * @param y y coordinate of origin. Top left of shape
     * @param originX x coordinate of the projector stream origin
     * @param originY y coordinate of the projector stream origin
     * @param hologramState determines which hologram gets drawn
    */
    public Hologram(int x, int y, int originX, int originY, int hologramState)
    {
        this.x = x;
        this.y = y;
        this.originX = originX;
        this.originY = originY;
        this.hologramState = hologramState;
    }

    /**
     * Draws hologram depending on state of obj
     * @param g2d Graphics2D component passed for object to be painted
     */
    @Override
    public void draw(Graphics2D g2d)
    {
        //Sets the default stroke to 2 pixels wide for the holograms frame.
        g2d.setStroke(new BasicStroke(2));

        //Goes through a switch case statement to see which hologram to draw.
        switch(hologramState)
        {
            case 1:
                drawHolo1(g2d);
                break;
            case 2:
                drawHolo2(g2d);
                break;
            case 3:
                drawHolo3(g2d);
                break;
            case 4:
                drawHolo4(g2d);
                break;
            case 5:
                drawHolo5(g2d);
                break;
        }

        //Draws the base or canvas for the holograms as well as its borders.
        base.draw(g2d);
        drawBorder(g2d, x, y, width, height, light);
    }

    /**Moves the hologram by an amount in the x axis.
     * @param x amount to be moved
    */
    @Override
    public void move(int x)
    {
        this.x += x;
    }
    
    /** Draws hologram that is used for entertainment bldg 3
     *  @param g2d Graphics2D component passed for object to be painted
     */
    private void drawHolo1(Graphics2D g2d)
    {
        width = 70;
        height = 180;

        main = new Color(9, 99, 1, alpha);
        light = new Color(15, 196, 0);

        projector = new Triangle(originX, originY, x, y+height, x+width, y+height, main); //project from bottom
        projector.draw(g2d);

        base = new Rectangle(x, y, width, height, main);

        //Draws a smiley face to the hologram.  
        Circle smileFace = new Circle(x + 60, y + 100, 50, new Color(255,255,0));
        smileFace.draw(g2d);
        smileFace.drawOutline(g2d, Color.BLACK);

        Rectangle eye1 = new Rectangle(x + 20, y + 65, 10, 5, new Color(0, 0, 0));
        Rectangle eye2 = new Rectangle(x + 40, y + 65, 10, 5, new Color(0, 0, 0));
        eye1.draw(g2d);
        eye2.draw(g2d);

        Rectangle mouth = new Rectangle(x + 20, y + 80, 30, 5, new Color(0, 0, 0));
        mouth.draw(g2d);
    }

    /** Draws hologram that is used for entertainment bldg 2
     *  @param g2d Graphics2D component passed for object to be painted
     */
    private void drawHolo2(Graphics2D g2d) 
    {
        width = 130;
        height = 170;

        main = new Color(76, 1, 99, alpha);
        light = new Color(151, 2, 196);

        projector = new Triangle(originX, originY, x, y+height, x+width, y+height, main); //project from bottom
        projector.draw(g2d);

        base = new Rectangle(x, y, width, height, main);

        Rectangle robotFace = new Rectangle(x + 20, y + 60, 90, 70, Color.GRAY);
        robotFace.draw(g2d);

        Rectangle rod1 = new Rectangle(x + 37, y + 40, 10, 20, Color.LIGHT_GRAY);
        Rectangle rod2 = new Rectangle(x + 82, y + 40, 10, 20, Color.LIGHT_GRAY);
        rod1.draw(g2d);
        rod2.draw(g2d);

        Circle rod1Circle = new Circle(x + 52, y + 45, 20, Color.RED);
        Circle rod2Circle = new Circle(x + 97, y + 45, 20, Color.RED);
        rod1Circle.draw(g2d);
        rod2Circle.draw(g2d);

        Circle eye1 = new Circle(x + 55, y + 100, 30, Color.WHITE);
        Circle eye2 = new Circle(x + 103, y + 100, 30, Color.WHITE);
        eye1.draw(g2d);
        eye2.draw(g2d);

        eye1.drawOutline(g2d, Color.BLACK);
        eye2.drawOutline(g2d, Color.BLACK);

        Rectangle mouth = new Rectangle(x + 35, y + 110, 58, 20, Color.WHITE);
        mouth.draw(g2d);
        mouth.drawOutline(g2d, Color.BLACK);

        Line mouthLine1 = new Line(x + 49, y + 130, x + 49, y + 110, 3, Color.BLACK);
        Line mouthLine2 = new Line(x + 63, y + 130, x + 63, y + 110, 3, Color.BLACK);
        Line mouthLine3 = new Line(x + 77, y + 130, x + 77, y + 110, 3, Color.BLACK);
        mouthLine1.draw(g2d);
        mouthLine2.draw(g2d);
        mouthLine3.draw(g2d);

        Rectangle ear1 = new Rectangle(x + 10, y + 70, 10, 40, Color.RED);
        Rectangle ear2 = new Rectangle(x + 110, y + 70, 10, 40, Color.RED);
        ear1.draw(g2d);
        ear2.draw(g2d);
    }

    /** Draws hologram that is used for residential bldg 2
     *  @param g2d Graphics2D component passed for object to be painted
     */
    private void drawHolo3(Graphics2D g2d)
    {
        width = 140;
        height = 200;

        main = new Color(173, 84, 0, alpha);
        light = new Color(240, 118, 2);

        projector = new Triangle(originX, originY, x, y+height, x+width, y+height, main); //project from bottom
        projector.draw(g2d);

        base = new Rectangle(x, y, width, height, main);

        Ellipse2D.Double letterO = new Ellipse2D.Double(x + 20, y + 10, 50, 100);
        g2d.setStroke(new BasicStroke(6));
        g2d.setColor(Color.BLACK);
        g2d.draw(letterO);

        Line letterK = new Line(x + 80, y + 70, x + 80, y + 190, 6, light);
        letterK.draw(g2d);
        Line letterKUP = new Line(x + 80, y + 130, x + 120, y + 70, 6, light);
        letterKUP.draw(g2d);
        Line letterKDown = new Line(x + 80, y + 130, x + 120, y + 190, 6, light);
        letterKDown.draw(g2d);
    }

    /** Draws hologram that is used for commercial bldg 4
     *  @param g2d Graphics2D component passed for object to be painted
     */
    private void drawHolo4(Graphics2D g2d) 
    {
        width = 75;
        height = 90;

        main = new Color(1, 111, 133, alpha);
        light = new Color(2, 186, 222);

        projector = new Triangle(originX, originY, x, y, x, y+height, main); //project from left side
        projector.draw(g2d);

        base = new Rectangle(x,y, width, height, main);

        Rectangle rod = new Rectangle(x + 20, y + 45, 30, 10, Color.LIGHT_GRAY);
        rod.draw(g2d);
        Rectangle weightRight = new Rectangle(x + 10, y + 30, 15, 40, Color.BLACK);
        weightRight.draw(g2d);
        Rectangle weightLeft = new Rectangle(x + 50, y + 30, 15, 40, Color.BLACK);
        weightLeft.draw(g2d);
        }

    /** Draws hologram that is used for commercial bldg 4
     *  @param g2d Graphics2D component passed for object to be painted
     */
    private void drawHolo5(Graphics2D g2d)
    {
        width = 50;
        height = 230;

        main = new Color(1, 111, 133, alpha);
        light = new Color(2, 186, 222);

        projector = new Triangle(originX, originY, x+width, y, x+width, y+height, main); //project from right side
        projector.draw(g2d);

        base = new Rectangle(x,y, width, height, main);

        Circle letterO = new Circle(x + 43, y + 50, 35, Color.BLUE);
        letterO.drawOutline(g2d, Color.BLUE);

        Line letterPLine = new Line(x + 15, y + 60, x + 15, y + 110, 3, Color.RED);
        letterPLine.draw(g2d);
        Path2D.Double letterPCurve = new Path2D.Double();
        letterPCurve.moveTo(x + 15, y + 60);
        letterPCurve.curveTo(x + 45, y + 70, x + 45, y + 80, x + 15, y + 95);
        letterPCurve.closePath();
        g2d.draw(letterPCurve);

        Line letterEBaseLine = new Line(x + 15, y + 120, x + 15, y + 160, 3, Color.BLUE);
        letterEBaseLine.draw(g2d);
        Line letterELine1 = new Line(x + 15, y + 120, x + 35, y + 120, 3, Color.BLUE);
        letterELine1.draw(g2d);
        Line letterELine2 = new Line(x + 15, y + 140, x + 35, y + 140, 3, Color.BLUE);
        letterELine2.draw(g2d);
        Line letterELine3 = new Line(x + 15, y + 160, x + 35, y + 160, 3, Color.BLUE);
        letterELine3.draw(g2d);

        Line letterNBaseLine = new Line(x + 15, y + 180, x + 15, y + 220, 3, Color.RED);
        letterNBaseLine.draw(g2d);
        Line letterNDiagonalLine = new Line(x + 15, y + 180, x + 35, y + 220, 3, Color.RED);
        letterNDiagonalLine.draw(g2d);
        Line letterNEndLine = new Line(x + 35, y + 180, x + 35, y + 220, 3, Color.RED);
        letterNEndLine.draw(g2d);
    }

    /**Draws the border lights for the holograms
     * @param g Graphics2D component passed for object to be painted
     * @param x x origin point for shape. Top left
     * @param y y origin point for shape. Top left
     * @param h height of outline
    */
    private void drawBorder(Graphics2D g, int x, int y, int w, int h, Color color)
    {
        Rectangle2D.Double border = new Rectangle2D.Double(x, y, w, h);
        
        g.setStroke(new BasicStroke(3));
        g.setColor(color);
        g.draw(border);

        Rectangle2D.Double light = new Rectangle2D.Double(x,y,w,h);
        g.setStroke(new BasicStroke(1));
        g.setColor(new Color(255, 255, 255, 200));
        g.draw(light);
    }
}
