package net.dohaw.ecs.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;
import net.dohaw.utils.Direction;

public class TransformC extends GameObjectComponent {

    @Getter @Setter public Vector2 position = new Vector2(0,0);
    @Getter @Setter public Vector3 rotation;
    @Getter @Setter private Direction directionFacing = Direction.LEFT;

    public TransformC(GameObject gameObject) {
        super(gameObject);
    }

}
