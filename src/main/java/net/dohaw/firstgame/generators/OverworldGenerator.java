package net.dohaw.firstgame.generators;

import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.GameObject;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.GameObjectHolder;
import net.dohaw.firstgame.gameobject.ImmovableGameObject;
import net.dohaw.firstgame.utils.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OverworldGenerator {

    final private int AMPLITUDE = 50;
    final private int NUM_CHUNKS = 50;
    final private int GROUND_WIDTH = 100;
    final private int GROUND_HEIGHT = 50;

    final private Location STARTING_LOCATION = new Location(0, 0);

    private Game game;
    private List<GameObject> groundParts = new ArrayList<>();
    private Random rand = new Random();

    public OverworldGenerator(Game game){
        this.game = game;
    }

    public void generateTerrain(){

        ImmovableGameObject lastGround = null;
        for(int num = 0; num < NUM_CHUNKS; num++){

            if(lastGround == null){
                lastGround = new ImmovableGameObject(game, STARTING_LOCATION, ObjectID.GROUND, GROUND_WIDTH, GROUND_HEIGHT);
            }else{
                int groundY = (int) getRandomGroundY();
                int groundX = lastGround.getLocation().getX() + GROUND_WIDTH;
                lastGround = new ImmovableGameObject(game, new Location(groundX, groundY), ObjectID.GROUND, GROUND_WIDTH, GROUND_HEIGHT);
            }
            lastGround.setRotation(30);
            groundParts.add(lastGround);

        }

        game.getObjectHandler().addObjects(groundParts);

    }

    public double getRandomGroundY() {
        return (-AMPLITUDE) + (rand.nextDouble() * (AMPLITUDE - (-AMPLITUDE)) );
    }

}
