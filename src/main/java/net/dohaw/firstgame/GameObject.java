package net.dohaw.firstgame;

import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public abstract class GameObject {

    protected ObjectID objectId;
    protected Vector vector;
    protected Location location;

    public GameObject(ObjectID objectId, Vector vec, Location location){
        this.objectId = objectId;
        this.vector = vec;
        this.location = location;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
