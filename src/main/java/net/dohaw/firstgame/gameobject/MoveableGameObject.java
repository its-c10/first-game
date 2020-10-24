package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.handlers.PhysicsHandler;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MoveableGameObject extends Collidable {

    public MoveableGameObject(Game game, ObjectID objectId, Vector vec, Location location, int height, int width) {

        super(game, objectId, vec, location, height, width);

        int vecCurrentY = vec.getY();
        int newY = Math.max(1, vecCurrentY);
        vec.setY(newY);

        this.collisionCoordAdditive = 5;

    }

    /*
        Temp
     */
    public MoveableGameObject(Game game, Location location){
        super(game, ObjectID.BACKGROUND, Vector.IMMOVABLE, location, 20 , 20);
        this.collisionCoordAdditive = 10;
    }



    @Override
    public void tick() {

        /*
            Gravity is turned off when on the ground
         */
        if(isOnGround){
            vector.setY(0);
        }else{

            /*
                In action of jumping
             */
            if(this instanceof Jumpable){

                Jumpable jumpable = (Jumpable) this;
                if(vector.getY() == jumpable.getJumpingAmount() && jumpable.isJumping()){
                    jumpable.jump();
                }else{
                    vector.setY(1);
                }

            }else{
                vector.setY(1);
            }

        }

        /*
            It checks to see if the next position that gravity is going to put it in is in collision. If so, then it doesn't put it in that position
         */
        Location toBeLocation = location.clone();
        toBeLocation.applyVector(vector);
        MoveableGameObject temp = new MoveableGameObject(game, toBeLocation);
        temp.setCollisionRect(new Rectangle2D.Double(toBeLocation.getX() - collisionCoordAdditive, toBeLocation.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2)));

        boolean isInCollision;
        if(physicsHandler != null){

            isInCollision = physicsHandler.isInCollision(temp, this);

            if(!isInCollision){
                location.applyVector(vector);
            }else if(!isOnGround){
                vector.setX(0);
                location.applyVector(vector);
            }

        }

        this.collisionRect = new Rectangle2D.Double(location.getX() - collisionCoordAdditive, location.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2));

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(location.getX(), location.getY(), width, height);

        if(inSkeletonMode){
            g.setColor(Color.WHITE);
            Rectangle2D collisionRect = getCollisionRect();
            g.drawRect((int)collisionRect.getX(), (int)collisionRect.getY(), (int)collisionRect.getWidth(), (int)collisionRect.getHeight());
        }

    }

}
