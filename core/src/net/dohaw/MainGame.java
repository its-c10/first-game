package net.dohaw;

import com.badlogic.gdx.ApplicationAdapter;

public class MainGame extends ApplicationAdapter {

	private Eldridge game;
	private MainMenuScreen mainMenuScreen;

	/*
		Run when the game first starts
	 */
	@Override
	public void create () {

		this.game = new Eldridge();
		game.create();
		this.mainMenuScreen = new MainMenuScreen(game);

	}

	/*
		This is ran multiple times a second. It's the game loop.
	 */
	@Override
	public void render () {
		game.render();
	}
	
	@Override
	public void dispose () {
		game.dispose();
		mainMenuScreen.dispose();
	}
}
