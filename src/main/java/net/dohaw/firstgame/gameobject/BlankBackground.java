package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Colorable;
import net.dohaw.firstgame.utils.Location;

import java.awt.*;

public class BlankBackground extends ImmovableGameObject implements Colorable {

    private Color color;

    public BlankBackground(Color color, Location location, ObjectID objectId, int width, int height) {
        super(location, objectId, width, height);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
