package net.dohaw.firstgame.gameobject.text;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.Camera;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Alignment;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class TextObject extends GameObject {

    @Getter @Setter Font font;
    @Getter @Setter String text;
    @Getter @Setter Color color;

    /*
        Most customizable constructor
     */
    public TextObject(Game game, ObjectID objectId, Vector vec, Location location, Font font, String text, Color color) {
        super(game, objectId, vec, location, 0, 0);
        this.font = font;
        this.text = text;
        this.color = color;
    }

    /*
        Non-movable. No relative
     */
    public TextObject(Game game, Location location, Font font, String text, Color color){
        super(game, ObjectID.BACKGROUND, null, location, 0, 0);
        this.font = font;
        this.text = text;
        this.color = color;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.setColor(color);
        g.setFont(font);

        g.drawString(text, location.getX(), location.getY());

    }

    public void alignText(Graphics g, Alignment alignment){

       if(alignment == Alignment.HORIZONTAL_CENTER){
           int strWidth = g.getFontMetrics(font).stringWidth(text);
           location.setX((Game.WIDTH / 2) - (strWidth / 2));
       }else if(alignment == Alignment.TOP_RIGHT){
           Camera camera = game.getSceneCamera();
           //camera.
       }

    }

}
