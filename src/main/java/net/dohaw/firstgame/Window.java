package net.dohaw.firstgame;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    private JFrame frame;

    public Window(Game game, int width, int height, String title){

        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }

}
