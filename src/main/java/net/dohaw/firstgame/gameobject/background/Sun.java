package net.dohaw.firstgame.gameobject.background;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;

import java.awt.*;

public class Sun extends ImmovableGameObject {

    public Sun(Location location, ObjectID objectId, int xSize, int ySize) {
        super(location, objectId, xSize, ySize);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(location.getX(), location.getY(), width, height);
    }
}
