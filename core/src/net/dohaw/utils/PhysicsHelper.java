package net.dohaw.utils;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import net.dohaw.ecs.components.CollisionC;
import net.dohaw.ecs.components.PlayerMovementC;

public class PhysicsHelper {

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

    public static double distanceBetweenPositions(Vector2 position1, Vector2 position2){

        float position1X = position1.x;
        float position1Y = position1.y;

        float position2X = position2.x;
        float position2Y = position2.y;

        float xDiff = position2X - position1X;
        float yDiff = position2Y - position1Y;
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));

    }

}
