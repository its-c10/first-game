package net.dohaw.firstgame.handlers;

import javafx.geometry.Side;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.GameRectangle2D;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class PhysicsHandler {

    private GameObjectHandler handler;

    public PhysicsHandler(Scene scene){
        this.handler = scene.getHandler();
    }

    public boolean isInCollision(MoveableGameObject tempMovableObject, MoveableGameObject actualObject){

        List<Collidable> collidableItemsInScene = handler.getCollidables();
        // Removes the object so that it doesn't compare itself
        collidableItemsInScene.removeIf(obj -> obj.getOBJ_UUID() == tempMovableObject.getOBJ_UUID());

        for(Collidable obj : collidableItemsInScene){

            Rectangle2D collisionRect = obj.getCollisionRect();
            Rectangle2D moveableObjectCollisionRect = tempMovableObject.getCollisionRect();

            boolean isCurrentlyColliding = collisionRect.intersects(moveableObjectCollisionRect) && obj.isVisible();

            if(isCurrentlyColliding){
                actualObject.setColliding(true);
                actualObject.setOnGround(isOnGround(collisionRect, moveableObjectCollisionRect));
                return true;
            }

        }

        actualObject.setColliding(false);
        //actualObject.setOnGround(false);

        return false;
    }

    public boolean isOnGround(Rectangle2D collisionRect, Rectangle2D moveableObjectRect){
        Line2D line = GameRectangle2D.getSide(moveableObjectRect, Side.BOTTOM);
        return line.intersects(collisionRect);
    }

}
