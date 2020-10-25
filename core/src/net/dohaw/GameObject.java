package net.dohaw;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.components.Component;
import net.dohaw.utils.Updatable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class GameObject implements Updatable {

    @Getter @Setter protected boolean isVisible;
    @Getter final protected UUID OBJ_UUID;
    @Getter private List<Component> components = new ArrayList<>();

    public GameObject(){
        this.OBJ_UUID = UUID.randomUUID();
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
        c.gameObject = this;
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

    /*
    public void update(float dt){
        for(int i = 0; i < components.size(); i++){
            components.get(i).update(dt);
        }
    }

    public void start(){
        for(int i = 0; i < components.size(); i++){
            components.get(i).start();
        }
    }*/

}
