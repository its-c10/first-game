package net.dohaw.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import net.dohaw.MainGame;

public class DesktopLauncher {

	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Eldridge";

		// Pack all of our textures into a texture
		// TODO: REMOVE THIS CODE BEFORE RELEASING OUR GAME
		TexturePacker.Settings sets = new TexturePacker.Settings();

		// https://github.com/libgdx/libgdx/wiki/Texture-packer <-- Look at this to see how everything works
		sets.pot = true;
		sets.fast = true;
		sets.combineSubdirectories = true;
		sets.paddingX = 1;
		sets.paddingY = 1;
		sets.edgePadding = true;
		TexturePacker.process(sets, "raw_textures", "./", "textures");

		new LwjglApplication(new MainGame(), config);
	}

}
