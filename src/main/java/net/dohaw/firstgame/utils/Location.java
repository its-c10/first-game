package net.dohaw.firstgame.utils;

import net.dohaw.firstgame.GameObject;

public class Location {

    private int x, y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void applyVector(Vector vector){
        this.x += vector.getX();
        this.y += vector.getY();
    }

    public boolean equals(Object other){
        if(other instanceof Location){
            Location loc = (Location) other;
            return loc.getX() == this.getX() && loc.getY() == this.getY();
        }
        return false;
    }

    public static Location align(Alignment alignment, GameObject obj){

        Location objLocation = obj.getLocation();
        int x = objLocation.getX();
        int y = objLocation.getY();

        int centerX = obj.getCenterX();
        int centerY = obj.getCenterY();

        if(alignment == Alignment.HORIZONTAL_CENTER){
            objLocation = new Location(centerX, y);
        }else if(alignment == Alignment.CENTER){
            objLocation = new Location(centerX, centerY);
        }else if(alignment == Alignment.VERTICAL_CENTER) {
            objLocation = new Location(x, centerY);
        }

        return objLocation;

    }

}
