package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.gameobject.GameObjectHolder;

import java.awt.*;

/*
    Class with the visible game objects on the screen
 */
public class GameObjectHandler extends GameObjectHolder {

    private Game game;

    public GameObjectHandler(Game game){
        this.game = game;
    }

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
        for(int x = 0; x < objects.size(); x++){
            objects.get(x).render(g);
        }
    }

    /*
        Adds multiple objects from a object from an instance of game holder
     */
    public void addObjects(GameObjectHolder gameObjectHolder){
        gameObjectHolder.getObjects().forEach(obj -> objects.add(obj));
    }

    /*
        Using standard loop to avoid annoying Concurrent error that I don't know how to deal with lol
     */

    /*
        The run() method constantly loops through objects. If we remove them, then they'll go away and we can add new ones to the scene
        Currently there's a bug to where you if you clear the objects, they stay there rendered for whatever reason. Doesn't necessarily stop what I want to do in the future.
        Will fix this in this future. I don't think it's a huge problem at the moment though. I can just add new objects on top of the old ones :)

        ** Now that I think about it, I don't think dispose is supposed to clear the new objects **
     */
    public void removeObjectsFromScene(){
        objects.clear();
    }

}
