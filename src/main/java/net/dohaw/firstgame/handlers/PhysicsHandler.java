package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.gameobject.Player;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;

import java.awt.geom.Rectangle2D;
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

            boolean isColliding = collisionRect.intersects(moveableObjectCollisionRect) && obj.isVisible();

            if(moveableGameObject instanceof Player && isColliding){
                ((Player)moveableGameObject).setColliding(true);
            }

            if(isColliding){
                return true;
            }

        }

        if(moveableGameObject instanceof Player){
            ((Player)moveableGameObject).setColliding(false);
        }

        return false;
    }

    /*
    public boolean doRectanglesOverlap(Rectangle2D moveableObjectRect, Rectangle2D collisionRect){
        return
    }*/


}
