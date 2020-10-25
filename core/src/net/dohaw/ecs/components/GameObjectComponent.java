package net.dohaw.ecs.components;

import com.badlogic.ashley.core.Component;
import lombok.Getter;
import net.dohaw.GameObject;

public abstract class GameObjectComponent implements Component {

    /** Game Object that the component belongs to **/
    @Getter protected GameObject gameObject;

    public GameObjectComponent(GameObject gameObject){
        this.gameObject = gameObject;
    }

}
