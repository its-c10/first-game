package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;

public class MenuObject extends ImmovableGameObject {

    public MenuObject(Game game, Location location, ObjectID objectId, int width, int height) {
        super(game, location, objectId, width, height);
    }

}
