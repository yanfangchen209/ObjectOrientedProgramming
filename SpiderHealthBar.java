import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Program header: SpiderHealthBar.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The SpiderHealthBar class make the image of health bar and has a show health bar effector.
 * 
 */

public class SpiderHealthBar extends Actor
{
    public static final float FONT_SIZE = 13.0f;
    public static final int WIDTH = 110;
    public static final int HEIGHT = 15;
    private int currentDisplayed; 
    
    public void act() {
       showHealthBar(); 
    }
    
    
    public void showHealthBar(){
        
        Window window = (Window)getWorld();
        int currentSpiderHealth = window.getSpiderHealth();
        if(currentSpiderHealth < 0){
            currentSpiderHealth = 0;
        }
        if(currentDisplayed != currentSpiderHealth){
            makeImage(currentSpiderHealth);
            currentDisplayed = currentSpiderHealth;
        }
        
    }

    private void makeImage(int spiderHealth)
    {
        GreenfootImage image = new GreenfootImage(WIDTH+50, HEIGHT);
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(Color.YELLOW); 
        double healthPercentage = (double)spiderHealth/100;
        image.fillRect(0, 0, (int)(healthPercentage * WIDTH), HEIGHT);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.BLACK);
        image.drawString("" + spiderHealth, WIDTH+10, 13);
        setImage(image);
    }
   
}
