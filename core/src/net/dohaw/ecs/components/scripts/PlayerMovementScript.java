package net.dohaw.ecs.components.scripts;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.BodyC;
import net.dohaw.ecs.components.GameObjectComponent;

/**
 *  dependent on the collision component
 */
public class PlayerMovementScript extends Script implements InputProcessor {

    @Getter @Setter private int movementSpeed = 3;
    @Getter @Setter private float jumpingForce = 3;
    @Setter private BodyC bodyComponent = null;

    public PlayerMovementScript(GameObject go) {
        super(go);
        BodyC potentialBodyComponent = go.getComponent(BodyC.class);
        if(potentialBodyComponent != null){
            this.bodyComponent = potentialBodyComponent;
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
            body.applyLinearImpulse(-0.8f, 0, 0, 0, true);
            System.out.println("POSITION: " + body.getPosition().toString());
            System.out.println("VEL: " + body.getLinearVelocity());
        }
    }

    /**
     * What you want the script to do before it runs #script
     */
    @Override
    public void start() {
        Gdx.input.setInputProcessor(this);
    }

    /**
     * What you want the script to do when you want to stop it
     */
    @Override
    public void stop() {

    }

    /**
     * Called when a key was pressed
     *
     * @param keycode one of the constants in {@link Input.Keys}
     * @return whether the input was processed
     */
    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    /**
     * Called when a key was released
     *
     * @param keycode one of the constants in {@link Input.Keys}
     * @return whether the input was processed
     */
    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    /**
     * Called when a key was typed
     *
     * @param character The character
     * @return whether the input was processed
     */
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    /**
     * Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     *
     * @param screenX The x coordinate, origin is in the upper left corner
     * @param screenY The y coordinate, origin is in the upper left corner
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Called when a finger was lifted or a mouse button was released. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     *
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @param button  the button
     * @return whether the input was processed
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /**
     * Called when a finger or the mouse was dragged.
     *
     * @param screenX
     * @param screenY
     * @param pointer the pointer for the event.
     * @return whether the input was processed
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    /**
     * Called when the mouse was moved without any buttons being pressed. Will not be called on iOS.
     *
     * @param screenX
     * @param screenY
     * @return whether the input was processed
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     * Called when the mouse wheel was scrolled. Will not be called on iOS.
     *
     * @param amount the scroll amount, -1 or 1 depending on the direction the wheel was scrolled.
     * @return whether the input was processed.
     */
    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
