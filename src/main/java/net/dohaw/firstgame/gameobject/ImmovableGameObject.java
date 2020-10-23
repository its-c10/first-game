package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.Colorable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Rotatable;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ImmovableGameObject extends Collidable implements Rotatable {

    private double rotation = 0;

    public ImmovableGameObject(Game game, Location location, ObjectID objectId, int width, int height) {
        super(game, objectId, null, location, width, height);
        this.collisionCoordAdditive = 10;
    }

    /*
        Ticking this just in case this gets moved somehow or after alignment of the object
     */
    @Override
    public void tick() {
        this.collisionRect = new Rectangle2D.Double(location.getX() - collisionCoordAdditive, location.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2));
    }

    @Override
    public void render(Graphics g) {

        Color color = Color.GRAY;

        if(this instanceof Colorable){
            color = ((Colorable)this).getColor();
        }

        if(inSkeletonMode){
            g.setColor(Color.WHITE);
            g.drawRect(location.getX() - collisionCoordAdditive, location.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2));
        }

        g.setColor(color);
        g.fillRect(location.getX(), location.getY(), width, height);

    }

    @Override
    public double getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
