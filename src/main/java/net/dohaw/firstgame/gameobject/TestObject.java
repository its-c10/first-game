package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;

public class TestObject extends ImmovableGameObject{

    public TestObject(Game game, Location location, ObjectID objectId, int width, int height) {
        super(game, location, objectId, width, height);
    }

}
