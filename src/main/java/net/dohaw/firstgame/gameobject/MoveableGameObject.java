package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.handlers.PhysicsHandler;
import net.dohaw.firstgame.scenes.Scene;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MoveableGameObject extends Collidable {

    private PhysicsHandler physicsHandler;

    public MoveableGameObject(ObjectID objectId, Vector vec, Location location, int height, int width) {

        super(objectId, vec, location, height, width);
        this.collisionRect = new Rectangle2D.Double(location.getX(), location.getY(), width, height);
        this.previousLocation = location;

        int vecCurrentY = vec.getY();
        int newY = Math.max(1, vecCurrentY);
        vec.setY(newY);

    }

    public void initPhysics(Scene scene){
        this.physicsHandler = new PhysicsHandler(scene);
    }

    @Override
    public void tick() {

        this.previousLocation = location;

        location.applyVector(vector);
        this.collisionRect = new Rectangle2D.Double(location.getX(), location.getY(), width, height);

        if(physicsHandler.isInCollision(this)){

        }

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(location.getX(), location.getY(), width, height);
    }

}
