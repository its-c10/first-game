package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class Player extends MoveableGameObject{

    public Player(Vector vec, Location location, int height, int width) {
        super(ObjectID.PLAYER, vec, location, height, width);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
}
