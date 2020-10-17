package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;

public class TestObject extends ImmovableGameObject{

    public TestObject(Location location, ObjectID objectId, int width, int height) {
        super(location, objectId, width, height);
    }

}
