package net.dohaw.ecs.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class TransformC extends GameObjectComponent {

    @Getter @Setter public Vector2 position;
    @Getter @Setter public Vector3 rotation;

    public TransformC(GameObject gameObject) {
        super(gameObject);
    }

}
