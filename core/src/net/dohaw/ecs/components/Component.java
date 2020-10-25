package net.dohaw.ecs.components;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

/**
 * Components are things that hold data about a game object.
 */
public abstract class Component {

    @Getter @Setter
    protected GameObject gameObject;

    public Component(GameObject go){
        this.gameObject = go;
    }

}
