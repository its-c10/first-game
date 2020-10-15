package net.dohaw.firstgame.gameobject.background;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

public abstract class MoveableGameObject extends GameObject {

    public MoveableGameObject(ObjectID objectId, Vector vec, Location location) {
        super(objectId, vec, location);
    }

    public void vectorTick() {
        int velX = vector.getX();
        int velY = vector.getY();
    }

}
