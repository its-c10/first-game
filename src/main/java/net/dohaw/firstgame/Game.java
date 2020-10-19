package net.dohaw.firstgame;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.gameobject.FPSCounter;
import net.dohaw.firstgame.handlers.GameObjectHandler;
import net.dohaw.firstgame.handlers.PhysicsHandler;
import net.dohaw.firstgame.scenes.PreStartingMenu;
import net.dohaw.firstgame.scenes.Scene;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    @Getter private FPSCounter fpsCounter;
    @Getter private int frames;
    @Getter public Graphics2D g;

    /*
        The entire game will be ran on one thread. Usually not recommended.
     */
    private Thread thread;
    private boolean running = false;
    @Getter private GameObjectHandler objectHandler;

    @Getter @Setter private Scene currentScene;

    public Game(){

        objectHandler = new GameObjectHandler(this);
        new Window(this, WIDTH, HEIGHT, "My First Game Ever");

        this.currentScene = new PreStartingMenu(this);
        currentScene.init();

        this.fpsCounter = new FPSCounter(this);
        objectHandler.addObject(fpsCounter);


    }

    public static void main(String args[]){
        new Game();
    }

    /*
    private void doStuff(){

        String[] arr = {"hello", "hell", "heaven", "goodbye"};
        String currentPrefix;
        String output = "";
        int index = 1;
        for(String word : arr){
            String[] wordSplit = word.split("");
            output += word.split("")[0];
            for(String wordChecking : arr){
                currentPrefix = getPrefix(wordSplit, index);
                if(wordChecking.contains(currentPrefix)){

                }
            }
        }

    }

    private String getPrefix(String[] arr, int currentIndex){
        String prefix = "";
        for(int x = 0; x < currentIndex; x++){
            prefix += arr[x];
        }
        return prefix;
    }

    private boolean */

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double amountOfticks = 60.0;
        double ns = 1000000000 / amountOfticks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        frames = 0;

        while(running){

            long now = System.nanoTime();
            //change
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running){
                render();
            }

            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                /*
                    Sometimes fpsCounter wouldn't be initialized yet (rarely). I assume this is because sometimes this code gets ran before the initialization of it.
                 */
                if(fpsCounter != null){
                    fpsCounter.setText("FPS: " + frames);
                }
                frames = 0;
            }

        }
        stop();

    }

    private void tick(){
        objectHandler.tick();
    }

    private void render(){

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            // How many buffers to create. 3 is recommended
            this.createBufferStrategy(3);
            return;
        }

        this.g = (Graphics2D) bs.getDrawGraphics();

        objectHandler.render(g);

        g.dispose();
        bs.show();

    }

}
