package net.dohaw.firstgame.scenes;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.BlankBackground;
import net.dohaw.firstgame.gameobject.FPSCounter;
import net.dohaw.firstgame.gameobject.TextObject;
import net.dohaw.firstgame.gameobject.sprites.AnimatedSprite;
import net.dohaw.firstgame.gameobject.sprites.Sprite;
import net.dohaw.firstgame.utils.Alignment;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PreStartingMenu extends Scene{

    public PreStartingMenu(Game game){
        super(game);
    }

    @Override
    public void init() {
        objects.add(new BlankBackground(Color.GRAY, Game.WIDTH, Game.HEIGHT));

        Sprite backgroundSprite = new Sprite.SpriteBuilder(game, "src/main/resources/premenu background.png")
            .setAlignment(Alignment.BOTTOM)
            .setHeight(180)
            .setWidth(Game.WIDTH)
            .setIsAnimated(false)
            .setLocation(new Location(0, 0))
            .setVector(new Vector(0, 0))
            .setObjectID(ObjectID.BACKGROUND)
            .create();

        objects.add(backgroundSprite);
        objects.add(new TextObject(new Location(0, 100), new Font("Roboto", Font.PLAIN, 40), "Game", Alignment.HORIZONTAL_CENTER, Color.BLACK));
        objects.add(new TextObject(new Location(0, (int) (Game.HEIGHT * .75)), new Font("Roboto", Font.BOLD, 20), "Press anywhere to continue...", Alignment.HORIZONTAL_CENTER, Color.BLACK));
        objects.add(new AnimatedSprite(game, "src/main/resources/arrow", ObjectID.BACKGROUND, new Vector(0, 0), new Location(0, 0), null, 100, 100));
        objects.add(new FPSCounter(game));
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
