package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.Vector;

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
        collidableItemsInScene.removeIf(obj -> obj.getOBJ_UUID() == moveableGameObject.getOBJ_UUID());

        for(Collidable obj : collidableItemsInScene){
            Rectangle2D collisionRect = obj.getCollisionRect();
            Rectangle2D moveableObjectCollisionRect = moveableGameObject.getCollisionRect();
            if(collisionRect.contains(moveableObjectCollisionRect) && obj.isVisible()){
                return true;
            }
        }
        return false;
    }


}
