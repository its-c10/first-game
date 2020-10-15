package net.dohaw.firstgame.startingMenu;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.handlers.ObjectHandler;
import net.dohaw.firstgame.utils.ObjectHolder;


public abstract class Menu extends ObjectHolder {

    private ObjectHandler objectHandler;

    public Menu(Game game){
        this.objectHandler = game.getObjectHandler();
    }

    public abstract void init();

}
