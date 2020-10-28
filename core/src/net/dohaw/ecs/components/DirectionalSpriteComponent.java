package net.dohaw.ecs.components;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;

/**
 * Means that their sprite animations change when going left to right
 */
public class DirectionalSpriteComponent extends GameObjectComponent{

    @Getter @Setter private Array<TextureAtlas.AtlasRegion> leftSprites;
    @Getter @Setter private Array<TextureAtlas.AtlasRegion> rightSprites;

    @Getter @Setter private int frameBuffer = 10;
    @Getter private int frameBufferCount = 0;

    @Getter @Setter private int indexSprite = 0;

    public DirectionalSpriteComponent(GameObject gameObject) {
        super(gameObject);
    }

    public void indexReset(){
        this.indexSprite = 0;
    }

    public void incrementIndex(){
        this.indexSprite++;
    }

    public void incrementFrameBufferCount(){
        this.frameBufferCount++;
    }

    public void bufferCountReset(){
        this.frameBufferCount = 0;
    }

    public boolean isTimeToSwitchSprite(){
        return frameBufferCount == frameBuffer;
    }

}
