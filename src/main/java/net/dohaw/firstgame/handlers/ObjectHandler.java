package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.utils.ObjectHolder;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler extends ObjectHolder {

    private LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void tick(){
        for(GameObject obj : objects){
            obj.vectorTick();
            obj.tick();
        }
    }

    public void render(Graphics g){
        for(GameObject obj : objects){
            obj.render(g);
        }
    }



}
