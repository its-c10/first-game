package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.GameObject;

import java.util.ArrayList;
import java.util.List;

/*
    Don't know why i would need this, but i have a slight feeling it could be useful in the future. Keeping it for now (10/17/2020)
 */
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
