package net.dohaw.firstgame.gameobject;

import lombok.Getter;
import lombok.Setter;
import net.dohaw.firstgame.Game;
import net.dohaw.firstgame.ObjectID;
import net.dohaw.firstgame.gameobject.text.TextObject;
import net.dohaw.firstgame.utils.Location;
import net.dohaw.firstgame.utils.Vector;

import java.awt.*;

public class FPSCounter extends TextObject {

    private Game game;
    @Setter @Getter private boolean showing = false;

    public FPSCounter(Game game) {
        super(game, ObjectID.BACKGROUND, new Vector(0, 0), new Location((int) (Game.WIDTH * .85), (int) (Game.HEIGHT * .1)),  new Font("Roboto", Font.BOLD, 10), "", Color.GRAY);
        this.game = game;
        this.showing = true;
    }

}
