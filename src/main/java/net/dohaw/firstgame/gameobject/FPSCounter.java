package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class FPSCounter extends TextObject{

    private Game game;
    private final long NEXT_SHOWING = 1000;
    private long nextShowing;
    private boolean showing;

    public FPSCounter(Game game) {
        super(ObjectID.BACKGROUND, new Vector(0, 0), new Location((int) (Game.WIDTH * .9), 40),  new Font("Roboto", Font.BOLD, 10), "FPS: " + game.getFrames(), Color.GRAY);
        this.game = game;
        this.showing = true;
        this.nextShowing = System.currentTimeMillis() + NEXT_SHOWING;
    }

    /*
        Runs with an interval
     */
    @Override
    public void render(Graphics g) {
        long now = System.currentTimeMillis();
        if(now >= nextShowing){
            int fps = game.getFrames();
            text = "FPS: " + fps;
            setNextShowing();
        }
        drawAccordingToAlignment(g);
    }

    public void setNextShowing(){
        this.nextShowing = System.currentTimeMillis() + NEXT_SHOWING;
    }

}
