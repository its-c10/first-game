package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.*;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.CollisionC;
import net.dohaw.ecs.components.MovementC;
import net.dohaw.ecs.components.PlayerMovementC;
import net.dohaw.ecs.components.TransformC;
import net.dohaw.utils.Direction;
import net.dohaw.utils.PhysicsHelper;
import org.w3c.dom.css.Rect;

/**
 *  A system that deals with movement, collision, gravity, and what-not
 */
public class PhysicsSystem extends IteratingSystem {

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
        dealWithMovement(entity, deltaTime);
        applyGravity(entity, deltaTime);
    }

    private void dealWithMovement(Entity entity, float deltaTime){

        MovementC movementComponent = entity.getComponent(MovementC.class);

        if(movementComponent != null){

            TransformC transformComponent = entity.getComponent(TransformC.class);
            Vector2 velocity = movementComponent.getVelocity();
            Vector2 position = transformComponent.getPosition();

            CollisionC collisionComponent = entity.getComponent(CollisionC.class);
            if(collisionComponent != null){

                Rectangle entityRect = (Rectangle) collisionComponent.getShape();
                GameObject tempGameObject = createTempEntity(position, velocity, deltaTime, entityRect);

                if(!PhysicsHelper.isNextMoveInCollision(getEntities(), tempGameObject)){

                    position.x += (velocity.x * deltaTime);
                    position.y += (velocity.y * deltaTime);

                    if(collisionComponent.getShape() instanceof Polygon){
                        ((Polygon) collisionComponent.getShape()).setPosition(position.x, position.y);
                    }else{
                        ((Rectangle) collisionComponent.getShape()).setPosition(position.x, position.y);
                    }

                }

            }else{
                position.x += (velocity.x * deltaTime);
                position.y += (velocity.y * deltaTime);
            }

        }

    }

    private void applyGravity(Entity systemEntity, float deltaTime) {

        MovementC movementComponent = systemEntity.getComponent(MovementC.class);
        if(movementComponent != null) {

            TransformC transformC = systemEntity.getComponent(TransformC.class);
            Vector2 velocity = movementComponent.getVelocity();
            Vector2 position = transformC.getPosition();

            float toBeVelocityY = velocity.y - 10;
            if(toBeVelocityY > movementComponent.getMaxGravity()){
                velocity.y -= 10;
            }else{
                velocity.y = -movementComponent.getMaxGravity();
            }
            position.y -= (velocity.y * deltaTime);

        }

    }

    /**
     * Makes a temporary entity that performs the entities step before it actually does it to check to see if it's in collision
    *  If the move isn't in collision, then it proceeds to move the actual entity
     * @param entityPos Entity position that it's copying
     * @param entityVelocity Entity velocity that it's copying
     * @param deltaTime dt
     * @param entityRect Entity collision rectangle that its copying
     * @return temporary entity
     */
    private GameObject createTempEntity(Vector2 entityPos, Vector2 entityVelocity, float deltaTime, Rectangle entityRect){

        GameObject tempGameObject = new GameObject("TEST");
        CollisionC tempCollisionComponent = new CollisionC(tempGameObject);

        float tempRectX = entityPos.x + (entityVelocity.x * deltaTime);
        float tempRectY = entityPos.y + (entityVelocity.y * deltaTime);

        Rectangle tempCollisionRect = new Rectangle(tempRectX, tempRectY, entityRect.width, entityRect.height);
        tempCollisionComponent.setShape(tempCollisionRect);
        tempGameObject.add(tempCollisionComponent);
        return tempGameObject;

    }

}
