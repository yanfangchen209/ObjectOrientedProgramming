import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Program header: Timer.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The Timer class creates the image for timer, having the time count down effector and show time method. 
 * and also show score method.
 */

public class Timer extends Actor
{
    public static final float FONT_SIZE = 18f;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 35;
    private int time = 3600;
    
    public void act(){

        countTime();

    }
    
    public void countTime(){
        Window window = (Window)getWorld();
        time--;
        showTime();
        if (time == 0){
            window.gameOver();
        }
    }
    
    public void showTime(){
        makeTimerImage("time: ", time);
    }

    private void makeTimerImage(String prefix,int time)
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
        image.drawString(prefix + time, 10, 25);
        setImage(image);
    }
 
}
