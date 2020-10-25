package net.dohaw.systems;

import com.badlogic.gdx.Screen;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;

public abstract class System {

    private boolean isActive;
    protected GameObjectHolder screen;

    public System(GameObjectHolder screen){
        this.screen = screen;
    }

    public abstract void init();

}
