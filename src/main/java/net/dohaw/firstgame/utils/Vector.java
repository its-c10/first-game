package net.dohaw.firstgame.utils;

public class Vector {

    private int x, y;

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void add(int additiveX, int additiveY){
        this.x += additiveX;
        this.y += additiveY;
    }

    public void multiply(int multiple){
        this.x *= multiple;
        this.y *= multiple;
    }

}
