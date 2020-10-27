package net.dohaw.ecs.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import net.dohaw.ecs.components.CollisionC;
import net.dohaw.ecs.components.TransformC;
import net.dohaw.ecs.components.SpriteC;

public class RenderSystem extends IteratingSystem {

    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;

    /**
     * Instantiates a system that will iterate over the entities described by the Family.
     *
     * @param family The family of entities iterated over in this System
     */
    public RenderSystem(Family family, SpriteBatch batch, ShapeRenderer shapeRenderer) {
        super(family);
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
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

        TransformC transformComponent = entity.getComponent(TransformC.class);
        SpriteC spriteComponent = entity.getComponent(SpriteC.class);
        Vector2 position = transformComponent.getPosition();
        batch.draw(spriteComponent.getTRegion(), position.x, position.y);

        CollisionC collisionComponent = entity.getComponent(CollisionC.class);

        if(collisionComponent != null){
            Shape2D collisionShape = collisionComponent.getShape();
            if(collisionShape instanceof Polygon){
                shapeRenderer.polygon(((Polygon) collisionShape).getVertices());
            }else if(collisionShape instanceof Rectangle){
                Rectangle rect = (Rectangle) collisionShape;
                shapeRenderer.rect(rect.x, rect.y, rect.width, rect.height);
            }
        }

    }

}
