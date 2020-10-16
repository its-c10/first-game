package net.dohaw.firstgame.gameobject.sprites;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.utils.Alignment;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimatedSprite extends Sprite{

    private List<BufferedImage> images;
    private int index = 0;
    private int counter = 0;

    public AnimatedSprite(Game game, String pathToFolder, ObjectID objectId, Vector vec, Location location, int width, int height) {
        super(game, pathToFolder, objectId, vec, location, width, height);
        sprite = images.get(index);
    }

    public AnimatedSprite(Game game, String pathToFolder, ObjectID objectId, Vector vec, Location location, Alignment alignment, int width, int height){
        super(game, pathToFolder, objectId, vec, location, alignment, width, height);
    }

    @Override
    protected void load(){

        images = new ArrayList<>();
        try{
            File[] folderFiles = new File(filePath).listFiles();
            for(File file : folderFiles){
                BufferedImage buffImg = ImageIO.read(file);
                images.add(buffImg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void tick() {

        if(index == (images.size() - 1)){
           index = 0;
        }else{
            index++;
        }

        if(counter == 10){
            sprite = images.get(index);
            counter = 0;
        }
        counter++;

    }

}
