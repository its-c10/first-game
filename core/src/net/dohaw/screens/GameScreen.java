package net.dohaw.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import net.dohaw.Eldridge;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;
import net.dohaw.MainGame;
import net.dohaw.ecs.components.PositionC;
import net.dohaw.ecs.components.SpriteC;
import net.dohaw.ecs.systems.PhysicsSystem;
import net.dohaw.ecs.systems.RenderSystem;

public class GameScreen extends GameObjectHolder implements Screen {

    private final int GRAVITY_FORCE = -5;

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

        GameObject go = new GameObject();
        go.add(new PositionC(go, world));

        SpriteC spriteComponent = new SpriteC(go);
        spriteComponent.setTRegion(GAME.tHolder.guy);
        go.add(spriteComponent);
        engine.addEntity(go);

        physicsSystem = new PhysicsSystem(Family.all(PositionC.class).get());
        physicsSystem.setProcessing(true);

        renderSystem = new RenderSystem(Family.all(PositionC.class, SpriteC.class).get(), batch);
        renderSystem.setProcessing(true);

        engine.addSystem(renderSystem);
        engine.addSystem(physicsSystem);

        isReady = true;
    }

}
