import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Program header: Spider.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The Spider class set the spider's movement, getter for spider health and eating fly effector.
 * 
 */

public class Spider extends Actor
{
    private static final int INITIAL_HEALTH = 100;
    private int spiderHealth = INITIAL_HEALTH;
    public static final int DAMAGE_EACH_STING_BY_WASP= 20; 
    private int timesStingByWasp; 

    public void act() 
    {
       
        if(isAtEdge()){
            turn(180);
        }
        keyMove();
        eatFly();
        checkHealth();
        
    } 
    
    public void eatFly(){
       if(isTouching(Fly.class)){
           Window window = (Window)getWorld();
           int fliesate = window.getFliesAte();
           fliesate++;
           window.setFliesAte(fliesate);
           window.getScoreCounter().addScore(2); 
           removeTouching(Fly.class);  
           window.addMoreFlies();
        }
    }

    
    public int getSpiderHealth(){
        return spiderHealth;
    }
     
    public void keyMove(){
        
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+1,getY());
            setRotation(0);
             
        }
        else if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-1,getY());
            setRotation(180);
            
        }
        else if(Greenfoot.isKeyDown("up")){
            setLocation(getX(),getY()-1);
            setRotation(270);
            
        }
        else if(Greenfoot.isKeyDown("down")){
            setLocation(getX(),getY()+1);
            setRotation(90);
           
        } 
        else{
             move(1);
             
        }

    }

    public void addOneSting(){
        timesStingByWasp++;
        calculateHealth();
    }
    
    private void calculateHealth(){
        spiderHealth = INITIAL_HEALTH - timesStingByWasp * DAMAGE_EACH_STING_BY_WASP;
    }
    public void checkHealth() 
    {
        calculateHealth();
        if (spiderHealth <= 0) 
        {   Window window = (Window)getWorld();
            window.removeObject(this); 
            window.gameOver();
        }
    }
    
}
