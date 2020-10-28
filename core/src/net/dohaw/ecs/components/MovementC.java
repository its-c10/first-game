package net.dohaw.ecs.components;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class MovementC extends GameObjectComponent {

    @Getter @Setter private Vector2 velocity = new Vector2(0, 0);
    @Getter @Setter private float maxVelocity = 50;
    @Getter @Setter private float movementSpeed = 10;
    @Getter @Setter private float mass = 100;

    public MovementC(GameObject gameObject) {
        super(gameObject);
    }

}
