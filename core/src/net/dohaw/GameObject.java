package net.dohaw;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.ecs.components.Component;
import net.dohaw.ecs.components.Position;
import net.dohaw.ecs.components.Sprite;
import net.dohaw.screens.GameScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameObject {

    @Getter @Setter protected boolean isVisible;
    @Getter final protected UUID OBJ_UUID;
    @Getter private List<Component> components = new ArrayList<>();

    @Getter private final GameScreen GAME_SCREEN;

    public GameObject(final GameScreen GAME_SCREEN){
        this.OBJ_UUID = UUID.randomUUID();
        this.GAME_SCREEN = GAME_SCREEN;
        addComponent(new Position(this));
        addComponent(new Sprite(this));
    }

    public boolean equals(Object other){
        if(other instanceof GameObject){
            return ((GameObject)other).getOBJ_UUID() == OBJ_UUID;
        }
        return false;
    }

    public <T extends Component> T getComponent(Class<T> componentClass){
        for(Component c : components){
            if(componentClass.isAssignableFrom(c.getClass())){
                try{
                    return componentClass.cast(c);
                }catch(ClassCastException e){
                    e.printStackTrace();
                    assert false: "Error: Casting component";
                }
            }
        }
        return null;
    }

    public <T extends Component> void removeComponent(Class<T> componentClass){
        for(int i = 0; i < components.size(); i++){
            Component c = components.get(i);
            if(componentClass.isAssignableFrom(c.getClass())){
                components.remove(i);
                return;
            }
        }
    }

    public void addComponent(Component c){
        this.components.add(c);
        c.setGameObject(this);
    }

    public <T extends Component> boolean hasComponent(Class<T> componentClass){
        for(int i = 0; i < components.size(); i++){
            Component c = components.get(i);
            if(componentClass.isAssignableFrom(c.getClass())){
                return true;
            }
        }
        return false;
    }

}
