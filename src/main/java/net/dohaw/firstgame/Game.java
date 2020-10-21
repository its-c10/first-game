package net.dohaw.firstgame;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.gameobject.FPSCounter;
import net.dohaw.firstgame.handlers.GameObjectHandler;
import net.dohaw.firstgame.scenes.PreStartingMenu;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Tickable;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    @Getter private FPSCounter fpsCounter;
    @Getter private int frames;
    @Getter private Graphics g;
    @Getter Window window;

    private List<Tickable> tickables = new ArrayList<>();

    /*
        The entire game will be ran on one thread. Usually not recommended.
     */
    private Thread thread;
    private boolean running = false;
    @Getter private GameObjectHandler objectHandler;

    @Getter @Setter private Scene currentScene;
    @Setter @Getter private Camera sceneCamera = null;

    public Game(){
        this.window = new Window(this, WIDTH, HEIGHT, "My First Game Ever");
    }

    public static void main(String args[]){
        new Game();
    }

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

        objectHandler = new GameObjectHandler(this);
        tickables.add(objectHandler);

        this.currentScene = new PreStartingMenu(this);
        currentScene.init();

        this.fpsCounter = new FPSCounter(this);
        objectHandler.addObject(fpsCounter);

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
        for(Tickable tickable : tickables){
            tickable.tick();
        }
    }

    private void render(){

        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            // How many buffers to create. 3 is recommended
            this.createBufferStrategy(3);
            return;
        }

        this.g = bs.getDrawGraphics();

        Graphics2D g2g = (Graphics2D) g;
        clearCanvas();

        if(sceneCamera != null){
            g2g.translate(-sceneCamera.getX(), -sceneCamera.getY());
        }

        objectHandler.render(g);

        g.dispose();
        bs.show();

    }

    public void addTickable(Tickable tickable){
        tickables.add(tickable);
    }

    public void removeTickable(Tickable tickable){
        tickables.remove(tickable);
    }

    public void clearCanvas(){
        super.paint(g);
    }

}
