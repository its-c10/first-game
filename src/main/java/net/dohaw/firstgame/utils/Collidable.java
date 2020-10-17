package net.dohaw.firstgame.utils;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.handlers.PhysicsHandler;

import java.awt.geom.Rectangle2D;

public abstract class Collidable extends GameObject {

    protected PhysicsHandler physicsHandler;
    @Getter final protected int COLLISION_COORD_ADDITIVE = 10;

    @Getter @Setter protected boolean inSkeletonMode;
    @Getter protected Rectangle2D collisionRect;

    public Collidable(ObjectID objectId, Vector vec, Location location, int width, int height) {
        super(objectId, vec, location, width, height);
        this.collisionRect = new Rectangle2D.Double(location.getX() - COLLISION_COORD_ADDITIVE, location.getY() - COLLISION_COORD_ADDITIVE, width + (COLLISION_COORD_ADDITIVE * 2), height + (COLLISION_COORD_ADDITIVE * 2));
    }

}
