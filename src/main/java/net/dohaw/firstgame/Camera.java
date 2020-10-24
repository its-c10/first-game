package net.dohaw.firstgame;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.gameobject.sprites.Player;
import net.dohaw.firstgame.handlers.GameObjectHandler;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Tickable;

public class Camera implements Tickable {

    @Getter @Setter private int x, y;
    private GameObjectHandler gameObjectHandler;
    private Player tempPlayer;

    public Camera(int x, int y, GameObjectHandler gameObjectHandler){
        this.x = x;
        this.y = y;
        this.gameObjectHandler = gameObjectHandler;
        this.tempPlayer = gameObjectHandler.getPlayerFromScene();
    }


    @Override
    public void tick() {

        if(tempPlayer != null){
            Location playerLocation = tempPlayer.getLocation();
            this.x = playerLocation.getX() - (Game.WIDTH / 2);
            this.y = playerLocation.getY() - 300;
        }else gameObjectHandler.getPlayerFromScene();

    }

}
