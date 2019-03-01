package com.simulation.earth.pathServis;

import com.simulation.earth.drawServis.LineToManager;
import javafx.scene.Group;
import org.fxyz3d.geometry.Point3D;

public interface ServisDrawTrajectory {
    void addLineInPathIfNeeded (float newX, float newY, float newZ);
    Group getPath();
    boolean isLineNeeded (float newX, float newY, float newZ);
    Point3D getOldPoint();
    void setOldPoint(Point3D oldPoint);
    Point3D getNewPoint();
    void setNewPoint(Point3D newPoint);
    double getDistanceDrawLine();
    void setDistanceDrawLine(double distanceDrawLine);
    LineToManager getLineToManager();
}
