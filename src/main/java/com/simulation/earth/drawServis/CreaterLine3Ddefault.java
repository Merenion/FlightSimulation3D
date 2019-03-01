package com.simulation.earth.drawServis;


import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;

public class CreaterLine3Ddefault implements FactoryLine{

    @Override
    public Line createLine(Point3D point1, Point3D point2, float width, Color color) {
        Line line = new Line3D(point1,point2,width,color);
        return line;
    }



}
