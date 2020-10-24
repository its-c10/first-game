package net.dohaw.firstgame.gameobject.sprites;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.ImmovableGameObject;
import net.dohaw.firstgame.utils.Location;

public class ImmovableSprite extends ImmovableGameObject {

    public ImmovableSprite(Game game, Location location, ObjectID objectId, int width, int height) {
        super(game, location, objectId, width, height);
    }

}
