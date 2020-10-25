package net.dohaw.ecs.components.exceptions;

public class ComponentDependencyNotFoundException extends Exception{

    public ComponentDependencyNotFoundException(String msg){
        super(msg);
    }

}
