package net.dohaw.firstgame.menus;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.handlers.GameObjectHandler;
import net.dohaw.firstgame.gameobject.GameObjectHolder;

import java.awt.event.MouseListener;


public abstract class Menu extends GameObjectHolder implements MouseListener {

    protected Game game;
    protected GameObjectHandler handler;

    public Menu(Game game){
        this.game = game;
        this.handler = game.getObjectHandler();
        game.addMouseListener(this);
        init();
    }

    public abstract void init();

}
