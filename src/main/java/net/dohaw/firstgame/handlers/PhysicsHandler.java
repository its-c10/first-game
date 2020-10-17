package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class PhysicsHandler {

    private GameObjectHandler handler;
    private Game game;

    public PhysicsHandler(Scene scene){
        this.handler = scene.getHandler();
        this.game = scene.getGame();
    }

    public boolean isInCollision(MoveableGameObject moveableGameObject){
        List<Collidable> collidableItemsInScene = handler.getCollidables();
        for(Collidable obj : collidableItemsInScene){
            Rectangle2D collisionRect = obj.getCollisionRect();
            if(collisionRect.intersects(moveableGameObject.getCollisionRect())){
                return true;
            }
        }
        return false;
    }


}
