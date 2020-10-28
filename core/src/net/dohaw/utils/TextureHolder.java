package net.dohaw.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.List;

public class TextureHolder {

    private TextureAtlas atlas;

    public TextureRegion idleGuy;
    public Array<TextureAtlas.AtlasRegion> leftGuyAnimations;
    public Array<TextureAtlas.AtlasRegion> rightGuyAnimations;

    public TextureHolder(){
        this.atlas = new TextureAtlas("textures.atlas");
    }

    public void init(){
        this.idleGuy = atlas.findRegion("Guy");
        this.leftGuyAnimations = atlas.findRegions("Guy_Left");
        this.rightGuyAnimations = atlas.findRegions("Guy_Right");
    }

    public void dispose(){
        atlas.dispose();
    }

}
