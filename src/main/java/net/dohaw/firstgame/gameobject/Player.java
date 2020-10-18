package net.dohaw.firstgame.gameobject;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class Player extends MoveableGameObject implements MouseListener, KeyListener {

    @Getter @Setter boolean isColliding;

    public Player(Vector vec, Location location, int height, int width) {
        super(ObjectID.PLAYER, vec, location, height, width);
    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        Location toBeLocation = location.clone();
        int keyCode = e.getKeyCode();
        switch(keyCode){
            case 65:
                toBeLocation.setX(location.getX() - 3);
                break;
            case 68:
                toBeLocation.setX(location.getX() + 3);
                break;
            case 32:
                toBeLocation.setY(location.getY() - 3);
                break;
            case 83:
                toBeLocation.setY(location.getY() + 3);
                break;
        }

        MoveableGameObject temp = new MoveableGameObject(toBeLocation);
        temp.setCollisionRect(new Rectangle2D.Double(toBeLocation.getX() - collision_coord_additive, toBeLocation.getY() - collision_coord_additive, width + (collision_coord_additive * 2), height + (collision_coord_additive * 2)));

        if(!physicsHandler.isInCollision(temp)) {
            this.location = toBeLocation;
        }

    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

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
