package net.dohaw.ecs.components;

import com.badlogic.gdx.physics.box2d.World;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class PositionC extends GameObjectComponent {

    @Setter public float xPos = 0;
    @Setter public float yPos = 0;

    @Setter public float xVel = 0;
    @Setter public float yVel = 0;

    @Getter private World world;

    public PositionC(GameObject gameObject, World world) {
        super(gameObject);
        this.world = world;
    }

}
