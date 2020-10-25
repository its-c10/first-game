package net.dohaw.ecs.components;

import lombok.Setter;
import net.dohaw.GameObject;

public class Position extends Component{

    @Setter public float xPos = 0;
    @Setter public float yPos = 0;

    @Setter public float xVel = 0;
    @Setter public float yVel = 0;

    public Position(GameObject go) {
        super(go);
    }


}
