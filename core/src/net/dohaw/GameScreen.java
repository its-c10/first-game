package net.dohaw;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen {

    private final Eldridge game;

    private SpriteBatch batch;
    private TextureHolder tHolder;
    private OrthographicCamera camera;

    // For centering image
    private Rectangle bucket;

    public GameScreen(final Eldridge game){

        this.game = game;

        batch = new SpriteBatch();
        // Directs to your assets folder
        camera = new OrthographicCamera();
        // Always showing us at least 800 pixels wide and 480 height
        camera.setToOrtho(false, 800, 480);

        tHolder = new TextureHolder();
        tHolder.init();

        bucket = new Rectangle();
        bucket.x = camera.viewportWidth / 2 - 64 / 2;
        bucket.y = 20;
        bucket.width = 64;
        bucket.height = 64;

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

        batch.begin();
        batch.draw(tHolder.guy, bucket.x, bucket.y);
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
        tHolder.dispose();
        game.dispose();
    }
}
