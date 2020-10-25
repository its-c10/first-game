package net.dohaw;

import com.badlogic.gdx.ApplicationAdapter;

public class MainGame extends ApplicationAdapter {

	private Eldridge game = new Eldridge();

	/*
		Run when the game first starts
	 */
	@Override
	public void create () {
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
