package net.dohaw.ecs.components;

import lombok.Getter;
import net.dohaw.GameObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PlayerMovementC extends GameObjectComponent {

    public HashSet<Integer> keysPressed = new HashSet<>();

    public PlayerMovementC(GameObject gameObject) {
        super(gameObject);
    }

}
