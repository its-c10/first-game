package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.gameobject.GameObjectHolder;
import net.dohaw.firstgame.utils.Collidable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
    Class with the visible game objects on the screen
 */
public class GameObjectHandler extends GameObjectHolder {

    private Game game;

    public GameObjectHandler(Game game){
        this.game = game;
    }

    public void tick(){
        for(GameObject obj : objects){
            obj.tick();
        }
    }

    public void render(Graphics g){
        for(int x = 0; x < objects.size(); x++){
            GameObject obj = objects.get(x);
            if(obj.isVisible()){
                objects.get(x).render(g);
            }
        }
    }

    /*
        Adds multiple objects from a object from an instance of game holder
     */

    public void addObjects(GameObjectHolder gameObjectHolder){
        gameObjectHolder.getObjects().forEach(obj -> objects.add(obj));
    }

    /*
        The run() method constantly loops through objects. If we remove them, then they'll go away and we can add new ones to the scene
        Currently there's a bug to where you if you clear the objects, they stay there rendered for whatever reason. Doesn't necessarily stop what I want to do in the future.
        Will fix this in this future. I don't think it's a huge problem at the moment though. I can just add new objects on top of the old ones :)

        ** Now that I think about it, I don't think dispose is supposed to clear the new objects **
     */
    public void removeObjectsFromScene(){
        objects.clear();
    }

    public List<Collidable> getCollidables(){
        List<Collidable> collidables = new ArrayList<>();
        for(GameObject obj : getObjects()){
            if(obj instanceof Collidable){
                collidables.add((Collidable) obj);
            }
        }
        return collidables;
    }

}
