package net.dohaw.ecs.components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class SpriteC extends GameObjectComponent {

    @Getter @Setter private TextureRegion idleSprite;

    public SpriteC(GameObject go) {
        super(go);
    }

}
