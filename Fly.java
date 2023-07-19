import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Program header: Fly.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The Fly class set the flies movement.
 * 
 */
public class Fly extends Actor
{
    
    public void act() 
    {
       randomMoves();
       
    } 
    //Generates random movement for flies.
    public void randomMoves(){

        move(Greenfoot.getRandomNumber(3) + 1);
        turn(Greenfoot.getRandomNumber(5)-1); 
        if(Greenfoot.getRandomNumber(100) < 1){
            setRotation(Greenfoot.getRandomNumber(360));
        }
        if(isAtEdge()){
            Window window = (Window)getWorld();
            turnTowards(350,300);
        }
    }
     
}
