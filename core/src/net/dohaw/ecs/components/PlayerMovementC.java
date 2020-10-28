package net.dohaw.ecs.components;

import lombok.Getter;
import net.dohaw.GameObject;

import java.util.HashSet;

public class PlayerMovementC extends GameObjectComponent {

    @Getter private HashSet<Integer> keysPressed = new HashSet<>();

    public PlayerMovementC(GameObject gameObject) {
        super(gameObject);
    }

}
