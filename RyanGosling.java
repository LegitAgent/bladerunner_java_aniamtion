/**
	This class will draw the a character in the middle of the screen who will walk as the buildings move.
    Will shift through different walking states based on how many pixels are moved and direction arrowkey pressed
	
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
import java.awt.geom.*;

public class RyanGosling implements DrawingObject
{
    int x, y, height, walkState, state;
    Color hoodieColor, pantColor, armColor;

    /**
     * Constructor initializes variable
     * @param x x coord origin of RyanGosling. Top left
     * @param y y coord origin of RyanGosling. Top right
     * @param height height of RyanGosling
     * @param state state of RyanGosling object
     */
    public RyanGosling(int x, int y, int height, int state)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.state = state;

        walkState = 1;

        hoodieColor = new Color(30, 54, 17);
        pantColor = new Color(102, 77, 51);
        armColor = new Color(19, 38, 10);
    }

    /**
     * Draws RyanGosling based on his state
     * @param g2d Graphics2D component passed for object to be painted
     */
    @Override
    public void draw(Graphics2D g2d)
    {
        if(state == 0)
        {
            drawIdleRyanGosling(g2d);
        }
        else if(state == 1)
        {
            drawRightRyanGosling(g2d);
        }
        else
        {
            drawLeftRyanGosling(g2d);
        }
    }
    
    /**Moves RyanGosling by an amount in the x axis.
     * @param x amount to be moved
     */
    @Override
    public void move(int x)
    {
        this.x += x;
        nextCycle();
    }

    /**
     * Draws RyanGosling in Idle stance (No arrowkeys pressed)
     * @param g2d Graphics2D component passed for object to be painted
     */
    private void drawIdleRyanGosling(Graphics2D g2d)
    {
        AffineTransform reset = g2d.getTransform();

        //Head
        Path2D hood = new Path2D.Double();
        hood.moveTo(x+14,y+35.1);
        hood.curveTo(x+4.9, y+35.25, x+10.3, y+19.5, x+13.5, y+17);
        hood.curveTo(x+16.8,y+13.13,x+20.7,y+13.2,x+23.9,y+17.2);
        hood.curveTo(x+27.3,y+20.9,x+32.3,y+33.9,x+23.1,y+35.1);

        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(hoodieColor);
        g2d.fill(hood);

        

        //Arm L
        RoundRectangle2D armLUpper = new RoundRectangle2D.Double(x+3,y+37, 9, 20, 8, 4);
        g2d.setColor(armColor);

        g2d.rotate(Math.toRadians(45),x+8,y+39);

        g2d.fill(armLUpper);

        RoundRectangle2D armLLower = new RoundRectangle2D.Double(x+6,y+55,9,20,8,4);
        g2d.rotate(Math.toRadians(-100),x+8,y+59);
        g2d.fill(armLLower);

        g2d.setTransform(reset);

        //Arm R
        RoundRectangle2D armRUpper = new RoundRectangle2D.Double(x+27, y+36, 9,20, 8, 4);
        g2d.setColor(armColor);

        g2d.rotate(Math.toRadians(-45),x+34,y+38);

        g2d.fill(armRUpper);

        RoundRectangle2D armRLower = new RoundRectangle2D.Double(x+27,y+57,9,20,8,4);

        g2d.rotate(Math.toRadians(100),x+34,y+55);

        g2d.fill(armRLower);

        g2d.setTransform(reset);

        //Pelvis
        Trapezoid pelvis = new Trapezoid(x+9, y+62, 18, 22, 10, pantColor);
        pelvis.draw(g2d);

        //Body
        Path2D body = new Path2D.Double();
        body.moveTo(x+33.1, y+36);
        body.curveTo(x+25.2, y+32.5, x+14.1, y+32.9, x+5, y+36);
        body.curveTo(x+2.4, y+38.6, x+3.2, y+47.2, x+6.4, y+62.3);
        body.curveTo(x+10.1,y+60.9,x+17.3,y+66,x+29.4,y+62.3);
        body.curveTo(x+33.7,y+51.7,x+35.2,y+40.9,x+33.1,y+36);

        g2d.setColor(hoodieColor);
        g2d.fill(body);

        //Leg L
        RoundRectangle2D legL = new RoundRectangle2D.Double(x+8,y+65,10,40,8,4);
        g2d.setColor(pantColor);

        g2d.rotate(Math.toRadians(2),x+14,y+67);

        g2d.fill(legL);

        //Foot L
        RoundRectangle2D footL = new RoundRectangle2D.Double(x+7.7,y+103, 9, 8, 8, 2);
        g2d.setColor(Color.WHITE);
        g2d.fill(footL);

        g2d.setTransform(reset);

        //Leg R
        RoundRectangle2D legR = new RoundRectangle2D.Double(x+18,y+65,10,40,8,4);
        g2d.setColor(pantColor);

        g2d.rotate(Math.toRadians(-2),x+23,y+67);

        g2d.fill(legR);

        //Foot R
        RoundRectangle2D footR = new RoundRectangle2D.Double(x+18.7,y+103, 9, 8, 8, 2);
        g2d.setColor(Color.WHITE);
        g2d.fill(footR);

        g2d.setTransform(reset);

    }

    /**
     * Draws RyanGosling in Moving right (Right arrowkey pressed)
     * @param g2d Graphics2D component passed for object to be painted
     */
    private void drawRightRyanGosling(Graphics2D g2d)
    {
        AffineTransform reset = g2d.getTransform();
       
        //Head
        Ellipse2D.Double head = new Ellipse2D.Double(x+18,y+14, 16, 18);
        g2d.setColor(new Color(232, 172, 123));
        g2d.fill(head);
 
        //Hood
        Path2D hood = new Path2D.Double();
        hood.moveTo(x+31,y+35.1);
        hood.curveTo(x+18.9,y+28.7, x+25.7, y+13.7, x+33.4, y+17.7);
        hood.lineTo(x+33.6, y+13.1);
        hood.curveTo(x+29.1, y+8.6, x+15.1, y+10.3, x+15.2, y+17);
        hood.curveTo(x+17.5, y+20, x+17.4, y+27.3, x+15.6, y+31.2);
        hood.lineTo(x+31,y+35.1);
        hood.closePath();
 
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(hoodieColor);
        g2d.fill(hood);
 
        //Leg Handling
        walkCycle(g2d);
 
        //Pelvis
        Trapezoid pelvis = new Trapezoid(x+17, y+60, 10, 14, 10, new Color(102, 77, 51));
        pelvis.draw(g2d);
 
        //Body
        Path2D body = new Path2D.Double();
        body.moveTo(x+26.8,y+33.8);
        body.curveTo(x+11, y+25.8, x+11.8, y+42.4, x+16.6, y+58.3);
        body.curveTo(x+20, y+56.8, x+21.9, y+62.3, x+29.5, y+62.3);
        body.curveTo(x+29.4, y+50, x+35.6, y+49, x+30.2, y+36.1);
        body.closePath();
 
        g2d.setColor(hoodieColor);
        g2d.fill(body);
 
        //Arms
        //Round rectangle from (https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/awt/geom/RoundRectangle2D.Double.html#archeight)
        RoundRectangle2D armUpper = new RoundRectangle2D.Double(x+18, y+37, 8, 20, 8, 4);
        
        g2d.setColor(armColor);
        g2d.rotate(Math.toRadians(45), x+19, y+39);
        g2d.fill(armUpper);
         
        RoundRectangle2D armLower = new RoundRectangle2D.Double(x+18, y+52, 8, 20, 8, 4);
        g2d.setColor(armColor);
        g2d.rotate(Math.toRadians(-80), x+20, y+54.5);
        g2d.fill(armLower);
 
        g2d.setTransform(reset);
    }

    /**
     * Draws RyanGosling in Moving left (left arrowkey pressed)
     * @param g2d Graphics2D component passed for object to be painted
     */
    private void drawLeftRyanGosling(Graphics2D g2d)
    {
        AffineTransform reset = g2d.getTransform();
       
        //Head
        Ellipse2D.Double head = new Ellipse2D.Double(x-33,y+14, 16, 18);
        g2d.setColor(new Color(232, 172, 123));
        g2d.fill(head);
 
        //Hood
        Path2D hood = new Path2D.Double();
        hood.moveTo(x-31,y+35.1);
        hood.curveTo(x-18.9,y+28.7, x-25.7, y+13.7, x-33.4, y+17.7);
        hood.lineTo(x-33.6, y+13.1);
        hood.curveTo(x-29.1, y+8.6, x-15.1, y+10.3, x-15.2, y+17);
        hood.curveTo(x-17.5, y+20, x-17.4, y+27.3, x-15.6, y+31.2);
        hood.lineTo(x-31,y+35.1);
        hood.closePath();
 
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(hoodieColor);
        g2d.fill(hood);
 
        //Leg Handling
        walkCycle(g2d);
 
        //Pelvis
        Trapezoid pelvis = new Trapezoid(x-27, y+60, 10, 14, 10, new Color(102, 77, 51));
        pelvis.draw(g2d);
 
        //Body
        Path2D body = new Path2D.Double();
        body.moveTo(x-26.8,y+33.8);
        body.curveTo(x-11, y+25.8, x-11.8, y+42.4, x-16.6, y+58.3);
        body.curveTo(x-20, y+56.8, x-21.9, y+62.3, x-29.5, y+62.3);
        body.curveTo(x-29.4, y+50, x-35.6, y+49, x-30.2, y+36.1);
        body.closePath();
 
        g2d.setColor(hoodieColor);
        g2d.fill(body);
 
        //Arms
        //Round rectangle from (https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/awt/geom/RoundRectangle2D.Double.html#archeight)
        RoundRectangle2D armUpper = new RoundRectangle2D.Double(x-26, y+37, 8, 20, 8, 4);
        
        g2d.setColor(armColor);
        g2d.rotate(Math.toRadians(-45), x-19, y+39);
        g2d.fill(armUpper);
         
        RoundRectangle2D armLower = new RoundRectangle2D.Double(x-26, y+52, 8, 20, 8, 4);
        g2d.setColor(armColor);
        g2d.rotate(Math.toRadians(80), x-20, y+54.5);
        g2d.fill(armLower);
 
        g2d.setTransform(reset);
    }

    /**
     * Handles RyanGosling leg changes in its walk cycle
     * @param g2d Graphics2D component passed for object to be painted
     */
    private void walkCycle(Graphics2D g2d)
    {
        Color legColorF = new Color(102, 77, 51);
        Color footF = new Color(230,230,230);

        Color legColorH = new Color(69, 52, 35);
        Color footH = new Color(182,182,182);

        AffineTransform reset = g2d.getTransform();
        
        //===LEG PARTS===
            RoundRectangle2D legHindUp, legHindDown, footHind, legFrontUp, legFrontDown, footFront;
        if(state == 1)
        {
            if(walkState == 1)
            {
                //Hind Leg
                legHindUp = new RoundRectangle2D.Double(x+18,y+67,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindUp);
    
                g2d.rotate(Math.toRadians(45),x+20,y+85);
    
                legHindDown = new RoundRectangle2D.Double(x+18,y+85,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindDown);
    
                //Back Foot
                footHind = new RoundRectangle2D.Double(x+18,y+98,15,8,8,4);
                g2d.setColor(footH);
                g2d.fill(footHind);
    
                g2d.setTransform(reset);
    
                g2d.rotate(Math.toRadians(-15), x+18, y+65);
    
                //Front Leg
                legFrontUp = new RoundRectangle2D.Double(x+17.5,y+67,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontUp);
    
                legFrontDown = new RoundRectangle2D.Double(x+17.5,y+85,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontDown);
    
                //Front Foot
                footFront = new RoundRectangle2D.Double(x+17.5,y+100,15,8,8,4);
                g2d.setColor(footF);
                g2d.fill(footFront);
    
                g2d.setTransform(reset);
            }
            else
            {
                g2d.rotate(Math.toRadians(-15), x+18, y+65);
    
                //Hind Leg
                legHindUp = new RoundRectangle2D.Double(x+19,y+67,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindUp);
    
                legHindDown = new RoundRectangle2D.Double(x+19,y+85,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindDown);
    
                //Back Foot
                footHind = new RoundRectangle2D.Double(x+19,y+100,15,8,8,4);
                g2d.setColor(footH);
                g2d.fill(footHind);
    
                g2d.setTransform(reset);
    
                //Front Leg
                legFrontUp = new RoundRectangle2D.Double(x+17.5,y+67,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontUp);
    
                g2d.rotate(Math.toRadians(45),x+20,y+87);
    
                legFrontDown = new RoundRectangle2D.Double(x+17.5,y+85,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontDown);
    
                //Front Foot
                footFront = new RoundRectangle2D.Double(x+17.5,y+100,15,8,8,4);
                g2d.setColor(footF);
                g2d.fill(footFront);
    
                g2d.setTransform(reset);
            }
        }
        if(state == 2)
        {
            if(walkState == 1)
            {
                //Hind Leg
                legHindUp = new RoundRectangle2D.Double(x-28,y+67,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindUp);
    
                g2d.rotate(Math.toRadians(-45),x-20,y+85);
    
                legHindDown = new RoundRectangle2D.Double(x-28,y+85,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindDown);
    
                //Back Foot
                footHind = new RoundRectangle2D.Double(x-33,y+98,15,8,8,4);
                g2d.setColor(footH);
                g2d.fill(footHind);
    
                g2d.setTransform(reset);
    
                g2d.rotate(Math.toRadians(15), x-18, y+65);
    
                //Front Leg
                legFrontUp = new RoundRectangle2D.Double(x-27.5,y+67,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontUp);
    
                legFrontDown = new RoundRectangle2D.Double(x-27.5,y+85,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontDown);
    
                //Front Foot
                footFront = new RoundRectangle2D.Double(x-32.5,y+100,15,8,8,4);
                g2d.setColor(footF);
                g2d.fill(footFront);
    
                g2d.setTransform(reset);
            }
            else
            {
                g2d.rotate(Math.toRadians(15), x-18, y+65);
    
                //Hind Leg
                legHindUp = new RoundRectangle2D.Double(x-29,y+67,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindUp);
    
                legHindDown = new RoundRectangle2D.Double(x-29,y+85,10,20,8,4);
                g2d.setColor(legColorH);
                g2d.fill(legHindDown);
    
                //Back Foot
                footHind = new RoundRectangle2D.Double(x-34,y+100,15,8,8,4);
                g2d.setColor(footH);
                g2d.fill(footHind);
    
                g2d.setTransform(reset);
    
                //Front Leg
                legFrontUp = new RoundRectangle2D.Double(x-27.5,y+67,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontUp);
    
                g2d.rotate(Math.toRadians(-45),x-20,y+87);
    
                legFrontDown = new RoundRectangle2D.Double(x-27.5,y+85,10,20,8,4);
                g2d.setColor(legColorF);
                g2d.fill(legFrontDown);
    
                //Front Foot
                footFront = new RoundRectangle2D.Double(x-32.5,y+100,15,8,8,4);
                g2d.setColor(footF);
                g2d.fill(footFront);
    
                g2d.setTransform(reset);
            }
        }
    }

    /**
     * Changes RyanGosling walk to its next walk cycle frame
     */
    private void nextCycle()
    {
        if(walkState == 2)
        {
            walkState = 1;
        }
        else if (walkState==1)
        {
            walkState = 2;
        }
    }

    /**
     * Determines which state RyanGosling should be in (Left, Right, Idle)
     * @param state RyanGosling current state
     */
    public void changeState(int state)
    {
        this.state = state;
    }

    /**
     * Sets x to a specific amount instead of incrementing it
     * @param amount x coord to move to
     */
    public void changeXCoordinate(int amount)
    {
        x = amount;
    }
}
