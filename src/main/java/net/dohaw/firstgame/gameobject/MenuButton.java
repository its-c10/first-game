package net.dohaw.firstgame.gameobject;

import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Clickable;
import net.dohaw.firstgame.utils.Location;

/*
    I know I will use the Clickable interface in other things other than menu's, so in order to keep the design fluent, I use it here.
    The reason that MenuObject doesn't just implement clickable is because not all menu objects will be clickable
 */
public class MenuButton extends MenuObject implements Clickable {

    public MenuButton(Location location, ObjectID objectId, int width, int height) {
        super(location, objectId, width, height);
    }

    @Override
    public boolean isApplicableClick(int numClick) {
        return false;
    }

}
