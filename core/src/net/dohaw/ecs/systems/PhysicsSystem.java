package net.dohaw.ecs.systems;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import net.dohaw.GameObject;
import net.dohaw.GameObjectHolder;
import net.dohaw.ecs.components.Position;
import net.dohaw.ecs.components.Velocity;

import java.util.ArrayList;
import java.util.List;

/**
 *  A system that deals with movement, collision, gravity, and what-not
 */
public class PhysicsSystem extends System {

    private float accumulator = 0;

    private final float TIME_STEP = 1/60f;
    private final int VELOCITY_ITERATIONS = 6;
    private final int POSITION_ITERATIONS = 2;

    private World world;
    private List<Velocity> velocityComponents = new ArrayList<>();
    private List<Position> positionComponents = new ArrayList<>();

    public PhysicsSystem(World world, GameObjectHolder screen) {
        super(screen);
        this.world = world;
    }

    public void update(){

        velocityComponents.get(0);

    }

    @Override
    public void init() {
        for(GameObject go : screen.getObjects()){
            if(go.hasComponent(Velocity.class)){

            }
        }
    }

    @Override
    public void run(float dt) {


        //doPhysicsStep(dt);
    }

    private void doPhysicsStep(float deltaTime) {
        // fixed time step
        // max frame time to avoid spiral of death (on slow devices)
        float frameTime = Math.min(deltaTime, 0.25f);
        accumulator += frameTime;
        while (accumulator >= TIME_STEP) {
            world.step(TIME_STEP,VELOCITY_ITERATIONS, POSITION_ITERATIONS);
            accumulator -= TIME_STEP;
        }
    }

}
