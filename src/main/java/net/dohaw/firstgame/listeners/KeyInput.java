package net.dohaw.firstgame.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        System.out.println("KEY: " + key);
    }

    public void keyReleased(KeyEvent e){

    }

}
