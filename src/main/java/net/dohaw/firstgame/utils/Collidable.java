package net.dohaw.firstgame.utils;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.handlers.PhysicsHandler;
import net.dohaw.firstgame.scenes.Scene;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Collidable extends GameObject {

    protected PhysicsHandler physicsHandler;

    @Getter @Setter protected boolean isColliding;
    @Getter @Setter public boolean isOnGround;
    @Getter @Setter public int collisionCoordAdditive;

    @Getter @Setter protected boolean inSkeletonMode;
    @Getter @Setter protected Rectangle2D collisionRect;

    public Collidable(Game game, ObjectID objectId, Vector vec, Location location, int width, int height) {
        super(game, objectId, vec, location, width, height);
        this.collisionRect = new Rectangle2D.Double(location.getX() - collisionCoordAdditive, location.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2));
    }

    public void initPhysics(Scene scene){
        this.physicsHandler = new PhysicsHandler(scene);
    }

    public void drawSkeleton(Graphics g){
        g.setColor(Color.WHITE);
        Rectangle2D collisionRect = getCollisionRect();
        g.drawRect((int)collisionRect.getX(), (int)collisionRect.getY(), (int)collisionRect.getWidth(), (int)collisionRect.getHeight());
    }

}
