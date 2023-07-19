import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Program header: Wasp.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The Wasp class set the wasps' movement, and has the effector of stingSpider() which decrease the score by 3 when 
 * the wasp touches the spider, remove the wasp and add a new one to make sure there are always two wasps in the world.
 * 
 */

public class Wasp extends Actor
{
    
    public void act() 
    {
        move(2);
        if(isAtEdge()){
            turn(180);
        }
        if(Greenfoot.getRandomNumber(100) < 1){
            setRotation(Greenfoot.getRandomNumber(360));
        }
        stingSpider();
    } 
    
    public void stingSpider() 
    {
       if(isTouching(Spider.class)){
            Window window = (Window)getWorld();
            window.addOneMoreSpiderSting();
            window.getScoreCounter().addScore(-3);
            window.removeObject(this);
            window.addWasps(1);
       }
    }  
}


