/**
	This class will hold presets for the tilesets on the SceneCanvas. 
    A Tileset includes multiples of Building, Window, Hologram objects
    There are 3 tilesets: Commercial, Residential, Entertainment
	
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

import java.awt.*;
import java.util.ArrayList;

public class Tileset implements DrawingObject
{
    //Constants for sectors
    public final int COMMERCIAL = 1;
    public final int RESIDENTIAL = 2;
    public final int ENTERTAINMENT = 3;

    private int state; //determines which tileset to use
    private SceneCanvas canvas;

    private int x, y;

    private ArrayList<DrawingObject> holder = new ArrayList<>();

    /**
     * Constructor will intialize values
     * @param x x coordinate of the tile set
     * @param y y coordinate of the tile set
     * @param s state for tileset to be set to
     * @param canvas the canvas that it will use to draw the tile sets
     */
    public Tileset(int x, int y, int s, SceneCanvas canvas)
    {
        state = s;
        this.canvas = canvas; 
        this.x = x;
        this.y = y;
    }

    /**Draws the tile sets
     * @param g2d Graphics2D component passed for object to be painted
     */
    public void draw(Graphics2D g2d)
    {
        //Make drawing based on state
        switch (state) 
        {
            case COMMERCIAL:
                drawCommercial(g2d);
                break;
            case RESIDENTIAL:
                drawResidential(g2d);
                break;
            case ENTERTAINMENT:
                drawEntertainment(g2d);
                break;
        }
    }

    /**Moves the tile set
     * @param x moves it on the x axis by this amount
     */
    public void move(int x)
    {
        this.x += x;
    }

    //Constant to set all buildings in the tileset to be at a certain amount tall.
    final int TALL = 500;

    /**
     * Draws Commercial Tileset
     * @param g Graphics2D component passed for object to be painted
     */
    private void drawCommercial(Graphics2D g)
    {
        Color front1 = new Color(70,0,41);
        Color front2 = new Color(90,6,55);
        Color front3 = new Color(123,9,77);

        Color light = new Color(158,215,39);

        Building bldg1 = new Building(x+30, 150, 100, TALL, 30, front1, light, canvas);
        Window b1w1 = new Window(x+45, y+165, 25);
        Window b1w2 = new Window(x+90, y+165, 25);
        Window b1w3 = new Window(x+45, y+200, 25);
        Window b1w4 = new Window(x+90, y+200, 25);
        Window b1w5 = new Window(x+45, y+235, 25);

        holder.add(bldg1);
        holder.add(b1w1);
        holder.add(b1w2);
        holder.add(b1w3);
        holder.add(b1w4);
        holder.add(b1w5);

        drawAllObjs(g);

        Building bldg2 = new Building(x+50, y+230, 150, TALL, 35, front2, light, canvas);
        Window b2w1 = new Window(x+65, y+240, 40);
        Window b2w2 = new Window(x+135, y+240, 40);
        Window b2w3 = new Window(x+65, y+380, 40);
        Window b2w4 = new Window(x+135, y+380, 40);
        
        holder.add(bldg2);
        holder.add(b2w1);
        holder.add(b2w2);
        holder.add(b2w3);
        holder.add(b2w4);

        drawAllObjs(g);

        Building bldg3 = new Building(x, y+260, 65, TALL, 20, front3, light, canvas);
        bldg3.draw(g);

        Hologram h1 = new Hologram(x-5, y+255, x+55, y+310, 5);
        h1.draw(g);

        Building bldg4 = new Building(x+170, y+240, 95, TALL, 20, front3, light,canvas);
        Window b4w1 = new Window(x+175, y+250, 25);
        Window b4w2 = new Window(x+205, y+250, 25);
        Window b4w3 = new Window(x+235, y+250, 25);
        Window b4w4 = new Window(x+175, y+400, 25);
        Window b4w5 = new Window(x+205, y+400, 25);
        Window b4w6 = new Window(x+235, y+400, 25);

        holder.add(bldg4);
        holder.add(b4w1);
        holder.add(b4w2);
        holder.add(b4w3);
        holder.add(b4w4);
        holder.add(b4w5);
        holder.add(b4w6);

        drawAllObjs(g);

        Hologram h2 = new Hologram(x+200, y+280, x+180, y+350, 4);
        h2.draw(g);
    }

    /**
     * Draws Residential Tileset
     * @param g Graphics2D component passed for object to be painted
     */
    private void drawResidential(Graphics2D g)
    {
        Color light = new Color(80,195,177);

        Color front1 = new Color(52,52,52);
        Color front2 = new Color(75,75,75);
        Color front3 = new Color(85,85,85);

        Building bldg1 = new Building(x+45, y+190, 90, TALL, 25, front1, light, canvas);
        Window b1w1 = new Window(x+55, y+200, 20);
        Window b1w2 = new Window(x+80, y+200, 20);
        Window b1w3 = new Window(x+105, y+200, 20);

        Window b1w4 = new Window(x+55, y+260, 20);
        Window b1w5 = new Window(x+80, y+260, 20);
        Window b1w6 = new Window(x+105, y+260, 20);

        holder.add(bldg1);
        holder.add(b1w1);
        holder.add(b1w2);
        holder.add(b1w3);

        holder.add(b1w4);
        holder.add(b1w5);
        holder.add(b1w6);

        drawAllObjs(g);

        Building bldg2 = new Building(x+85, y+250, 170, TALL, 30, front2, light, canvas);

        bldg2.draw(g);
        Hologram holo = new Hologram(x+100, y+265, x+200, y+500, 3);
        holo.draw(g);

        Building bldg3 = new Building(x, y+290, 150, TALL, 30, front3, light, canvas);
        Window b3w1 = new Window(x+15, y+300, 40);
        Window b3w2 = new Window(x+90, y+300, 40);

        Window b3w3 = new Window(x+15, y+370, 40);
        Window b3w4 = new Window(x+90, y+370, 40);

        Window b3w5 = new Window(x+15, y+440, 40);
        Window b3w6 = new Window(x+90, y+440, 40);

        holder.add(bldg3);
        holder.add(b3w1);
        holder.add(b3w2);
        holder.add(b3w3);
        holder.add(b3w4);
        holder.add(b3w5);
        holder.add(b3w6);

        drawAllObjs(g);
    }

    /**
     * Draws Entertainment Tileset
     * @param g Graphics2D component passed for object to be painted
     */
    private void drawEntertainment(Graphics2D g)
    {
        Color front1 = new Color(0,0,15);
        Color front2 = new Color(0,0,38);
        Color front3 = new Color(0, 0, 61);

        Color light = new Color(230, 39, 64);

        Building bldg1 = new Building(x+30, y+230, 100, TALL, 60, front1, light, canvas);
        Building bldg2 = new Building(x+70, y+260, 165, TALL, 60, front2, light, canvas);
        Building bldg3 = new Building(x, y+280, 100, TALL, 40, front3, light, canvas);
        bldg1.draw(g);


        bldg2.draw(g);
        Hologram h1 = new Hologram(x+85, y+280, x+190, y+500, 2);
        h1.draw(g);

        bldg3.draw(g);
        Hologram h2 = new Hologram(x+16, y+295, x+30, y+505, 1);
        h2.draw(g);
    }

    /**
     * Draws all objects included in the holder for the tileset
     * @param g2d Graphics2D component passed for object to be painted
     */
    private void drawAllObjs(Graphics2D g2d)
    {
        for(DrawingObject n : holder)
        {
            n.draw(g2d);
        }

        holder.clear();
    }
}
