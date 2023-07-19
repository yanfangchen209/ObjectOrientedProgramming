import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**Program header: Window.java
 * 
 * Author: Adam Nixon & Yanfang Chen
 * Class: CS-2163-EC02S JAVA Final Project
 * 
 * Brief Program Description:
 * The Window is where the actors live in.
 * In this game, the spider eats flies when touching them, and the wasps sting spider when touching it, which
 * will decrease the spider's health.
 */

public class Window extends World
{

    private int startFlies = 5;
    private int startWasps = 2;
    private int fliesAte;
    private GreenfootSound gameMusic = new GreenfootSound("game-music.mp3");
    private GreenfootSound gameOverSound = new GreenfootSound("Game-OverSoundeffect.mp3");
    private GreenfootSound waspBuzzSound = new GreenfootSound("Wasp-Buzzing.mp3");
    private ScoreCounter scoreCounter;
    private Spider spider;
    private SpiderHealthBar healthBar;
    
    /**
     * Constructor to create objects in the world Window.
     */
    public Window()
    {    
        //Create a new world with 700x600 cells with a cell size of 1x1 pixels.
        super(700, 600, 1);
        addFlies(startFlies);
        spider = new Spider();
        addObject(spider,350,300);
        addWasps(startWasps);
        healthBar = new SpiderHealthBar();
        addObject(healthBar,637, 18);
        healthBar.showHealthBar();
        Timer timer = new Timer();
        addObject(timer,50,581);
        timer.showTime();
        scoreCounter = new ScoreCounter();
        addObject(scoreCounter, 56, 28);
        scoreCounter.showScore();
    }
    
    public void started(){
        gameMusic.play();
        waspBuzzSound.play();
    }
    
    public void stopped(){
        gameMusic.stop();
        waspBuzzSound.stop();
    }
    
    public void addFlies(int flies){
        for(int i =0; i < flies; i++){
            addObject(new Fly(), Greenfoot.getRandomNumber(400) + 200,Greenfoot.getRandomNumber(400) + 100);
        } 
    }
    
    public void addMoreFlies(){
        List<Fly> fly = getObjects(Fly.class);
        if(fly.size()<=2){
            refreshFlies();
        }
    }
    
    public void refreshFlies(){
            startFlies +=2;
            addFlies(startFlies);
    }
    
    public void addWasps(int wasp){
        for(int i =0; i < wasp; i++){
            addObject(new Wasp(), Greenfoot.getRandomNumber(getWidth()),Greenfoot.getRandomNumber(getHeight()));
        } 
    }
    
    public ScoreCounter getScoreCounter(){
        return scoreCounter;
    }
    
    public void addOneMoreSpiderSting(){
        spider.addOneSting();
    }
    
    public int getFliesAte(){
        return fliesAte;
    }
    
    public void setFliesAte(int fliesAte){
        this.fliesAte = fliesAte;
    }
    
    public int getSpiderHealth(){
        return spider.getSpiderHealth();
    }

    public void gameOver(){
        gameOverSound.play();
        addObject(new ScoreBoard(fliesAte, scoreCounter.getScore()), getWidth()/2, getHeight()/2);
        healthBar.showHealthBar();
        Greenfoot.stop();
    }
    
}

