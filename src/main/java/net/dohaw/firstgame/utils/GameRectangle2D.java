package net.dohaw.firstgame.utils;

import javafx.geometry.Side;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class GameRectangle2D {

    public static Line2D getSide(Rectangle2D rect, Side side){

        Point2D topLeft = new Point2D.Double(rect.getMinX(), rect.getMinY());
        Point2D bottomLeft = new Point2D.Double(rect.getMinX(), rect.getMaxX());
        Point2D topRight = new Point2D.Double(rect.getMaxX(), rect.getMinY());
        Point2D bottomRight = new Point2D.Double(rect.getMaxX(), rect.getMaxY());

        if(side == Side.LEFT){
            return new Line2D.Double(topLeft, bottomLeft);
        }else if(side == Side.TOP){
            return new Line2D.Double(topLeft, topRight);
        }else if(side == Side.RIGHT){
            return new Line2D.Double(topRight, bottomRight);
        }else{
            return new Line2D.Double(bottomLeft, bottomRight);
        }

    }

}
