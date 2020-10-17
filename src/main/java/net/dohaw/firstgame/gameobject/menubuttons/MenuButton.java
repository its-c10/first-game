package net.dohaw.firstgame.gameobject.menubuttons;

import net.dohaw.firstgame.gameobject.GameObjectHolder;
import net.dohaw.firstgame.utils.Clickable;
import net.dohaw.firstgame.utils.Colorable;

import java.awt.event.MouseListener;

/*
    I know I will use the Clickable interface in other things other than menu's, so in order to keep the design fluent, I use it here.
    The reason that MenuObject doesn't just implement clickable is because not all menu objects will be clickable
 */
public abstract class MenuButton extends GameObjectHolder implements Clickable, MouseListener, Colorable {

}
