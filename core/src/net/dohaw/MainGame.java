package net.dohaw;

import com.badlogic.gdx.ApplicationAdapter;
import net.dohaw.screens.MainMenuScreen;

public class MainGame extends ApplicationAdapter {

	private Eldridge game;

	/*
		Run when the game first starts
	 */
	@Override
	public void create () {
		this.game = new Eldridge();
		game.create();
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
	}
}
