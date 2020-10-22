package net.dohaw.firstgame.handlers;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.FPSCounter;
import net.dohaw.firstgame.gameobject.GameObjectHolder;
import net.dohaw.firstgame.gameobject.Player;
import net.dohaw.firstgame.utils.Collidable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Tickable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/*
    Class with the visible game objects on the screen
 */
public class GameObjectHandler extends GameObjectHolder implements Tickable {

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
            if(obj.isVisible() && !(obj instanceof FPSCounter)){
                objects.get(x).render(g);
            }
        }

        /*
            Debug messages
         */
        Player playerFromScene = getPlayerFromScene();
        if(playerFromScene != null){


            Location playerLocation = playerFromScene.getLocation();

            final int DEBUG_Y = playerLocation.getY() - 200;

            FPSCounter fpsCounter = game.getFpsCounter();
            Location fpsCounterLocation = new Location(playerLocation.getX() + 200, DEBUG_Y);
            fpsCounter.setLocation(fpsCounterLocation);
            fpsCounter.render(g);

            g.setColor(Color.GRAY);
            g.setFont(new Font("Roboto", Font.PLAIN, 15));

            final int DEBUG_X = playerLocation.getX() - 250;
            g.drawString(playerLocation.toString(), DEBUG_X, DEBUG_Y);
            g.drawString("Colliding: " + playerFromScene.isColliding(), DEBUG_X, DEBUG_Y + 15);
            g.drawString("On ground: " + playerFromScene.isOnGround(), DEBUG_X, DEBUG_Y + 30);
            g.drawString("Jumping: " + playerFromScene.isJumping(), DEBUG_X, DEBUG_Y + 45);
            g.drawString(playerFromScene.getVector().toString(), DEBUG_X, DEBUG_Y + 60);

        }



    }

    public Player getPlayerFromScene(){
        for(GameObject obj : game.getCurrentScene().getObjects()){
            if(obj.getObjectId() == ObjectID.PLAYER){
                return (Player) obj;
            }
        }
        return null;
    }

    /*
        Adds multiple objects from a object from an instance of game holder
     */

    public void addObjects(GameObjectHolder gameObjectHolder){
        gameObjectHolder.getObjects().forEach(obj -> objects.add(obj));
    }

    public void addObjects(List<GameObject> obj){
        obj.forEach(ob -> objects.add(ob));
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
            if(obj instanceof Collidable && !(obj instanceof Player)){
                collidables.add((Collidable) obj);
            }
        }
        return collidables;
    }

}
