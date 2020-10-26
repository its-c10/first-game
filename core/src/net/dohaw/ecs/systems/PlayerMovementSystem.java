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

        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.D)){

            float maxVelocity = movementComponent.getMaxVelocity();
            float movementSpeed = movementComponent.getMovementSpeed();

            if(Gdx.input.isKeyPressed(Input.Keys.A) && velocity.x > -maxVelocity){
                velocity.x = -movementSpeed;
                playerMovementComponent.keysPressed.add(Input.Keys.A);
            }

            if(Gdx.input.isKeyPressed(Input.Keys.D) && velocity.x < maxVelocity){
                velocity.x = movementSpeed;
                playerMovementComponent.keysPressed.add(Input.Keys.D);
            }

        }else{

            if(playerMovementComponent.keysPressed.contains(Input.Keys.A)){
                playerMovementComponent.keysPressed.remove(Input.Keys.A);
                velocity.x = 0;
            }

            if(playerMovementComponent.keysPressed.contains(Input.Keys.D)){
                playerMovementComponent.keysPressed.remove(Input.Keys.D);
                velocity.x = 0;
            }

        }

    }
}
