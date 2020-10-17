package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class PhysicsHandler {

    private Scene scene;
    private GameObjectHandler handler;
    private Game game;

    public PhysicsHandler(Scene scene){
        this.scene = scene;
        this.handler = scene.getHandler();
        this.game = scene.getGame();
    }

    public boolean isInCollision(MoveableGameObject moveableGameObject){
        List<Collidable> collidableItemsInScene = new ArrayList<>();
        for(Collidable obj : collidableItemsInScene){
            Rectangle2D collisionRect = obj.
        }
    }


}
