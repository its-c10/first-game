package net.dohaw.utils;

import lombok.Getter;
import lombok.Setter;

public class Vector {

    @Getter
    @Setter
    private float x, y;
    final public static Vector IMMOVABLE = new Vector(0, 0);

    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void add(float additiveX, float additiveY){
        this.x += additiveX;
        this.y += additiveY;
    }

    public void multiply(float multiple){
        this.x *= multiple;
        this.y *= multiple;
    }

    @Override
    public String toString(){
        return "Vector: [" + x + ", " + y + "]";
    }

}
