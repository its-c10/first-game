package net.dohaw.firstgame.handlers;

import javafx.geometry.Side;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.GameRectangle2D;
import sun.security.x509.CRLDistributionPointsExtension;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class PhysicsHandler {

    private GameObjectHandler handler;
    private final int GROUND_CHECK_BUFFER = 2;

    public PhysicsHandler(Scene scene){
        this.handler = scene.getHandler();
    }

    public boolean isInCollision(MoveableGameObject tempMovableObject, MoveableGameObject actualObject){

        List<Collidable> collidableItemsInScene = handler.getCollidables();
        // Removes the object so that it doesn't compare itself
        collidableItemsInScene.removeIf(obj -> obj.getOBJ_UUID() == tempMovableObject.getOBJ_UUID());

        Rectangle2D moveableObjectCollisionRect = tempMovableObject.getCollisionRect();
        boolean isOnGround = isOnGround(collidableItemsInScene, moveableObjectCollisionRect);
        actualObject.setOnGround(isOnGround);

        for(Collidable obj : collidableItemsInScene){

            Rectangle2D collisionRect = obj.getCollisionRect();
            boolean isCurrentlyColliding = collisionRect.intersects(moveableObjectCollisionRect) && obj.isVisible();

            if(isCurrentlyColliding){
                actualObject.setColliding(true);
                return true;
            }

        }

        actualObject.setColliding(false);

        return false;
    }

    public boolean isOnGround(List<Collidable> collidables, Rectangle2D moveableObjectRect){

        // + 2 to look 2 pixels under the object
        double maxY = moveableObjectRect.getMaxY() + GROUND_CHECK_BUFFER;

        Point2D point1 = new Point2D.Double(moveableObjectRect.getMinX(), maxY);
        Point2D point2 = new Point2D.Double(moveableObjectRect.getMaxX(), maxY);

        for(Collidable collidable : collidables){
            Rectangle2D rectCollidable = collidable.getCollisionRect();
            if(rectCollidable.contains(point1) || rectCollidable.contains(point2)){
                return true;
            }
        }
        return false;

    }

}
