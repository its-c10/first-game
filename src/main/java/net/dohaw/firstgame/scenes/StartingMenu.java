package net.dohaw.firstgame.scenes;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.BlankBackground;

import java.awt.*;
import java.awt.event.MouseEvent;

public class StartingMenu extends Scene{

    public StartingMenu(Game game) {
        super(game);
    }

    @Override
    public void init() {

        objects.add(new BlankBackground(Color.BLACK, Game.WIDTH, Game.HEIGHT));
        handler.addObjects(this);

    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
