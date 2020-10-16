package net.dohaw.firstgame.utils;

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

}
