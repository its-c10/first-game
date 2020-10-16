package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.runnable.BaseRunnable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class FPSCounter extends TextObject{

    private Game game;

    public FPSCounter(Game game) {
        super(ObjectID.BACKGROUND, new Vector(0, 0), new Location((int) (Game.WIDTH * .9), Game.HEIGHT),  new Font("Roboto", Font.BOLD, 20), "FPS: " + game.frames, Color.GRAY);
        this.game = game;
        init();
    }

    public void init(){

        BaseRunnable runnable = new BaseRunnable() {
            @Override
            public void run() {
                text = "FPS: " + game.frames;
                drawAccordingToAlignment(game.g);
                System.out.println("Testing");
            }
        };

        runnable.scheduleRepeatedTask(0, 1);

    }

    /*
        Don't want this to run since it updates way too many times a second
     */
    @Override
    public void render(Graphics g) { }

}
