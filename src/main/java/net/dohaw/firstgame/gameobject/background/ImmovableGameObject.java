package net.dohaw.firstgame.gameobject.background;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.ObjectID;

import java.awt.*;


public class ImmovableGameObject extends GameObject {

    public ImmovableGameObject(Location location, ObjectID objectId, int width, int height) {
        super(objectId, null, location, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(location.getX(), location.getY(), width, height);
    }
}
