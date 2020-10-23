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

public class MoveableSprite extends GameObject {

    /*
        Have to make this static in order to do this
     */
    public static class SpriteBuilder {

        private Location location;
        private Vector vector;
        private int width = 100;
        private int height = 100;
        private boolean isAnimated;
        private Alignment alignment;
        private String path;
        private Game game;
        private ObjectID id;
        private GameObject relative;

        public SpriteBuilder(Game game, String path){
            this.game = game;
            this.path = path;
        }

        public SpriteBuilder setLocation(Location location){
            this.location = location;
            return this;
        }

        public SpriteBuilder setVector(Vector vector){
            this.vector = vector;
            return this;
        }

        public SpriteBuilder setIsAnimated(boolean isAnimated){
            this.isAnimated = isAnimated;
            return this;
        }

        public SpriteBuilder setAlignment(Alignment alignment){
            this.alignment = alignment;
            return this;
        }

        public SpriteBuilder setRelative(GameObject relative){
            this.relative = relative;
            return this;
        }

        public SpriteBuilder setHeight(int height){
            this.height = height;
            return this;
        }

        public SpriteBuilder setWidth(int width){
            this.width = width;
            return this;
        }

        public SpriteBuilder setObjectID(ObjectID id){
            this.id = id;
            return this;
        }

        public MoveableSprite create(){
            if(isAnimated){
                return new AnimatedMoveableSprite(game, path, id, vector, location, width, height);
            }
            return new MoveableSprite(game, path, id, vector, location, width, height);
        }

    }

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
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
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
