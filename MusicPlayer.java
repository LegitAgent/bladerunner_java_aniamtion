/**
	MusicPlayer is where music gets played by calling the javax.sound.sampled.*; classes. 
    Will get called and instantiated in SceneFrame 
	
	@author Joaquin Alonzo A. Salazar (237547), Martin Darius L. Alba (230179)
	@version February 28, 2024
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
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
    //Plays music given a filepath within the folder
    /** 
     * @param filepath a String of the filepath of the music.
    */
    public void playMusic(String filepath)
    {
        //Checks for errors
        try 
        {
            //Creates an object File with the argument of the filepath.
            File musicPath = new File(filepath);
            //Checks if the filepath exists with the given string.
            if(musicPath.exists())
            {
                //SOURCE FROM Max O'Didily(https://www.youtube.com/watch?v=TErboGLHZGA&t=653s)
                //Makes a new AudioInputStream object and passes on the musicPath to be turned into an audio input stream.
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                //Makes a new clip object that opens the audi input stream and loops it continously.
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                
            }
            //Checks if the file does not exist.
            else
            {
                System.out.println("error");
            }
        }
        //Catches any errors and prints its stack trace.
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
