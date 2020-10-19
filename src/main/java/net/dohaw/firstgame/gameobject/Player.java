package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.runnable.BaseRunnable;
import net.dohaw.firstgame.utils.Jumpable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class Player extends MoveableGameObject implements MouseListener, KeyListener, Jumpable {

    /*
        Defined by the doing of going upwards via space bar (Not when coming down)
     */
    private boolean isJumping = false;

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

    @Override
    public int getJumpingAmount() {
        return -3;
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
            //A
            case 65:
                vector.setX(-3);
                break;
            //D
            case 68:
                vector.setX(3);
                break;
            //Space
            case 32:

                /*
                    When they jump
                 */
                if(isOnGround){
                    vector.setY(getJumpingAmount());
                    isOnGround = false;
                    isJumping = true;
                }

                break;
            //S
            case 83:
                vector.setY(3);
                break;
        }

        MoveableGameObject temp = new MoveableGameObject(toBeLocation);
        temp.setCollisionRect(new Rectangle2D.Double(toBeLocation.getX() - collisionCoordAdditive, toBeLocation.getY() - collisionCoordAdditive, width + (collisionCoordAdditive * 2), height + (collisionCoordAdditive * 2)));

        if(!physicsHandler.isInCollision(temp, this)) {
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

        int keyCode = e.getKeyCode();
        switch(keyCode){
            //A
            case 65:
            //D
            case 68:
                vector.setX(0);
                break;
            //S
            case 83:
                vector.setY(0);
                break;
        }

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
    public boolean isJumping() {
        return isJumping;
    }

    @Override
    public void setIsJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    @Override
    public void jump() {
        BaseRunnable task = new BaseRunnable() {
            @Override
            public void run() {
                vector.setY(1);
                isJumping = false;
            }
        };
        task.scheduleLaterTask(1);
    }

}
