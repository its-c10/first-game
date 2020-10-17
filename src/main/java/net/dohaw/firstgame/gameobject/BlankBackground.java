package net.dohaw.firstgame.gameobject;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Colorable;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class BlankBackground extends BackgroundGameObject implements Colorable {

    private Color color;

    /*
        If you want the background of something to be customizable for whatever reason (Probably will rarely use this)
     */
    public BlankBackground(ObjectID objectId, Vector vec, Location location, int width, int height) {
        super(objectId, vec, location, width, height);
    }

    /*
        When you just want to make a quick background. No customization
     */
    public BlankBackground(){
        super(ObjectID.BACKGROUND, Vector.IMMOVABLE, Location.NONE, Game.WIDTH, Game.HEIGHT);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

}
