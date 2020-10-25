package net.dohaw.ecs.components;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.exceptions.ComponentDependencyNotFoundException;

import java.util.Vector;

/**
 * Dependent on the position component
 */
public class BodyC extends Component{

    /*
      100 is some arbitrary number. Mass affects gravity
     */
    @Getter @Setter private float mass = 100;
    @Getter @Setter private float gravityForce = 2;

    // Body definition
    @Getter private BodyDef bodyDef = new BodyDef();
    @Getter private com.badlogic.gdx.physics.box2d.Body body;
    private Position positionComponent = null;

    public BodyC(GameObject go) {
        super(go);
        if(go.hasComponent(Position.class)){
            this.positionComponent = go.getComponent(Position.class);
            this.body = go.getGAME_SCREEN().getWorld().createBody(bodyDef);
        }else{
            try {
                throw new ComponentDependencyNotFoundException("The position dependency is not found for the Body component!");
            } catch (ComponentDependencyNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void setBodyDefinitionType(BodyDef.BodyType bodyType){
        this.bodyDef.type = bodyType;
    }


}
