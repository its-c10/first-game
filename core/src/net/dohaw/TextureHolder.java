package net.dohaw;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureHolder {

    private TextureAtlas atlas;
    public TextureRegion guy;

    public TextureHolder(){
        this.atlas = new TextureAtlas("textures.atlas");
    }

    public void init(){
        this.guy = atlas.findRegion("Guy");
    }

    public void dispose(){
        atlas.dispose();
    }

}
