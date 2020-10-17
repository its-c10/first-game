package net.dohaw.firstgame.utils;

import lombok.Getter;
import lombok.Setter;

public class Vector {

    @Getter @Setter private int x, y;
    final public static Vector IMMOVABLE = new Vector(0, 0);

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
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
