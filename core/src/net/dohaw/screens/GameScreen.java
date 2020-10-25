package net.dohaw.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import lombok.Getter;
import net.dohaw.Eldridge;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;
import net.dohaw.MainGame;
import net.dohaw.ecs.components.Position;
import net.dohaw.ecs.components.Sprite;
import net.dohaw.ecs.systems.PhysicsSystem;

public class GameScreen extends GameObjectHolder implements Screen {

    private final float GRAVITY_FORCE = -5;

    @Getter private World world;
    private PhysicsSystem physicsSystem;

    private final Eldridge GAME;

    private SpriteBatch batch;
    private OrthographicCamera camera;

    private boolean isReady;

    // For centering image
    private Rectangle bucket;

    public GameScreen(final Eldridge GAME){

        this.GAME = GAME;
        this.world = new World(new Vector2(0, GRAVITY_FORCE), true);

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
            for(GameObject obj : objects){
                if(obj.hasComponent(Sprite.class)){
                    Sprite spriteComp = obj.getComponent(Sprite.class);
                    Position posComp = obj.getComponent(Position.class);
                    batch.draw(spriteComp.getTRegion(), posComp.xPos, posComp.yPos);
                }
            }
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

//        GameObject go = new GameObject(this);
//        Sprite spriteComponent = go.getComponent(Sprite.class);
//        spriteComponent.setTRegion(GAME.tHolder.guy);
//        objects.add(go);

        isReady = true;
    }

}
