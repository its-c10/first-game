package net.dohaw.ecs.components;

import com.badlogic.gdx.math.Shape2D;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class CollisionC extends GameObjectComponent{

    @Getter @Setter private boolean isCollisionShapeVisible = false;
    @Getter @Setter private Shape2D shape;
    @Getter @Setter private ShapeType shapeType;
    @Getter @Setter private float shapeRadius = 2;

    public CollisionC(GameObject gameObject) {
        super(gameObject);
    }

    public enum ShapeType{
        POLGYON,
        RECTANGLE
    }


}
