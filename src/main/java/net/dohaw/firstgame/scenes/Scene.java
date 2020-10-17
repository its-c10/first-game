package net.dohaw.firstgame.scenes;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.handlers.GameObjectHandler;
import net.dohaw.firstgame.gameobject.GameObjectHolder;
import net.dohaw.firstgame.utils.Collidable;

import java.awt.event.MouseListener;

public abstract class Scene extends GameObjectHolder implements MouseListener {

    @Getter protected Game game;
    @Getter protected GameObjectHandler handler;

    public Scene(Game game){
        this.game = game;
        this.handler = game.getObjectHandler();
        game.addMouseListener(this);
    }

    public abstract void init();

    /*
        Makes it to where it switches to the next scene in the game
     */
    public void goToNextScene(Scene newScene){
        handler.removeObjectsFromScene();
        newScene.init();
    }

    private void skeletonMode(boolean enabled){
        if(enabled){
            for(Collidable collidable : handler.getCollidables()){

            }
        }
    }

}
