package net.dohaw.firstgame.gameobject.sprites;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Alignment;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite extends GameObject {

    protected String filePath;
    protected BufferedImage sprite = null;
    protected Game game;

    public Sprite(Game game, String filePath, ObjectID objectId, Vector vec, Location location, int width, int height){
        super(objectId, vec, location, width, height);
        this.filePath = filePath;
        this.game = game;
        load();
    }

    public Sprite(Game game, String filePath, ObjectID objectId, Vector vec, Location location, Alignment alignment, int width, int height){
        super(objectId, vec, location, alignment, width, height);
        this.filePath = filePath;
        this.game = game;
        load();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if(alignment != null){
            location = Location.align(alignment, this);
        }
        g.drawImage(sprite, location.getX(), location.getY(), width, height, game);
    }

    protected void load(){
        try{
            this.sprite = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
