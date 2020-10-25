package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;
import net.dohaw.ecs.components.BodyC;
import net.dohaw.ecs.components.PositionC;
import net.dohaw.ecs.components.Velocity;

import java.util.ArrayList;
import java.util.List;

/**
 *  A system that deals with movement, collision, gravity, and what-not
 */
public class PhysicsSystem extends IteratingSystem {

    private float accumulator = 0;

    private final float TIME_STEP = 1/60f;
    private final int VELOCITY_ITERATIONS = 6;
    private final int POSITION_ITERATIONS = 2;

    /**
     * Instantiates a system that will iterate over the entities described by the Family.
     *
     * @param family The family of entities iterated over in this System
     */
    public PhysicsSystem(Family family) {
        super(family);
    }

    /**
     * This method is called on every entity on every update call of the EntitySystem. Override this to implement your system's
     * specific processing.
     *
     * @param entity    The current Entity being processed
     * @param deltaTime The delta time between the last and current frame
     */
    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        BodyC bodyComponent = entity.getComponent(BodyC.class);
        Body body = bodyComponent.getBody();
        Vector2 linearVelocity = body.getLinearVelocity();
        body.setTransform(linearVelocity, body.getAngle());
        PositionC positionC = entity.getComponent(PositionC.class);
        positionC.xPos = bodyComponent.getBody().getPosition().x;
        positionC.yPos = bodyComponent.getBody().getPosition().y;
    }

}
