package com.simulation.earth.drawServis;


import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;


public interface FactoryLine {
    Line createLine (Point3D point1, Point3D point2, float width, Color color);
}
