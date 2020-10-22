package net.dohaw.firstgame.scenes;

import lombok.Getter;
import net.dohaw.firstgame.Camera;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.GameObjectHolder;
import net.dohaw.firstgame.handlers.GameObjectHandler;

public abstract class Scene extends GameObjectHolder{

    @Getter protected Game game;
    @Getter protected GameObjectHandler handler;

    public Scene(Game game){
        this.game = game;
        this.handler = game.getObjectHandler();
    }

    public abstract void init();

    /*
        Makes it to where it switches to the next scene in the game
     */
    public void goToNextScene(Scene newScene){

        handler.removeObjectsFromScene();
        newScene.init();
        game.setCurrentScene(newScene);

        Camera camera = new Camera(0, 0, handler);
        game.setSceneCamera(camera);
        game.addTickable(camera);

    }


}
