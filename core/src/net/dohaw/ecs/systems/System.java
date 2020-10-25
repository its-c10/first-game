package net.dohaw.ecs.systems;

import net.dohaw.GameObjectHolder;

public abstract class System {

    private boolean isActive;
    protected GameObjectHolder screen;

    public System(GameObjectHolder screen){
        this.screen = screen;
    }

    public abstract void init();

    public abstract void run(float dt);

}
