package net.dohaw.firstgame.scenes

import net.dohaw.firstgame.ObjectID
import net.dohaw.firstgame.gameobject.ImmovableGameObject
import net.dohaw.firstgame.utils.Alignment
import net.dohaw.firstgame.utils.Location

class TestingGroundsTest extends GroovyTestCase {
    void testInit() {
        ImmovableGameObject ground = new ImmovableGameObject(new Location(0, 400), ObjectID.BACKGROUND, 300, 20);
        ground.setInSkeletonMode(true);
        ground.align(Alignment.BOTTOM);
        ground.align(Alignment.HORIZONTAL_CENTER);
    }
}
