/**
	SceneFrame instantiates the JFrame of the project. It also contains a SceneCanvas where all drawings
    will be made. Also contains InputHandling class to allow for keyListening
	
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

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SceneFrame implements ActionListener
{
    private JFrame f;
    private InputHandling iH;

    SceneCanvas canvas;
    int pixelsWalked = 0, pixelsWalkedLeft = -147, pixelsWalkedRight = 147;
    int walkAnimRight = 0, walkAnimLeft = 0;
    int backPixelsWalkedLeft = 0, backPixelsWalkedRight = 0;
    int animationThreshold = 30;

    Hovercar car;
    Hovercar car2;
    Hovercar car3;
    Hovercar car4;

    RyanGosling rg;

    ArrayList<Tileset> tiles;
    ArrayList<BackgroundCity> backgroundCities;
   
    final int BG_MOVEMENT = 3;
    final int CAR_MOVEMENT = 4;
    final int BACK_BG_MOVEMENT = 1;

    /**
     Constructor method for SceneFrame. Initializes variables
     */
    public SceneFrame() 
    {
        f = new JFrame();
        canvas = new SceneCanvas(f);
        f.add(canvas, "Center");

        //Connect keyListener - from StackOverflow (Hovercraft Full Of Eels) and Stefan Kussmaul
        iH = new InputHandling();   

        f.setFocusable(true);
        f.requestFocus();
        f.requestFocusInWindow();
        f.addKeyListener(iH);

        //Music Player
        MusicPlayer music = new MusicPlayer();
        //HOME-Resonance(Slowed & Reverbed) https://www.youtube.com/watch?v=Ks17y5uTrbw
        music.playMusic("resonance.wav");

        //Tileset
        tiles = new ArrayList<>();
        tiles = canvas.getTileset();

        //Background Cities
        backgroundCities = new ArrayList<>();
        backgroundCities = canvas.getBackgroundCities();
        
        //Timer for canvas
        Timer timer = new Timer(10, this);
        timer.start();
    }

    /**
     Mutator method to set diff. properties of JFrame
     Add certain elements if necessary
     */
    public void setUpGUI()
    {
        //Information on pack from sidgate, Stack Overflow
        f.pack();
        f.setTitle("Midterm Project - Alba - Salazar");

        //close operations - DON'T CHANGE
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    /**
     * InputHandling is a class that allows for the user to move the scene left or right. Implements KeyListener class
     * to allow for use from arrowkeys
     */
    public class InputHandling implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e)
        {

        }

        /**
         * Will cause scene to move left or right depending on the Key Pressed among Left & Right arrowkeys
         * @param e KeyEvent detected when key is pressed
         */
        @Override
        public void keyPressed(KeyEvent e)
        {
            car = canvas.getHovercar();
            car2 = canvas.getHovercar2();
            car3 = canvas.getHovercar3();
            car4 = canvas.getHovercar4();

            rg = canvas.getRyanGosling();

            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                rg.changeState(2);
                rg.changeXCoordinate(422);
                car.move(CAR_MOVEMENT);
                car2.move(CAR_MOVEMENT);
                car3.move(CAR_MOVEMENT);
                car4.move(CAR_MOVEMENT);

                pixelsWalked -= BG_MOVEMENT;
                walkAnimLeft += BG_MOVEMENT;
                for(Tileset n : tiles)
                {
                    n.move(BG_MOVEMENT);
                }
                for(BackgroundCity bg : backgroundCities)
                {
                    bg.move(BACK_BG_MOVEMENT);
                }
                if(walkAnimLeft == animationThreshold)
                {
                    //edit frame to be walking left
                    rg.move(0);
                    walkAnimLeft = 0;
                }

            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                rg.changeState(1);
                rg.changeXCoordinate(378);
                car.move(-CAR_MOVEMENT);
                car2.move(-CAR_MOVEMENT);
                car3.move(-CAR_MOVEMENT);
                car4.move(-CAR_MOVEMENT);

                pixelsWalked += BG_MOVEMENT;
                walkAnimRight += BG_MOVEMENT;
                for(Tileset n : tiles)
                {
                    n.move(-BG_MOVEMENT);
                }

                for(BackgroundCity bg : backgroundCities)
                {
                    bg.move(-BACK_BG_MOVEMENT);
                }
                
                if(walkAnimRight == animationThreshold)
                {
                    rg.move(0);
                    walkAnimRight = 0;
                }
            }
        }

        /**
         * Will cause RyanGosling to go into Idle and sets his X coordinate when left & right are not being pressed
         * @param e KeyEvent detected when key is released
         */
        @Override
        public void keyReleased(KeyEvent e)
        {
            rg = canvas.getRyanGosling();
            rg.changeXCoordinate(378);
            rg.changeState(0);
        }
    }
    
    /**
     * Moves hovercars in scene
     * Also handles generating random tilesets
     * @param e Event occurring. Based on timer
     */
    public void actionPerformed(ActionEvent e)
    {

        car = canvas.getHovercar();
        car2 = canvas.getHovercar2();
        car3 = canvas.getHovercar3();
        car4 = canvas.getHovercar4();

        car.constantSpeed();
        car2.constantSpeed();
        car3.constantSpeed();
        car4.constantSpeed();

        if(pixelsWalked >= pixelsWalkedRight)
        {
            canvas.addToTileList(canvas.generateRandomTileset(0));
            pixelsWalkedRight += 531;
        }
        else if(pixelsWalked <= pixelsWalkedLeft)
        {
            canvas.addToTileList(canvas.generateRandomTileset(1));
            pixelsWalkedLeft -= 531;
        }

        if(pixelsWalked <= backPixelsWalkedLeft)
        {
            canvas.generateBackgroundCity(1);
            backPixelsWalkedLeft -= 2400;
        }
        else if(pixelsWalked >= backPixelsWalkedRight)
        {
            canvas.generateBackgroundCity(0);
            backPixelsWalkedRight += 2400;
        }
        canvas.repaint();
        
    };

}
