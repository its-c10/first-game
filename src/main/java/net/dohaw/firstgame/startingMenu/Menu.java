package net.dohaw.firstgame.startingMenu;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.handlers.GameObjectHandler;
import net.dohaw.firstgame.utils.GameObjectHolder;


public abstract class Menu extends GameObjectHolder {

    protected GameObjectHandler handler;

    public Menu(Game game){
        this.handler = game.getObjectHandler();
        init();
    }

    public abstract void init();

}
