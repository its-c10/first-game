package net.dohaw.ecs.components;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import lombok.Getter;
import lombok.Setter;
import net.dohaw.GameObject;
import net.dohaw.ecs.components.exceptions.ComponentDependencyNotFoundException;

import javax.swing.text.Position;

/**
 * Dependent on the position component
 */
public class BodyC extends GameObjectComponent {

    /*
      100 is some arbitrary number. Mass affects gravity
     */
    @Getter @Setter private float mass = 100;
    @Getter @Setter private float gravityForce = 2;

    // Body definition
    @Getter private BodyDef bodyDef = new BodyDef();
    @Getter private com.badlogic.gdx.physics.box2d.Body body;
    private PositionC positionComponent = null;

    public BodyC(GameObject go) {
        super(go);
        PositionC potentialPositionComponent = go.getComponent(PositionC.class);
        if(potentialPositionComponent != null){
            this.positionComponent = go.getComponent(PositionC.class);
            this.body = positionComponent.getWorld().createBody(bodyDef);
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
