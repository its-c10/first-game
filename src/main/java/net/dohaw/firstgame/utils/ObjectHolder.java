package net.dohaw.firstgame.utils;

import net.dohaw.firstgame.GameObject;

import java.util.ArrayList;
import java.util.List;

public class ObjectHolder {

    protected List<GameObject> objects = new ArrayList<>();

    public ObjectHolder(){

    }

    public void addObject(GameObject obj){
        this.objects.add(obj);
    }

    public void removeObject(GameObject obj){
        this.objects.remove(obj);
    }

}
