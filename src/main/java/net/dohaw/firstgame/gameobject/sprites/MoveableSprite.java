package net.dohaw.firstgame.gameobject.sprites;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.MoveableGameObject;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MoveableSprite extends MoveableGameObject {

    protected String filePath;
    protected BufferedImage sprite = null;
    protected Game game;

    public MoveableSprite(Game game, String filePath, ObjectID objectId, Vector vec, Location location, int width, int height){
        super(game, objectId, vec, location, width, height);
        this.filePath = filePath;
        this.game = game;
        load();
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(sprite, location.getX(), location.getY(), width, height, game);

        if(inSkeletonMode){
            g.setColor(Color.WHITE);
            Rectangle2D collisionRect = getCollisionRect();
            g.drawRect((int)collisionRect.getX(), (int)collisionRect.getY(), (int)collisionRect.getWidth(), (int)collisionRect.getHeight());
        }

    }

    protected void load(){
        try{
            this.sprite = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
