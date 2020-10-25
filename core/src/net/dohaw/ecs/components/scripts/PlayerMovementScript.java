package net.dohaw.ecs.components.scripts;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.BodyC;
import net.dohaw.ecs.components.GameObjectComponent;
import net.dohaw.ecs.components.exceptions.ComponentDependencyNotFoundException;

/**
 *  dependent on the collision component
 */
public class PlayerMovementScript extends Script {

    @Getter @Setter private int movementSpeed = 3;
    @Getter @Setter private float jumpingForce = 3;
    @Setter private BodyC bodyComponent = null;

    public PlayerMovementScript(GameObject go) {
        super(go);
        BodyC potentialBodyComponent = go.getComponent(BodyC.class);
        if(potentialBodyComponent != null){
            this.bodyComponent = potentialBodyComponent;
        }else{
            try {
                throw new ComponentDependencyNotFoundException("The Player Movement Script can't be used without the BodyC component!");
            } catch (ComponentDependencyNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The code block that gets ran over and over again.
     *
     * @param dt delta time
     */
    @Override
    public void script(float dt) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.A)){
            Body body = bodyComponent.getBody();
            body.setType(BodyDef.BodyType.KinematicBody);
            body.setLinearVelocity(0, 10);
        }
    }

    /**
     * What you want the script to do before it runs #script
     */
    @Override
    public void start() {
    }

    /**
     * What you want the script to do when you want to stop it
     */
    @Override
    public void stop() {

    }


}
