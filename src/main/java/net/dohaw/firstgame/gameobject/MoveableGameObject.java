package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.handlers.PhysicsHandler;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Alignment;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MoveableGameObject extends Collidable {

    public MoveableGameObject(ObjectID objectId, Vector vec, Location location, int height, int width) {

        super(objectId, vec, location, height, width);

        int vecCurrentY = vec.getY();
        int newY = Math.max(1, vecCurrentY);
        vec.setY(newY);

        this.collisionCoordAdditive = 10;

    }

    /*
        Temp
     */
    public MoveableGameObject(Location location){
        super(ObjectID.BACKGROUND, Vector.IMMOVABLE, location, 20 , 20);
        this.collisionCoordAdditive = 10;
    }

    public void initPhysics(Scene scene){
        this.physicsHandler = new PhysicsHandler(scene);
    }

    @Override
    public void tick() {

        if(isOnGround){
            vector.setY(0);
        }

        /*
            Had to make the clone function in order to fix the cancellation of velocity
         */
        this.collisionRect = new Rectangle2D.Double(location.getX() - collisionCoordAdditive, location.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2));

        /*
            It checks to see if the next position that gravity is going to put it in is in collision. If so, then it doesn't put it in that position
         */
        Location toBeLocation = location.clone();
        toBeLocation.applyVector(vector);
        MoveableGameObject temp = new MoveableGameObject(toBeLocation);
        temp.setCollisionRect(new Rectangle2D.Double(toBeLocation.getX() - collisionCoordAdditive, toBeLocation.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2)));
        boolean isInCollision = physicsHandler.isInCollision(temp, this);

        if(!isInCollision){
            location.applyVector(vector);
        }

        /*
            Teleports you back to the center if you fall off
         */
        if(location.getY() > Game.HEIGHT){
            align(Alignment.CENTER);
        }

        /*
            Cases for players
         */

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(location.getX(), location.getY(), width, height);

        if(inSkeletonMode){
            g.setColor(Color.WHITE);
            g.drawRect(location.getX() - collisionCoordAdditive, location.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2));
        }

    }

}
