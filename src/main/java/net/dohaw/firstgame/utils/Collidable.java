package net.dohaw.firstgame.utils;

import lombok.Getter;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Collidable extends GameObject {

    @Getter protected boolean inSkeletonMode;
    @Getter protected Rectangle2D collisionRect;
    @Getter protected Location previousLocation;

    public Collidable(ObjectID objectId, Vector vec, Location location, int width, int height) {
        super(objectId, vec, location, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
