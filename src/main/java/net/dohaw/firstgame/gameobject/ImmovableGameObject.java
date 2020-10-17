package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.Colorable;
import net.dohaw.firstgame.utils.Location;

import java.awt.*;

public abstract class ImmovableGameObject extends Collidable {

    public ImmovableGameObject(Location location, ObjectID objectId, int width, int height) {
        super(objectId, null, location, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        if(inSkeletonMode){
            g.setColor(Color.WHITE);
            g.drawRect(location.getX(), location.getY(), width, height);
        }else{

            Color color = Color.BLACK;
            if(this instanceof Colorable){
                color = ((Colorable)this).getColor();
            }

            g.setColor(color);
            g.fillRect(location.getX(), location.getY(), width, height);
        }

    }

}
