package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import net.dohaw.ecs.components.CollisionC;
import net.dohaw.ecs.components.MovementC;
import net.dohaw.ecs.components.TransformC;

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
        dealWithMovement(entity);
    }

    private void dealWithMovement(Entity entity){

        MovementC movementComponent = entity.getComponent(MovementC.class);
        TransformC transformComponent = entity.getComponent(TransformC.class);

        Vector2 velocity = movementComponent.getVelocity();
        Vector2 position = transformComponent.getPosition();

        position.x += velocity.x;
        position.y += velocity.y;

        if(entity.getComponent(CollisionC.class) != null){
            CollisionC collisionComponenet = entity.getComponent(CollisionC.class);
            if(collisionComponenet.getShape() instanceof Polygon){
                ((Polygon) collisionComponenet.getShape()).setPosition(position.x, position.y);
            }else{
                ((Rectangle) collisionComponenet.getShape()).setPosition(position.x, position.y);
            }
        }

    }

}
