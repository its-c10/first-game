package net.dohaw.utils;

import lombok.Getter;

public class Location {

    @Getter private float x, y;
    public final static Location NONE = new Location(0, 0);

    public Location(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void applyVector(Vector vector){
        this.x += vector.getX();
        this.y += vector.getY();
    }

    public Location clone(){
        return new Location(this.x, this.y);
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof Location){
            Location loc = (Location) other;
            return loc.getX() == this.getX() && loc.getY() == this.getY();
        }
        return false;
    }

    @Override
    public String toString(){
        return "Location: [X: " + x + " Y: " + y + "]";
    }

}
