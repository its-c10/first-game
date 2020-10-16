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
    @Getter @Setter Alignment alignment;
    @Getter @Setter Color color;
    // No real reason to change this, which is why it's constant
    private final GameObject RELATIVE;

    /*
        Most customizable constructor
     */
    public TextObject(ObjectID objectId, Vector vec, Location location,  Font font, String text, Color color) {
        super(objectId, vec, location, 0, 0);
        this.font = font;
        this.text = text;
        this.RELATIVE = null;
        this.color = color;
    }

    /*
        Non-movable. No relative
     */
    public TextObject(Location location, Font font, String text, Alignment alignment, Color color){
        super(ObjectID.BACKGROUND, null, location, 0, 0);
        this.font = font;
        this.text = text;
        this.alignment = alignment;
        this.RELATIVE = null;
        this.color = color;
    }

    /*
        Non-movable. Relative here
     */
    public TextObject(Location location, Font font, String text, Alignment alignment, GameObject relative, Color color){
        super(ObjectID.BACKGROUND, null, location, 0, 0);
        this.font = font;
        this.text = text;
        this.alignment = alignment;
        this.RELATIVE = relative;
        this.color = color;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.setColor(color);
        g.setFont(font);
        drawAccordingToAlignment(g);

    }

    public void drawAccordingToAlignment(Graphics g){

        FontMetrics fm = g.getFontMetrics();
        g.setColor(color);
        g.setFont(font);

        if(alignment == Alignment.CENTER){
            int xLocation = (Game.WIDTH - fm.stringWidth(text)) / 2 - (font.getSize() / 2);
            g.drawString(text, xLocation, location.getY());
        }else{
            g.drawString(text, location.getX(), location.getY());
        }

    }

}
