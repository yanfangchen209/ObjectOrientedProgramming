import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Program header: ScoreBoard.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The ScoreBoard class create the image for score board when game is over.
 */

public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 40f;
    public static final int WIDTH = 475;
    public static final int HEIGHT = 260;
    
    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int fliesAte, int score)
    { 
        String s = (score > 20) ? "You Win!" : "You Lose!";
        makeScoreBoard("Game Over ! " + s,"Flies ate: ","Score: ",fliesAte, score);
    }

    /**
     * Make the score board image.
     */
    private void makeScoreBoard(String firstLine, String secondLine, String thirdLine, int fliesAte, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(Color.YELLOW); 
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.BLACK);
        image.drawString(firstLine, 30, 70);
        image.drawString(secondLine + fliesAte, 30, 150);
        image.drawString(thirdLine + score, 30, 230);
        setImage(image);
    }
}