package net.dohaw.firstgame.menus;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.gameobject.BlankBackground;
import net.dohaw.firstgame.gameobject.TextObject;
import net.dohaw.firstgame.utils.Alignment;
import net.dohaw.firstgame.utils.Location;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PreStartingMenu extends Scene{

    public PreStartingMenu(Game game){
        super(game);
    }

    @Override
    public void init() {
        objects.add(new BlankBackground(Color.YELLOW, Game.WIDTH, Game.HEIGHT));
        objects.add(new TextObject(new Location(0, 100), new Font("Roboto", Font.PLAIN, 40), "Game", Alignment.CENTER, Color.BLACK));
        objects.add(new TextObject(new Location(0, (int) (Game.HEIGHT * .75)), new Font("Roboto", Font.BOLD, 20), "Press anywhere to continue...", Alignment.CENTER, Color.BLACK));
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
        goToNextScene(new StartingMenu(game));
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) { }

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
