package net.dohaw.firstgame.utils;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.handlers.PhysicsHandler;

import java.awt.geom.Rectangle2D;

public abstract class Collidable extends GameObject {

    protected PhysicsHandler physicsHandler;
    @Getter @Setter protected int collision_coord_additive;

    @Getter @Setter protected boolean inSkeletonMode;
    @Getter protected Rectangle2D collisionRect;

    public Collidable(ObjectID objectId, Vector vec, Location location, int width, int height) {
        super(objectId, vec, location, width, height);
        this.collisionRect = new Rectangle2D.Double(location.getX() - collision_coord_additive, location.getY() - collision_coord_additive, width + (collision_coord_additive * 2), height + (collision_coord_additive * 2));
    }

}
