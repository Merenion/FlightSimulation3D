package com.simulation.earth.drawServis;


import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import org.fxyz3d.geometry.Point3D;

/**
 * Интерфейс фабрики для создания графичиских обьектов связвнных с прямыми
 */
public interface FactoryLine {
    Line createLine (Point3D point1, Point3D point2, float width, Color color);
    LineTo creteLineTo ();
}
