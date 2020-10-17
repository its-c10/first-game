package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Colorable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class BackgroundGameObject extends GameObject {

    public BackgroundGameObject(ObjectID objectId, Vector vec, Location location, int width, int height) {
        super(objectId, vec, location, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        if(this instanceof Colorable){
            Colorable colorable = (Colorable) this;
            g.setColor(colorable.getColor());
        }else{
            g.setColor(Color.GREEN);
        }

        g.fillRect(location.getX(), location.getY(), width, height);
    }

}
