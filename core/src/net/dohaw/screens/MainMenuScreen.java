package net.dohaw.screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import net.dohaw.Eldridge;
import net.dohaw.GameObjectHolder;
import net.dohaw.MainGame;

public class MainMenuScreen extends GameObjectHolder implements Screen {

    private final Eldridge GAME;
    private OrthographicCamera camera;

    public MainMenuScreen(final Eldridge game){

        this.GAME = game;
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false, 20, 20);

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

        //camera.update();
        ///GAME.batch.setProjectionMatrix(camera.combined);

        GAME.batch.begin();

        GAME.font.draw(GAME.batch, "Welcome to my first game with this framework!", 100, 150);
        GAME.font.draw(GAME.batch, "Tap anywhere to begin!", 100, 100);

        GAME.batch.end();

        if(Gdx.input.isTouched()){
            GameScreen gs = new GameScreen(GAME);
            gs.init();
            GAME.setScreen(gs);
        }

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
    }

    /**
     * You initialize what you want in your objects variable in this method
     */
    @Override
    public void init() {

    }

}
