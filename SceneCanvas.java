/**
    SceneCanvas is a class where the DrawingObject interface is called, this is where most drawings get drawn.
    SceneCanvas also provides a size for the GUI, as well as the list of DrawingObjects to be drawn.
	
	@author Joaquin Alonzo A. Salazar (237547), Martin Darius L. Alba (230179)
	@version February 23, 2024
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
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class SceneCanvas extends JComponent
{
    //Perspective point
    public final int ORIGIN_X = 400;
    public final int ORIGIN_Y = 300;

    ArrayList<DrawingObject> drawing;

    Random rand;
    int y, x;

    Background bg;
    Platform platform;
    RyanGosling ryanGosling;
    Hovercar car, car2, car3, car4;

    Line origin;
    public final int COMLENGTH = 265;
    public final int RESLENGTH = 255;
    public final int ENTLENGTH = 235;

    //Temp
    ArrayList<Tileset> tiles;
    ArrayList<BackgroundCity> backgroundCities;

    /**
     * Constructor Initializes Variables
     * @param f JFrame to be passed onto this object
     */
    public SceneCanvas(JFrame f) 
    {
        f.setPreferredSize(new Dimension(800,600));
        drawing = new ArrayList<>();
        tiles = new ArrayList<>();
        backgroundCities = new ArrayList<>();

        bg = new Background(0, 0, new Color(14, 1, 20), new Color(139, 219, 225));
        backgroundCities.add(new BackgroundCity(0, 0));
        ryanGosling = new RyanGosling(ORIGIN_X - 22, 450, 50,0);

        origin = new Line(ORIGIN_X, 0, ORIGIN_X, 600, 2, Color.MAGENTA);

        car = generateRandomCar(0);
        car2 = generateRandomCar(0);
        car3 = generateRandomCar(1);
        car4 = generateRandomCar(1);
        
        platform = new Platform(0, 500, 800, 150);

        // makes a new shape class and adds it to the list.
        drawing.add(bg);
        
        rand = new Random();
        int state = rand.nextInt(3) + 1;
        tiles.add( new Tileset(0, 0, state, this) );
        state = rand.nextInt(3) + 1;
        tiles.add( new Tileset(780 - determineTileLength(state), 0, state, this) );
    }

    /**
     * Paints all objects
     * @param g Graphics component to be passed for objects to be drawn
     */
    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.setRenderingHints(rh);

        // loops through list of drawing objects.
        for(DrawingObject thing : drawing)
        {
            thing.draw(g2d);
        }

        for(BackgroundCity bg : backgroundCities)
        {
            bg.draw(g2d);
        }

        for(Tileset n : tiles)
        {
            n.draw(g2d);
        }
        
        car.draw(g2d);
        car2.draw(g2d);
        car3.inverseDraw(g2d);
        car4.inverseDraw(g2d);

        if(car.getXCoordinate() >= 850 + generateRandomDistance(0))
        {
            car = generateRandomCar(0);
        }
        else if(car2.getXCoordinate() >= 850 + generateRandomDistance(0))
        {
            car2 = generateRandomCar(0);
        }
        else if(car3.getXCoordinate() <= -50 + generateRandomDistance(1))
        {
            car3 = generateRandomCar(1);
        }
        else if(car4.getXCoordinate() <= -50 + generateRandomDistance(1))
        {
            car4 = generateRandomCar(1);
        }
        platform.draw(g2d); 
        ryanGosling.draw(g2d);
    }


    /**
     * Gets RyanGosling for use in SceneFrame
     * @return instance of RyanGosling
     */
    public RyanGosling getRyanGosling()
    {
        return ryanGosling;
    }

    /**
     * Gets Tilesets for use in SceneFrame
     * @return All instances of tilesets in the canvas
     */
    public ArrayList<Tileset> getTileset()
    {
        return tiles;
    }

    /**
     * Randomly generates a Tileset based on player location
     * @param posneg determines if Tileset is spawned on left or right. If 0, right. If anything else, left
     * @return Tileset to be spawned
     */
    public Tileset generateRandomTileset(int posneg)
    {
        rand = new Random();
        int state = rand.nextInt(3) + 1;
        if(posneg == 0)
        {
            Tileset tile = new Tileset(900, 0, state, this);
            return tile;
        }
        else
        {
            Tileset tile = new Tileset(-350, 0, state, this);
            return tile;
        }
    }

    /**
     * gets the length of Tilesets depending on its state
     * @param state state of Tileset
     * @return Length of Tileset
     */
    public int determineTileLength(int state)
    {
        switch(state)
        {
            case 1:
                y = COMLENGTH;
                break;
            case 2:
                y = RESLENGTH;
                break;
            case 3:
                y = ENTLENGTH;
                break;
        }
        return y;
    }

    /**
     * Adds a Tileset to the ArrayList of Tiles
     * @param tile Tileset to be added
     */
    public void addToTileList(Tileset tile)
    {
        tiles.add(tile);
    }

    //Cars

    /**
     * Gets 1st Hovercar for use in SceneFrame
     * @return Instance of 1st Hovercar in the canvas
     */
    public Hovercar getHovercar()
    {
        return car;
    }

    /**
     * Gets 2nd Hovercar for use in SceneFrame
     * @return Instance of 2nd Hovercar in the canvas
     */
    public Hovercar getHovercar2()
    {
        return car2;
    }

    /**
     * Gets 3rd Hovercar for use in SceneFrame
     * @return Instance of 3rd Hovercar in the canvas
     */
    public Hovercar getHovercar3()
    {
        return car3;
    }

    /**
     * Gets 4th Hovercar for use in SceneFrame
     * @return Instance of 4th Hovercar in the canvas
     */
    public Hovercar getHovercar4()
    {
        return car4;
    }

    /**
     * Creates a random HoverCar from a random direction
     * @param posneg determines whether to spawn hovercar on right (==0) or left (anything else)
     * @return randomly generated HoverCar
     */
    public Hovercar generateRandomCar(int posneg)
    {
        rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        int height = rand.nextInt(300) + 100;
        int size = rand.nextInt(20)+10;
        int xCarVelocity = rand.nextInt(10) + 3;
        if(posneg == 0)
        {
            Hovercar car = new Hovercar(-80, height, size, xCarVelocity, new Color(r,g,b), Color.BLACK, Color.WHITE);
            return car;
        }
        else
        {
            Hovercar car = new Hovercar(880, height, size, -xCarVelocity, new Color(r,g,b), Color.BLACK, Color.WHITE);
            return car;

        }
    }

    /**
     * Generates a random distance for the hovercars when spawned
     * @param posneg determines whether to spawn at left or right
     * @return distance of hovercar
     */
    public int generateRandomDistance(int posneg)
    {
        rand = new Random();
        if(posneg == 0)
        {
            int distance = rand.nextInt(500) + 850;
            return distance;
        }
        else
        {
            int distance = -50 - rand.nextInt(500);
            return distance;
        }
    }

    /**
     * Gets BackgroundCity objects to be used in SceneFrame
     * @return ArrayList of BackgroundCity. All instances of BackgroundCity
     */
    public ArrayList<BackgroundCity> getBackgroundCities()
    {
        return backgroundCities;
    }

    /**
     * Generates a BackgroundCity for infinite effect
     * @param posneg determines if BackgroundCity is spawned on left or right
     */
    public void generateBackgroundCity(int posneg)
    {
        if(posneg == 0)
        {
            backgroundCities.add(new BackgroundCity(800, 0));
        }
        else
        {
            backgroundCities.add(new BackgroundCity(-800, 0));
        }
    }
}