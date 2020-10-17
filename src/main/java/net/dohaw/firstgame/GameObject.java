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
    @Getter @Setter protected GameObject relative;
    @Getter @Setter protected boolean isVisible = true;

    public GameObject(ObjectID objectId, Vector vec, Location location, int width, int height){
        this.objectId = objectId;
        this.vector = vec;
        this.location = location;
        this.width = width;
        this.height = height;
        this.OBJ_UUID = UUID.randomUUID();
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
        For non-relative alignment
     */
    public void align(Alignment alignment){

        int centerX = getCenterX();
        int centerY = getCenterY();

        if(alignment == Alignment.HORIZONTAL_CENTER){
            location.setX(centerX);
        }else if(alignment == Alignment.CENTER){
            location.setX(centerX);
            location.setY(centerY);
        }else if(alignment == Alignment.VERTICAL_CENTER) {
            location.setY(centerY);
        }

    }

    /*
        For alignment that is relative to an object or when you want the object to be relative to the scene, but add on to the x or y
     */
    public void alignRelative(Alignment alignment, int xAdditive, int yAdditive){

        if(alignment == Alignment.RIGHT || alignment == Alignment.BOTTOM){

            if(alignment == Alignment.RIGHT) {
                location.setX((Game.WIDTH - width));
            }else{
                location.setY(Game.HEIGHT - height);
            }

        }else{

            Location relativeLocation = relative.getLocation();
            int relativeX = relativeLocation.getX();
            int relativeY = relativeLocation.getY();
            int relativeWidth = relative.getWidth();
            int relativeHeight = relative.getHeight();

            if(alignment == Alignment.RELATIVE_RIGHT){
                location.setX( (relativeX + relativeWidth) + xAdditive);
            }else if(alignment == Alignment.RELATIVE_LEFT){
                location.setX( (relativeX - relativeWidth) - xAdditive);
            }else if(alignment == Alignment.RELATIVE_TOP){
                location.setY(relativeY + yAdditive);
            }else if(alignment == Alignment.RELATIVE_BOTTOM){
                location.setY( (relativeY - relativeHeight) - yAdditive);
            }

        }

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
        return (Game.WIDTH / 2) - (width / 2);
    }

}
