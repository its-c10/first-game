package net.dohaw.firstgame.scenes;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.BlankBackground;
import net.dohaw.firstgame.gameobject.ImmovableGameObject;
import net.dohaw.firstgame.gameobject.sprites.Player;
import net.dohaw.firstgame.utils.Generatable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestingGrounds extends Scene implements MouseListener, Generatable {

    public TestingGrounds(Game game) {
        super(game);
    }

    @Override
    public void init() {

        BlankBackground background = new BlankBackground(game);
        background.setColor(Color.BLACK);
        objects.add(background);

        ImmovableGameObject ground = new ImmovableGameObject(game, new Location(100, 300), ObjectID.BACKGROUND, 300, 50);
        ground.setInSkeletonMode(true);
        objects.add(ground);

        Player player = new Player(game, "src/main/resources/Guy.png", new Vector(0, 0), new Location(100, 200), 30, 30);
        player.initPhysics(this);
        player.setInSkeletonMode(true);

        game.addKeyListener(player);
        game.addMouseListener(player);
        objects.add(player);

        objects.add(game.getFpsCounter());

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

    @Override
    public void generate() {

        

    }

}
