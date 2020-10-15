package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.gameobject.background.MoveableGameObject;
import net.dohaw.firstgame.utils.ObjectHolder;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ObjectHandler extends ObjectHolder {

    /*
        I don't know if immovable objects will need to be able to tick in the future

        Added a vector tick method for objects that move

     */
    public void tick(){
        for(GameObject obj : objects){
            obj.tick();
            if(obj instanceof MoveableGameObject){
                ((MoveableGameObject) obj).vectorTick();
            }
        }
    }

    public void render(Graphics g){
        for(GameObject obj : objects){
            obj.render(g);
        }
    }

}
