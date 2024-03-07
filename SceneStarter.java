/**
	SceneStarter is the main method. It calls upon SceneFrame 
    to open a JFrame where the animations and graphics will be displayed.
	
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

public class SceneStarter
{
    private static SceneFrame sf;

	/**
	 * Main method
	 */
    public static void main(String[] args) 
    {
        sf = new SceneFrame();
        sf.setUpGUI();
    }
}