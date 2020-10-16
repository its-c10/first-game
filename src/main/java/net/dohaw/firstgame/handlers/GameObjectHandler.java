package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.gameobject.GameObjectHolder;

import java.awt.*;

/*
    Class with the visible game objects on the screen
 */
public class GameObjectHandler extends GameObjectHolder {

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

    /*
        Adds multiple objects from a object from an instance of game holder
     */
    public void addObjects(GameObjectHolder gameObjectHolder){
        gameObjectHolder.getObjects().forEach(obj -> objects.add(obj));
    }

    public void removeObjects(GameObjectHolder gameObjectHolder){
        for(GameObject obj : objects){
            if(gameObjectHolder.getObjects().contains(obj)){
                System.out.println(obj.getObjectId());
            }
        }
    }

}
