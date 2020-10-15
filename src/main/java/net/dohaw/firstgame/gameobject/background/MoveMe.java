package net.dohaw.firstgame.gameobject.background;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class MoveMe extends MoveableGameObject{

    public MoveMe(ObjectID objectId, Vector vec, Location location) {
        super(objectId, vec, location);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
