package net.dohaw.systems;

import com.badlogic.gdx.Screen;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;
import net.dohaw.components.CollisionComponent;
import net.dohaw.components.InputComponent;
import net.dohaw.components.PositionComponent;
import net.dohaw.components.VelocityComponent;

import java.util.ArrayList;
import java.util.List;

/**
 *  A system that deals with movement, collision, gravity, and what-not
 */
public class PhysicsSystem extends System {

    private List<VelocityComponent> velocityComponents = new ArrayList<>();
    private List<PositionComponent> positionComponents = new ArrayList<>();
    private List<InputComponent> inputComponents = new ArrayList<>();

    public PhysicsSystem(GameObjectHolder screen) {
        super(screen);
    }

    public void update(){

        velocityComponents.get(0);

    }

    @Override
    public void init() {
        for(GameObject go : screen.getObjects()){
            if(go.hasComponent(VelocityComponent.class)){

            }
        }
    }

}
