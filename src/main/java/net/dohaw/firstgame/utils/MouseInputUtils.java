package net.dohaw.firstgame.utils;

import net.dohaw.firstgame.gameobject.MenuButton;

public class MouseInputUtils {

    public static boolean isItemClicked(int xClicked, int yClicked, MenuButton menuObject){

        Location menuLocation = menuObject.getLocation();
        int minXObject = menuLocation.getX();
        int minYObject = menuLocation.getY();
        int maxXObject = minXObject + menuObject.getWidth();
        //draws from top left
        int maxYObject = minYObject - menuObject.getHeight();

        return (xClicked > minXObject && xClicked < maxXObject) && (yClicked > minYObject && yClicked < maxYObject);
    }

}
