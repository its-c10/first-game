package net.dohaw.ecs.components;

import com.badlogic.gdx.math.Shape2D;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class ShapeC extends GameObjectComponent{

    @Getter @Setter private Shape2D shape;
    @Getter @Setter private float width, height;

    public ShapeC(GameObject gameObject) {
        super(gameObject);
    }

}
