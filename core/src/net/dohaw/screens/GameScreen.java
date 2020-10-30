package net.dohaw.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import net.dohaw.Eldridge;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;
import net.dohaw.MainGame;
import net.dohaw.ecs.components.*;
import net.dohaw.ecs.systems.PhysicsSystem;
import net.dohaw.ecs.systems.PlayerMovementSystem;
import net.dohaw.ecs.systems.RenderSystem;

import java.util.UUID;

public class GameScreen extends GameObjectHolder implements Screen{

    private final int GRAVITY_FORCE = -5;

    private PlayerMovementSystem playerMovementSystem;
    private RenderSystem renderSystem;
    private PhysicsSystem physicsSystem;

    private Engine engine;
    private final Eldridge GAME;

    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private OrthographicCamera camera;

    private boolean isReady;

    public GameScreen(final Eldridge GAME){

        this.engine = new Engine();

        this.GAME = GAME;

        this.batch = GAME.batch;
        this.shapeRenderer = GAME.shapeRenderer;
        shapeRenderer.setAutoShapeType(true);
        // Directs to your assets folder
        this.camera = new OrthographicCamera();
        // Always showing us at least 800 pixels wide and 480 height
        camera.setToOrtho(false, 300, 300);

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
        shapeRenderer.setProjectionMatrix(camera.combined);

        /*
            Draw stuff in between begin and end
         */
        shapeRenderer.begin();
        batch.begin();

        if(isReady){
            engine.update(delta);
        }

        batch.end();
        shapeRenderer.end();
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

        GameObject playerObj = initPlayer();
        engine.addEntity(playerObj);

        GameObject test = new GameObject("TEST");

        TransformC transformComponent = new TransformC(test);
        transformComponent.position.x = 50;
        transformComponent.position.y = 0;
        test.add(transformComponent);



        ShapeC shapeComponent = new ShapeC(test);
        Rectangle rect = new Rectangle(50, 0, 50, 50);
        shapeComponent.setShape(rect);
        test.add(shapeComponent);

        CollisionC collisionComponent = new CollisionC(test);
        collisionComponent.setShape(rect);
        test.add(collisionComponent);

        engine.addEntity(test);

        playerMovementSystem = new PlayerMovementSystem(Family.all(PlayerMovementC.class, MovementC.class).get());
        playerMovementSystem.setProcessing(true);
        physicsSystem = new PhysicsSystem(Family.all(TransformC.class, MovementC.class).get());
        physicsSystem.setProcessing(true);

        Family family = Family.one(SpriteC.class, DirectionalSpriteComponent.class, ShapeC.class).one(TransformC.class).get();
        renderSystem = new RenderSystem(family, batch, GAME.shapeRenderer);
        renderSystem.setProcessing(true);

        engine.addSystem(playerMovementSystem);
        engine.addSystem(physicsSystem);
        engine.addSystem(renderSystem);

        isReady = true;
    }

    private GameObject initPlayer(){

        GameObject playerObj = new GameObject("PLAYER");
        playerObj.add(new MovementC(playerObj));
        playerObj.add(new PlayerMovementC(playerObj));

        TransformC transformComponent = new TransformC(playerObj);
        playerObj.add(transformComponent);

        DirectionalSpriteComponent dirSpriteComponent = new DirectionalSpriteComponent(playerObj);
        TextureRegion idleSprite = GAME.tHolder.idleGuy;

        dirSpriteComponent.setIdleSprite(GAME.tHolder.idleGuy);
        dirSpriteComponent.setLeftSprites(GAME.tHolder.leftGuyAnimations);
        dirSpriteComponent.setRightSprites(GAME.tHolder.rightGuyAnimations);
        playerObj.add(dirSpriteComponent);

        CollisionC collisionComponent = new CollisionC(playerObj);
        collisionComponent.setCollisionShapeVisible(true);
        Vector2 pos = transformComponent.position;
        Rectangle rect = new Rectangle(pos.x, pos.y, idleSprite.getRegionWidth(), idleSprite.getRegionHeight());
        collisionComponent.setShape(rect);
        playerObj.add(collisionComponent);

        return playerObj;
    }

}
