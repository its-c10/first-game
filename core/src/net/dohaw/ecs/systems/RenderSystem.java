package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import net.dohaw.ecs.components.PositionC;
import net.dohaw.ecs.components.SpriteC;
import net.dohaw.ecs.components.Velocity;

public class RenderSystem extends IteratingSystem {

    private SpriteBatch batch;

    /**
     * Instantiates a system that will iterate over the entities described by the Family.
     *
     * @param family The family of entities iterated over in this System
     */
    public RenderSystem(Family family, SpriteBatch batch) {
        super(family);
        this.batch = batch;
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
        PositionC positionComponent = entity.getComponent(PositionC.class);
        SpriteC spriteComponent = entity.getComponent(SpriteC.class);
        batch.draw(spriteComponent.getTRegion(), positionComponent.xPos, positionComponent.yPos);
        System.out.println("ENTITY: " + entity.toString());
    }

}
