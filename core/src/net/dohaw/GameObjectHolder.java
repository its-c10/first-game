package net.dohaw;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObjectHolder {

    protected List<GameObject> objects = new ArrayList<>();

    public GameObjectHolder(){}

    /**
     * You initialize what you want in your objects variable in this method
     */
    public abstract void init();

    /**
     *
     * @param obj Object you want to add to the object holder
     */
    public void addObject(GameObject obj){
        objects.add(obj);
        obj.start();
    }

}
