package net.dohaw.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.Eldridge;
import net.dohaw.GameObject;
import net.dohaw.utils.Location;
import net.dohaw.utils.Vector;

public class MoveableGameObject extends GameObject {

    @Getter @Setter private float movementSpeed = 3;
    @Getter @Setter private Vector vector = Vector.IMMOVABLE;

    public MoveableGameObject(Eldridge game, TextureRegion texture, Location location) {
        super(game, texture, location);
    }

    /**
     * @param dt delta time
     */
    @Override
    public void update(float dt) {

    }

}
