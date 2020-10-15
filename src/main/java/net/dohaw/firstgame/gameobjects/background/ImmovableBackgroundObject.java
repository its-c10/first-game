package net.dohaw.firstgame.gameobjects.background;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.ObjectID;

import java.awt.*;

public class ImmovableBackgroundObject extends GameObject {

    public ImmovableBackgroundObject(Location location, ObjectID objectId) {
        super(objectId, null, location);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
