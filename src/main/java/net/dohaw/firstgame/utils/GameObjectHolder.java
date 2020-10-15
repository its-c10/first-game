package net.dohaw.firstgame.utils;

import net.dohaw.firstgame.GameObject;

import java.util.ArrayList;
import java.util.List;

public class GameObjectHolder {

    protected List<GameObject> objects = new ArrayList<>();

    public GameObjectHolder(){

    }

    public void addObject(GameObject obj){
        this.objects.add(obj);
    }

    public void removeObject(GameObject obj){
        this.objects.remove(obj);
    }

    public List<GameObject> getObjects(){
        return objects;
    }

}
