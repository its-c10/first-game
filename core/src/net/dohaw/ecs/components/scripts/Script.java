package net.dohaw.ecs.components.scripts;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.GameObjectComponent;

/**
 * May carry out very specific behaviors for a game object
 */
public abstract class Script extends GameObjectComponent {

    @Getter @Setter private float deltaTime;
    @Getter @Setter private boolean isActive = false;

    public Script(GameObject go) {
        super(go);
    }

    /**
     * The code block that gets ran over and over again
     * @param dt delta time
     */
    public abstract void script(float dt);

    /**
     * What you want the script to do before it runs #script
     */
    public abstract void start();

    /**
     * What you want the script to do when you want to stop it
     */
    public abstract void stop();

}
