package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

public abstract class MoveableGameObject extends GameObject {

    public MoveableGameObject(ObjectID objectId, Vector vec, Location location, int height, int width) {
        super(objectId, vec, location, height, width);
    }

    public void vectorTick() {
        location.applyVector(vector);
    }

}
