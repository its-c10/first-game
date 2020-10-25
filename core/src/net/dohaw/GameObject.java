package net.dohaw;

import com.badlogic.ashley.core.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class GameObject extends Entity {

    @Getter @Setter protected boolean isVisible;
    @Getter final protected UUID OBJ_UUID;

    public GameObject(){
        this.OBJ_UUID = UUID.randomUUID();
    }

    public boolean equals(Object other){
        if(other instanceof GameObject){
            return ((GameObject)other).getOBJ_UUID() == OBJ_UUID;
        }
        return false;
    }


}
