package net.dohaw;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.dohaw.screens.MainMenuScreen;
import net.dohaw.utils.TextureHolder;

public class Eldridge extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public TextureHolder tHolder;

    public void create() {

        batch = new SpriteBatch();
        font = new BitmapFont();
        tHolder = new TextureHolder();
        tHolder.init();

        MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
        mainMenuScreen.init();
        this.setScreen(mainMenuScreen);

    }

    /**
     * Runs the game screen's render method
     */
    public void render() {
        super.render(); //important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        tHolder.dispose();
    }

}
