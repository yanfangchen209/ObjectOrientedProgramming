import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Program header: ScoreCounter.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The ScoreCounter class creates the image for score counter, having the calculating score effector and getter for score 
 * and also show score method.
 */

public class ScoreCounter extends Actor
{
    public static final float FONT_SIZE = 18f;
    public static final int WIDTH = 110;
    public static final int HEIGHT = 50;
    private int score = 0;
    
    public void addScore(int points){
        
        Window window = (Window)getWorld();
        score = score + points;
        showScore();
        if (score < 0) 
            {
                window.gameOver();
            }
    }
    
    public void showScore(){
        Window window = (Window)getWorld();
        makeScoreCounterImage("flies ate: ","score: ",window.getFliesAte(), score);
    }
    
    public int getScore(){
        return score;
    }

    private void makeScoreCounterImage(String firstLine, String secondLine,int fliesAte, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        image.setColor(new Color(0,0,0, 255));  
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 0)); 
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.BLACK);
        image.drawString(firstLine + fliesAte, 10, 20);
        image.drawString(secondLine + score, 10, 40);
        setImage(image);
    }
 
}