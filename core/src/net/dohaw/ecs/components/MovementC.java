package net.dohaw.ecs.components;

import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class MovementC extends GameObjectComponent {

    @Getter @Setter private Vector2 velocity = new Vector2(0, 0);
    @Getter @Setter private float maxVelocity = 50;
    @Getter @Setter private float maxGravity = -20;
    @Getter @Setter private float movementSpeed = 10;
    @Getter @Setter private float mass = 100;

    @Getter @Setter private boolean hasJumpingCapability = false;
    @Getter @Setter private boolean hasDoubleJumpCapability = false;
    @Getter @Setter private boolean isOnGround = false;
    @Getter @Setter private boolean isJumping = false;

    @Getter @Setter private int jumpCount = 0;

    @Getter @Setter private float jumpForce = 10;

    public MovementC(GameObject gameObject) {
        super(gameObject);
    }

}
