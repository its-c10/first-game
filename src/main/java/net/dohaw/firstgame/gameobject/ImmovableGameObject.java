package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.utils.Colorable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.ObjectID;

import java.awt.*;

public abstract class ImmovableGameObject extends GameObject {

    public ImmovableGameObject(Location location, ObjectID objectId, int width, int height) {
        super(objectId, null, location, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        Color color = Color.BLACK;
        if(this instanceof Colorable){
            color = ((Colorable)this).getColor();
        }

        g.setColor(color);
        g.fillRect(location.getX(), location.getY(), width, height);
    }
}
