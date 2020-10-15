package net.dohaw.firstgame;

import net.dohaw.firstgame.gameobject.background.ImmovableGameObject;
import net.dohaw.firstgame.gameobject.background.MoveMe;
import net.dohaw.firstgame.handlers.ObjectHandler;
import net.dohaw.firstgame.startingMenu.StartingMenu;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    /*
        The entire game will be ran on one thread. Usually not recommended.
     */
    private Thread thread;
    private boolean running = false;
    private ObjectHandler objectHandler;
    private StartingMenu startingMenu;

    public Game(){

        objectHandler = new ObjectHandler();
        new Window(this, WIDTH, HEIGHT, "My First Game Ever");

        objectHandler.addObject(new ImmovableGameObject(new Location(0, 0), ObjectID.BACKGROUND, WIDTH, HEIGHT));
        objectHandler.addObject(new ImmovableGameObject(new Location(10, 10), ObjectID.BACKGROUND, 10, 10));
        //objectHandler.addObject(new MoveMe(ObjectID.BACKGROUND, new Vector(1, 1), new Location(10, 10), 10, 10));

    }

    public static void main(String args[]){
        new Game();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
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
        int frames = 0;

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
                System.out.println("FPS: " + frames);
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

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        objectHandler.render(g);

        g.dispose();
        bs.show();

    }

    public ObjectHandler getObjectHandler(){
        return objectHandler;
    }

}
