package net.dohaw.firstgame.utils;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.GameObject;

public class Location {

    @Getter @Setter private int x, y;
    
    public final static Location NONE = new Location(0, 0);

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Location(GameObject relative, int xAway, int yAway){
        Location relativeLocation = relative.getLocation();
        this.x = relativeLocation.getX() + xAway;
        this.y = relativeLocation.getY() + yAway;
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
