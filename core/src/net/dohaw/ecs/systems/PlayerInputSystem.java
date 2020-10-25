package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import net.dohaw.ecs.components.scripts.PlayerMovementScript;

public class PlayerInputSystem extends IteratingSystem {

    /**
     * Instantiates a system that will iterate over the entities described by the Family.
     *
     * @param family The family of entities iterated over in this System
     */
    public PlayerInputSystem(Family family) {
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
        PlayerMovementScript playerMovementScript = entity.getComponent(PlayerMovementScript.class);
        playerMovementScript.script(deltaTime);
    }

}
