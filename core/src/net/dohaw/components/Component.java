package net.dohaw.components;

import net.dohaw.GameObject;

/**
 * Components are things that hold data about a game object.
 */
public abstract class Component {

    public GameObject gameObject;

    public Component(GameObject go){
        this.gameObject = go;
    }

}
