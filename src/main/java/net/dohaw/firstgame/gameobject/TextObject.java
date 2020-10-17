package net.dohaw.firstgame.gameobject;

import lombok.Getter;
import lombok.Setter;
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
    // No real reason to change this, which is why it's constant

    /*
        Most customizable constructor
     */
    public TextObject(ObjectID objectId, Vector vec, Location location,  Font font, String text, Color color) {
        super(objectId, vec, location, 0, 0);
        this.font = font;
        this.text = text;
        this.color = color;
    }

    /*
        Non-movable. No relative
     */
    public TextObject(Location location, Font font, String text, Color color){
        super(ObjectID.BACKGROUND, null, location, 0, 0);
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
       }

    }

}
