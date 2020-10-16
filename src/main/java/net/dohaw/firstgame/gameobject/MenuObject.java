package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.sprites.Sprite;
import net.dohaw.firstgame.utils.Location;

import java.awt.image.BufferedImage;

public class MenuObject extends ImmovableGameObject {

    public MenuObject(Location location, ObjectID objectId, int width, int height) {
        super(location, objectId, width, height);
    }

}
