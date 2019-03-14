package com.simulation.earth.pathServis;

import com.simulation.earth.drawServis.LineToManager;
import javafx.scene.Group;
import org.fxyz3d.geometry.Point3D;

public interface ServisDrawTrajectory {
    void addLineInPathIfNeeded (float newX, float newY, float newZ);
    Group getPath();
    boolean isNeededDraw(float newX, float newY, float newZ);
    void setDistanceDrawLine(double distanceDrawLine);
    LineToManager getLineToManager();
    void clear ();
    void setMaxNumberLine(int maxNumberLine);
    int getMaxNumberLine();
    boolean isLimitTerms();
    void setLimitTerms(boolean limitTerms);
}
