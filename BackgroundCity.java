/**
	This class will draw the background city in the canvas. Will be used as a parallax to create infinite effect
	
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
import java.awt.geom.Path2D;

public class BackgroundCity implements DrawingObject
{
    //x, y coordinates of the background itself.
    private int x, y;
    //Constant variables
    public static final int TALL = 500;
    public static final Color BUILDING_COLOR = Color.BLACK;
    public static final Color BLUE_OUTLINE = new Color(85, 78, 243);
    public static final Color PURPLE_OUTLINE = new Color(170, 57, 208);
    //Used for the translucent effect.
    private float alpha = (float) 0.3;

    /**Declares the arguments x and y as the variables of the class.
     * @param x x coord to set as starting point of draw. Top left of obj
     * @param y y coord to set as starting point of draw. Top left of obj
    */
    public BackgroundCity(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**Draws all the buildings that are used in the background city.
     * @param g2d Graphics2D component passed for shapes to be painted
    */
    @Override
    public void draw(Graphics2D g2d)
    {   
        Rectangle backBuilding1 = new Rectangle(x + 130, y + 150, 80, TALL, BUILDING_COLOR);

        Rectangle b1 = new Rectangle(x, y + 100, 70, TALL, BUILDING_COLOR);

        Rectangle b2 = new Rectangle(x + 50, y + 80, 80, TALL, BUILDING_COLOR);

        Rectangle b3 = new Rectangle(x + 100, y + 120, 65, TALL, BUILDING_COLOR);

        Rectangle b4 = new Rectangle(x + 20, y + 200, 120, TALL, BUILDING_COLOR);

        Rectangle b5 = new Rectangle(x + 180, y + 130, 60, TALL, BUILDING_COLOR);

        Rectangle b6 = new Rectangle(x + 205, y + 85, 75, TALL, BUILDING_COLOR);

        Rectangle b7 = new Rectangle(x + 270, y + 150, 65, TALL, BUILDING_COLOR);

        Rectangle b8 = new Rectangle(x + 195, y + 180, 90, TALL, BUILDING_COLOR);

        Path2D.Double b9 = new Path2D.Double();
        b9.moveTo(x + 310, y + 80);
        b9.lineTo(x + 360, y + 80);
        b9.lineTo(x + 370, y + 95);
        b9.lineTo(x + 370, y + 170);
        b9.lineTo(x + 360, y + 190);
        b9.lineTo(x + 360, y + TALL);
        b9.lineTo(x + 310, y + TALL);
        b9.closePath();

        Path2D.Double b10 = new Path2D.Double();
        b10.moveTo(x + 350, y + 130);
        b10.lineTo(x + 400, y + 130);
        b10.lineTo(x + 400, y + 100);
        b10.lineTo(x + 445, y + 100);
        b10.lineTo(x + 445, y + TALL);
        b10.lineTo(x + 350, y + TALL);
        b10.closePath();

        Path2D.Double b11 = new Path2D.Double();
        b11.moveTo(x + 455, y + 30);
        b11.lineTo(x + 530 , y + 30);
        b11.lineTo(x + 530, y + TALL);
        b11.lineTo(x + 415, y + TALL);
        b11.lineTo(x + 415, y + 190);
        b11.lineTo(x + 455, y + 140);
        b11.closePath();

        Rectangle b12 = new Rectangle(x + 390, y + 180, 110, TALL, BUILDING_COLOR);

        Quadrilateral b13 = new Quadrilateral(x + 560, y + 75, x + 560, y + TALL, x + 390, y + TALL, x + 540, y + 90, BUILDING_COLOR);

        Rectangle b14 = new Rectangle(x + 550, y + 120,  60, TALL, BUILDING_COLOR);

        Rectangle b15 = new Rectangle(x + 577, y + 70, 15, TALL, BUILDING_COLOR);

        Quadrilateral b16 = new Quadrilateral(x + 610, y + 75, x + 610, y + TALL, x + 790, y + TALL, x + 630, y + 90, BUILDING_COLOR);

        Rectangle b17 = new Rectangle(x + 630, y + 50, 50, TALL, BUILDING_COLOR);

        Rectangle b18 = new Rectangle(x + 670, y + 65, 55, TALL, BUILDING_COLOR);

        Rectangle b19 = new Rectangle(x + 705, y + 40, 105, TALL, BUILDING_COLOR);

        //Background stuff
        Quadrilateral roofDoor = new Quadrilateral(x + 15, y + 100, x + 15, y + 80, x + 35, y + 80, x + 45, y + 100, BUILDING_COLOR);
        roofDoor.draw(g2d);

        Rectangle chimney = new Rectangle(x + 70, y + 60, 10, 20, BUILDING_COLOR);
        Rectangle chimney2 = new Rectangle(x + 85, y + 50, 10, 30, BUILDING_COLOR);
        chimney.draw(g2d);
        chimney2.draw(g2d);

        Rectangle fan = new Rectangle(x + 140, y + 113, 20, 7, BUILDING_COLOR);
        fan.draw(g2d);

        Rectangle signalTower = new Rectangle(x + 182, y + 100, 4, 30, BUILDING_COLOR);
        signalTower.draw(g2d);
        Rectangle fan2 = new Rectangle(x + 188, y + 120, 14, 10, BUILDING_COLOR);
        fan2.draw(g2d);
        
        Rectangle fan3 = new Rectangle(x + 210, y + 70, 30, 15, BUILDING_COLOR);
        fan3.draw(g2d);
        Rectangle signalTowerBottom = new Rectangle(x + 250, y + 50, 7, 35, BUILDING_COLOR);
        signalTowerBottom.draw(g2d);
        Rectangle signalTowerTop = new Rectangle(x + 252, y + 30, 3, 20, BUILDING_COLOR);
        signalTowerTop.draw(g2d);

        Rectangle signalTower2 = new Rectangle(x + 285, y + 125, 5, 25, BUILDING_COLOR);
        signalTower2.draw(g2d);
        Rectangle signalTowerBottom2 = new Rectangle(x + 295, y + 115, 9, 35, BUILDING_COLOR);
        signalTowerBottom2.draw(g2d);
        Rectangle signalTowerTop2 = new Rectangle(x + 298, y + 95, 4, 20, BUILDING_COLOR);
        signalTowerTop2.draw(g2d);

        Path2D.Double ladder = new Path2D.Double();
        ladder.moveTo(x + 430, y + 100);
        ladder.lineTo(x + 415, y + 95);
        ladder.lineTo(x + 430, y + 90);
        ladder.lineTo(x + 415, y + 85);
        ladder.lineTo(x + 430, y + 80);
        ladder.lineTo(x + 415, y + 75);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(ladder);
        Rectangle ladderHold1 = new Rectangle(x + 412, y + 70, 3, 30, BUILDING_COLOR);
        Rectangle ladderHold2 = new Rectangle(x + 430, y + 70, 3, 30, BUILDING_COLOR);
        ladderHold1.draw(g2d);
        ladderHold2.draw(g2d);
        
        //Behind behind
        b15.draw(g2d);
        b15.drawOutline(g2d, BLUE_OUTLINE);

        backBuilding1.draw(g2d) ;
        backBuilding1.drawOutline(g2d, PURPLE_OUTLINE);

        g2d.setColor(BUILDING_COLOR);
        g2d.fill(b10);
        g2d.setColor(BLUE_OUTLINE);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(b10);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(new Color(1,1,1, alpha));
        g2d.draw(b10);

        b14.draw(g2d);
        b14.drawOutline(g2d, PURPLE_OUTLINE);
        b17.draw(g2d);
        b17.drawOutline(g2d, PURPLE_OUTLINE);
        b19.draw(g2d);
        b19.drawOutline(g2d, PURPLE_OUTLINE);

        //Behind front
        b2.draw(g2d);
        b2.drawOutline(g2d, PURPLE_OUTLINE);
        b6.draw(g2d);
        b6.drawOutline(g2d, PURPLE_OUTLINE);

        g2d.setColor(BUILDING_COLOR);
        g2d.fill(b9);
        g2d.setColor(PURPLE_OUTLINE);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(b9);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(new Color(1,1,1, alpha));
        g2d.draw(b9);

        b13.draw(g2d);
        b13.drawOutline(g2d, BLUE_OUTLINE);
        b16.draw(g2d);
        b16.drawOutline(g2d, BLUE_OUTLINE);
        b18.draw(g2d);
        b18.drawOutline(g2d, BLUE_OUTLINE);

        //Front behind
        b1.draw(g2d);
        b1.drawOutline(g2d, BLUE_OUTLINE);
        b3.draw(g2d);
        b3.drawOutline(g2d, BLUE_OUTLINE);
        b5.draw(g2d);
        b5.drawOutline(g2d, BLUE_OUTLINE);
        b7.draw(g2d);
        b7.drawOutline(g2d, BLUE_OUTLINE);

        g2d.setColor(BUILDING_COLOR);
        g2d.fill(b11);
        g2d.setColor(PURPLE_OUTLINE);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(b11);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(new Color(1,1,1, alpha));
        g2d.draw(b11);

        //Front front
        b4.draw(g2d);
        b4.drawOutline(g2d, PURPLE_OUTLINE);
        b8.draw(g2d);
        b8.drawOutline(g2d, PURPLE_OUTLINE);
        b12.draw(g2d);
        b12.drawOutline(g2d, BLUE_OUTLINE);

        Rectangle street = new Rectangle(x - 50, y+400, 900, 300, new Color(20,20,20));
        street.draw(g2d);
            
    }

    /** Moves the background city in the x axis by x amount.
     *  @param x amount to be moved along x axis
     */
    @Override
    public void move(int x) 
    {
        this.x += x;
    }
}