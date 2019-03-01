package com.simulation.earth.drawServis;

import javafx.scene.paint.Color;
import org.fxyz3d.geometry.Point3D;

public interface Line {

    Point3D getStartingCoordinat ();
    Point3D getEndCoordinat ();
    void setStartingCoordinat (Point3D point3D);
    void setEndCoordinat (Point3D point3D);
    void changeScaleWidth (float coefficient);
    void setWidth (float width);
    void setColor (Color color);
}
