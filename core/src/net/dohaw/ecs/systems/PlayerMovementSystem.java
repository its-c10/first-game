package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.MovementC;
import net.dohaw.ecs.components.PlayerMovementC;
import net.dohaw.ecs.components.TransformC;
import net.dohaw.utils.Direction;

import java.util.HashSet;

public class PlayerMovementSystem extends IteratingSystem {

    /**
     * Instantiates a system that will iterate over the entities described by the Family.
     *
     * @param family The family of entities iterated over in this System
     */
    public PlayerMovementSystem(Family family) {
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

        GameObject player = (GameObject) entity;
        PlayerMovementC playerMovementComponent = player.getComponent(PlayerMovementC.class);
        MovementC movementComponent = player.getComponent(MovementC.class);
        Vector2 velocity = movementComponent.getVelocity();
        HashSet<Integer> keysPressed =  playerMovementComponent.getKeysPressed();

        TransformC transformComponent = entity.getComponent(TransformC.class);

        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.D)){

            float maxVelocity = movementComponent.getMaxVelocity();
            float movementSpeed = movementComponent.getMovementSpeed();

            if(Gdx.input.isKeyPressed(Input.Keys.A) && velocity.x > -maxVelocity){
                velocity.x += -movementSpeed;
                keysPressed.add(Input.Keys.A);
                transformComponent.setDirectionFacing(Direction.LEFT);
            }

            if(Gdx.input.isKeyPressed(Input.Keys.D) && velocity.x < maxVelocity) {
                velocity.x += movementSpeed;
                keysPressed.add(Input.Keys.D);
                transformComponent.setDirectionFacing(Direction.RIGHT);
            }

            /*
            boolean hasJumpingCapability = movementComponent.isHasJumpingCapability();
            if(hasJumpingCapability) {
                if(Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                    boolean isOnGround = movementComponent.isOnGround();
                    boolean isJumping = movementComponent.isJumping();
                    if(isOnGround && !isJumping){

                    }
                }
            }*/

        }else{

            if(keysPressed.contains(Input.Keys.A)){
                keysPressed.remove(Input.Keys.A);
                velocity.x = 0;
                transformComponent.setDirectionFacing(null);
            }

            if(keysPressed.contains(Input.Keys.D)){
                keysPressed.remove(Input.Keys.D);
                velocity.x = 0;
                transformComponent.setDirectionFacing(null);
            }

        }

    }
}
