package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.Jumpable;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class PhysicsHandler {

    private Game game;
    private GameObjectHandler handler;
    private final int GROUND_CHECK_BUFFER = 2;

    public PhysicsHandler(Scene scene){
        this.handler = scene.getHandler();
        this.game = scene.getGame();
    }

    public boolean isInCollision(MoveableGameObject tempMovableObject, MoveableGameObject actualObject){

        List<Collidable> collidableItemsInScene = handler.getCollidables();
        // Removes the object so that it doesn't compare itself
        collidableItemsInScene.removeIf(obj -> obj.getOBJ_UUID() == tempMovableObject.getOBJ_UUID());

        Rectangle2D moveableObjectCollisionRect = tempMovableObject.getCollisionRect();
        boolean isOnGround = isOnGround(collidableItemsInScene, moveableObjectCollisionRect);

        if(actualObject instanceof Jumpable){

            Jumpable jumpable = (Jumpable) actualObject;
            boolean isJumping = jumpable.isJumping();

            /*
                Only set on ground to true when they aren't jumping (this could be while they're falling down) and are truly on the ground.
             */
            if(isOnGround && !isJumping){
                actualObject.setOnGround(true);
                ((Jumpable)actualObject).setIsJumping(false);
            }else{
                actualObject.setOnGround(false);
            }

        }else{
            actualObject.setOnGround(isOnGround);
        }

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

        //the bottom left and bottom right corners are always in collision, therfore will always return true when checking to see if hitbox is on the ground when hugging to the left or right of a wall.
        Point2D point1 = new Point2D.Double(moveableObjectRect.getMinX() + 4, maxY);
        Point2D point2 = new Point2D.Double(moveableObjectRect.getMaxX() - 4, maxY);

        for(Collidable collidable : collidables){
            Rectangle2D rectCollidable = collidable.getCollisionRect();
            if(rectCollidable.contains(point1) || rectCollidable.contains(point2)){
                return true;
            }
        }
        return false;

    }

    /*
        Applies
     */
    public void gravity(){
        for(GameObject obj : handler.getObjects()){
            if(obj instanceof MoveableGameObject){
            }
        }
    }

}
