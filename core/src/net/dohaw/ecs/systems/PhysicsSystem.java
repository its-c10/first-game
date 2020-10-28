package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.*;
import net.dohaw.ecs.components.CollisionC;
import net.dohaw.ecs.components.MovementC;
import net.dohaw.ecs.components.TransformC;

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
    }

    private void dealWithMovement(Entity entity, float deltaTime){

        MovementC movementComponent = entity.getComponent(MovementC.class);
        TransformC transformComponent = entity.getComponent(TransformC.class);

        Vector2 velocity = movementComponent.getVelocity();
        Vector2 position = transformComponent.getPosition();

        if(entity.getComponent(CollisionC.class) != null){

            if(!isNextMoveInCollision(entity)){

                position.x += (velocity.x * deltaTime);
                position.y += (velocity.y * deltaTime);

                CollisionC collisionComponenet = entity.getComponent(CollisionC.class);
                if(collisionComponenet.getShape() instanceof Polygon){
                    ((Polygon) collisionComponenet.getShape()).setPosition(position.x, position.y);
                }else{
                    ((Rectangle) collisionComponenet.getShape()).setPosition(position.x, position.y);
                }

            }

        }else{
            position.x += velocity.x;
            position.y += velocity.y;
        }

    }


    private boolean isNextMoveInCollision(Entity entityInCheck){

        CollisionC collisionComponent = entityInCheck.getComponent(CollisionC.class);
        Rectangle entityInCheckRect = (Rectangle) collisionComponent.getShape();
        ImmutableArray<Entity> entities = getEntities();

        for(Entity e : entities){
            if(!e.equals(entityInCheck)){
                if(e.getComponent(CollisionC.class) != null){
                    CollisionC collisionComponentEntity = e.getComponent(CollisionC.class);
                    Rectangle rectCollisionEntity = (Rectangle) collisionComponentEntity.getShape();
                    if(Intersector.overlaps(rectCollisionEntity, entityInCheckRect)){
                        return true;
                    }
                }
            }
        }

        return false;

    }

}
