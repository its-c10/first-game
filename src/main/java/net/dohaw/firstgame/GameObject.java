package net.dohaw.firstgame;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.utils.Alignment;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;
import java.util.UUID;

public abstract class GameObject {

    @Getter @Setter protected ObjectID objectId;
    @Getter @Setter protected Vector vector;
    @Getter @Setter protected Location location;
    @Getter @Setter protected int width;
    @Getter @Setter protected int height;
    @Getter final protected UUID OBJ_UUID;
    @Getter @Setter protected Alignment alignment;

    public GameObject(ObjectID objectId, Vector vec, Location location, int width, int height){
        this.objectId = objectId;
        this.vector = vec;
        this.location = location;
        this.width = width;
        this.height = height;
        this.OBJ_UUID = UUID.randomUUID();
    }

    public GameObject(ObjectID objectId, Vector vec, Location location, Alignment alignment, int width, int height){
        this.objectId = objectId;
        this.vector = vec;
        this.location = location;
        this.width = width;
        this.height = height;
        this.OBJ_UUID = UUID.randomUUID();
        this.alignment = alignment;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    @Override
    public String toString(){
        return "GAME OBJECT | ID: " + objectId.toString();
    }

    public boolean equals(Object other){
        if(other instanceof GameObject){
            return ((GameObject)other).getOBJ_UUID() == OBJ_UUID;
        }
        return false;
    }

    /*
        Where the Y would be if the object were centered vertically
     */
    public int getCenterY(){
        return (Game.HEIGHT / 2) - height;
    }

    /*
        Where the X would be if the object were centered horizontally
     */
    public int getCenterX(){
        System.out.println("" + ((Game.WIDTH / 2) - (width / 2)) );
        return (Game.WIDTH / 2) - (width / 2);
    }

}
