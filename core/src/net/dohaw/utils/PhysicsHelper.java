package net.dohaw.utils;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import javafx.scene.effect.ColorInput;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.CollisionC;
import net.dohaw.ecs.components.GroundC;
import net.dohaw.ecs.components.PlayerMovementC;

import java.util.UUID;

public class PhysicsHelper {

    private static final int GROUND_CHECK_BUFFER = 2;

    public static boolean isNextMoveInCollision(ImmutableArray<Entity> entities, Entity entityInCheck){

        CollisionC collisionComponent = entityInCheck.getComponent(CollisionC.class);
        Rectangle entityInCheckRect = (Rectangle) collisionComponent.getShape();

        for(Entity e : entities){
            /* Not a player */
            if(e.getComponent(PlayerMovementC.class) == null){
                if(e.getComponent(CollisionC.class) != null){
                    CollisionC collisionComponentEntity = e.getComponent(CollisionC.class);
                    Rectangle rectCollisionEntity = (Rectangle) collisionComponentEntity.getShape();
                    return Intersector.overlaps(rectCollisionEntity, entityInCheckRect);
                }
            }
        }

        return false;

    }

    public static boolean isOnGround(ImmutableArray<Entity> entities, Entity entityInCheck, UUID realEntityInCheckUUID){

        CollisionC collisionComponent = entityInCheck.getComponent(CollisionC.class);
        Rectangle collisionRect = (Rectangle) collisionComponent.getShape();

        float y = collisionRect.y - GROUND_CHECK_BUFFER;
        Vector2 bottomLeftPoint = new Vector2(collisionRect.x + 2, y);
        Vector2 bottomRightPoint = new Vector2((collisionRect.x + collisionRect.width) - 2, y);

        for(Entity e : entities){
            GameObject go = (GameObject) e;
            if(!go.getOBJ_UUID().equals(realEntityInCheckUUID)){
                if(go.getComponent(GroundC.class) != null){
                    CollisionC entityCollisionComponent = e.getComponent(CollisionC.class);
                    Rectangle entityCollisionRect = (Rectangle) entityCollisionComponent.getShape();
                    return entityCollisionRect.contains(bottomLeftPoint.x, bottomLeftPoint.y) || entityCollisionRect.contains(bottomRightPoint.x, bottomRightPoint.y);
                }
            }
        }

        return false;
    }

}
