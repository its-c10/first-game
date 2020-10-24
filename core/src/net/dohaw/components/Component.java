package net.dohaw.components;

import net.dohaw.GameObject;

public abstract class Component {

    public GameObject gameObject;

    public abstract void update(float dt);

    public void start(){

    }

}
