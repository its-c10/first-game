package net.dohaw.firstgame.menus;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.handlers.GameObjectHandler;
import net.dohaw.firstgame.gameobject.GameObjectHolder;

import java.awt.event.MouseListener;


public abstract class Scene extends GameObjectHolder implements MouseListener {

    protected Game game;
    protected GameObjectHandler handler;

    public Scene(Game game){
        this.game = game;
        this.handler = game.getObjectHandler();
        game.addMouseListener(this);
        init();
    }

    public abstract void init();

    /*
        Makes it to where it switches to the next scene in the game
     */
    public void goToNextScene(Scene newScene){
        handler.removeObjects(this);
        newScene.init();
        handler.addObjects(newScene);
    }

}
