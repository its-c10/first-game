package net.dohaw.firstgame.gameobject.menubuttons;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.MenuObject;
import net.dohaw.firstgame.utils.Clickable;
import net.dohaw.firstgame.utils.Colorable;
import net.dohaw.firstgame.utils.Location;

import java.awt.event.MouseListener;

/*
    I know I will use the Clickable interface in other things other than menu's, so in order to keep the design fluent, I use it here.
    The reason that MenuObject doesn't just implement clickable is because not all menu objects will be clickable
 */
public abstract class MenuButton extends MenuObject implements Clickable, MouseListener, Colorable {

    public MenuButton(Game game, Location location, ObjectID objectId, int width, int height) {
        super(location, objectId, width, height);
        game.addMouseListener(this);
    }

}
