package net.dohaw.ecs.components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

public class Sprite extends Component{

    @Getter @Setter private TextureRegion tRegion;

    public Sprite(GameObject go) {
        super(go);
    }

}
