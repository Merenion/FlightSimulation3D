package com.simulation.earth.drawServis;

import javafx.css.Styleable;
import javafx.event.EventTarget;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;

/**
 * Интерфейс для работы с прямыми
 */
public interface Line extends EventTarget, Styleable {

    Point3D getStartingCoordinat ();
    Point3D getEndCoordinat ();
    void setStartingCoordinat (Point3D point3D);
    void setEndCoordinat (Point3D point3D);
    void changeScaleWidth (float coefficient);
    void setWidth (float width);
    void setColor (Color color);
}
