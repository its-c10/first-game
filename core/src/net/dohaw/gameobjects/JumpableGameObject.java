package net.dohaw.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.Eldridge;
import net.dohaw.utils.Location;

/**
 * For classes that can jump. For right now, Players are the only thing that can jump but there may be other classes in the future.
 * That is why this is an abstract class instead of an interface.
 */
public abstract class JumpableGameObject extends MoveableGameObject{

    @Getter @Setter private float jumpForce = 3;
    @Getter @Setter private boolean isJumping = false;
    @Getter @Setter private boolean canDoubleJump = false;

    public JumpableGameObject(Eldridge game, TextureRegion texture, Location location) {
        super(game, texture, location);
    }

}
