package net.dohaw.firstgame.gameobject;

import lombok.Getter;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
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

    @Getter private Location previousLocation;

    public MoveableGameObject(ObjectID objectId, Vector vec, Location location, int height, int width) {

        super(objectId, vec, location, height, width);
        this.previousLocation = location;

        int vecCurrentY = vec.getY();
        int newY = Math.max(1, vecCurrentY);
        //vec.setY(newY);

        this.collision_coord_additive = 10;

    }

    public void initPhysics(Scene scene){
        this.physicsHandler = new PhysicsHandler(scene);
    }

    @Override
    public void tick() {

        /*
            Had to make the clone function in order to fix the cancellation of velocity
         */
        this.previousLocation = location.clone();

        location.applyVector(vector);
        this.collisionRect = new Rectangle2D.Double(location.getX() - collision_coord_additive, location.getY() - collision_coord_additive, width + (collision_coord_additive * 2), height + (collision_coord_additive * 2));

        /*
            If the object comes in contact with another object, the applied velocity is essentially canceled by setting the location of the object to it's previous location
         */
        if(physicsHandler.isInCollision(this)){
            location = previousLocation;
            //System.out.println("IN COLLISION");
        }

        /*
            Teleports you back to the center if you fall off
         */
        if(location.getY() > Game.HEIGHT){
            align(Alignment.CENTER);
        }

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillRect(location.getX(), location.getY(), width, height);

        if(inSkeletonMode){
            g.setColor(Color.WHITE);
            g.drawRect(location.getX() - collision_coord_additive, location.getY() - collision_coord_additive, width + (collision_coord_additive * 2), height + (collision_coord_additive * 2));
        }

    }

}
