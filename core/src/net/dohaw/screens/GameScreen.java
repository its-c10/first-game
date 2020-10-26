package net.dohaw.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import net.dohaw.Eldridge;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;
import net.dohaw.MainGame;
import net.dohaw.ecs.components.CollisionC;
import net.dohaw.ecs.components.MovementC;
import net.dohaw.ecs.components.TransformC;
import net.dohaw.ecs.components.SpriteC;
import net.dohaw.ecs.systems.PhysicsSystem;
import net.dohaw.ecs.systems.RenderSystem;

import java.util.UUID;

public class GameScreen extends GameObjectHolder implements Screen, InputProcessor {

    private final int GRAVITY_FORCE = -5;

    private UUID uuidPlayer;
    private World world;

    private RenderSystem renderSystem;
    private PhysicsSystem physicsSystem;

    private Engine engine;
    private final Eldridge GAME;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private boolean isReady;

    // For centering image
    private Rectangle bucket;

    public GameScreen(final Eldridge GAME){

        this.engine = new Engine();

        this.GAME = GAME;

        batch = new SpriteBatch();
        // Directs to your assets folder
        camera = new OrthographicCamera();
        // Always showing us at least 800 pixels wide and 480 height
        camera.setToOrtho(false, 800, 480);

        Gdx.input.setInputProcessor(this);
    }

    /**
     * Called when this screen becomes the current screen for a {@link MainGame}.
     */
    @Override
    public void show() {

    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        /*
            Draw stuff in between begin and end
         */
        batch.begin();

        if(isReady){
            engine.update(delta);
        }

        batch.end();
    }

    /**
     * @param width
     * @param height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause() {

    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link MainGame}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        batch.dispose();
        GAME.dispose();
    }

    @Override
    public void init() {

        this.world = new World(new Vector2(0, GRAVITY_FORCE), true);

        GameObject playerObj = new GameObject();
        playerObj.add(new MovementC(playerObj));
        this.uuidPlayer = playerObj.getOBJ_UUID();

        playerObj.add(new TransformC(playerObj));

        SpriteC spriteComponent = new SpriteC(playerObj);
        spriteComponent.setTRegion(GAME.tHolder.guy);
        playerObj.add(spriteComponent);

        playerObj.add(new CollisionC(playerObj));
        engine.addEntity(playerObj);

        physicsSystem = new PhysicsSystem(Family.all(TransformC.class).get());
        physicsSystem.setProcessing(true);
        renderSystem = new RenderSystem(Family.all(TransformC.class, SpriteC.class).get(), batch, GAME.shapeRenderer);
        renderSystem.setProcessing(true);

        engine.addSystem(physicsSystem);
        engine.addSystem(renderSystem);

        isReady = true;
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

        GameObject player = getPlayer();

        MovementC movementComponent = player.getComponent(MovementC.class);
        Vector2 velocity = movementComponent.getVelocity();

        float maxVelocity = movementComponent.getMaxVelocity();
        float movementSpeed = movementComponent.getMovementSpeed();

        if(Gdx.input.isKeyPressed(Input.Keys.A) && velocity.x > -maxVelocity){
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D) && velocity.x < maxVelocity){
        }

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

    private GameObject getPlayer(){
        for(Entity e : engine.getEntities()){
            GameObject go = (GameObject) e;
            if(go.getOBJ_UUID() == uuidPlayer){
                return go;
            }
        }
        return null;
    }

}
