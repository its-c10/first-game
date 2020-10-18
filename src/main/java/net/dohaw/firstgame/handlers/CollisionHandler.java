package net.dohaw.firstgame.handlers;

import javafx.geometry.Side;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.gameobject.Player;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.GameRectangle2D;
import net.dohaw.firstgame.utils.Vector;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class CollisionHandler {

    private GameObjectHandler handler;
    private Game game;

    public enum CollisionFrom{
        FROM_LEFT,
        FROM_RIGHT,
        FROM_TOP,
        FROM_BOTTOM,
    }

    public CollisionHandler(Scene scene){
        this.handler = scene.getHandler();
        this.game = scene.getGame();
    }

    public boolean isInCollision(MoveableGameObject moveableGameObject){

        List<Collidable> collidableItemsInScene = handler.getCollidables();
        // Removes the object so that it doesn't compare itself
        collidableItemsInScene.removeIf(obj -> obj.getOBJ_UUID() == moveableGameObject.getOBJ_UUID());

        for(Collidable obj : collidableItemsInScene){

            Rectangle2D collisionRect = obj.getCollisionRect();
            Rectangle2D moveableObjectCollisionRect = moveableGameObject.getCollisionRect();

            boolean isCurrentlyColliding = collisionRect.intersects(moveableObjectCollisionRect) && obj.isVisible();

            if(isCurrentlyColliding){
                moveableGameObject.setColliding(true);
                moveableGameObject.setOnGround(isOnGround(collisionRect, moveableObjectCollisionRect));
                return true;
            }

        }

        if(moveableGameObject instanceof Player){
            moveableGameObject.setColliding(false);
        }

        return false;
    }
    public boolean isOnGround(Rectangle2D collisionRect, Rectangle2D moveableObjectRect){
        Line2D line = GameRectangle2D.getSide(moveableObjectRect, Side.BOTTOM);
        return line.intersects(collisionRect);
    }

    /*
    public boolean doRectanglesOverlap(Rectangle2D moveableObjectRect, Rectangle2D collisionRect){
        return
    }*/


}
