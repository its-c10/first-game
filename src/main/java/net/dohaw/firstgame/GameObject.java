package net.dohaw.firstgame;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public abstract class GameObject {

    @Getter @Setter protected ObjectID objectId;
    @Getter @Setter protected Vector vector;
    @Getter @Setter protected Location location;
    @Getter @Setter protected int width;
    @Getter @Setter protected int height;

    public GameObject(ObjectID objectId, Vector vec, Location location, int width, int height){
        this.objectId = objectId;
        this.vector = vec;
        this.location = location;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    @Override
    public String toString(){
        return "GAME OBJECT | ID: " + objectId.toString();
    }

}
